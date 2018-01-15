package com.datapaga.library.environment.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 5/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * RefundDetails object.
 */
public class RefundDetails implements Parcelable {

    private String uuid;
    private String refund_description;
    private String ip_customer;

    public RefundDetails() {
    }

    public RefundDetails(String uuid, String refund_description, String ip_customer) {
        this.uuid = uuid;
        this.refund_description = refund_description;
        this.ip_customer = ip_customer;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String UUID) {
        this.uuid = UUID;
    }

    public String getRefundDescription() {
        return refund_description;
    }

    public void setRefundDescription(String refundDescription) {
        this.refund_description = refundDescription;
    }

    public String getCustomerIP() {
        return ip_customer;
    }

    public void setCustomerIP(String customerIP) {
        this.ip_customer = customerIP;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uuid);
        dest.writeString(this.refund_description);
        dest.writeString(this.ip_customer);
    }

    protected RefundDetails(Parcel in) {
        this.uuid = in.readString();
        this.refund_description = in.readString();
        this.ip_customer = in.readString();
    }

    public static final Parcelable.Creator<RefundDetails> CREATOR = new Parcelable.Creator<RefundDetails>() {
        @Override
        public RefundDetails createFromParcel(Parcel source) {
            return new RefundDetails(source);
        }

        @Override
        public RefundDetails[] newArray(int size) {
            return new RefundDetails[size];
        }
    };
}
