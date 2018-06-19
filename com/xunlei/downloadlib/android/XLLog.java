package com.xunlei.downloadlib.android;

import android.util.Log;
import com.xunlei.downloadlib.proguard.c;
import com.xunlei.downloadlib.proguard.d;
import com.xunlei.downloadlib.proguard.e;

public class XLLog {
    private static c a;
    private static e b;

    @Deprecated
    public static boolean init(String str) {
        return init();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean init() {
        /*
        r0 = com.xunlei.downloadlib.android.XLLog.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x003d }
        r2 = 1;
        if (r1 == 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);
        return r2;
    L_0x000a:
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ all -> 0x003d }
        r1 = r1.getPath();	 Catch:{ all -> 0x003d }
        r3 = new java.io.File;	 Catch:{ all -> 0x003d }
        r4 = "xunlei_ds_log.ini";
        r3.<init>(r1, r4);	 Catch:{ all -> 0x003d }
        r1 = r3.exists();	 Catch:{ all -> 0x003d }
        if (r1 != 0) goto L_0x0021;
    L_0x001f:
        monitor-exit(r0);
        return r2;
    L_0x0021:
        r1 = new com.xunlei.downloadlib.proguard.c;	 Catch:{ all -> 0x003d }
        r3 = r3.getPath();	 Catch:{ all -> 0x003d }
        r1.<init>(r3);	 Catch:{ all -> 0x003d }
        a = r1;	 Catch:{ all -> 0x003d }
        r1 = r1.a();	 Catch:{ all -> 0x003d }
        if (r1 == 0) goto L_0x003b;
    L_0x0032:
        r1 = new com.xunlei.downloadlib.proguard.e;	 Catch:{ all -> 0x003d }
        r3 = a;	 Catch:{ all -> 0x003d }
        r1.<init>(r3);	 Catch:{ all -> 0x003d }
        b = r1;	 Catch:{ all -> 0x003d }
    L_0x003b:
        monitor-exit(r0);
        return r2;
    L_0x003d:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.android.XLLog.init():boolean");
    }

    public static void i(String str, String str2) {
        a(d.LOG_LEVEL_INFO, str, str2);
    }

    public static void d(String str, String str2) {
        a(d.LOG_LEVEL_DEBUG, str, str2);
    }

    public static void w(String str, String str2) {
        a(d.LOG_LEVEL_WARN, str, str2);
    }

    public static void e(String str, String str2) {
        a(d.LOG_LEVEL_ERROR, str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        d dVar = d.LOG_LEVEL_WARN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(th);
        a(dVar, str, stringBuilder.toString());
    }

    public static void v(String str, String str2) {
        d(str, str2);
    }

    public static void wtf(String str, String str2, Throwable th) {
        d dVar = d.LOG_LEVEL_WARN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(th);
        a(dVar, str, stringBuilder.toString());
    }

    public static boolean canbeLog(d dVar) {
        return b != null ? true : null;
    }

    static void a(d dVar, String str, String str2) {
        Object obj;
        if (dVar != d.LOG_LEVEL_ERROR) {
            if (a == null || !a.b()) {
                obj = null;
                if (obj == null || b != null) {
                    str2 = b(dVar, str, str2);
                    if (obj != null) {
                        Log.println(dVar.a(), str, str2);
                    }
                    if (b != null) {
                        b.a(dVar, str, str2);
                    }
                }
                return;
            }
        }
        obj = 1;
        if (obj == null) {
        }
        str2 = b(dVar, str, str2);
        if (obj != null) {
            Log.println(dVar.a(), str, str2);
        }
        if (b != null) {
            b.a(dVar, str, str2);
        }
    }

    public static void printStackTrace(Throwable th) {
        if (b != null) {
            b.a(th);
        }
    }

    private static java.lang.String b(com.xunlei.downloadlib.proguard.d r1, java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = new java.lang.StringBuilder;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r3);
        r3 = "\t";
        r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        r2 = java.lang.Thread.currentThread();	 Catch:{ Exception -> 0x006e }
        r2 = r2.getStackTrace();	 Catch:{ Exception -> 0x006e }
        r3 = r2.length;	 Catch:{ Exception -> 0x006e }
        r0 = 5;	 Catch:{ Exception -> 0x006e }
        if (r3 <= r0) goto L_0x0057;	 Catch:{ Exception -> 0x006e }
    L_0x0022:
        r2 = r2[r0];	 Catch:{ Exception -> 0x006e }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006e }
        r0 = "[";	 Catch:{ Exception -> 0x006e }
        r3.<init>(r0);	 Catch:{ Exception -> 0x006e }
        r0 = r2.getFileName();	 Catch:{ Exception -> 0x006e }
        r3.append(r0);	 Catch:{ Exception -> 0x006e }
        r0 = ":";	 Catch:{ Exception -> 0x006e }
        r3.append(r0);	 Catch:{ Exception -> 0x006e }
        r3 = r3.toString();	 Catch:{ Exception -> 0x006e }
        r1.append(r3);	 Catch:{ Exception -> 0x006e }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006e }
        r3.<init>();	 Catch:{ Exception -> 0x006e }
        r2 = r2.getLineNumber();	 Catch:{ Exception -> 0x006e }
        r3.append(r2);	 Catch:{ Exception -> 0x006e }
        r2 = "]";	 Catch:{ Exception -> 0x006e }
        r3.append(r2);	 Catch:{ Exception -> 0x006e }
        r2 = r3.toString();	 Catch:{ Exception -> 0x006e }
        r1.append(r2);	 Catch:{ Exception -> 0x006e }
        goto L_0x006e;	 Catch:{ Exception -> 0x006e }
    L_0x0057:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006e }
        r0 = "[stack=";	 Catch:{ Exception -> 0x006e }
        r3.<init>(r0);	 Catch:{ Exception -> 0x006e }
        r2 = r2.length;	 Catch:{ Exception -> 0x006e }
        r3.append(r2);	 Catch:{ Exception -> 0x006e }
        r2 = "]";	 Catch:{ Exception -> 0x006e }
        r3.append(r2);	 Catch:{ Exception -> 0x006e }
        r2 = r3.toString();	 Catch:{ Exception -> 0x006e }
        r1.append(r2);	 Catch:{ Exception -> 0x006e }
    L_0x006e:
        r1 = r1.toString();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.android.XLLog.b(com.xunlei.downloadlib.proguard.d, java.lang.String, java.lang.String):java.lang.String");
    }
}
