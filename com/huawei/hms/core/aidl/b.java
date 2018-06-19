package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: DataBuffer */
public class b implements Parcelable {
    public static final Creator<b> CREATOR = new c();
    public String a;
    public Bundle b;
    private int c;
    private Bundle d;

    public int describeContents() {
        return 0;
    }

    private b(Parcel parcel) {
        this.c = 1;
        this.b = null;
        this.d = null;
        a(parcel);
    }

    public b() {
        this.c = 1;
        this.b = null;
        this.d = null;
    }

    public b(String str, int i) {
        this.c = 1;
        this.b = null;
        this.d = null;
        this.a = str;
        this.c = i;
    }

    public b a(Bundle bundle) {
        this.d = bundle;
        return this;
    }

    public Bundle a() {
        return this.d;
    }

    public int b() {
        return this.d == null ? 0 : 1;
    }

    private void a(Parcel parcel) {
        this.c = parcel.readInt();
        this.a = parcel.readString();
        this.b = parcel.readBundle(a(Bundle.class));
        this.d = parcel.readBundle(a(Bundle.class));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeString(this.a);
        parcel.writeBundle(this.b);
        parcel.writeBundle(this.d);
    }

    public int c() {
        return this.c;
    }

    private static ClassLoader a(Class cls) {
        return cls.getClassLoader();
    }
}
