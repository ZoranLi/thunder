package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DimensionSet */
final class c implements Creator<DimensionSet> {
    c() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DimensionSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return DimensionSet.a(parcel);
    }
}
