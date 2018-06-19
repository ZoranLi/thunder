package com.xunlei.a.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: IThunderHostFacade */
public interface b extends IInterface {

    /* compiled from: IThunderHostFacade */
    public static abstract class a extends Binder implements b {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.xunlei.plugin.thunder.IThunderHostFacade");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            a aVar = this;
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                boolean z = false;
                String readString;
                Bundle bundle;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        long readLong = parcel.readLong();
                        parcel.readString();
                        a(readLong);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        String readString2 = parcel.readString();
                        String readString3 = parcel.readString();
                        String readString4 = parcel.readString();
                        int readInt = parcel.readInt();
                        boolean z2 = parcel.readInt() != 0;
                        parcel.readString();
                        a(readString2, readString3, readString4, readInt, z2);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(readString, z);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        a(parcel.readString(), parcel3.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        b(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        a(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        readString = b(readString, z);
                        parcel2.writeNoException();
                        parcel4.writeString(readString);
                        return true;
                    case 11:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        Map d = d();
                        parcel2.writeNoException();
                        parcel4.writeMap(d);
                        return true;
                    case 14:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        b(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null;
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(bundle, z);
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(z);
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        c(readString, z);
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel3.enforceInterface("com.xunlei.plugin.thunder.IThunderHostFacade");
                        bundle = e();
                        parcel2.writeNoException();
                        parcel4.writeInt(1);
                        bundle.writeToParcel(parcel4, 1);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel4.writeString("com.xunlei.plugin.thunder.IThunderHostFacade");
            return true;
        }
    }

    void a(long j) throws RemoteException;

    void a(long j, long j2) throws RemoteException;

    void a(Bundle bundle, boolean z) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2, String str3, int i, boolean z) throws RemoteException;

    void a(String str, String str2, String str3, long j, String str4, String str5, String str6, boolean z) throws RemoteException;

    void a(String str, Map map) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    void a(boolean z) throws RemoteException;

    String b(String str, boolean z) throws RemoteException;

    void b() throws RemoteException;

    void b(long j) throws RemoteException;

    void b(String str) throws RemoteException;

    void c() throws RemoteException;

    void c(String str, boolean z) throws RemoteException;

    Map d() throws RemoteException;

    Bundle e() throws RemoteException;
}
