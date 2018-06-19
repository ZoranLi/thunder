package com.qihoo360.loader2;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo360.replugin.component.service.server.b;
import com.qihoo360.replugin.model.PluginInfo;
import java.util.List;
import java.util.Map;

/* compiled from: IPluginHost */
public interface j extends IInterface {

    /* compiled from: IPluginHost */
    public static abstract class a extends Binder implements j {

        /* compiled from: IPluginHost */
        private static class a implements j {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(String str, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readStrongBinder();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final long a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final i a(String str, int i, PluginBinderInfo pluginBinderInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (pluginBinderInfo != null) {
                        obtain.writeInt(1);
                        pluginBinderInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    str = com.qihoo360.loader2.i.a.a(obtain2.readStrongBinder());
                    if (obtain2.readInt() != 0) {
                        pluginBinderInfo.a(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return str;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String a(String str, int i, IBinder iBinder, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str2);
                    this.a.transact(5, obtain, obtain2, null);
                    obtain2.readException();
                    str = obtain2.readString();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final List<PluginInfo> b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    List<PluginInfo> createTypedArrayList = obtain2.createTypedArrayList(PluginInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(7, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(8, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(9, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(10, obtain, obtain2, null);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(PluginBinderInfo pluginBinderInfo, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    if (pluginBinderInfo != null) {
                        obtain.writeInt(1);
                        pluginBinderInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(PluginBinderInfo pluginBinderInfo, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    if (pluginBinderInfo != null) {
                        obtain.writeInt(1);
                        pluginBinderInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
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
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeInt(i);
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    i = obtain2.readInt();
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(PluginInfo pluginInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    if (pluginInfo != null) {
                        obtain.writeInt(1);
                        pluginInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final PluginInfo b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    this.a.transact(18, obtain, obtain2, 0);
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

            public final boolean b(PluginInfo pluginInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    boolean z = true;
                    if (pluginInfo != null) {
                        obtain.writeInt(1);
                        pluginInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(19, obtain, obtain2, 0);
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

            public final boolean c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    boolean z = false;
                    this.a.transact(20, obtain, obtain2, 0);
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

            public final void a(String str, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(21, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void b(String str, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(22, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void c(String str, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d(String str, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    boolean z = false;
                    this.a.transact(25, obtain, obtain2, 0);
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

            public final IBinder a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readStrongBinder();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final List a(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    intent = obtain2.readArrayList(getClass().getClassLoader());
                    return intent;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final b d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    b a = com.qihoo360.replugin.component.service.server.b.a.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final com.qihoo360.replugin.packages.a e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    this.a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    com.qihoo360.replugin.packages.a a = com.qihoo360.replugin.packages.a.a.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    this.a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readInt();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeString(str);
                    this.a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readInt();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    obtain.writeInt(i);
                    this.a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    i = obtain2.readString();
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.loader2.IPluginHost");
                    this.a.transact(33, obtain, obtain2, 0);
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
            attachInterface(this, "com.qihoo360.loader2.IPluginHost");
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.loader2.IPluginHost");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof j)) {
                return new a(iBinder);
            }
            return (j) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                IBinder iBinder = null;
                PluginBinderInfo pluginBinderInfo;
                Intent intent;
                PluginInfo pluginInfo;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        a((String) parcel.readString(), (IBinder) parcel.readStrongBinder());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = a((String) parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(i);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeLong(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = parcel.readString();
                        i2 = parcel.readInt();
                        parcel = parcel.readInt() != 0 ? (PluginBinderInfo) PluginBinderInfo.CREATOR.createFromParcel(parcel) : null;
                        i = a((String) i, i2, (PluginBinderInfo) parcel);
                        parcel2.writeNoException();
                        if (i != 0) {
                            iBinder = i.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        if (parcel != null) {
                            parcel2.writeInt(1);
                            parcel.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = a((String) parcel.readString(), parcel.readInt(), parcel.readStrongBinder(), (String) parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = b();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(i);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        a(parcel.readInt(), (String) parcel.readString(), parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        b(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        a(parcel.readInt(), (String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        b(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        if (parcel.readInt() != 0) {
                            pluginBinderInfo = (PluginBinderInfo) PluginBinderInfo.CREATOR.createFromParcel(parcel);
                        }
                        a(pluginBinderInfo, (IBinder) parcel.readStrongBinder());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        if (parcel.readInt() != 0) {
                            pluginBinderInfo = (PluginBinderInfo) PluginBinderInfo.CREATOR.createFromParcel(parcel);
                        }
                        b(pluginBinderInfo, (IBinder) parcel.readStrongBinder());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        a((String) parcel.readString(), (Map) parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = parcel.readString();
                        i2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        a((String) i, (String) i2, intent);
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        if (parcel.readInt() != 0) {
                            pluginInfo = (PluginInfo) PluginInfo.CREATOR.createFromParcel(parcel);
                        }
                        a(pluginInfo);
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = b((String) parcel.readString());
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 19:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        if (parcel.readInt() != 0) {
                            pluginInfo = (PluginInfo) PluginInfo.CREATOR.createFromParcel(parcel);
                        }
                        i = b(pluginInfo);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 21:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = parcel.readString();
                        if (parcel.readInt() != null) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        a((String) i, intent);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = parcel.readString();
                        if (parcel.readInt() != null) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        b((String) i, intent);
                        return true;
                    case 23:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = parcel.readString();
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        c(i, intent);
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = parcel.readString();
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        d(i, intent);
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 26:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = a((String) parcel.readString(), (String) parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(i);
                        return true;
                    case 27:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        i = a(intent);
                        parcel2.writeNoException();
                        parcel2.writeList(i);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = d();
                        parcel2.writeNoException();
                        if (i != 0) {
                            iBinder = i.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = e();
                        parcel2.writeNoException();
                        if (i != 0) {
                            iBinder = i.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = f(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = b(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.qihoo360.loader2.IPluginHost");
                        i = f();
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.qihoo360.loader2.IPluginHost");
            return true;
        }
    }

    int a(int i) throws RemoteException;

    long a() throws RemoteException;

    IBinder a(String str) throws RemoteException;

    IBinder a(String str, String str2) throws RemoteException;

    i a(String str, int i, PluginBinderInfo pluginBinderInfo) throws RemoteException;

    String a(String str, int i, IBinder iBinder, String str2) throws RemoteException;

    List a(Intent intent) throws RemoteException;

    void a(int i, String str, String str2) throws RemoteException;

    void a(int i, String str, String str2, String str3) throws RemoteException;

    void a(PluginBinderInfo pluginBinderInfo, IBinder iBinder) throws RemoteException;

    void a(PluginInfo pluginInfo) throws RemoteException;

    void a(String str, Intent intent) throws RemoteException;

    void a(String str, IBinder iBinder) throws RemoteException;

    void a(String str, String str2, Intent intent) throws RemoteException;

    void a(String str, Map map) throws RemoteException;

    PluginInfo b(String str) throws RemoteException;

    String b(int i) throws RemoteException;

    List<PluginInfo> b() throws RemoteException;

    void b(int i, String str, String str2) throws RemoteException;

    void b(int i, String str, String str2, String str3) throws RemoteException;

    void b(PluginBinderInfo pluginBinderInfo, IBinder iBinder) throws RemoteException;

    void b(String str, Intent intent) throws RemoteException;

    boolean b(PluginInfo pluginInfo) throws RemoteException;

    void c() throws RemoteException;

    void c(String str, Intent intent) throws RemoteException;

    boolean c(String str) throws RemoteException;

    b d() throws RemoteException;

    void d(String str, Intent intent) throws RemoteException;

    boolean d(String str) throws RemoteException;

    int e(String str) throws RemoteException;

    com.qihoo360.replugin.packages.a e() throws RemoteException;

    int f(String str) throws RemoteException;

    String f() throws RemoteException;
}
