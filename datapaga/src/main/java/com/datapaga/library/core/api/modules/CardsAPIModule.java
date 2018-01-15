package com.datapaga.library.core.api.modules;

import com.android.volley.Response;
import com.datapaga.library.core.api.API;
import com.datapaga.library.core.api.interfaces.CardsAPIInterface;
import com.datapaga.library.environment.callbacks.CardCallback;
import com.datapaga.library.environment.callbacks.CardsCallback;
import com.datapaga.library.environment.objects.Card;
import com.datapaga.library.environment.objects.DatapagaException;
import com.datapaga.library.environment.objects.RequestDetails;
import com.datapaga.library.util.JSONBuilder;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The API controller for the Cards Module.
 */
public class CardsAPIModule extends API implements CardsAPIInterface {

    /**
     * LIST_ALL_CARDS endpoint
     */
    private final String LIST_ALL_CARDS = "cards/list";
    /**
     * GET_CARD_DETAIL endpoint
     */
    private final String GET_CARD_DETAIL = "cards/detail/";

    /**
     * Cards API Module constructor.
     */
    public CardsAPIModule() {
    }

    /**
     * Retrieves a list of all cards available in the account.
     *
     * @param page     Page number to be called.
     * @param callback Cards callback.
     */
    @Override
    public void getAllCards(int page, final CardsCallback callback) {
        JSONBuilder properties = new JSONBuilder();
        if (page > 0) {
            properties.add("page", String.valueOf(page));
        }

        JSONObject params = new JSONBuilder()
                .keys("card")
                .values(fuseAuth(properties.getJSON()));

        doRequest(newJSONPOSTRequest(LIST_ALL_CARDS, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.has("error")) {
                                callback.onError(gson().fromJson(
                                        response.toString(), DatapagaException.class));
                            } else {
                                List<Card> cards = new ArrayList<>();
                                JSONArray cardsJSON = response.getJSONArray("response");
                                for (int i = 0; i < cardsJSON.length(); i++) {
                                    cards.add(gson().fromJson(
                                            cardsJSON.getJSONObject(i).toString(),
                                            Card.class));
                                }

                                response.remove("response");
                                RequestDetails details = gson().fromJson(
                                        response.toString(), RequestDetails.class);

                                callback.onSuccess(cards, details);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ));
    }

    /**
     * Retrieves the card details from the provided UUID.
     *
     * @param UUID     Card UUID.
     * @param callback Card callback.
     */
    @Override
    public void getCardDetails(String UUID, final CardCallback callback) {
        boolean validUUID = true;
        if (UUID == null) {
            validUUID = false;
        } else if (UUID.trim().equals("")) {
            validUUID = false;
        }
        if (validUUID) {
            JSONObject params = new JSONBuilder()
                    .keys("card")
                    .values(getAuth());

            doRequest(newJSONPOSTRequest(GET_CARD_DETAIL + UUID, params,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.has("error")) {
                                    callback.onError(gson().fromJson(
                                            response.toString(), DatapagaException.class));
                                } else {
                                    callback.onSuccess(new Gson().fromJson(
                                            response.getJSONObject("response").toString(),
                                            Card.class));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ));
        } else {
            callback.onError(new DatapagaException("0000", "Invalid UUID.", "0"));
        }
    }
}
