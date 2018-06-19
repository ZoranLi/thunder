package com.getui.gtc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Ie implements Parcelable {
    public static final Creator CREATOR = new c();
    private String a;
    private String b;
    private String c;
    private String d;

    protected Ie(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ie ie = (Ie) obj;
        return this.a != null ? this.a.equals(ie.a) : ie.a == null;
    }

    public String getAid() {
        return this.b;
    }

    public String getCn() {
        return this.a;
    }

    public String getCs() {
        return this.c;
    }

    public String getK() {
        return this.d;
    }

    public int hashCode() {
        return this.a != null ? this.a.hashCode() : 0;
    }

    public void setAid(String str) {
        this.b = str;
    }

    public void setCn(String str) {
        this.a = str;
    }

    public void setCs(String str) {
        this.c = str;
    }

    public void setK(String str) {
        this.d = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
