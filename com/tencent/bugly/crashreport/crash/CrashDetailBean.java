package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Creator<CrashDetailBean> CREATOR = new 1();
    public String A = "";
    public long B = -1;
    public long C = -1;
    public long D = -1;
    public long E = -1;
    public long F = -1;
    public long G = -1;
    public String H = "";
    public String I = "";
    public String J = "";
    public String K = "";
    public String L = "";
    public long M = -1;
    public boolean N = false;
    public Map<String, String> O = null;
    public int P = -1;
    public int Q = -1;
    public Map<String, String> R = null;
    public Map<String, String> S = null;
    public byte[] T = null;
    public String U = null;
    public String V = null;
    public long a = -1;
    public int b = 0;
    public String c = UUID.randomUUID().toString();
    public boolean d = false;
    public String e = "";
    public String f = "";
    public String g = "";
    public Map<String, PlugInBean> h = null;
    public Map<String, PlugInBean> i = null;
    public boolean j = false;
    public boolean k = false;
    public int l = 0;
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public long r = -1;
    public String s = null;
    public int t = 0;
    public String u = "";
    public String v = "";
    public String w = null;
    public byte[] x = null;
    public Map<String, String> y = null;
    public String z = "";

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((CrashDetailBean) obj);
    }

    public CrashDetailBean(Parcel parcel) {
        this.b = parcel.readInt();
        this.c = parcel.readString();
        boolean z = true;
        this.d = parcel.readByte() == (byte) 1;
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.j = parcel.readByte() == (byte) 1;
        this.k = parcel.readByte() == (byte) 1;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.y = ap.b(parcel);
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readLong();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.N = z;
        this.O = ap.b(parcel);
        this.h = ap.a(parcel);
        this.i = ap.a(parcel);
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = ap.b(parcel);
        this.S = ap.b(parcel);
        this.T = parcel.createByteArray();
        this.x = parcel.createByteArray();
        this.U = parcel.readString();
        this.V = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeByte((byte) this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeByte((byte) this.j);
        parcel.writeByte((byte) this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        ap.b(parcel, this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeLong(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeLong(this.M);
        parcel.writeByte((byte) this.N);
        ap.b(parcel, this.O);
        ap.a(parcel, this.h);
        ap.a(parcel, this.i);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        ap.b(parcel, this.R);
        ap.b(parcel, this.S);
        parcel.writeByteArray(this.T);
        parcel.writeByteArray(this.x);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
    }

    public int a(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        long j = this.r - crashDetailBean.r;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : null;
    }
}
