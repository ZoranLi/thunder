package com.qihoo360.mobilesafe.svcmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo360.replugin.IBinderGetter;

/* compiled from: IServiceChannel */
public interface a extends IInterface {

    /* compiled from: IServiceChannel */
    public static abstract class a extends Binder implements a {

        /* compiled from: IServiceChannel */
        private static class a implements a {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final IBinder a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readStrongBinder();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, IBinderGetter iBinderGetter) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinderGetter != null ? iBinderGetter.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder a(String str, String str2, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(5, obtain, obtain2, null);
                    obtain2.readException();
                    str = obtain2.readStrongBinder();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
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
            attachInterface(this, "com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                        i = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(i);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                        a((String) parcel.readString(), (IBinder) parcel.readStrongBinder());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                        a((String) parcel.readString(), (IBinderGetter) com.qihoo360.replugin.IBinderGetter.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                        b(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                        i = a(parcel.readString(), parcel.readString(), parcel.readStrongBinder());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(i);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
                        a((String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.qihoo360.mobilesafe.svcmanager.IServiceChannel");
            return true;
        }
    }

    IBinder a(String str) throws RemoteException;

    IBinder a(String str, String str2, IBinder iBinder) throws RemoteException;

    void a(String str, IBinder iBinder) throws RemoteException;

    void a(String str, IBinderGetter iBinderGetter) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void b(String str) throws RemoteException;
}
