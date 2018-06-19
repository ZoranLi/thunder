package com.xunlei.downloadprovider.publiser.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PublisherInfo */
final class p implements Creator<PublisherInfo> {
    p() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PublisherInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PublisherInfo(parcel);
    }
}
