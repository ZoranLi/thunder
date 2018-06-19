package com.xunlei.downloadprovider.ipc.download;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: IPCTaskInfo */
final class b implements Creator<IPCTaskInfo> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new IPCTaskInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new IPCTaskInfo(parcel);
    }
}
