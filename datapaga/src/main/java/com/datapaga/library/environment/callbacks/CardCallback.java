package com.datapaga.library.environment.callbacks;

import com.datapaga.library.environment.objects.Card;
import com.datapaga.library.environment.objects.DatapagaException;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A callback interface to an Card Module request.
 */
public interface CardCallback {

    /**
     * On success listener.
     * @param card The requested card.
     */
    void onSuccess(Card card);

    /**
     * On error listener.
     * @param e Datapaga exception.
     */
    void onError(DatapagaException e);
}
