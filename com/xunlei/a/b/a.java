package com.xunlei.a.b;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IQrcodeFacade */
public interface a extends IInterface {

    /* compiled from: IQrcodeFacade */
    public static abstract class a extends Binder implements a {

        /* compiled from: IQrcodeFacade */
        private static class a implements a {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final byte[] a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.qrcode.IQrcodeFacade");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.createByteArray();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bitmap a(String str, int i, Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.qrcode.IQrcodeFacade");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readInt() != null ? (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return str;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xunlei.plugin.qrcode.IQrcodeFacade");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xunlei.plugin.qrcode.IQrcodeFacade");
                        i = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xunlei.plugin.qrcode.IQrcodeFacade");
                        i = a(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null);
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
            parcel2.writeString("com.xunlei.plugin.qrcode.IQrcodeFacade");
            return true;
        }
    }

    Bitmap a(String str, int i, Bitmap bitmap) throws RemoteException;

    byte[] a(String str) throws RemoteException;
}
