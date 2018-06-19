package com.qihoo360.loader2;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PluginBinderInfo */
final class r implements Creator<PluginBinderInfo> {
    r() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PluginBinderInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PluginBinderInfo(parcel);
    }
}
