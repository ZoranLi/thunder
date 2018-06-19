package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LiveExtra */
final class c implements Creator<LiveExtra> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LiveExtra[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LiveExtra(parcel);
    }
}
