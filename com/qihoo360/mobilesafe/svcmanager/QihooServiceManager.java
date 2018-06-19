package com.qihoo360.mobilesafe.svcmanager;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import com.qihoo360.mobilesafe.a.a;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class QihooServiceManager {
    private static final boolean a;
    private static final String b;
    private static Uri c;
    private static a d;
    private static Map<String, SoftReference<IBinder>> e = Collections.synchronizedMap(new HashMap());
    private static final IBinder f = new Binder();

    static {
        boolean z = a.a;
        a = z;
        b = z ? "QihooServiceManager" : QihooServiceManager.class.getSimpleName();
    }

    public static android.os.IBinder getService(android.content.Context r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a;
        if (r0 == 0) goto L_0x0012;
    L_0x0004:
        r0 = new java.lang.StringBuilder;
        r1 = "[getService] begin = ";
        r0.<init>(r1);
        r1 = android.os.SystemClock.elapsedRealtime();
        r0.append(r1);
    L_0x0012:
        r0 = e;
        r0 = r0.get(r4);
        r0 = (java.lang.ref.SoftReference) r0;
        r1 = 0;
        if (r0 == 0) goto L_0x004a;
    L_0x001d:
        r0 = r0.get();
        r0 = (android.os.IBinder) r0;
        if (r0 == 0) goto L_0x004b;
    L_0x0025:
        r2 = r0.isBinderAlive();
        if (r2 == 0) goto L_0x0044;
    L_0x002b:
        r2 = r0.pingBinder();
        if (r2 == 0) goto L_0x0044;
    L_0x0031:
        r3 = a;
        if (r3 == 0) goto L_0x0043;
    L_0x0035:
        r3 = new java.lang.StringBuilder;
        r4 = "[getService] end = ";
        r3.<init>(r4);
        r1 = android.os.SystemClock.elapsedRealtime();
        r3.append(r1);
    L_0x0043:
        return r0;
    L_0x0044:
        r2 = e;
        r2.remove(r4);
        goto L_0x004b;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r2 = a(r3);
        if (r2 != 0) goto L_0x0052;
    L_0x0051:
        return r1;
    L_0x0052:
        r1 = r2.a(r4);	 Catch:{ RemoteException -> 0x0068 }
        if (r1 == 0) goto L_0x0067;
    L_0x0058:
        r0 = com.qihoo360.mobilesafe.svcmanager.i.a(r3, r4, r1);	 Catch:{ RemoteException -> 0x0067 }
        r3 = e;	 Catch:{ RemoteException -> 0x0068 }
        r1 = new java.lang.ref.SoftReference;	 Catch:{ RemoteException -> 0x0068 }
        r1.<init>(r0);	 Catch:{ RemoteException -> 0x0068 }
        r3.put(r4, r1);	 Catch:{ RemoteException -> 0x0068 }
        goto L_0x0068;
    L_0x0067:
        r0 = r1;
    L_0x0068:
        r3 = a;
        if (r3 == 0) goto L_0x007a;
    L_0x006c:
        r3 = new java.lang.StringBuilder;
        r4 = "[getService] end = ";
        r3.<init>(r4);
        r1 = android.os.SystemClock.elapsedRealtime();
        r3.append(r1);
    L_0x007a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.QihooServiceManager.getService(android.content.Context, java.lang.String):android.os.IBinder");
    }

    public static boolean addService(android.content.Context r0, java.lang.String r1, android.os.IBinder r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a(r0);
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
        return r0;
    L_0x0008:
        r0.a(r1, r2);	 Catch:{ RemoteException -> 0x000b }
    L_0x000b:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.QihooServiceManager.addService(android.content.Context, java.lang.String, android.os.IBinder):boolean");
    }

    public static boolean addService(android.content.Context r0, java.lang.String r1, com.qihoo360.replugin.IBinderGetter r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a(r0);
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
        return r0;
    L_0x0008:
        r0.a(r1, r2);	 Catch:{ RemoteException -> 0x000b }
    L_0x000b:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.QihooServiceManager.addService(android.content.Context, java.lang.String, com.qihoo360.replugin.IBinderGetter):boolean");
    }

    public static boolean removeService(android.content.Context r0, java.lang.String r1, android.os.IBinder r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a(r0);
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
        return r0;
    L_0x0008:
        r0.b(r1);	 Catch:{ RemoteException -> 0x000b }
    L_0x000b:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.QihooServiceManager.removeService(android.content.Context, java.lang.String, android.os.IBinder):boolean");
    }

    public static android.os.IBinder getPluginService(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = getService(r3, r5);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r1 = a(r3);
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        r3 = 0;
        return r3;
    L_0x000f:
        r2 = f;	 Catch:{ RemoteException -> 0x0019 }
        r1 = r1.a(r4, r5, r2);	 Catch:{ RemoteException -> 0x0019 }
        com.qihoo360.mobilesafe.svcmanager.d.a(r3, r4, r5, r1);	 Catch:{ RemoteException -> 0x001a }
        goto L_0x001a;
    L_0x0019:
        r1 = r0;
    L_0x001a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.QihooServiceManager.getPluginService(android.content.Context, java.lang.String, java.lang.String):android.os.IBinder");
    }

    static com.qihoo360.mobilesafe.svcmanager.a a(android.content.Context r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a;
        if (r0 == 0) goto L_0x0012;
    L_0x0004:
        r0 = new java.lang.StringBuilder;
        r1 = "[getServerChannel] begin = ";
        r0.<init>(r1);
        r1 = android.os.SystemClock.elapsedRealtime();
        r0.append(r1);
    L_0x0012:
        r0 = d;
        if (r0 == 0) goto L_0x0031;
    L_0x0016:
        r0 = d;
        r0 = r0.asBinder();
        r0 = r0.isBinderAlive();
        if (r0 == 0) goto L_0x0031;
    L_0x0022:
        r0 = d;
        r0 = r0.asBinder();
        r0 = r0.pingBinder();
        if (r0 == 0) goto L_0x0031;
    L_0x002e:
        r8 = d;
        return r8;
    L_0x0031:
        r0 = com.qihoo360.replugin.a.b.e;
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r8 = com.qihoo360.mobilesafe.svcmanager.g.a;
        return r8;
    L_0x0038:
        r0 = 0;
        if (r8 != 0) goto L_0x003c;
    L_0x003b:
        return r0;
    L_0x003c:
        r1 = r8.getContentResolver();	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r8 = c;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        if (r8 != 0) goto L_0x005f;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
    L_0x0044:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r2 = "content://";	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r8.<init>(r2);	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r2 = com.qihoo360.mobilesafe.svcmanager.ServiceProvider.a;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r8.append(r2);	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r2 = "/severchannel";	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r8.append(r2);	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r8 = android.net.Uri.parse(r8);	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        c = r8;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
    L_0x005f:
        r2 = c;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r3 = 0;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r4 = 0;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r5 = 0;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r6 = 0;	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r8 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0087, all -> 0x0080 }
        r1 = com.qihoo360.mobilesafe.svcmanager.f.a(r8);	 Catch:{ Exception -> 0x007e, all -> 0x0079 }
        r1 = com.qihoo360.mobilesafe.svcmanager.a.a.a(r1);	 Catch:{ Exception -> 0x007e, all -> 0x0079 }
        d = r1;	 Catch:{ Exception -> 0x0089, all -> 0x0079 }
        if (r8 == 0) goto L_0x008c;
    L_0x0075:
        r8.close();	 Catch:{ Exception -> 0x008c }
        goto L_0x008c;
    L_0x0079:
        r0 = move-exception;
        r7 = r0;
        r0 = r8;
        r8 = r7;
        goto L_0x0081;
    L_0x007e:
        r1 = r0;
        goto L_0x0089;
    L_0x0080:
        r8 = move-exception;
    L_0x0081:
        if (r0 == 0) goto L_0x0086;
    L_0x0083:
        r0.close();	 Catch:{ Exception -> 0x0086 }
    L_0x0086:
        throw r8;
    L_0x0087:
        r8 = r0;
        r1 = r8;
    L_0x0089:
        if (r8 == 0) goto L_0x008c;
    L_0x008b:
        goto L_0x0075;
    L_0x008c:
        r8 = a;
        if (r8 == 0) goto L_0x009e;
    L_0x0090:
        r8 = new java.lang.StringBuilder;
        r0 = "[getServerChannel] end = ";
        r8.<init>(r0);
        r2 = android.os.SystemClock.elapsedRealtime();
        r8.append(r2);
    L_0x009e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.QihooServiceManager.a(android.content.Context):com.qihoo360.mobilesafe.svcmanager.a");
    }

    static void a(android.content.Context r0, java.lang.String r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a(r0);
        if (r0 == 0) goto L_0x000a;
    L_0x0006:
        r0.a(r1, r2);	 Catch:{ RemoteException -> 0x000a }
        return;
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.QihooServiceManager.a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
