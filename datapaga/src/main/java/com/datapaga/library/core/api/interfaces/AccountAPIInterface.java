package com.datapaga.library.core.api.interfaces;

import com.datapaga.library.environment.callbacks.AccountCallback;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * An interface for the account module in the internal API.
 */
public interface AccountAPIInterface {

    /**
     * Retrieves the account balance inside the provided callback.
     * @param callback Account callback.
     */
    void getBalance(AccountCallback callback);
}
