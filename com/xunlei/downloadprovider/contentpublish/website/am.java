package com.xunlei.downloadprovider.contentpublish.website;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WebsiteDetailInfo */
final class am implements Creator<WebsiteDetailInfo> {
    am() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WebsiteDetailInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WebsiteDetailInfo(parcel);
    }
}
