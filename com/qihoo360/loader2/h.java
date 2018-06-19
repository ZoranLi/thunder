package com.qihoo360.loader2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IPlugin */
public interface h extends IInterface {

    /* compiled from: IPlugin */
    public static abstract class a extends Binder implements h {

        /* compiled from: IPlugin */
        private static class a implements h {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final IBinder a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPlugin");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readStrongBinder();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.loader2.IPlugin");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qihoo360.loader2.IPlugin");
                i = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(i);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qihoo360.loader2.IPlugin");
                return true;
            }
        }
    }

    IBinder a(String str) throws RemoteException;
}
