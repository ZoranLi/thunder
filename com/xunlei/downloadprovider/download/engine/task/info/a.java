package com.xunlei.downloadprovider.download.engine.task.info;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DownloadAdditionInfo */
final class a implements Creator<DownloadAdditionInfo> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DownloadAdditionInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new DownloadAdditionInfo(parcel);
    }
}
