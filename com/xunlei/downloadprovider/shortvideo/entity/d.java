package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LocationInfo */
final class d implements Creator<LocationInfo> {
    d() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LocationInfo(parcel);
    }
}
