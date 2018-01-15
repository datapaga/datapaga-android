Datapaga Android Library
============

A Java wrapper around the Datapaga API using Google Volley.

More info here:
* [About Datapaga](https://datapaga.com/)
* [API Documentation](http://apidocs.datapaga.com)

# Installation and setup

Step 1. Add this in your root build.gradle at the end of the repositories:
``` Gradle
allprojects {
	repositories {
		...
		jcenter()
	}
}
```
Step 2. Add the dependency
``` Gradle
dependencies {
	implementation 'com.android.volley:volley:1.1.0'
	implementation 'com.google.code.gson:gson:2.8.2'
	implementation 'com.datapaga.android:datapaga:1.0.0'
}
```
* `Volley` for networking.
* `Gson` for parsing.

Step 3. Add internet permissions in the manifest
``` xml
<uses-permission android:name="android.permission.INTERNET" />
```


## Using your API Credentials and initializing the core.
* Add your credentials inside the `application` element.

``` xml
<meta-data
android:name="com.datapaga.api.key"
android:value="YOUR_API_KEY" />

<meta-data
android:name="com.datapaga.api.secret"
android:value="YOUR_API_SECRET" />
```

* Initialize the Datapaga Library.

``` java
Datapaga.initialize(getApplicationContext());
```


## Usage
All API endpoints are available as methods inside each module object. Each method has the following signature:
### Datapaga.module().endpoint(Parameters, Callback)
__Arguments__
* Parameters - If needed, this will be request's properties.
* Callback - The callback is used to return to the previous method once the wrapper has retrieved the desired data from the API.

__Transactions Module Examples__ 
* Requesting transactions with date filters.
``` java
/** Main method */
void getAllTransactions(Date startDate, Date endDate, int page, TransactionsCallback callback);

/** Usage */
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
```

* Requesting a specific transaction.
``` java
/** Method */
void getSpecificTransaction(String UUID, TransactionCallback callback);

/** Usage */
Datapaga.transactions().getSpecificTransaction("SOME_TRANSACTION_UUID",
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
```

* Creating a transaction.
``` java
/** Method */
void createTransaction(Charge charge, ChargeCallback callback);

/** Usage */
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
```

* Refunding a transaction.
``` java
/** Method */
void refundTransaction(RefundDetails details, RefundCallback callback);

/** Usage */
Datapaga.transactions().refundTransaction(rd,
	new RefundCallback() {
	    @Override
	    public void onSuccess(Boolean refundApproved) {
	    	//Some action
	    }

	    @Override
	    public void onError(DatapagaException e) {
	        log(e.toString());
	    }
	});
```

__Cards Module Examples__ 

* Getting all cards.
``` java
/** Main method */
void getAllCards(int page, CardsCallback callback);

/** Usage */
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
```

* Getting card details.
``` java
/** Main method */
void getCardDetails(String UUID, CardCallback callback);

/** Usage */
Datapaga.cards().getCardDetails("SOME_CARD_UUID",
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
```

__Account Module Examples__ 

* Getting account balance.
``` java
/** Main method */
void getBalance(AccountCallback callback);

/** Usage */
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
	});       
```