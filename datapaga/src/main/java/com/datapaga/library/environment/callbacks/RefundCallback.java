package com.datapaga.library.environment.callbacks;

import com.datapaga.library.environment.objects.DatapagaException;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A callback interface to an Transaction Module request.
 */
public interface RefundCallback {

    /**
     * On success listener.
     * @param refundApproved The refund response.
     */
    void onSuccess(Boolean refundApproved);

    /**
     * On error listener.
     * @param e Datapaga exception.
     */
    void onError(DatapagaException e);
}
