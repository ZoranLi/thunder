package com.qihoo360.replugin;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class IBinderGetter$a$a implements IBinderGetter {
    private IBinder a;

    IBinderGetter$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final IBinder get() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.qihoo360.replugin.IBinderGetter");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
