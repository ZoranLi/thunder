package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MeasureSet */
final class f implements Creator<MeasureSet> {
    f() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MeasureSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return MeasureSet.a(parcel);
    }
}
