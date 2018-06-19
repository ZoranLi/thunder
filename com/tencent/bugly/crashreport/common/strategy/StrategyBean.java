package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* compiled from: BUGLY */
public class StrategyBean implements Parcelable {
    public static final Creator<StrategyBean> CREATOR = new Creator<StrategyBean>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public final StrategyBean a(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        public final StrategyBean[] a(int i) {
            return new StrategyBean[i];
        }
    };
    public static String a = "http://rqd.uu.qq.com/rqd/sync";
    public static String b = "http://android.bugly.qq.com/rqd/async";
    public static String c = "http://android.bugly.qq.com/rqd/async";
    public static String d;
    public long e;
    public long f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public long p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public Map<String, String> v;
    public int w;
    public long x;
    public long y;

    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.e = -1;
        this.f = -1;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.q = StatisticConfig.MIN_UPLOAD_INTERVAL;
        this.r = b;
        this.s = c;
        this.t = a;
        this.w = 10;
        this.x = 300000;
        this.y = -1;
        this.f = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("S(@L@L@)");
        d = stringBuilder.toString();
        stringBuilder.setLength(0);
        stringBuilder.append("*^@K#K@!");
        this.u = stringBuilder.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.e = -1;
        this.f = -1;
        boolean z = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.q = StatisticConfig.MIN_UPLOAD_INTERVAL;
        this.r = b;
        this.s = c;
        this.t = a;
        this.w = 10;
        this.x = 300000;
        this.y = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("S(@L@L@)");
            d = stringBuilder.toString();
            this.f = parcel.readLong();
            this.g = parcel.readByte() == (byte) 1;
            this.h = parcel.readByte() == (byte) 1;
            this.i = parcel.readByte() == (byte) 1;
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.u = parcel.readString();
            this.v = ap.b(parcel);
            this.j = parcel.readByte() == (byte) 1;
            this.k = parcel.readByte() == (byte) 1;
            this.n = parcel.readByte() == (byte) 1;
            this.o = parcel.readByte() == (byte) 1;
            this.q = parcel.readLong();
            this.l = parcel.readByte() == (byte) 1;
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.m = z;
            this.p = parcel.readLong();
            this.w = parcel.readInt();
            this.x = parcel.readLong();
            this.y = parcel.readLong();
        } catch (Parcel parcel2) {
            parcel2.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f);
        parcel.writeByte((byte) this.g);
        parcel.writeByte((byte) this.h);
        parcel.writeByte((byte) this.i);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.u);
        ap.b(parcel, this.v);
        parcel.writeByte((byte) this.j);
        parcel.writeByte((byte) this.k);
        parcel.writeByte((byte) this.n);
        parcel.writeByte((byte) this.o);
        parcel.writeLong(this.q);
        parcel.writeByte((byte) this.l);
        parcel.writeByte((byte) this.m);
        parcel.writeLong(this.p);
        parcel.writeInt(this.w);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
    }
}
