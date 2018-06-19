package com.xunlei.downloadprovider.download.engine.shub;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: GcidInfo */
final class a implements Creator<GcidInfo> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GcidInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GcidInfo(parcel);
    }
}
