package com.datapaga.library.environment.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 4/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * Charge object.
 */
public class Charge implements Parcelable {

    private String first_name;
    private String last_name;
    private String web_site_url;
    private String phone;
    private String country;
    private String city;
    private String email;
    private String customer_ip;
    private String region;
    private String zip;
    private String street;
    private String total_amount;
    private String product_description;
    private String card_holder_name;
    private String card_number;
    private String card_expire_month;
    private String card_expire_year;
    private String card_type;
    private String card_security_code;

    public Charge() {
    }

    public Charge(String firstName, String lastName, String websiteURL, String phone,
                  String country, String city, String email, String customerIP, String region,
                  String zip, String street, String totalAmount, String productDescription,
                  String cardHolderName, String cardNumber, String cardExpireMonth,
                  String cardExpireYear, String cardType, String cardSecutityCode) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.web_site_url = websiteURL;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.email = email;
        this.customer_ip = customerIP;
        this.region = region;
        this.zip = zip;
        this.street = street;
        this.total_amount = totalAmount;
        this.product_description = productDescription;
        this.card_holder_name = cardHolderName;
        this.card_number = cardNumber;
        this.card_expire_month = cardExpireMonth;
        this.card_expire_year = cardExpireYear;
        this.card_type = cardType;
        this.card_security_code = cardSecutityCode;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getWebsiteURL() {
        return web_site_url;
    }

    public void setWebsiteURL(String websiteURL) {
        this.web_site_url = websiteURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerIP() {
        return customer_ip;
    }

    public void setCustomerIP(String customerIP) {
        this.customer_ip = customerIP;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTotalAmount() {
        return total_amount;
    }

    public void setTotalAmount(String totalAmount) {
        this.total_amount = totalAmount;
    }

    public String getProductDescription() {
        return product_description;
    }

    public void setProductDescription(String productDescription) {
        this.product_description = productDescription;
    }

    public String getCardHolderName() {
        return card_holder_name;
    }

    public void setCardHolderName(String cardHolderName) {
        this.card_holder_name = cardHolderName;
    }

    public String getCardNumber() {
        return card_number;
    }

    public void setCardNumber(String cardNumber) {
        this.card_number = cardNumber;
    }

    public String getCardExpireMonth() {
        return card_expire_month;
    }

    public void setCardExpireMonth(String cardExpireMonth) {
        this.card_expire_month = cardExpireMonth;
    }

    public String getCardExpireYear() {
        return card_expire_year;
    }

    public void setCardExpireYear(String cardExpireYear) {
        this.card_expire_year = cardExpireYear;
    }

    public String getCardType() {
        return card_type;
    }

    public void setCardType(String cardType) {
        this.card_type = cardType;
    }

    public String getCardSecutityCode() {
        return card_security_code;
    }

    public void setCardSecutityCode(String cardSecutityCode) {
        this.card_security_code = cardSecutityCode;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", web_site_url='" + web_site_url + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", customer_ip='" + customer_ip + '\'' +
                ", region='" + region + '\'' +
                ", zip='" + zip + '\'' +
                ", street='" + street + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", product_description='" + product_description + '\'' +
                ", card_holder_name='" + card_holder_name + '\'' +
                ", card_number='" + card_number + '\'' +
                ", card_expire_month='" + card_expire_month + '\'' +
                ", card_expire_year='" + card_expire_year + '\'' +
                ", card_type='" + card_type + '\'' +
                ", card_security_code='" + card_security_code + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.first_name);
        dest.writeString(this.last_name);
        dest.writeString(this.web_site_url);
        dest.writeString(this.phone);
        dest.writeString(this.country);
        dest.writeString(this.city);
        dest.writeString(this.email);
        dest.writeString(this.customer_ip);
        dest.writeString(this.region);
        dest.writeString(this.zip);
        dest.writeString(this.street);
        dest.writeString(this.total_amount);
        dest.writeString(this.product_description);
        dest.writeString(this.card_holder_name);
        dest.writeString(this.card_number);
        dest.writeString(this.card_expire_month);
        dest.writeString(this.card_expire_year);
        dest.writeString(this.card_type);
        dest.writeString(this.card_security_code);
    }

    protected Charge(Parcel in) {
        this.first_name = in.readString();
        this.last_name = in.readString();
        this.web_site_url = in.readString();
        this.phone = in.readString();
        this.country = in.readString();
        this.city = in.readString();
        this.email = in.readString();
        this.customer_ip = in.readString();
        this.region = in.readString();
        this.zip = in.readString();
        this.street = in.readString();
        this.total_amount = in.readString();
        this.product_description = in.readString();
        this.card_holder_name = in.readString();
        this.card_number = in.readString();
        this.card_expire_month = in.readString();
        this.card_expire_year = in.readString();
        this.card_type = in.readString();
        this.card_security_code = in.readString();
    }

    public static final Parcelable.Creator<Charge> CREATOR = new Parcelable.Creator<Charge>() {
        @Override
        public Charge createFromParcel(Parcel source) {
            return new Charge(source);
        }

        @Override
        public Charge[] newArray(int size) {
            return new Charge[size];
        }
    };
}
