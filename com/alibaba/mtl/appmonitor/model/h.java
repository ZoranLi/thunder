package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MeasureValueSet */
final class h implements Creator<MeasureValueSet> {
    h() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MeasureValueSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return MeasureValueSet.a(parcel);
    }
}
