package com.getui.gtc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class d implements Parcelable {
    public static final Creator CREATOR = new e();
    public int a;
    public String b;
    public String c;
    public Long d;
    public String e;
    public String f;
    public String g;
    public Long h;

    protected d(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = Long.valueOf(parcel.readLong());
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = Long.valueOf(parcel.readLong());
    }

    public final Long a() {
        return Long.valueOf(this.d == null ? 0 : this.d.longValue());
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.a == ((d) obj).a;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d.longValue());
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h.longValue());
    }
}
