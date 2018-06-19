package com.xunlei.downloadprovider.contentpublish.website;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WebsiteInfo */
final class at implements Creator<WebsiteInfo> {
    at() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WebsiteInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WebsiteInfo(parcel);
    }
}
