package com.xunlei.downloadprovider.ipc.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDownloadTaskManager */
public interface a extends IInterface {

    /* compiled from: IDownloadTaskManager */
    public static abstract class a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        i = a(parcel.readLong());
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        b(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        c(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        d(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        i = e(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        f(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        i = g(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        h(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        i = i(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        i = j(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeLong(i);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        i = k(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeLong(i);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        i = a(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLongArray(i);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
                        a(parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager");
            return true;
        }
    }

    IPCTaskInfo a(long j) throws RemoteException;

    void a(long j, int i, String str, long j2, int i2) throws RemoteException;

    long[] a(long j, int i) throws RemoteException;

    void b(long j) throws RemoteException;

    void c(long j) throws RemoteException;

    void d(long j) throws RemoteException;

    boolean e(long j) throws RemoteException;

    void f(long j) throws RemoteException;

    boolean g(long j) throws RemoteException;

    void h(long j) throws RemoteException;

    boolean i(long j) throws RemoteException;

    long j(long j) throws RemoteException;

    long k(long j) throws RemoteException;
}
