package com.datapaga.library.environment.modules;

import com.datapaga.library.core.DatapagaCore;
import com.datapaga.library.core.api.interfaces.CardsAPIInterface;
import com.datapaga.library.environment.callbacks.CardCallback;
import com.datapaga.library.environment.callbacks.CardsCallback;
import com.datapaga.library.environment.interfaces.CardsInterface;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The middle controller for the Cards Module between his API Module and the Datapaga controller.
 */
public class CardsModule implements CardsInterface{

    /**
     * The Cards API Interface.
     */
    private CardsAPIInterface mCardsAPI;

    /**
     * Cards module constructor that instantiates the API Interface.
     */
    public CardsModule() {
        this.mCardsAPI = DatapagaCore.instance().getCardsModule();
    }

    /**
     * Retrieves a list of all cards available in the account.
     * @param callback Cards callback.
     */
    @Override
    public void getAllCards(CardsCallback callback) {
        mCardsAPI.getAllCards(0, callback);
    }

    /**
     * Retrieves a list of all cards available in the account.
     * @param page Page number to be called.
     * @param callback Cards callback.
     */
    @Override
    public void getAllCards(int page, CardsCallback callback) {
        mCardsAPI.getAllCards(page, callback);
    }

    /**
     * Retrieves the card details from the provided UUID.
     * @param UUID Card UUID.
     * @param callback Card callback.
     */
    @Override
    public void getCardDetails(String UUID, CardCallback callback) {
        mCardsAPI.getCardDetails(UUID, callback);
    }
}
