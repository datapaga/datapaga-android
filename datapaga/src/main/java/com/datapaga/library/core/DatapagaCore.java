package com.datapaga.library.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.datapaga.library.core.api.interfaces.AccountAPIInterface;
import com.datapaga.library.core.api.interfaces.CardsAPIInterface;
import com.datapaga.library.core.api.interfaces.TransactionsAPIInterface;
import com.datapaga.library.core.api.modules.AccountAPIModule;
import com.datapaga.library.core.api.modules.CardsAPIModule;
import com.datapaga.library.core.api.modules.TransactionsAPIModule;
import com.datapaga.library.environment.modules.DatapagaController;
import com.datapaga.library.environment.interfaces.DatapagaInterface;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 7/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The Datapaga Library Core class, handles everything.
 */
public class DatapagaCore {

    /** The library tag. */
    private final String LIB_TAG = "DatapagaCore";
    /** DatapagaCore instance. */
    private static volatile DatapagaCore sDatapagaCoreInstance;
    /** Datapaga Core builder. */
    private Builder mBuilder;
    /** Networking RequestQueue. */
    private RequestQueue mRequestQueue;
    /** Transactions API Module Interface instance. */
    private TransactionsAPIInterface mTransactionsApiInterface;
    /** Cards API Module Interface instance. */
    private CardsAPIInterface mCardsApiInterface;
    /** Account API Module Interface instance. */
    private AccountAPIInterface mAccountApiInterface;
    /** Datapaga Interface instance. */
    private DatapagaInterface mDatapagaInterface;

    /**
     * Datapaga Core private constructor, only for auto-instance.
     */
    private DatapagaCore() {
        if (sDatapagaCoreInstance != null) {
            throw new RuntimeException("Use instance() method to get the single instance of this class.");
        }
    }

    /**
     * Returns the Datapaga Library Core synchronized and only instance.
     * @return DatapagaCore instance.
     */
    public static DatapagaCore instance() {
        if (sDatapagaCoreInstance == null) {
            synchronized (DatapagaCore.class) {
                if (sDatapagaCoreInstance == null) {
                    sDatapagaCoreInstance = new DatapagaCore();
                }
            }
        }
        return sDatapagaCoreInstance;
    }

    /**
     * This method initializes the Datapaga Library, providing a base context and getting the Datapaga credentials.
     * @param context The application context.
     */
    public void initialize(Context context) {
        try {
            Bundle appMetaData = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA).metaData;
            this.mBuilder = new Builder(context,
                    appMetaData.getString("com.datapaga.api.key"),
                    appMetaData.getString("com.datapaga.api.secret"));
            this.mTransactionsApiInterface = new TransactionsAPIModule();
            this.mCardsApiInterface = new CardsAPIModule();
            this.mAccountApiInterface = new AccountAPIModule();
            this.mDatapagaInterface = new DatapagaController();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the Transactions API Module instances inside the Datapaga Core.
     * @return Transactions API Module Interface.
     */
    public TransactionsAPIInterface getTransactionsModule() {
        if (this.mTransactionsApiInterface == null) {
            throw new NullPointerException("No context detected, use Datapaga.initialize(context) " +
                    "method to run the single instance of this class.");
        }
        return this.mTransactionsApiInterface;
    }

    /**
     * Returns the Cards API Module instances inside the Datapaga Core.
     * @return Cards API Module Interface.
     */
    public CardsAPIInterface getCardsModule() {
        if (this.mCardsApiInterface == null) {
            throw new NullPointerException("No context detected, use Datapaga.initialize(context) " +
                    "method to run the single instance of this class.");
        }
        return this.mCardsApiInterface;
    }

    /**
     * Returns the Account API Module instances inside the Datapaga Core.
     * @return Account API Module Interface.
     */
    public AccountAPIInterface getAccountModule() {
        if (this.mAccountApiInterface == null) {
            throw new NullPointerException("No context detected, use Datapaga.initialize(context) " +
                    "method to run the single instance of this class.");
        }
        return this.mAccountApiInterface;
    }

    /**
     * Retuns the instanced Datapaga Interface in the Datapaga Core.
     * @return Datapaga Instance.
     */
    public DatapagaInterface getInterface() {
        if (this.mDatapagaInterface == null) {
            throw new NullPointerException("No context detected, use Datapaga.initialize(context) " +
                    "method to run the single instance of this class.");
        }
        return this.mDatapagaInterface;
    }

    /**
     * Retrieves the Datapaga API Key if it's present.
     * @return API Key inside AndroidManifest.xml
     */
    public String getApiKey() {
        return this.mBuilder.getApiKey();
    }

    /**
     * Retrieves the Datapaga API Secret if it's present.
     * @return API Secret inside AndroidManifest.xml
     */
    public String getApiSecret() {
        return this.mBuilder.getApiSecret();
    }

    //#####################################################################
    //          Requests Management
    //#####################################################################

    /**
     * Retrieves the RequestQueue instance for Networking.
     * @return RequestQueue instance.
     */
    private RequestQueue getmRequestQueue() {
        if (mRequestQueue == null) {
            if (this.mBuilder.getContext() == null) {
                throw new NullPointerException("No context detected, use " +
                        "DatapagaController.initialize(context) method to run the single instance " +
                        "of this class.");
            } else {
                mRequestQueue = Volley.newRequestQueue(this.mBuilder.getContext());
            }
        }
        return mRequestQueue;
    }

    /**
     * Adds a request to the request queue.
     * @param req The request to be added.
     * @param <T> The request Type.
     */
    public <T> void addToRequestQueue(Request<T> req) {
        if (req != null) {
            req.setRetryPolicy(new DefaultRetryPolicy(15000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            req.setTag(LIB_TAG);
            getmRequestQueue().add(req);
        }
    }

    /**
     * Cancels all the pending requests with the provided tag.
     * @param tag The ID of the request group.
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    /**
     * Cancels all the pending requests.
     */
    public void cancelAllRequests() {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(
                    new RequestQueue.RequestFilter() {
                        @Override
                        public boolean apply(Request<?> request) {
                            return true;
                        }
                    }
            );
        }
    }

    /**
     * Builder class containing certain data to DatapagaCore.
     */
    private class Builder {

        /** Base context for Datapaga Core. */
        private Context mContext;
        /** The API Key for the Datapaga Library. */
        private String mApiKey;
        /** The API Secret for the Datapaga Library. */
        private String mApiSecret;

        /**
         * The DatapagaCore.Builder constructor.
         * @param mContext The applicacion base context.
         * @param mApiKey The library API Key.
         * @param mApiSecret The library API Secret.
         */
        Builder(Context mContext, String mApiKey, String mApiSecret) {
            if (mApiKey == null || mApiSecret == null) {
                throw new NullPointerException("API_KEY or API_SECRET not found, you have to add both keys in Android Manifest before initialize DatapagaController.");
            }
            this.mContext = mContext;
            this.mApiKey = mApiKey;
            this.mApiSecret = mApiSecret;
        }

        Context getContext() {
            return mContext;
        }

        public void setContext(Context mContext) {
            this.mContext = mContext;
        }

        String getApiKey() {
            return mApiKey;
        }

        public void setApiKey(String mApiKey) {
            this.mApiKey = mApiKey;
        }

        String getApiSecret() {
            return mApiSecret;
        }

        public void setApiSecret(String mApiSecret) {
            this.mApiSecret = mApiSecret;
        }
    }

}
