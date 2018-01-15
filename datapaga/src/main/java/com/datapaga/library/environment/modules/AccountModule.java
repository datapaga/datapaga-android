package com.datapaga.library.environment.modules;

import com.datapaga.library.core.DatapagaCore;
import com.datapaga.library.core.api.interfaces.AccountAPIInterface;
import com.datapaga.library.environment.callbacks.AccountCallback;
import com.datapaga.library.environment.interfaces.AccountInterface;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The middle controller for the Account Module between his API Module and the Datapaga controller.
 */
public class AccountModule implements AccountInterface{

    /**
     * The Account API Interface.
     */
    private AccountAPIInterface mAccountAPI;

    /**
     * Account module constructor that instantiates the API Interface.
     */
    public AccountModule() {
        this.mAccountAPI = DatapagaCore.instance().getAccountModule();
    }

    /**
     * Retrieves the account balance inside the provided callback.
     * @param callback Account callback.
     */
    @Override
    public void getBalance(AccountCallback callback) {
        mAccountAPI.getBalance(callback);
    }
}
