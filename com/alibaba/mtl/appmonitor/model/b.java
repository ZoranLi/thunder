package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Dimension */
final class b implements Creator<Dimension> {
    b() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Dimension[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Dimension.a(parcel);
    }
}
