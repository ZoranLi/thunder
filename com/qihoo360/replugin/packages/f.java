package com.qihoo360.replugin.packages;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PluginRunningList */
final class f implements Creator<PluginRunningList> {
    f() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PluginRunningList[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PluginRunningList(parcel);
    }
}
