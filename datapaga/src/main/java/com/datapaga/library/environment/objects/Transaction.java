package com.datapaga.library.environment.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 18/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * Transaction object.
 */
public class Transaction implements Parcelable {

    private int id;
    private String confirmation_number;
    private String transaction_id;
    private String merchant_id;
    private String terminal_id;
    private String total_amount;
    private String payment_status;
    private String code;
    private String description;
    private String transaction_time;
    private String store_id;
    private String created_at;
    private String updated_at;
    private String client_email;
    private String street;
    private String country;
    private String city;
    private String zip;
    private String region;
    private String customer_ip;
    private String created_date;
    private String description_of_transaction;
    private String uuid;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfirmationNumber() {
        return confirmation_number;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmation_number = confirmationNumber;
    }

    public String getTransactionID() {
        return transaction_id;
    }

    public void setTransactionID(String transactionID) {
        this.transaction_id = transactionID;
    }

    public String getMerchantID() {
        return merchant_id;
    }

    public void setMerchantID(String merchantID) {
        this.merchant_id = merchantID;
    }

    public String getTerminalID() {
        return terminal_id;
    }

    public void setTerminalID(String terminalID) {
        this.terminal_id = terminalID;
    }

    public String getTotalAmount() {
        return total_amount;
    }

    public void setTotalAmount(String totalAmount) {
        this.total_amount = totalAmount;
    }

    public String getPaymentStatus() {
        return payment_status;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.payment_status = paymentStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionTime() {
        return transaction_time;
    }

    public void setTransactionTime(String transactionTime) {
        this.transaction_time = transactionTime;
    }

    public String getStoreID() {
        return store_id;
    }

    public void setStoreID(String storeID) {
        this.store_id = storeID;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }

    public String getClientEmail() {
        return client_email;
    }

    public void setClientEmail(String clientEmail) {
        this.client_email = clientEmail;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCustomerIP() {
        return customer_ip;
    }

    public void setCustomerIP(String customerIP) {
        this.customer_ip = customerIP;
    }

    public String getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(String createdDate) {
        this.created_date = createdDate;
    }

    public String getTransactionDescription() {
        return description_of_transaction;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.description_of_transaction = transactionDescription;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String UUID) {
        this.uuid = UUID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", confirmation_number='" + confirmation_number + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", terminal_id='" + terminal_id + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", transaction_time='" + transaction_time + '\'' +
                ", store_id='" + store_id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", client_email='" + client_email + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", region='" + region + '\'' +
                ", customer_ip='" + customer_ip + '\'' +
                ", created_date='" + created_date + '\'' +
                ", description_of_transaction='" + description_of_transaction + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.confirmation_number);
        dest.writeString(this.transaction_id);
        dest.writeString(this.merchant_id);
        dest.writeString(this.terminal_id);
        dest.writeString(this.total_amount);
        dest.writeString(this.payment_status);
        dest.writeString(this.code);
        dest.writeString(this.description);
        dest.writeString(this.transaction_time);
        dest.writeString(this.store_id);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
        dest.writeString(this.client_email);
        dest.writeString(this.street);
        dest.writeString(this.country);
        dest.writeString(this.city);
        dest.writeString(this.zip);
        dest.writeString(this.region);
        dest.writeString(this.customer_ip);
        dest.writeString(this.created_date);
        dest.writeString(this.description_of_transaction);
        dest.writeString(this.uuid);
    }

    protected Transaction(Parcel in) {
        this.id = in.readInt();
        this.confirmation_number = in.readString();
        this.transaction_id = in.readString();
        this.merchant_id = in.readString();
        this.terminal_id = in.readString();
        this.total_amount = in.readString();
        this.payment_status = in.readString();
        this.code = in.readString();
        this.description = in.readString();
        this.transaction_time = in.readString();
        this.store_id = in.readString();
        this.created_at = in.readString();
        this.updated_at = in.readString();
        this.client_email = in.readString();
        this.street = in.readString();
        this.country = in.readString();
        this.city = in.readString();
        this.zip = in.readString();
        this.region = in.readString();
        this.customer_ip = in.readString();
        this.created_date = in.readString();
        this.description_of_transaction = in.readString();
        this.uuid = in.readString();
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel source) {
            return new Transaction(source);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };
}
