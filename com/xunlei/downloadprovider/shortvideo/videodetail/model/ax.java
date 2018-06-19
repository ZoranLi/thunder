package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager.CommentSateInfo;

/* compiled from: StateSyncManager */
final class ax implements Creator<CommentSateInfo> {
    ax() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CommentSateInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CommentSateInfo(parcel);
    }
}
