package com.xunlei.a.c;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILoginCompleteCallback */
public abstract class a$a extends Binder implements a {
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface("com.xunlei.plugin.thunder.ILoginCompleteCallback");
            a(parcel.readInt() != 0 ? 1 : 0, parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        } else if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel2.writeString("com.xunlei.plugin.thunder.ILoginCompleteCallback");
            return true;
        }
    }
}
