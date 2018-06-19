package com.qihoo360.replugin.component.service.server;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IPluginServiceServer */
public interface b extends IInterface {

    /* compiled from: IPluginServiceServer */
    public static abstract class a extends Binder implements b {

        /* compiled from: IPluginServiceServer */
        private static class a implements b {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final ComponentName a(Intent intent, Messenger messenger) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (messenger != null) {
                        obtain.writeInt(1);
                        messenger.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    intent = obtain2.readInt() != null ? (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int b(Intent intent, Messenger messenger) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (messenger != null) {
                        obtain.writeInt(1);
                        messenger.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    intent = obtain2.readInt();
                    return intent;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(Intent intent, com.qihoo360.loader2.mgr.a aVar, int i, Messenger messenger) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    obtain.writeInt(i);
                    if (messenger != null) {
                        obtain.writeInt(1);
                        messenger.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    intent = obtain2.readInt();
                    return intent;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(com.qihoo360.loader2.mgr.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    boolean z = false;
                    this.a.transact(4, obtain, obtain2, 0);
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

            public final String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                    this.a.transact(5, obtain, obtain2, 0);
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
            attachInterface(this, "com.qihoo360.replugin.component.service.server.IPluginServiceServer");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Messenger messenger = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                        i = parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : 0;
                        if (parcel.readInt() != 0) {
                            messenger = (Messenger) Messenger.CREATOR.createFromParcel(parcel);
                        }
                        i = a(i, messenger);
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                        i = parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : 0;
                        if (parcel.readInt() != 0) {
                            messenger = (Messenger) Messenger.CREATOR.createFromParcel(parcel);
                        }
                        i = b(i, messenger);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                        i = parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : 0;
                        i2 = com.qihoo360.loader2.mgr.a.a.a(parcel.readStrongBinder());
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            messenger = (Messenger) Messenger.CREATOR.createFromParcel(parcel);
                        }
                        i = a(i, i2, readInt, messenger);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                        i = a(com.qihoo360.loader2.mgr.a.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeString(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.qihoo360.replugin.component.service.server.IPluginServiceServer");
            return true;
        }
    }

    int a(Intent intent, com.qihoo360.loader2.mgr.a aVar, int i, Messenger messenger) throws RemoteException;

    ComponentName a(Intent intent, Messenger messenger) throws RemoteException;

    String a() throws RemoteException;

    boolean a(com.qihoo360.loader2.mgr.a aVar) throws RemoteException;

    int b(Intent intent, Messenger messenger) throws RemoteException;
}
