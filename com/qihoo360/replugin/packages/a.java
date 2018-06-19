package com.qihoo360.replugin.packages;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo360.replugin.model.PluginInfo;
import java.util.List;

/* compiled from: IPluginManagerServer */
public interface a extends IInterface {

    /* compiled from: IPluginManagerServer */
    public static abstract class a extends Binder implements a {

        /* compiled from: IPluginManagerServer */
        private static class a implements a {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final PluginInfo a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readInt() != null ? (PluginInfo) PluginInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return str;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(PluginInfo pluginInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    boolean z = true;
                    if (pluginInfo != null) {
                        obtain.writeInt(1);
                        pluginInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == null) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final List<PluginInfo> a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    List<PluginInfo> createTypedArrayList = obtain2.createTypedArrayList(PluginInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final List<PluginInfo> b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    List<PluginInfo> createTypedArrayList = obtain2.createTypedArrayList(PluginInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    obtain.writeString(str);
                    obtain.writeInt(z);
                    this.a.transact(true, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final PluginRunningList c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    PluginRunningList pluginRunningList = obtain2.readInt() != 0 ? (PluginRunningList) PluginRunningList.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return pluginRunningList;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.a.transact(7, obtain, obtain2, 0);
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

            public final void a(PluginRunningList pluginRunningList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    if (pluginRunningList != null) {
                        obtain.writeInt(1);
                        pluginRunningList.writeToParcel(obtain, 0);
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

            public final void a(String str, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.a.transact(9, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String[] b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.packages.IPluginManagerServer");
                    obtain.writeString(str);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.createStringArray();
                    return str;
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
            attachInterface(this, "com.qihoo360.replugin.packages.IPluginManagerServer");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                PluginInfo pluginInfo = null;
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        i = a((String) parcel.readString());
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        if (parcel.readInt() != 0) {
                            pluginInfo = (PluginInfo) PluginInfo.CREATOR.createFromParcel(parcel);
                        }
                        i = a(pluginInfo);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        i = b();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(i);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        i = parcel.readString();
                        if (parcel.readInt() != null) {
                            z = true;
                        }
                        a((String) i, z);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        i = c();
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        i = a((String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 8:
                        PluginRunningList pluginRunningList;
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        if (parcel.readInt() != 0) {
                            pluginRunningList = (PluginRunningList) PluginRunningList.CREATOR.createFromParcel(parcel);
                        }
                        a(pluginRunningList);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        a(parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.qihoo360.replugin.packages.IPluginManagerServer");
                        i = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStringArray(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.qihoo360.replugin.packages.IPluginManagerServer");
            return true;
        }
    }

    PluginInfo a(String str) throws RemoteException;

    List<PluginInfo> a() throws RemoteException;

    void a(PluginRunningList pluginRunningList) throws RemoteException;

    void a(String str, int i, String str2) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    boolean a(PluginInfo pluginInfo) throws RemoteException;

    boolean a(String str, String str2) throws RemoteException;

    List<PluginInfo> b() throws RemoteException;

    String[] b(String str) throws RemoteException;

    PluginRunningList c() throws RemoteException;
}
