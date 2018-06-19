package com.xunlei.downloadprovider.homepage.cinecism.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: CinecismInfo */
final class a implements Creator<CinecismInfo> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CinecismInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CinecismInfo(parcel);
    }
}
