package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VipExtras */
final class k implements Creator<VipExtras> {
    k() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VipExtras[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new VipExtras(parcel);
    }
}
