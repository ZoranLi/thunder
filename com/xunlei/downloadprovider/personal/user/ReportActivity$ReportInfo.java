package com.xunlei.downloadprovider.personal.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReportActivity$ReportInfo implements Parcelable {
    public static final Creator<ReportActivity$ReportInfo> CREATOR = new s();
    int a;
    String b;
    String c;
    String d;

    public int describeContents() {
        return 0;
    }

    public ReportActivity$ReportInfo(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    protected ReportActivity$ReportInfo(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
