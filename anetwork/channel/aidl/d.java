package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface d extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements d {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "anetwork.channel.aidl.IRemoteNetworkGetter");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("anetwork.channel.aidl.IRemoteNetworkGetter");
                i = a(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(i != 0 ? i.asBinder() : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("anetwork.channel.aidl.IRemoteNetworkGetter");
                return true;
            }
        }
    }

    n a(int i) throws RemoteException;
}
