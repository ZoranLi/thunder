package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: Taobao */
public interface a extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "anetwork.channel.aidl.Connection");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("anetwork.channel.aidl.Connection");
                        i = a();
                        parcel2.writeNoException();
                        if (i != 0) {
                            i = i.asBinder();
                        } else {
                            i = 0;
                        }
                        parcel2.writeStrongBinder(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("anetwork.channel.aidl.Connection");
                        i = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 3:
                        parcel.enforceInterface("anetwork.channel.aidl.Connection");
                        i = c();
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("anetwork.channel.aidl.Connection");
                        i = d();
                        parcel2.writeNoException();
                        parcel2.writeMap(i);
                        return true;
                    case 5:
                        parcel.enforceInterface("anetwork.channel.aidl.Connection");
                        e();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("anetwork.channel.aidl.Connection");
            return true;
        }
    }

    j a() throws RemoteException;

    int b() throws RemoteException;

    String c() throws RemoteException;

    Map d() throws RemoteException;

    void e() throws RemoteException;
}
