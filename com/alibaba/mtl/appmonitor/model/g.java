package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MeasureValue */
final class g implements Creator<MeasureValue> {
    g() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MeasureValue[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return MeasureValue.a(parcel);
    }
}
