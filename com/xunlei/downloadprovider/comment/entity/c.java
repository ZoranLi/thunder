package com.xunlei.downloadprovider.comment.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: CommentInfo */
final class c implements Creator<CommentInfo> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CommentInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CommentInfo(parcel);
    }
}
