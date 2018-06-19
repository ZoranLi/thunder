package com.qihoo360.replugin.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PluginInfo */
final class a implements Creator<PluginInfo> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PluginInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PluginInfo(parcel);
    }
}
