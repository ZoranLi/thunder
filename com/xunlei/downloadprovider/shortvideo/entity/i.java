package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VideoUserInfo */
final class i implements Creator<VideoUserInfo> {
    i() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VideoUserInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new VideoUserInfo(parcel);
    }
}
