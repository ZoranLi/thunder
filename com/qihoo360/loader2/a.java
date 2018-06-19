package com.qihoo360.loader2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.qihoo360.loader2.BinderCursor.BinderParcelable;

/* compiled from: BinderCursor */
final class a implements Creator<BinderParcelable> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BinderParcelable[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderParcelable(parcel);
    }
}
