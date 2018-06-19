package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LottieAnimationView */
final class h implements Creator<SavedState> {
    h() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }
}
