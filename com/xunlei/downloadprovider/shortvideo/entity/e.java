package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ParamsExtra */
final class e implements Creator<ParamsExtra> {
    e() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParamsExtra[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ParamsExtra(parcel);
    }
}
