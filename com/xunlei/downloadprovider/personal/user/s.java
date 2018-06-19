package com.xunlei.downloadprovider.personal.user;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ReportActivity */
final class s implements Creator<ReportActivity$ReportInfo> {
    s() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ReportActivity$ReportInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ReportActivity$ReportInfo(parcel);
    }
}
