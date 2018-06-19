package com.xunlei.downloadprovider.ipc.download;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCTaskInfo implements Parcelable {
    public static final Creator<IPCTaskInfo> CREATOR = new b();
    public long a;
    public String b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public int k;
    public int l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public boolean r;
    public int s;
    public int t;
    public long u;
    public long v;

    public int describeContents() {
        return 0;
    }

    protected IPCTaskInfo(Parcel parcel) {
        this.a = -1;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        boolean z = false;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = 0;
        this.t = 0;
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readLong();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readLong();
        this.n = parcel.readLong();
        this.o = parcel.readLong();
        this.p = parcel.readLong();
        this.q = parcel.readLong();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.r = z;
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readLong();
        this.v = parcel.readLong();
    }

    public IPCTaskInfo() {
        this.a = -1;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = 0;
        this.t = 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeLong(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeLong(this.m);
        parcel.writeLong(this.n);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
        parcel.writeLong(this.q);
        parcel.writeByte((byte) this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeLong(this.u);
        parcel.writeLong(this.v);
    }
}
