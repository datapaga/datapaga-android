package com.datapaga.library.environment.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 18/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * RequestDetails object.
 */
public class RequestDetails implements Parcelable {

    private int current_page;
    private int next_page;
    private int prev_page;
    private int total_pages;
    private int total_count;

    public RequestDetails() {
    }

    public int getCurrentPage() {
        return current_page;
    }

    public void setCurrentPage(int current_page) {
        this.current_page = current_page;
    }

    public int getNextPage() {
        return next_page;
    }

    public void setNextPage(int next_page) {
        this.next_page = next_page;
    }

    public int getPreviousPage() {
        return prev_page;
    }

    public void setPreviousPage(int prev_page) {
        this.prev_page = prev_page;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public void setTotalPages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotalEntries() {
        return total_count;
    }

    public void setTotalEntries(int total_count) {
        this.total_count = total_count;
    }

    @Override
    public String toString() {
        return "RequestDetails{" +
                "current_page=" + current_page +
                ", next_page=" + next_page +
                ", prev_page=" + prev_page +
                ", total_pages=" + total_pages +
                ", total_count=" + total_count +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.current_page);
        dest.writeInt(this.next_page);
        dest.writeInt(this.prev_page);
        dest.writeInt(this.total_pages);
        dest.writeInt(this.total_count);
    }

    protected RequestDetails(Parcel in) {
        this.current_page = in.readInt();
        this.next_page = in.readInt();
        this.prev_page = in.readInt();
        this.total_pages = in.readInt();
        this.total_count = in.readInt();
    }

    public static final Creator<RequestDetails> CREATOR = new Creator<RequestDetails>() {
        @Override
        public RequestDetails createFromParcel(Parcel source) {
            return new RequestDetails(source);
        }

        @Override
        public RequestDetails[] newArray(int size) {
            return new RequestDetails[size];
        }
    };
}
