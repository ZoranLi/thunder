package com.xunlei.downloadprovider.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDownload */
public interface a extends IInterface {

    /* compiled from: IDownload */
    public static abstract class a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xunlei.downloadprovider.ipc.IDownload");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.IDownload");
                        a((long[]) parcel.createLongArray());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.IDownload");
                        i = parcel.readStrongBinder();
                        if (i == 0) {
                            i = 0;
                        } else {
                            parcel = i.queryLocalInterface("com.xunlei.downloadprovider.ipc.IDownloadServiceCallback");
                            if (parcel == null || (parcel instanceof b) == 0) {
                                i = new a(i);
                            } else {
                                i = (b) parcel;
                            }
                        }
                        a((b) i);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.xunlei.downloadprovider.ipc.IDownload");
            return true;
        }
    }

    void a(b bVar) throws RemoteException;

    void a(long[] jArr) throws RemoteException;
}
