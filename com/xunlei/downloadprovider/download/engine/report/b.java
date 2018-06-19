package com.xunlei.downloadprovider.download.engine.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TaskStatInfo */
final class b implements Creator<TaskStatInfo> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TaskStatInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new TaskStatInfo(parcel);
    }
}
