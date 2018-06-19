package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface k extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements k {

        /* compiled from: Taobao */
        private static class a implements k {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    if (defaultProgressEvent != null) {
                        obtain.writeInt(1);
                        defaultProgressEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    if (defaultFinishEvent != null) {
                        obtain.writeInt(1);
                        defaultFinishEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(int i, ParcelableHeader parcelableHeader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    obtain.writeInt(i);
                    i = 1;
                    if (parcelableHeader != null) {
                        obtain.writeInt(1);
                        parcelableHeader.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == null) {
                        i = 0;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return i;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    byte readByte = obtain2.readByte();
                    return readByte;
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
            attachInterface(this, "anetwork.channel.aidl.ParcelableNetworkListener");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                DefaultProgressEvent defaultProgressEvent = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                        if (parcel.readInt() != 0) {
                            defaultProgressEvent = (DefaultProgressEvent) DefaultProgressEvent.CREATOR.createFromParcel(parcel);
                        }
                        a(defaultProgressEvent);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        DefaultFinishEvent defaultFinishEvent;
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                        if (parcel.readInt() != 0) {
                            defaultFinishEvent = (DefaultFinishEvent) DefaultFinishEvent.CREATOR.createFromParcel(parcel);
                        }
                        a(defaultFinishEvent);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        ParcelableHeader parcelableHeader;
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                        i = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            parcelableHeader = (ParcelableHeader) ParcelableHeader.c.createFromParcel(parcel);
                        }
                        i = a(i, parcelableHeader);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                        a((j) anetwork.channel.aidl.j.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                        i = a();
                        parcel2.writeNoException();
                        parcel2.writeByte(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("anetwork.channel.aidl.ParcelableNetworkListener");
            return true;
        }
    }

    byte a() throws RemoteException;

    void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException;

    void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException;

    void a(j jVar) throws RemoteException;

    boolean a(int i, ParcelableHeader parcelableHeader) throws RemoteException;
}
