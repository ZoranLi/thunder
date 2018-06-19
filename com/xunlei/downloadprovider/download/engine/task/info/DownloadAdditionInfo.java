package com.xunlei.downloadprovider.download.engine.task.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DownloadAdditionInfo implements Parcelable {
    public static final Creator<DownloadAdditionInfo> CREATOR = new a();
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public int g;
    public boolean h;

    public int describeContents() {
        return 0;
    }

    public DownloadAdditionInfo() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = true;
        this.g = 0;
        this.h = false;
    }

    protected DownloadAdditionInfo(Parcel parcel) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        boolean z = true;
        this.f = true;
        this.g = 0;
        this.h = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == null) {
            z = false;
        }
        this.h = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeByte((byte) this.f);
        parcel.writeByte((byte) this.h);
    }
}
