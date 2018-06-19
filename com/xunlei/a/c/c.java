package com.xunlei.a.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IThunderMemberFacade */
public interface c extends IInterface {

    /* compiled from: IThunderMemberFacade */
    public static abstract class a extends Binder implements c {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xunlei.plugin.thunder.IThunderMemberFacade");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xunlei.plugin.thunder.IThunderMemberFacade");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xunlei.plugin.thunder.IThunderMemberFacade");
                        i = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(1);
                        i.writeToParcel(parcel2, 1);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xunlei.plugin.thunder.IThunderMemberFacade");
                        i = parcel.readString();
                        i2 = parcel.readStrongBinder();
                        if (i2 == 0) {
                            i2 = 0;
                        } else {
                            IInterface queryLocalInterface = i2.queryLocalInterface("com.xunlei.plugin.thunder.ILoginCompleteCallback");
                            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                                i2 = new a$a$a(i2);
                            } else {
                                i2 = (a) queryLocalInterface;
                            }
                        }
                        a(i, i2, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xunlei.plugin.thunder.IThunderMemberFacade");
                        a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xunlei.plugin.thunder.IThunderMemberFacade");
                        i = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xunlei.plugin.thunder.IThunderMemberFacade");
                        i = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.xunlei.plugin.thunder.IThunderMemberFacade");
            return true;
        }
    }

    void a(String str, a aVar, String str2) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    boolean a() throws RemoteException;

    boolean a(String str) throws RemoteException;

    Bundle b() throws RemoteException;

    boolean c() throws RemoteException;
}
