package com.datapaga.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.datapaga.library.environment.Datapaga;
import com.datapaga.library.environment.callbacks.AccountCallback;
import com.datapaga.library.environment.callbacks.CardCallback;
import com.datapaga.library.environment.callbacks.CardsCallback;
import com.datapaga.library.environment.callbacks.ChargeCallback;
import com.datapaga.library.environment.callbacks.RefundCallback;
import com.datapaga.library.environment.callbacks.TransactionCallback;
import com.datapaga.library.environment.callbacks.TransactionsCallback;
import com.datapaga.library.environment.objects.Card;
import com.datapaga.library.environment.objects.Charge;
import com.datapaga.library.environment.objects.DatapagaException;
import com.datapaga.library.environment.objects.RefundDetails;
import com.datapaga.library.environment.objects.RequestDetails;
import com.datapaga.library.environment.objects.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        Datapaga.initialize(getApplicationContext());

//        getAllTransactions();
//        getTransaction();
//        createTransaction();
//        refundTransaction();
//        getAllCards();
//        getCard();
//        getBalance();
    }

    void getAllTransactions() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse("2017-01-01");
            d2 = sdf.parse("2017-12-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Datapaga.transactions().getAllTransactions(d1, d2, 1,
                new TransactionsCallback() {
                    @Override
                    public void onSuccess(List<Transaction> transactions, RequestDetails details) {
                        for (Transaction t : transactions) {
                            log(t.toString());
                        }

                        log(details.toString());
                    }

                    @Override
                    public void onError(DatapagaException e) {
                        log(e.toString());
                    }
                });
    }

    void getTransaction() {
        Datapaga.transactions().getSpecificTransaction("am_38a20609903bafef",
                new TransactionCallback() {
                    @Override
                    public void onSuccess(Transaction transaction) {
                        log(transaction.toString());
                    }

                    @Override
                    public void onError(DatapagaException e) {
                        log(e.toString());
                    }
                });
    }

    void createTransaction() {
        Charge c = new Charge(
                "John",
                "Doe",
                "www.datapaga2.com",
                "77787982",
                "SV",
                "San Salvador",
                "fdhftjhfyjyjyjfyj@android.com",
                "127.0.0.3",
                "CA",
                "0002",
                "Calle Principal #21",
                "200",
                "Camiseta Example",
                "Charlie One",
                "5555555555554444",
                "01",
                "23",
                "MC",
                "071");
        Datapaga.transactions().createTransaction(c,
                new ChargeCallback() {
                    @Override
                    public void onCreated(String UUID) {
                        log("UUID: " + UUID);
                    }

                    @Override
                    public void onError(DatapagaException e) {
                        log(e.toString());
                    }
                });
    }

    void refundTransaction() {
        RefundDetails rd = new RefundDetails(
                "am_38a20609903bafef",
                "Artefacto no funcional.",
                "127.0.33.01");
        Datapaga.transactions().refundTransaction(rd,
                new RefundCallback() {
                    @Override
                    public void onSuccess(Boolean refundApproved) {

                    }

                    @Override
                    public void onError(DatapagaException e) {
                        log(e.toString());
                    }
                });
    }

    void getAllCards() {
        Datapaga.cards().getAllCards(1,
                new CardsCallback() {
                    @Override
                    public void onSuccess(List<Card> cards, RequestDetails details) {
                        for (Card c : cards) {
                            log(c.toString());
                        }

                        log(details.toString());
                    }

                    @Override
                    public void onError(DatapagaException e) {
                        log(e.toString());
                    }
                });
    }

    void getCard() {
        Datapaga.cards().getCardDetails("cd_f012d2a52e1eb118e89f",
                new CardCallback() {
                    @Override
                    public void onSuccess(Card card) {
                        log(card.toString());
                    }

                    @Override
                    public void onError(DatapagaException e) {
                        log(e.toString());
                    }
                });
    }

    void getBalance(){
        Datapaga.account().getBalance(
                new AccountCallback() {
                    @Override
                    public void onSuccess(String balance) {
                        log(balance);
                    }

                    @Override
                    public void onError(DatapagaException e) {
                        log(e.toString());
                    }
                }
        );
    }

    void log(String msg){
        Log.d("Response", msg);
    }
}