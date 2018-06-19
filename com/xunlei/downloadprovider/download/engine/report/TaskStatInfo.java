package com.xunlei.downloadprovider.download.engine.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TaskStatInfo implements Parcelable {
    public static final Creator<TaskStatInfo> CREATOR = new b();
    public String a;
    protected String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public String j;

    public int describeContents() {
        return 0;
    }

    public TaskStatInfo() {
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = "";
        this.i = "";
        this.j = "";
    }

    public TaskStatInfo(String str, String str2, String str3) {
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = "";
        this.i = "";
        this.j = "";
        this.a = str;
        this.c = str3;
        this.b = str2;
    }

    public TaskStatInfo(String str, String str2) {
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = "";
        this.i = "";
        this.j = "";
        this.b = str;
        this.c = str2;
    }

    protected TaskStatInfo(Parcel parcel) {
        this.d = "";
        this.e = "";
        this.f = "";
        boolean z = false;
        this.g = false;
        this.h = "";
        this.i = "";
        this.j = "";
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.g = z;
        this.h = parcel.readString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TaskStatInfo{mCreateOriginFrom='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", mDownloadUrl='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeByte((byte) this.g);
        parcel.writeString(this.h);
    }
}
