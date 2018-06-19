package com.qihoo360.replugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IBinderGetter extends IInterface {

    public static abstract class a extends Binder implements IBinderGetter {
        public static IBinderGetter a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.replugin.IBinderGetter");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBinderGetter)) {
                return new a(iBinder);
            }
            return (IBinderGetter) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qihoo360.replugin.IBinderGetter");
                i = get();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(i);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qihoo360.replugin.IBinderGetter");
                return true;
            }
        }
    }

    IBinder get() throws RemoteException;
}
