package com.igexin.sdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a extends Binder implements IGexinMsgService {
    public a() {
        attachInterface(this, "com.igexin.sdk.aidl.IGexinMsgService");
    }

    public static IGexinMsgService a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.igexin.sdk.aidl.IGexinMsgService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof IGexinMsgService)) ? new b(iBinder) : (IGexinMsgService) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1598968902) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = startService(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 2:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = stopService(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 3:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = isStarted(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 4:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = setSilentTime(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 5:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    byte[] extFunction = extFunction(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(extFunction);
                    return true;
                case 6:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = onASNLConnected(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 7:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = onPSNLConnected(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 8:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = sendByASNL(parcel.readString(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 9:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = receiveToPSNL(parcel.readString(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 10:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = onASNLNetworkConnected();
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                case 11:
                    parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                    i = onASNLNetworkDisconnected();
                    parcel2.writeNoException();
                    parcel2.writeInt(i);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
        parcel2.writeString("com.igexin.sdk.aidl.IGexinMsgService");
        return true;
    }
}
