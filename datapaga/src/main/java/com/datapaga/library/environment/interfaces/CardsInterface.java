package com.datapaga.library.environment.interfaces;

import com.datapaga.library.environment.callbacks.CardCallback;
import com.datapaga.library.environment.callbacks.CardsCallback;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * An interface for the cards module in the Datapaga library.
 */
public interface CardsInterface {

    /**
     * Retrieves a list of all cards available in the account.
     * @param callback Cards callback.
     */
    void getAllCards(CardsCallback callback);

    /**
     * Retrieves a list of all cards available in the account.
     * @param page Page number to be called.
     * @param callback Cards callback.
     */
    void getAllCards(int page, CardsCallback callback);

    /**
     * Retrieves the card details from the provided UUID.
     * @param UUID Card UUID.
     * @param callback Card callback.
     */
    void getCardDetails(String UUID, CardCallback callback);
}
