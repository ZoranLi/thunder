package com.xunlei.tdlive.route;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IXLLiveRoute extends IInterface {

    public static abstract class Stub extends Binder implements IXLLiveRoute {

        private static class a implements IXLLiveRoute {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public IBinder asBinder() {
                return this.a;
            }

            public boolean dispatch(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.tdlive.route.IXLLiveRoute");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    str2 = null;
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != null) {
                        str2 = 1;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return str2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xunlei.tdlive.route.IXLLiveRoute");
        }

        public static IXLLiveRoute asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xunlei.tdlive.route.IXLLiveRoute");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXLLiveRoute)) {
                return new a(iBinder);
            }
            return (IXLLiveRoute) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xunlei.tdlive.route.IXLLiveRoute");
                i = dispatch(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(i);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xunlei.tdlive.route.IXLLiveRoute");
                return true;
            }
        }
    }

    boolean dispatch(String str, String str2) throws RemoteException;
}
