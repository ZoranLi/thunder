package com.xunlei.common.new_ptl.member;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class XLAvatarItem$1 implements Creator<XLAvatarItem> {
    XLAvatarItem$1() {
    }

    private static XLAvatarItem a(Parcel parcel) {
        return new XLAvatarItem(parcel);
    }

    private static XLAvatarItem[] a(int i) {
        return new XLAvatarItem[i];
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new XLAvatarItem[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new XLAvatarItem(parcel);
    }
}
