package com.alibaba.sdk.android.feedback.xblink.webview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class j implements Parcelable {
    public static final Creator a = new k();
    private boolean b = true;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;

    public j(Parcel parcel) {
        boolean z = true;
        this.b = parcel.readInt() == 1;
        this.c = parcel.readInt() == 1;
        this.d = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.e = z;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
