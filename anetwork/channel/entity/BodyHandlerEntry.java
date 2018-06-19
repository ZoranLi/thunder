package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import anet.channel.bytes.ByteArray;
import anet.channel.request.BodyEntry;
import anetwork.channel.aidl.g;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
public class BodyHandlerEntry implements BodyEntry {
    public static final Creator<BodyHandlerEntry> CREATOR = new b();
    g a;

    public int describeContents() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    private BodyHandlerEntry() {
        this.a = null;
    }

    public int writeTo(OutputStream outputStream) throws IOException {
        try {
            ByteArray a = a.a.a(2048);
            int i = 0;
            while (!this.a.a()) {
                int a2 = this.a.a(a.getBuffer());
                outputStream.write(a.getBuffer(), 0, a2);
                i += a2;
            }
            a.recycle();
            return i;
        } catch (OutputStream outputStream2) {
            throw new IOException("RemoteException", outputStream2);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(this.a);
    }
}
