package com.igexin.push.util;

import android.os.IBinder;
import android.os.IInterface;

final class o implements IInterface {
    private IBinder a;

    public o(IBinder iBinder) {
        this.a = iBinder;
    }

    public final java.lang.String a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = android.os.Parcel.obtain();
        r1 = android.os.Parcel.obtain();
        r2 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r0.writeInterfaceToken(r2);	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r2 = r5.a;	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r3 = 1;	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r4 = 0;	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r2.transact(r3, r0, r1, r4);	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r1.readException();	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r2 = r1.readString();	 Catch:{ Exception -> 0x002a, all -> 0x0022 }
        r1.recycle();
        r0.recycle();
        return r2;
    L_0x0022:
        r2 = move-exception;
        r1.recycle();
        r0.recycle();
        throw r2;
    L_0x002a:
        r1.recycle();
        r0.recycle();
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.o.a():java.lang.String");
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
