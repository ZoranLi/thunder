package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PubExtra */
final class f implements Creator<PubExtra> {
    f() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PubExtra[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PubExtra(parcel);
    }
}
