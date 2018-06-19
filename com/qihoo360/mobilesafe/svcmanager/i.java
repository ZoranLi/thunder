package com.qihoo360.mobilesafe.svcmanager;

import android.content.Context;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo360.mobilesafe.a.a;
import java.io.FileDescriptor;

/* compiled from: ServiceWrapper */
class i implements IBinder, DeathRecipient {
    private static final boolean a;
    private static final String b;
    private final Context c;
    private IBinder d;
    private final String e;

    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
    }

    public boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
        return false;
    }

    static {
        boolean z = a.a;
        a = z;
        b = z ? "ServiceWrapper" : i.class.getSimpleName();
    }

    public static android.os.IBinder a(android.content.Context r1, java.lang.String r2, android.os.IBinder r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r0 = 0;
    L_0x0006:
        r0 = r3.queryLocalInterface(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return r3;
    L_0x000d:
        r0 = new com.qihoo360.mobilesafe.svcmanager.i;
        r0.<init>(r1, r2, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.i.a(android.content.Context, java.lang.String, android.os.IBinder):android.os.IBinder");
    }

    private i(android.content.Context r1, java.lang.String r2, android.os.IBinder r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r0.<init>();
        r1 = r1.getApplicationContext();
        r0.c = r1;
        r0.d = r3;
        r0.e = r2;
        r1 = r0.d;	 Catch:{ RemoteException -> 0x0014 }
        r2 = 0;	 Catch:{ RemoteException -> 0x0014 }
        r1.linkToDeath(r0, r2);	 Catch:{ RemoteException -> 0x0014 }
        return;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.i.<init>(android.content.Context, java.lang.String, android.os.IBinder):void");
    }

    private IBinder a() throws RemoteException {
        IBinder iBinder = this.d;
        if (iBinder != null) {
            return iBinder;
        }
        a a = QihooServiceManager.a(this.c);
        if (a == null) {
            throw new RemoteException();
        }
        iBinder = a.a(this.e);
        if (iBinder == null) {
            throw new RemoteException();
        }
        this.d = iBinder;
        return iBinder;
    }

    public String getInterfaceDescriptor() throws RemoteException {
        return a().getInterfaceDescriptor();
    }

    public boolean pingBinder() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.a();	 Catch:{ RemoteException -> 0x0009 }
        r0 = r0.pingBinder();	 Catch:{ RemoteException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.i.pingBinder():boolean");
    }

    public boolean isBinderAlive() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.a();	 Catch:{ RemoteException -> 0x0009 }
        r0 = r0.isBinderAlive();	 Catch:{ RemoteException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.i.isBinderAlive():boolean");
    }

    public android.os.IInterface queryLocalInterface(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.a();	 Catch:{ RemoteException -> 0x0009 }
        r2 = r0.queryLocalInterface(r2);	 Catch:{ RemoteException -> 0x0009 }
        return r2;
    L_0x0009:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.i.queryLocalInterface(java.lang.String):android.os.IInterface");
    }

    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        a().dump(fileDescriptor, strArr);
    }

    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return a().transact(i, parcel, parcel2, i2);
    }

    public void linkToDeath(DeathRecipient deathRecipient, int i) throws RemoteException {
        if (a != null) {
            throw new UnsupportedOperationException("ServiceWrapper does NOT support Death Recipient!");
        }
    }

    public void binderDied() {
        if (a) {
            new StringBuilder("ServiceWrapper [binderDied]: ").append(this.e);
        }
        this.d = null;
    }
}
