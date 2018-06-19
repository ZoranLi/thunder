package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAIDLInvoke */
public interface e extends IInterface {

    /* compiled from: IAIDLInvoke */
    public static abstract class a extends Binder implements e {

        /* compiled from: IAIDLInvoke */
        private static class a implements e {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public IBinder asBinder() {
                return this.a;
            }

            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(b bVar, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                b bVar = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
                        if (parcel.readInt() != 0) {
                            bVar = (b) b.CREATOR.createFromParcel(parcel);
                        }
                        a(bVar);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
                        if (parcel.readInt() != 0) {
                            bVar = (b) b.CREATOR.createFromParcel(parcel);
                        }
                        a(bVar, com.huawei.hms.core.aidl.d.a.a(parcel.readStrongBinder()));
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.huawei.hms.core.aidl.IAIDLInvoke");
            return true;
        }
    }

    void a(b bVar) throws RemoteException;

    void a(b bVar, d dVar) throws RemoteException;
}
