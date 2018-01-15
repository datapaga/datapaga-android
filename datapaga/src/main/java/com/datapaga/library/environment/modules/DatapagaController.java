package com.datapaga.library.environment.modules;

import com.datapaga.library.environment.interfaces.AccountInterface;
import com.datapaga.library.environment.interfaces.CardsInterface;
import com.datapaga.library.environment.interfaces.DatapagaInterface;
import com.datapaga.library.environment.interfaces.TransactionsInterface;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 7/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * The main controller for the Datapaga Instance and the internal modules.
 */
public class DatapagaController implements DatapagaInterface{

    /** The Transactions Interface instance. */
    private TransactionsInterface mTi;
    /** The Cards Interface instance. */
    private CardsInterface mCi;
    /** The Account Interface instance. */
    private AccountInterface mAi;

    /**
     * Datapaga Controller constructor that instantiates all the necesary modules for the Datapaga Library.
     */
    public DatapagaController() {
        this.mTi = new TransactionsModule();
        this.mCi = new CardsModule();
        this.mAi = new AccountModule();
    }

    /**
     * Retrieves the transactions intance provided by DatapagaCore.
     * @return Transaction interface.
     */
    @Override
    public TransactionsInterface transactions() {
        return this.mTi;
    }

    /**
     * Retrieves the cards intance provided by DatapagaCore.
     * @return Cards interface.
     */
    @Override
    public CardsInterface cards() {
        return this.mCi;
    }

    /**
     * Retrieves the account intance provided by DatapagaCore.
     * @return Account interface.
     */
    @Override
    public AccountInterface account() {
        return this.mAi;
    }


}
