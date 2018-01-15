package com.datapaga.library.core.api.modules;

import com.android.volley.Response;
import com.datapaga.library.core.api.API;
import com.datapaga.library.core.api.interfaces.TransactionsAPIInterface;
import com.datapaga.library.environment.callbacks.ChargeCallback;
import com.datapaga.library.environment.callbacks.RefundCallback;
import com.datapaga.library.environment.callbacks.TransactionCallback;
import com.datapaga.library.environment.callbacks.TransactionsCallback;
import com.datapaga.library.environment.objects.Charge;
import com.datapaga.library.environment.objects.DatapagaException;
import com.datapaga.library.environment.objects.RefundDetails;
import com.datapaga.library.environment.objects.RequestDetails;
import com.datapaga.library.environment.objects.Transaction;
import com.datapaga.library.util.JSONBuilder;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 4/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The API controller for the Transactions Module.
 */
public class TransactionsAPIModule extends API implements TransactionsAPIInterface {

    /**
     * GET_ALL_TRANSACTIONS endpoint
     */
    private final String GET_ALL_TRANSACTIONS = "account_movements/transaction_history";
    /**
     * GET_SPECIFIC_TRANSACTION endpoint
     */
    private final String GET_SPECIFIC_TRANSACTION = "account_movements/transaction_history/";
    /**
     * CREATE_TRANSACTION endpoint
     */
    private final String CREATE_TRANSACTION = "account_movements/charge";
    /**
     * REFUND_TRANSACTION endpoint
     */
    private final String REFUND_TRANSACTION = "account_movements/refund";

    /**
     * Transactions API Module constructor.
     */
    public TransactionsAPIModule() {
    }

    /**
     * Retrieves a list of all the transactions made by the account.
     *
     * @param callback Transactions callback.
     */
    @Override
    public void getAllTransactions(Date startDate, Date endDate, int page,
                                   final TransactionsCallback callback) {
        JSONBuilder properties = new JSONBuilder();
        if (page > 0) {
            properties.add("page", String.valueOf(page));
        }
        if (startDate != null && endDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
            properties.add("start_date", sdf.format(startDate));
            properties.add("end_date", sdf.format(endDate));
        }
        JSONObject params = new JSONBuilder()
                .keys("account_movement")
                .values(fuseAuth(properties.getJSON()));

        System.out.println(params.toString());

        doRequest(newJSONPOSTRequest(GET_ALL_TRANSACTIONS, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.has("error")) {
                                callback.onError(gson().fromJson(
                                        response.toString(), DatapagaException.class));
                            } else {
                                List<Transaction> transactions = new ArrayList<>();
                                JSONArray transactionsJSON = response.getJSONArray("response");
                                for (int i = 0; i < transactionsJSON.length(); i++) {
                                    transactions.add(gson().fromJson(
                                            transactionsJSON.getJSONObject(i).toString(),
                                            Transaction.class));
                                }

                                response.remove("response");
                                RequestDetails details = gson().fromJson(
                                        response.toString(), RequestDetails.class);

                                callback.onSuccess(transactions, details);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ));
    }

    /**
     * Retrieves the requested transaction by the provided UUID.
     *
     * @param UUID     Transaction UUID.
     * @param callback Transaction callback.
     */
    @Override
    public void getSpecificTransaction(String UUID, final TransactionCallback callback) {
        boolean validUUID = true;
        if (UUID == null) {
            validUUID = false;
        } else if (UUID.trim().equals("")) {
            validUUID = false;
        }

        if (validUUID) {
            JSONObject params = new JSONBuilder()
                    .keys("account_movement")
                    .values(getAuth());
            doRequest(newJSONPOSTRequest(GET_SPECIFIC_TRANSACTION + UUID, params,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.has("error")) {
                                    callback.onError(gson().fromJson(
                                            response.toString(), DatapagaException.class));
                                } else {
                                    callback.onSuccess(
                                            new Gson().fromJson(response.getJSONObject("response")
                                                    .toString(), Transaction.class));
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

    /**
     * Creates a charge to the provided customer inside the charge.
     *
     * @param charge   The transaction to be charged to clients account.
     * @param callback Transaction callback.
     */
    @Override
    public void createTransaction(Charge charge, final ChargeCallback callback) {
        JSONObject chargeParams = new JSONBuilder().toJson(gson().toJson(charge));
        JSONObject params = new JSONBuilder()
                .keys("account_movement")
                .values(fuseAuth(chargeParams));
        doRequest(newJSONPOSTRequest(CREATE_TRANSACTION, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.has("error")) {
                                callback.onError(gson().fromJson(
                                        response.toString(), DatapagaException.class));
                            } else {
                                callback.onCreated(response.getJSONObject("response")
                                        .getString("uuid"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ));
    }

    /**
     * Refunds a charge made to a certain user.
     *
     * @param details  The details of the refund to clients account.
     * @param callback Transaction callback.
     */
    @Override
    public void refundTransaction(RefundDetails details, final RefundCallback callback) {
        JSONObject refundParams = new JSONBuilder().toJson(gson().toJson(details));
        JSONObject params = new JSONBuilder()
                .keys("refund")
                .values(fuseAuth(refundParams));
        doRequest(newJSONPOSTRequest(REFUND_TRANSACTION,
                params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.has("error")) {
                                callback.onError(gson().fromJson(
                                        response.toString(), DatapagaException.class));
                            } else {
                                boolean refundApproved = false;
                                if (response.getJSONObject("response")
                                        .getString("status").equals("APPROVED")) {
                                    refundApproved = true;
                                }
                                callback.onSuccess(refundApproved);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ));
    }
}
