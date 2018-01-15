package com.datapaga.library.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.datapaga.library.core.DatapagaCore;
import com.datapaga.library.util.JSONBuilder;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 7/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * API abstract class for basic networking usage.
 */
public abstract class API {

    /** Development test URL #2. */
    private static final String BASE_URL_DEV2 = "https://datapaga-staging.herokuapp.com/v1/";
    /** Development test URL #1. */
    private static final String BASE_URL_DEV1 = "https://datapaga.herokuapp.com/v1/";
    /** Production test URL. */
    private static final String BASE_URL_PROD = "https://api.datapaga.com/v1/";

    /** Base URL for networking usage. */
    public static final String BASE_URL = BASE_URL_DEV2;

    /**
     * This method fuses a JSONObject with the required authentication.
     * @param json The JSONObject to fuse.
     * @return The fused JSONObject with the API credentials.
     */
    protected JSONObject fuseAuth(JSONObject json) {
        JSONBuilder jb;
        if (json != null) {
            jb = new JSONBuilder(json);
        } else {
            jb = new JSONBuilder();
        }
        jb.add("api_key", DatapagaCore.instance().getApiKey());
        jb.add("api_secret", DatapagaCore.instance().getApiSecret());
        return jb.getJSON();
    }

    /**
     * This method returns a basic JSONObject with the required authentication.
     * @return JSONObject with the API credentials.
     */
    protected JSONObject getAuth() {
        return fuseAuth(null);
    }

    /**
     * This method is a shortcut that adds a Request to the Networking Request Queue.
     * @param req The request to be added.
     * @param <T> The request type.
     */
    protected <T> void doRequest(Request<T> req) {
        DatapagaCore.instance().addToRequestQueue(req);
    }

    /**
     * This method returns a new instance of Gson library.
     * @return Gson new instance.
     */
    protected Gson gson() {
        return new Gson();
    }

    /**
     * This method validates if the provided String its a JSONObject.
     * @param str The String to be validate.
     * @return True if the provided String is a JSONObject.
     */
    private boolean isJSONValid(String str) {
        try {
            new JSONObject(str);
        } catch (JSONException ex) {
            return false;
        }
        return true;
    }

    /**
     * Creates a new JSONObjectRequest on "GET" method.
     * @param endpoint The API endpoint.
     * @param listener The response listener.
     * @return The instance of the created request.
     */
    protected JsonObjectRequest newJSONGETRequest(String endpoint,
                                                  final Response.Listener<JSONObject> listener) {
        return newJSONRequest(Request.Method.GET, endpoint, null, listener);
    }

    /**
     * Creates a new JSONObjectRequest on "POST" method.
     * @param endpoint The API endpoint.
     * @param params The request params.
     * @param listener The response listener.
     * @return The instance of the created request.
     */
    protected JsonObjectRequest newJSONPOSTRequest(String endpoint, final JSONObject params,
                                                   final Response.Listener<JSONObject> listener) {
        return newJSONRequest(Request.Method.POST, endpoint, params, listener);
    }

    /**
     * Creates a new JSONObjectRequest of any method.
     * @param requestMethod The requested method.
     * @param endpoint The API endpoint.
     * @param params The request params (if needed).
     * @param listener The response listener.
     * @return The instance of the created request.
     */
    private JsonObjectRequest newJSONRequest(int requestMethod, String endpoint, final JSONObject params,
                                             final Response.Listener<JSONObject> listener) {
        String URL = BASE_URL + endpoint;
        return new JsonObjectRequest(requestMethod, URL, params,
                listener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError err) {
                        try {
                            boolean networkResponseExists = false;
                            String errorCode = "0000";
                            String errorString = null;

                            if(err.networkResponse != null){
                                networkResponseExists = true;
                            }

                            if (err instanceof NoConnectionError) {
                                errorString = "NoConnectionError";
                            } else if (err instanceof TimeoutError) {
                                errorString = "TimeoutError";
                            } else if (err instanceof AuthFailureError) {
                                errorString = "AuthFailureError";
                            } else if (err instanceof ServerError) {
                                errorString = "ServerError";
                            } else if (err instanceof NetworkError) {
                                errorString = "NetworkError";
                            } else if (err instanceof ParseError) {
                                errorString = "ParseError";
                            }

                            if(networkResponseExists){
                                if(isJSONValid(new String(err.networkResponse.data)) && err.networkResponse.statusCode != 500){
                                    JSONObject errorResponse = new JSONObject(new String(err.networkResponse.data));
                                    if (errorResponse.has("error")) {
                                        JSONObject error = errorResponse.getJSONObject("error");
                                        errorCode = error.has("code") ? error.getString("code") : errorCode;
                                        errorString = error.has("message") ? error.getString("message") : errorString;
                                    }
                                }
                            }

                            listener.onResponse(
                                    new JSONBuilder()
                                            .keys("code", "error", "server_status")
                                            .values(errorCode, errorString, networkResponseExists ? err.networkResponse.statusCode : 3301)
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    private void warnException(){

    }
}
