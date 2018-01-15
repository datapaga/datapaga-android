package com.datapaga.library.environment;

import android.content.Context;

import com.datapaga.library.core.DatapagaCore;
import com.datapaga.library.environment.interfaces.AccountInterface;
import com.datapaga.library.environment.interfaces.CardsInterface;
import com.datapaga.library.environment.interfaces.TransactionsInterface;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 21/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A class provided by Datapaga for using the library.
 */
public class Datapaga {

    /**
     * Initializes the Datapaga Library with all the internal modules.
     * @param c The application context.
     */
    public static void initialize(Context c) {
        DatapagaCore.instance().initialize(c);
    }

    /**
     * Returns the Transactions Module instance in DatapagaCore.
     * @return Transactions Interface instance.
     */
    public static TransactionsInterface transactions(){
        return DatapagaCore.instance().getInterface().transactions();
    }

    /**
     * Returns the Cards Module instance in DatapagaCore.
     * @return Cards Interface instance.
     */
    public static CardsInterface cards(){
        return DatapagaCore.instance().getInterface().cards();
    }

    /**
     * Returns the Account Module instance in DatapagaCore.
     * @return Account Interface instance.
     */
    public static AccountInterface account(){
        return DatapagaCore.instance().getInterface().account();
    }

}
