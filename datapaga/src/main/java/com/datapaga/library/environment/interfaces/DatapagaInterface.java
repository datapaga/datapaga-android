package com.datapaga.library.environment.interfaces;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 21/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * An interface for the Datapaga controller instanced in DatapagaCore.
 */
public interface DatapagaInterface {

    /**
     * Retrieves the transactions intance provided by DatapagaCore.
     * @return Transaction interface.
     */
    TransactionsInterface transactions();

    /**
     * Retrieves the cards intance provided by DatapagaCore.
     * @return Cards interface.
     */
    CardsInterface cards();

    /**
     * Retrieves the account intance provided by DatapagaCore.
     * @return Account interface.
     */
    AccountInterface account();
}
