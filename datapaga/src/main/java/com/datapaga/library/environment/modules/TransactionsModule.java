package com.datapaga.library.environment.modules;

import com.datapaga.library.core.DatapagaCore;
import com.datapaga.library.core.api.interfaces.TransactionsAPIInterface;
import com.datapaga.library.environment.callbacks.ChargeCallback;
import com.datapaga.library.environment.callbacks.RefundCallback;
import com.datapaga.library.environment.callbacks.TransactionCallback;
import com.datapaga.library.environment.callbacks.TransactionsCallback;
import com.datapaga.library.environment.interfaces.TransactionsInterface;
import com.datapaga.library.environment.objects.Charge;
import com.datapaga.library.environment.objects.RefundDetails;

import java.util.Date;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 4/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The middle controller for the Transactions Module between his API Module and the Datapaga controller.
 */
public class TransactionsModule implements TransactionsInterface{

    /**
     * The Transactions API Interface.
     */
    private TransactionsAPIInterface mTransactionsAPI;

    /**
     * Transactions module constructor that instantiates the API Interface.
     */
    public TransactionsModule() {
        this.mTransactionsAPI = DatapagaCore.instance().getTransactionsModule();
    }

    /**
     * Retrieves a list of all the transactions made by the account.
     * @param callback Transactions callback.
     */
    @Override
    public void getAllTransactions(TransactionsCallback callback) {
        mTransactionsAPI.getAllTransactions(null, null, 0, callback);
    }

    /**
     * Retrieves a list of all the transactions made by the account.
     * @param page Page number to be called.
     * @param callback Transactions callback.
     */
    @Override
    public void getAllTransactions(int page, TransactionsCallback callback) {
        mTransactionsAPI.getAllTransactions(null, null, page, callback);
    }

    /**
     * Retrieves a list of all the transactions made by the account.
     * @param startDate The first day to search.
     * @param endDate The last dat to search.
     * @param page Page number to be called.
     * @param callback Transactions callback.
     */
    @Override
    public void getAllTransactions(Date startDate, Date endDate, int page,
                                   TransactionsCallback callback) {
        mTransactionsAPI.getAllTransactions(startDate, endDate, page, callback);
    }

    /**
     * Retrieves the requested transaction by the provided UUID.
     * @param UUID Transaction UUID.
     * @param callback Transaction callback.
     */
    @Override
    public void getSpecificTransaction(String UUID, TransactionCallback callback) {
        mTransactionsAPI.getSpecificTransaction(UUID, callback);
    }

    /**
     * Creates a charge to the provided customer inside the charge.
     * @param charge The transaction to be charged to clients account.
     * @param callback Transaction callback.
     */
    @Override
    public void createTransaction(Charge charge, ChargeCallback callback) {
        mTransactionsAPI.createTransaction(charge, callback);
    }

    /**
     * Refunds a charge made to a certain user.
     * @param details The details of the refund to clients account.
     * @param callback Transaction callback.
     */
    @Override
    public void refundTransaction(RefundDetails details, RefundCallback callback) {
        mTransactionsAPI.refundTransaction(details, callback);
    }
}
