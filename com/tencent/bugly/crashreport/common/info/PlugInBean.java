package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: BUGLY */
public class PlugInBean implements Parcelable {
    public static final Creator<PlugInBean> CREATOR = new 1();
    public final String a;
    public final String b;
    public final String c;

    public int describeContents() {
        return 0;
    }

    public PlugInBean(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("plid:");
        stringBuilder.append(this.a);
        stringBuilder.append(" plV:");
        stringBuilder.append(this.b);
        stringBuilder.append(" plUUID:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    public PlugInBean(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
