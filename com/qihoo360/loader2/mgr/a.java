package com.qihoo360.loader2.mgr;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IServiceConnection */
public interface a extends IInterface {

    /* compiled from: IServiceConnection */
    public static abstract class a extends Binder implements a {

        /* compiled from: IServiceConnection */
        private static class a implements a {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(ComponentName componentName, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.mgr.IServiceConnection");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.qihoo360.loader2.mgr.IServiceConnection");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.loader2.mgr.IServiceConnection");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qihoo360.loader2.mgr.IServiceConnection");
                a(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : 0, parcel.readStrongBinder());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qihoo360.loader2.mgr.IServiceConnection");
                return true;
            }
        }
    }

    void a(ComponentName componentName, IBinder iBinder) throws RemoteException;
}
