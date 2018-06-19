package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UserVisitInfo */
final class g implements Creator<UserVisitInfo> {
    g() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new UserVisitInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new UserVisitInfo(parcel);
    }
}
