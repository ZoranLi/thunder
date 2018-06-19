package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Measure */
final class e implements Creator<Measure> {
    e() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Measure[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Measure.a(parcel);
    }
}
