package com.datapaga.library.environment.callbacks;

import com.datapaga.library.environment.objects.DatapagaException;
import com.datapaga.library.environment.objects.RequestDetails;
import com.datapaga.library.environment.objects.Transaction;

import java.util.List;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 18/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A callback interface to an Transaction Module request.
 */
public interface TransactionsCallback {

    /**
     * On success listener.
     * @param transactions A list of the requested transactions.
     * @param details Pagination details.
     */
    void onSuccess(List<Transaction> transactions, RequestDetails details);

    /**
     * On error listener.
     * @param e Datapaga exception.
     */
    void onError(DatapagaException e);
}
