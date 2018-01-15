package com.datapaga.library.environment.callbacks;

import com.datapaga.library.environment.objects.DatapagaException;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A callback interface to an Account Module request.
 */
public interface AccountCallback {

    /**
     * On success listener.
     * @param balance The account balance.
     */
    void onSuccess(String balance);

    /**
     * On error listener.
     * @param e Datapaga exception.
     */
    void onError(DatapagaException e);
}
