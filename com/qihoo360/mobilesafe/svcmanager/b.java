package com.qihoo360.mobilesafe.svcmanager;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ParcelBinder */
final class b implements Creator<ParcelBinder> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelBinder[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ParcelBinder(parcel);
    }
}
