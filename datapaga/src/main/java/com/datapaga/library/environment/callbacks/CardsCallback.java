package com.datapaga.library.environment.callbacks;

import com.datapaga.library.environment.objects.Card;
import com.datapaga.library.environment.objects.DatapagaException;
import com.datapaga.library.environment.objects.RequestDetails;

import java.util.List;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A callback interface to an Card Module request.
 */
public interface CardsCallback {

    /**
     * On success listener.
     * @param cards The list of the requested cards.
     * @param details Pagination details.
     */
    void onSuccess(List<Card> cards, RequestDetails details);

    /**
     * On error listener.
     * @param e Datapaga exception.
     */
    void onError(DatapagaException e);
}
