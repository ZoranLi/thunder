package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BUGLY */
final class PlugInBean$1 implements Creator<PlugInBean> {
    PlugInBean$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public final PlugInBean a(Parcel parcel) {
        return new PlugInBean(parcel);
    }

    public final PlugInBean[] a(int i) {
        return new PlugInBean[i];
    }
}
