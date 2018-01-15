package com.datapaga.library.core.api.interfaces;

import com.datapaga.library.environment.callbacks.ChargeCallback;
import com.datapaga.library.environment.callbacks.RefundCallback;
import com.datapaga.library.environment.callbacks.TransactionCallback;
import com.datapaga.library.environment.callbacks.TransactionsCallback;
import com.datapaga.library.environment.objects.Charge;
import com.datapaga.library.environment.objects.RefundDetails;

import java.util.Date;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 4/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * An interface for the transactions module in the internal API.
 */
public interface TransactionsAPIInterface {

    /**
     * Retrieves a list of all the transactions made by the account.
     * @param callback Transactions callback.
     */
    void getAllTransactions(Date startDate, Date endDate, int page,
                            TransactionsCallback callback);

    /**
     * Retrieves the requested transaction by the provided UUID.
     * @param UUID Transaction UUID.
     * @param callback Transaction callback.
     */
    void getSpecificTransaction(String UUID, final TransactionCallback callback);

    /**
     * Creates a charge to the provided customer inside the charge.
     * @param charge The transaction to be charged to clients account.
     * @param callback Transaction callback.
     */
    void createTransaction(Charge charge, final ChargeCallback callback);

    /**
     * Refunds a charge made to a certain user.
     * @param details The details of the refund to clients account.
     * @param callback Transaction callback.
     */
    void refundTransaction(RefundDetails details, final RefundCallback callback);
}
