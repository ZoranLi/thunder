package com.qihoo360.loader2;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo360.replugin.component.service.server.b;

/* compiled from: IPluginClient */
public interface i extends IInterface {

    /* compiled from: IPluginClient */
    public static abstract class a extends Binder implements i {

        /* compiled from: IPluginClient */
        private static class a implements i {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final String a(String str, int i, String str2, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readStrongBinder();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void b(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final b c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    b a = com.qihoo360.replugin.component.service.server.b.a.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginClient");
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.qihoo360.loader2.IPluginClient");
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.loader2.IPluginClient");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                return new a(iBinder);
            }
            return (i) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Intent intent = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        i = parcel.readString();
                        i2 = parcel.readInt();
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        i = a(i, i2, readString, intent);
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        i = a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(i);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        a(intent);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        b(intent);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        i = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 7:
                        IBinder asBinder;
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        i = c();
                        parcel2.writeNoException();
                        if (i != 0) {
                            asBinder = i.asBinder();
                        }
                        parcel2.writeStrongBinder(asBinder);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        i = parcel.readString();
                        i2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        a(i, i2, intent);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        i = d();
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginClient");
                        i = e();
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.qihoo360.loader2.IPluginClient");
            return true;
        }
    }

    IBinder a(String str, String str2) throws RemoteException;

    String a(String str, int i, String str2, Intent intent) throws RemoteException;

    void a() throws RemoteException;

    void a(Intent intent) throws RemoteException;

    void a(String str, String str2, Intent intent) throws RemoteException;

    int b() throws RemoteException;

    void b(Intent intent) throws RemoteException;

    b c() throws RemoteException;

    String d() throws RemoteException;

    String e() throws RemoteException;
}
