package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface g extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements g {

        /* compiled from: Taobao */
        private static class a implements g {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final int a(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableBodyHandler");
                    obtain.writeByteArray(bArr);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableBodyHandler");
                    boolean z = false;
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("anetwork.channel.aidl.ParcelableBodyHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                return new a(iBinder);
            }
            return (g) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableBodyHandler");
                        i = parcel.createByteArray();
                        parcel = a(i);
                        parcel2.writeNoException();
                        parcel2.writeInt(parcel);
                        parcel2.writeByteArray(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableBodyHandler");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("anetwork.channel.aidl.ParcelableBodyHandler");
            return true;
        }
    }

    int a(byte[] bArr) throws RemoteException;

    boolean a() throws RemoteException;
}
