package com.datapaga.library.environment.callbacks;

import com.datapaga.library.environment.objects.DatapagaException;
import com.datapaga.library.environment.objects.Transaction;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 4/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A callback interface to an Transaction Module request.
 */
public interface TransactionCallback {

    /**
     * On success listener.
     * @param transaction The requested transaction.
     */
    void onSuccess(Transaction transaction);

    /**
     * On error listener.
     * @param e Datapaga exception.
     */
    void onError(DatapagaException e);
}
