package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VipExtra */
final class j implements Creator<VipExtra> {
    j() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VipExtra[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new VipExtra(parcel);
    }
}
