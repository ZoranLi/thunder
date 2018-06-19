package com.xunlei.downloadprovider.homepage.photoarticle.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PhotoArticleInfo */
final class a implements Creator<PhotoArticleInfo> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PhotoArticleInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PhotoArticleInfo(parcel);
    }
}
