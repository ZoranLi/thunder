package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BaseVideoInfo */
final class b implements Creator<BaseVideoInfo> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BaseVideoInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BaseVideoInfo(parcel);
    }
}
