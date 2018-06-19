package com.qihoo360.loader2.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IPref */
public interface a extends IInterface {

    /* compiled from: IPref */
    public static abstract class a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.qihoo360.loader2.sp.IPref");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.qihoo360.loader2.sp.IPref");
                        i = a(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qihoo360.loader2.sp.IPref");
                        b(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qihoo360.loader2.sp.IPref");
                        i = a(parcel.readString());
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
            parcel2.writeString("com.qihoo360.loader2.sp.IPref");
            return true;
        }
    }

    Bundle a(String str) throws RemoteException;

    String a(String str, String str2, String str3) throws RemoteException;

    void b(String str, String str2, String str3) throws RemoteException;
}
