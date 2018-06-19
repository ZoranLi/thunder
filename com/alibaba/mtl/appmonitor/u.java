package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Transaction */
final class u implements Creator<Transaction> {
    u() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Transaction[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Transaction.a(parcel);
    }
}
