package com.xunlei.downloadprovider.xlui.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PagerSlidingTabStrip */
final class c implements Creator<SavedState> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }
}
