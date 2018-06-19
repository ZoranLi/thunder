package com.qihoo360.loader2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class PluginBinderInfo implements Parcelable {
    public static final Creator<PluginBinderInfo> CREATOR = new r();
    public int a;
    public int b;
    public int c;

    public final int describeContents() {
        return 0;
    }

    PluginBinderInfo() {
        this.a = 0;
        this.b = -1;
        this.c = -1;
    }

    public PluginBinderInfo(int i) {
        this.a = i;
        this.b = -1;
        this.c = -1;
    }

    PluginBinderInfo(Parcel parcel) {
        a(parcel);
    }

    final void a(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}
