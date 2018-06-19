package com.xiaomi.stats;

import android.support.v4.view.ViewCompat;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.thrift.b;
import com.xiaomi.xmpush.thrift.au;
import java.util.Hashtable;

public class h {
    private static final int a = com.xiaomi.push.thrift.a.PING_RTT.a();

    static class a {
        static Hashtable<Integer, Long> a = new Hashtable();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        b f = f.a().f();
        f.a(com.xiaomi.push.thrift.a.CHANNEL_STATS_COUNTER.a());
        f.c(i);
        f.a().a(f);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (h.class) {
            if (i2 < ViewCompat.MEASURED_SIZE_MASK) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        b f = f.a().f();
        f.a((byte) i);
        f.a(i2);
        f.b(i3);
        f.b(str);
        f.c(i4);
        f.a().a(f);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (h.class) {
            long currentTimeMillis = System.currentTimeMillis();
            i = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i))) {
                b f = f.a().f();
                f.a(i2);
                f.b((int) (currentTimeMillis - ((Long) a.a.get(Integer.valueOf(i))).longValue()));
                f.b(str);
                if (i3 >= 0) {
                    f.c(i3);
                }
                f.a().a(f);
                a.a.remove(Integer.valueOf(i2));
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new a(xMPushService, bVar).a();
    }

    public static void a(java.lang.String r1, int r2, java.lang.Exception r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xiaomi.stats.f.a();
        r0 = r0.f();
        if (r2 <= 0) goto L_0x0021;
    L_0x000a:
        r3 = com.xiaomi.push.thrift.a.GSLB_REQUEST_SUCCESS;
        r3 = r3.a();
        r0.a(r3);
        r0.b(r1);
        r0.b(r2);
        r1 = com.xiaomi.stats.f.a();
        r1.a(r0);
        return;
    L_0x0021:
        r2 = com.xiaomi.stats.d.a(r3);	 Catch:{ NullPointerException -> 0x003d }
        r3 = r2.a;	 Catch:{ NullPointerException -> 0x003d }
        r3 = r3.a();	 Catch:{ NullPointerException -> 0x003d }
        r0.a(r3);	 Catch:{ NullPointerException -> 0x003d }
        r2 = r2.b;	 Catch:{ NullPointerException -> 0x003d }
        r0.c(r2);	 Catch:{ NullPointerException -> 0x003d }
        r0.b(r1);	 Catch:{ NullPointerException -> 0x003d }
        r1 = com.xiaomi.stats.f.a();	 Catch:{ NullPointerException -> 0x003d }
        r1.a(r0);	 Catch:{ NullPointerException -> 0x003d }
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.h.a(java.lang.String, int, java.lang.Exception):void");
    }

    public static void a(java.lang.String r2, java.lang.Exception r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = com.xiaomi.stats.d.b(r3);	 Catch:{ NullPointerException -> 0x0024 }
        r0 = com.xiaomi.stats.f.a();	 Catch:{ NullPointerException -> 0x0024 }
        r0 = r0.f();	 Catch:{ NullPointerException -> 0x0024 }
        r1 = r3.a;	 Catch:{ NullPointerException -> 0x0024 }
        r1 = r1.a();	 Catch:{ NullPointerException -> 0x0024 }
        r0.a(r1);	 Catch:{ NullPointerException -> 0x0024 }
        r3 = r3.b;	 Catch:{ NullPointerException -> 0x0024 }
        r0.c(r3);	 Catch:{ NullPointerException -> 0x0024 }
        r0.b(r2);	 Catch:{ NullPointerException -> 0x0024 }
        r2 = com.xiaomi.stats.f.a();	 Catch:{ NullPointerException -> 0x0024 }
        r2.a(r0);	 Catch:{ NullPointerException -> 0x0024 }
    L_0x0024:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.h.a(java.lang.String, java.lang.Exception):void");
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(java.lang.String r2, java.lang.Exception r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = com.xiaomi.stats.d.d(r3);	 Catch:{ NullPointerException -> 0x0024 }
        r0 = com.xiaomi.stats.f.a();	 Catch:{ NullPointerException -> 0x0024 }
        r0 = r0.f();	 Catch:{ NullPointerException -> 0x0024 }
        r1 = r3.a;	 Catch:{ NullPointerException -> 0x0024 }
        r1 = r1.a();	 Catch:{ NullPointerException -> 0x0024 }
        r0.a(r1);	 Catch:{ NullPointerException -> 0x0024 }
        r3 = r3.b;	 Catch:{ NullPointerException -> 0x0024 }
        r0.c(r3);	 Catch:{ NullPointerException -> 0x0024 }
        r0.b(r2);	 Catch:{ NullPointerException -> 0x0024 }
        r2 = com.xiaomi.stats.f.a();	 Catch:{ NullPointerException -> 0x0024 }
        r2.a(r0);	 Catch:{ NullPointerException -> 0x0024 }
    L_0x0024:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.h.b(java.lang.String, java.lang.Exception):void");
    }

    public static byte[] c() {
        org.apache.thrift.a e = f.a().e();
        return e != null ? au.a(e) : null;
    }
}
