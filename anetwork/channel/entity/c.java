package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import anetwork.channel.aidl.j.a;

/* compiled from: Taobao */
final class c implements Creator<InputStreamEntry> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new InputStreamEntry[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        InputStreamEntry inputStreamEntry = new InputStreamEntry();
        inputStreamEntry.a = a.a(parcel.readStrongBinder());
        return inputStreamEntry;
    }
}
