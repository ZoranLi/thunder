package com.xunlei.downloadprovider.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDownloadServiceCallback */
public interface b extends IInterface {

    /* compiled from: IDownloadServiceCallback */
    public static abstract class a extends Binder implements b {

        /* compiled from: IDownloadServiceCallback */
        private static class a implements b {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(long[] jArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xunlei.downloadprovider.ipc.IDownloadServiceCallback");
                    obtain.writeLongArray(jArr);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xunlei.downloadprovider.ipc.IDownloadServiceCallback");
                a(parcel.createLongArray());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xunlei.downloadprovider.ipc.IDownloadServiceCallback");
                return true;
            }
        }
    }

    void a(long[] jArr) throws RemoteException;
}
