package com.huawei.hms.core.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DataBuffer */
final class c implements Creator<b> {
    c() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public final b a(Parcel parcel) {
        return new b(parcel);
    }

    public final b[] a(int i) {
        return new b[i];
    }
}
