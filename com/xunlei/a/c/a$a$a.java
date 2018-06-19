package com.xunlei.a.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILoginCompleteCallback */
class a$a$a implements a {
    private IBinder a;

    a$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final void a(boolean z, int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xunlei.plugin.thunder.ILoginCompleteCallback");
            obtain.writeInt(z);
            obtain.writeInt(i);
            obtain.writeString(str);
            this.a.transact(1, obtain, obtain2, null);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
