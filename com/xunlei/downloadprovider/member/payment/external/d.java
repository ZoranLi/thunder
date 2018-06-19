package com.xunlei.downloadprovider.member.payment.external;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PayAction */
final class d implements Creator<PayAction> {
    d() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayAction[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayAction(parcel);
    }
}
