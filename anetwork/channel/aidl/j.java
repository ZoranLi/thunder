package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface j extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements j {

        /* compiled from: Taobao */
        private static class a implements j {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(byte[] bArr, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    i = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final long a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    obtain.writeInt(i);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "anetwork.channel.aidl.ParcelableInputStream");
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("anetwork.channel.aidl.ParcelableInputStream");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof j)) {
                return new a(iBinder);
            }
            return (j) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                byte[] bArr = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                        i = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                        i = parcel.readInt();
                        if (i >= 0) {
                            bArr = new byte[i];
                        }
                        i = a(bArr, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        parcel2.writeByteArray(bArr);
                        return true;
                    case 5:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                        i = parcel.readInt();
                        if (i >= 0) {
                            bArr = new byte[i];
                        }
                        i = a(bArr);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        parcel2.writeByteArray(bArr);
                        return true;
                    case 6:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                        i = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(i);
                        return true;
                    case 7:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                        i = d();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("anetwork.channel.aidl.ParcelableInputStream");
            return true;
        }
    }

    int a() throws RemoteException;

    int a(byte[] bArr) throws RemoteException;

    int a(byte[] bArr, int i, int i2) throws RemoteException;

    long a(int i) throws RemoteException;

    void b() throws RemoteException;

    int c() throws RemoteException;

    int d() throws RemoteException;
}
