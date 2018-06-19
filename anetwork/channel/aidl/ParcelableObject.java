package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: Taobao */
public class ParcelableObject implements Parcelable {
    public static final Creator<ParcelableObject> CREATOR = new l();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    ParcelableObject(byte b) {
        b = new ParcelableObject();
    }
}
