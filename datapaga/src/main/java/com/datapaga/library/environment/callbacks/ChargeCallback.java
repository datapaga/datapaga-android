package com.datapaga.library.environment.callbacks;

import com.datapaga.library.environment.objects.DatapagaException;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 4/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A callback interface to an Transaction Module request.
 */
public interface ChargeCallback {

    /**
     * On created listener.
     * @param UUID The UUID of the created transaction.
     */
    void onCreated(String UUID);

    /**
     * On error listener.
     * @param e Datapaga exception.
     */
    void onError(DatapagaException e);
}
