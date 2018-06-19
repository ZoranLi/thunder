package com.xunlei.downloadprovider.download.engine.shub;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GcidInfo implements Parcelable {
    public static final Creator<GcidInfo> CREATOR = new a();
    public String a;
    public String b;
    private long c;

    public int describeContents() {
        return 0;
    }

    protected GcidInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readLong();
    }

    public GcidInfo(String str, String str2, long j) {
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
    }
}
