package com.datapaga.library.environment.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * Card object.
 */
public class Card implements Parcelable {

    private String uuid;
    private String status;
    private String expiration_date;
    private String emboss_name;
    private String card_number;
    private String order_status;
    private String card_id;
    private Boolean card_default;
    private String balance;
    private String description;
    private Boolean type_of_transfer;
    private String days;
    private Boolean suspended;

    public Card() {
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String UUID) {
        this.uuid = UUID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpirationDate() {
        return expiration_date;
    }

    public void setExpirationDate(String expirationDate) {
        this.expiration_date = expirationDate;
    }

    public String getEmbossName() {
        return emboss_name;
    }

    public void setEmbossName(String embossName) {
        this.emboss_name = embossName;
    }

    public String getCardNumber() {
        return card_number;
    }

    public void setCardNumber(String cardNumber) {
        this.card_number = cardNumber;
    }

    public String getOrderStatus() {
        return order_status;
    }

    public void setOrderStatus(String orderStatus) {
        this.order_status = orderStatus;
    }

    public String getCardID() {
        return card_id;
    }

    public void setCardID(String cardID) {
        this.card_id = cardID;
    }

    public Boolean getCardDefault() {
        return card_default;
    }

    public void setCardDefault(Boolean cardDefault) {
        this.card_default = cardDefault;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getTransferType() {
        return type_of_transfer;
    }

    public void setTransferType(Boolean transferType) {
        this.type_of_transfer = transferType;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    @Override
    public String toString() {
        return "Card{" +
                "uuid='" + uuid + '\'' +
                ", status='" + status + '\'' +
                ", expiration_date='" + expiration_date + '\'' +
                ", emboss_name='" + emboss_name + '\'' +
                ", card_number='" + card_number + '\'' +
                ", order_status='" + order_status + '\'' +
                ", card_id='" + card_id + '\'' +
                ", card_default=" + card_default +
                ", balance='" + balance + '\'' +
                ", description='" + description + '\'' +
                ", type_of_transfer=" + type_of_transfer +
                ", days='" + days + '\'' +
                ", suspended=" + suspended +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uuid);
        dest.writeString(this.status);
        dest.writeString(this.expiration_date);
        dest.writeString(this.emboss_name);
        dest.writeString(this.card_number);
        dest.writeString(this.order_status);
        dest.writeString(this.card_id);
        dest.writeValue(this.card_default);
        dest.writeString(this.balance);
        dest.writeString(this.description);
        dest.writeValue(this.type_of_transfer);
        dest.writeString(this.days);
        dest.writeValue(this.suspended);
    }

    protected Card(Parcel in) {
        this.uuid = in.readString();
        this.status = in.readString();
        this.expiration_date = in.readString();
        this.emboss_name = in.readString();
        this.card_number = in.readString();
        this.order_status = in.readString();
        this.card_id = in.readString();
        this.card_default = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.balance = in.readString();
        this.description = in.readString();
        this.type_of_transfer = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.days = in.readString();
        this.suspended = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Card> CREATOR = new Parcelable.Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel source) {
            return new Card(source);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };
}
