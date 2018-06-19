package com.xunlei.downloadprovider.member.payment.external;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PayEntryParam */
final class f implements Creator<PayEntryParam> {
    f() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayEntryParam[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayEntryParam(parcel);
    }
}
