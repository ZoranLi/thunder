package com.alibaba.mtl.appmonitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* compiled from: IMonitor */
public interface r extends IInterface {

    /* compiled from: IMonitor */
    public static abstract class a extends Binder implements r {

        /* compiled from: IMonitor */
        private static class a implements r {
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
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(z);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(boolean z, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(z);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(3, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, MeasureSet measureSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        obtain.writeInt(1);
                        dimensionSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        obtain.writeInt(1);
                        dimensionSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeMap(map);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(14, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != null) {
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

            public final void a(String str, String str2, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    this.a.transact(19, obtain, obtain2, 0.0d);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, String str3, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeDouble(d);
                    this.a.transact(20, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != null) {
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

            public final void b(String str, String str2, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    this.a.transact(24, obtain, obtain2, 0.0d);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void g(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void h(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean c(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != null) {
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

            public final void d(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(29, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.a.transact(30, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    this.a.transact(31, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(32, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(33, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void i(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void j(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean e(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != null) {
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

            public final void c(String str, String str2, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    this.a.transact(37, obtain, obtain2, 0.0d);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        obtain.writeInt(1);
                        dimensionValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeDouble(d);
                    this.a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        obtain.writeInt(1);
                        dimensionValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (measureValueSet != null) {
                        obtain.writeInt(1);
                        measureValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(Transaction transaction, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    if (transaction != null) {
                        obtain.writeInt(1);
                        transaction.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(Transaction transaction, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    if (transaction != null) {
                        obtain.writeInt(1);
                        transaction.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.a.transact(41, obtain, obtain2, 0);
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
            attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
        }

        public static r a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof r)) {
                return new a(iBinder);
            }
            return (r) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                MeasureSet measureSet = null;
                String readString;
                String readString2;
                MeasureValueSet measureValueSet;
                Transaction transaction;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(z);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(z, (String) parcel.readString(), (String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a((String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        b(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a(parcel.readInt(), (int) parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = parcel.readString();
                        i2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            measureSet = (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel);
                        }
                        a((String) i, (String) i2, measureSet);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = parcel.readString();
                        i2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            measureSet = (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel);
                        }
                        if (parcel.readInt() != null) {
                            z = true;
                        }
                        a((String) i, (String) i2, measureSet, z);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        DimensionSet dimensionSet;
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = parcel.readString();
                        i2 = parcel.readString();
                        MeasureSet measureSet2 = parcel.readInt() != 0 ? (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            dimensionSet = (DimensionSet) DimensionSet.CREATOR.createFromParcel(parcel);
                        }
                        a((String) i, (String) i2, measureSet2, dimensionSet);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        readString = parcel.readString();
                        readString2 = parcel.readString();
                        MeasureSet measureSet3 = parcel.readInt() != 0 ? (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            measureValueSet = (DimensionSet) DimensionSet.CREATOR.createFromParcel(parcel);
                        }
                        a(readString, readString2, measureSet3, (DimensionSet) measureValueSet, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a((Map) parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        d();
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        c(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        d(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = a((String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a((String) parcel.readString(), (String) parcel.readString(), parcel.readDouble());
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        e(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        f(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = b((String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        b((String) parcel.readString(), (String) parcel.readString(), parcel.readDouble());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        g(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        h(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = c(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        d(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a((String) parcel.readString(), (String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 30:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a((String) parcel.readString(), (String) parcel.readString(), parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        b((String) parcel.readString(), (String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        c((String) parcel.readString(), (String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        j(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = e(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 37:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        c((String) parcel.readString(), (String) parcel.readString(), parcel.readDouble());
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        readString = parcel.readString();
                        readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            measureValueSet = (DimensionValueSet) DimensionValueSet.CREATOR.createFromParcel(parcel);
                        }
                        a(readString, readString2, (DimensionValueSet) measureValueSet, parcel.readDouble());
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        i = parcel.readString();
                        i2 = parcel.readString();
                        DimensionValueSet dimensionValueSet = parcel.readInt() != 0 ? (DimensionValueSet) DimensionValueSet.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            measureValueSet = (MeasureValueSet) MeasureValueSet.CREATOR.createFromParcel(parcel);
                        }
                        a((String) i, (String) i2, dimensionValueSet, measureValueSet);
                        parcel2.writeNoException();
                        return true;
                    case 40:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        if (parcel.readInt() != 0) {
                            transaction = (Transaction) Transaction.CREATOR.createFromParcel(parcel);
                        }
                        a(transaction, (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 41:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        if (parcel.readInt() != 0) {
                            transaction = (Transaction) Transaction.CREATOR.createFromParcel(parcel);
                        }
                        b(transaction, (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.alibaba.mtl.appmonitor.IMonitor");
            return true;
        }
    }

    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(Transaction transaction, String str) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2, double d) throws RemoteException;

    void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException;

    void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException;

    void a(String str, String str2, String str3) throws RemoteException;

    void a(String str, String str2, String str3, double d) throws RemoteException;

    void a(String str, String str2, String str3, String str4) throws RemoteException;

    void a(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void a(Map map) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(boolean z, String str, String str2, String str3) throws RemoteException;

    boolean a(String str, String str2) throws RemoteException;

    void b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(Transaction transaction, String str) throws RemoteException;

    void b(String str, String str2, double d) throws RemoteException;

    void b(String str, String str2, String str3) throws RemoteException;

    boolean b(String str, String str2) throws RemoteException;

    void c() throws RemoteException;

    void c(int i) throws RemoteException;

    void c(String str, String str2, double d) throws RemoteException;

    void c(String str, String str2, String str3) throws RemoteException;

    boolean c(String str, String str2) throws RemoteException;

    void d() throws RemoteException;

    void d(int i) throws RemoteException;

    void d(String str, String str2) throws RemoteException;

    void e(int i) throws RemoteException;

    boolean e(String str, String str2) throws RemoteException;

    void f(int i) throws RemoteException;

    void g(int i) throws RemoteException;

    void h(int i) throws RemoteException;

    void i(int i) throws RemoteException;

    void j(int i) throws RemoteException;
}
