package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BUGLY */
final class CrashDetailBean$1 implements Creator<CrashDetailBean> {
    CrashDetailBean$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public final CrashDetailBean a(Parcel parcel) {
        return new CrashDetailBean(parcel);
    }

    public final CrashDetailBean[] a(int i) {
        return new CrashDetailBean[i];
    }
}
