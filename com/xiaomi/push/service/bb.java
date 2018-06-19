package com.xiaomi.push.service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class bb {
    private static volatile bb a;
    private Context b;
    private Handler c = new Handler(Looper.getMainLooper());
    private Map<String, Map<String, String>> d = new HashMap();

    private bb(Context context) {
        this.b = context;
    }

    public static bb a(Context context) {
        if (a == null) {
            synchronized (bb.class) {
                if (a == null) {
                    a = new bb(context);
                }
            }
        }
        return a;
    }

    private synchronized java.lang.String a(java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.d;	 Catch:{ all -> 0x0030 }
        if (r0 == 0) goto L_0x002c;	 Catch:{ all -> 0x0030 }
    L_0x0005:
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0030 }
        if (r0 != 0) goto L_0x002c;	 Catch:{ all -> 0x0030 }
    L_0x000b:
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0030 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x002c;
    L_0x0012:
        r0 = r1.d;	 Catch:{ Throwable -> 0x0028 }
        r2 = r0.get(r2);	 Catch:{ Throwable -> 0x0028 }
        r2 = (java.util.Map) r2;	 Catch:{ Throwable -> 0x0028 }
        if (r2 == 0) goto L_0x0024;	 Catch:{ Throwable -> 0x0028 }
    L_0x001c:
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x0028 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0028 }
        monitor-exit(r1);
        return r2;
    L_0x0024:
        r2 = "";	 Catch:{ all -> 0x0030 }
        monitor-exit(r1);
        return r2;
    L_0x0028:
        r2 = "";	 Catch:{ all -> 0x0030 }
        monitor-exit(r1);
        return r2;
    L_0x002c:
        r2 = "";	 Catch:{ all -> 0x0030 }
        monitor-exit(r1);
        return r2;
    L_0x0030:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bb.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private synchronized void c(String str, String str2, String str3) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        Map map = (Map) this.d.get(str);
        if (map == null) {
            map = new HashMap();
        }
        map.put(str2, str3);
        this.d.put(str, map);
    }

    public synchronized void a(String str, String str2, Boolean bool) {
        c(str, str2, String.valueOf(bool));
        this.c.post(new bc(this, str, str2, bool));
    }

    public synchronized void a(String str, String str2, String str3) {
        c(str, str2, str3);
        this.c.post(new bd(this, str, str2, str3));
    }

    public synchronized boolean a(java.lang.String r3, java.lang.String r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.a(r3, r4);	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
        if (r1 != 0) goto L_0x0011;	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
    L_0x000b:
        r3 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
        monitor-exit(r2);
        return r3;
    L_0x0011:
        r0 = r2.b;	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
        r1 = 4;	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
        r3 = r0.getSharedPreferences(r3, r1);	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
        r3 = r3.getBoolean(r4, r5);	 Catch:{ Throwable -> 0x0021, all -> 0x001e }
        monitor-exit(r2);
        return r3;
    L_0x001e:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
    L_0x0021:
        monitor-exit(r2);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bb.a(java.lang.String, java.lang.String, boolean):boolean");
    }

    public synchronized String b(String str, String str2, String str3) {
        Object a = a(str, str2);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        return this.b.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
