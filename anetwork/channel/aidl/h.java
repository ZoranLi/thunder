package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface h extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements h {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "anetwork.channel.aidl.ParcelableFuture");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        i = a(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 3:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
                        i = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
                        i = a((long) parcel.readLong());
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("anetwork.channel.aidl.ParcelableFuture");
            return true;
        }
    }

    NetworkResponse a(long j) throws RemoteException;

    boolean a() throws RemoteException;

    boolean a(boolean z) throws RemoteException;

    boolean b() throws RemoteException;
}
