package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VideoFollowInfo */
final class h implements Creator<VideoFollowInfo> {
    h() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VideoFollowInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new VideoFollowInfo(parcel);
    }
}
