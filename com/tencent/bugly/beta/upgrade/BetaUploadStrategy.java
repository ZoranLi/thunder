package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.bg;

/* compiled from: BUGLY */
public class BetaUploadStrategy implements Parcelable, Creator<BetaUploadStrategy> {
    public static final Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();
    public bg a;
    public long b;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public BetaUploadStrategy() {
        this.a = new bg();
        this.a.b = true;
        this.a.c = true;
        if (e.E.Q) {
            this.a.d = StrategyBean.b;
            this.a.e = StrategyBean.b;
        } else {
            this.a.d = "http://android.bugly.qq.com/rqd/async";
            this.a.e = "http://android.bugly.qq.com/rqd/async";
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.a.h = currentTimeMillis;
        this.b = currentTimeMillis;
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.a = (bg) ah.a(parcel.createByteArray(), bg.class);
        this.b = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(ah.a(this.a));
        parcel.writeLong(this.b);
    }

    public BetaUploadStrategy a(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    public BetaUploadStrategy[] a(int i) {
        return new BetaUploadStrategy[i];
    }
}
