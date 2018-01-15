package com.datapaga.library.environment.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 18/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * DatapagaException object.
 */
public class DatapagaException implements Parcelable {

    private String code;
    private String error;
    private String server_status;

    public DatapagaException(String code, String error, String server_status) {
        this.code = code;
        this.error = error;
        this.server_status = server_status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getServerStatus() {
        return server_status;
    }

    public void setServerStatus(String serverStatus) {
        this.server_status = serverStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DatapagaException{" +
                "code='" + code + '\'' +
                ", error='" + error + '\'' +
                ", server_status='" + server_status + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.error);
        dest.writeString(this.server_status);
    }

    protected DatapagaException(Parcel in) {
        this.code = in.readString();
        this.error = in.readString();
        this.server_status = in.readString();
    }

    public static final Creator<DatapagaException> CREATOR = new Creator<DatapagaException>() {
        @Override
        public DatapagaException createFromParcel(Parcel source) {
            return new DatapagaException(source);
        }

        @Override
        public DatapagaException[] newArray(int size) {
            return new DatapagaException[size];
        }
    };
}
