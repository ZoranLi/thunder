package com.xunlei.downloadprovider.comment.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BaseCommentInfo */
final class b implements Creator<BaseCommentInfo> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BaseCommentInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BaseCommentInfo(parcel);
    }
}
