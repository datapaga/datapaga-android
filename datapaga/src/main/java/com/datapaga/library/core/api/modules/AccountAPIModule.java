package com.datapaga.library.core.api.modules;

import com.android.volley.Response;
import com.datapaga.library.core.api.API;
import com.datapaga.library.core.api.interfaces.AccountAPIInterface;
import com.datapaga.library.environment.callbacks.AccountCallback;
import com.datapaga.library.environment.objects.DatapagaException;
import com.datapaga.library.util.JSONBuilder;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The API controller for the Account Module.
 */
public class AccountAPIModule extends API implements AccountAPIInterface {

    /** GET_ACCOUNT_BALANCE endpoint */
    private final String GET_ACCOUNT_BALANCE = "stores/balance";

    /**
     * Account API Module constructor.
     */
    public AccountAPIModule() {
    }

    /**
     * Retrieves the account balance inside the provided callback.
     * @param callback Account callback.
     */
    @Override
    public void getBalance(final AccountCallback callback) {
        JSONObject params = new JSONBuilder()
                .keys("store")
                .values(getAuth());

        doRequest(newJSONPOSTRequest(GET_ACCOUNT_BALANCE, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.has("error")) {
                                callback.onError(gson().fromJson(
                                        response.toString(), DatapagaException.class));
                            } else {
                                callback.onSuccess(response.getJSONObject("response")
                                        .getString("balance"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ));
    }
}
