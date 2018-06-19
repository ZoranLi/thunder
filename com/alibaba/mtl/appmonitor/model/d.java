package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DimensionValueSet */
final class d implements Creator<DimensionValueSet> {
    d() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DimensionValueSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return DimensionValueSet.a(parcel);
    }
}
