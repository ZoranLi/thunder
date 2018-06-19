package com.igexin.sdk.aidl;

import android.os.IBinder;
import android.os.Parcel;

class b implements IGexinMsgService {
    private IBinder a;

    b(IBinder iBinder) {
        this.a = iBinder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public byte[] extFunction(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeByteArray(bArr);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            bArr = obtain2.createByteArray();
            return bArr;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int isStarted(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeString(str);
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int onASNLConnected(String str, String str2, String str3, long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeLong(j);
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int onASNLNetworkConnected() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            this.a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int onASNLNetworkDisconnected() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            this.a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int onPSNLConnected(String str, String str2, String str3, long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeLong(j);
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int receiveToPSNL(String str, String str2, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeByteArray(bArr);
            this.a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int sendByASNL(String str, String str2, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeByteArray(bArr);
            this.a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int setSilentTime(int i, int i2, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str);
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            i = obtain2.readInt();
            return i;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int startService(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeString(str);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int stopService(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.igexin.sdk.aidl.IGexinMsgService");
            obtain.writeString(str);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
