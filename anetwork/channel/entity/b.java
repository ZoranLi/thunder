package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import anetwork.channel.aidl.g.a;

/* compiled from: Taobao */
final class b implements Creator<BodyHandlerEntry> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BodyHandlerEntry[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        BodyHandlerEntry bodyHandlerEntry = new BodyHandlerEntry();
        bodyHandlerEntry.a = a.a(parcel.readStrongBinder());
        return bodyHandlerEntry;
    }
}
