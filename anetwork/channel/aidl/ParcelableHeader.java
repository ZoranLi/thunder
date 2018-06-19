package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ParcelableHeader implements Parcelable {
    public static Creator<ParcelableHeader> c = new i();
    public int a;
    public Map<String, List<String>> b;

    public int describeContents() {
        return 0;
    }

    public ParcelableHeader(int i, Map<String, List<String>> map) {
        this.b = map;
        this.a = i;
    }

    ParcelableHeader() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.b != 0) {
            parcel.writeInt(1);
            parcel.writeMap(this.b);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.a);
    }

    static ParcelableHeader a(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.b = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.a = parcel.readInt();
        } catch (Parcel parcel2) {
            ALog.e("anet.ParcelableHeader", "[readFromParcel]", null, parcel2, new Object[0]);
        }
        return parcelableHeader;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ParcelableResponseHeader [responseCode=");
        stringBuilder.append(this.a);
        stringBuilder.append(", header=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
