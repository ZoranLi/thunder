package com.xunlei.downloadprovider.download.create;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DownData */
final class ac implements Creator<DownData> {
    ac() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DownData[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new DownData(parcel);
    }
}
