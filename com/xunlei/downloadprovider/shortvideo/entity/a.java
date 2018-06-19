package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: AudioInfo */
final class a implements Creator<AudioInfo> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AudioInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AudioInfo(parcel);
    }
}
