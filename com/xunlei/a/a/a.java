package com.xunlei.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILibDlnaFacade */
public interface a extends IInterface {

    /* compiled from: ILibDlnaFacade */
    public static abstract class a extends Binder implements a {

        /* compiled from: ILibDlnaFacade */
        private static class a implements a {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    boolean z = false;
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                    boolean z = false;
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        i = a(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        d();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        i = e();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        i = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.xunlei.plugin.libdlna.ILibDlnaFacade");
                        i = f();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.xunlei.plugin.libdlna.ILibDlnaFacade");
            return true;
        }
    }

    void a() throws RemoteException;

    boolean a(int i) throws RemoteException;

    boolean a(int i, String str) throws RemoteException;

    void b() throws RemoteException;

    void c() throws RemoteException;

    void d() throws RemoteException;

    int e() throws RemoteException;

    boolean f() throws RemoteException;
}
