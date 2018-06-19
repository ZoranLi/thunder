package com.alibaba.mtl.log.b;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.l;

/* compiled from: CoreStatics */
public final class a {
    private static volatile long a;
    private static long b;
    private static long c;
    private static int d;
    private static long e;
    private static long f;
    private static long g;
    private static long h;
    private static long i;
    private static long j;
    private static int k;
    private static int l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;
    private static long q;
    private static long r;
    private static long s;
    private static long t;
    private static long u;
    private static long v;
    private static long w;
    private static long x;
    private static StringBuilder y = new StringBuilder();

    public static synchronized void a(String str) {
        synchronized (a.class) {
            if (c(str)) {
                return;
            }
            if ("65501".equalsIgnoreCase(str)) {
                x++;
            } else if ("65133".equalsIgnoreCase(str)) {
                v++;
            } else if ("65502".equalsIgnoreCase(str)) {
                w++;
            } else if ("65503".equalsIgnoreCase(str) != null) {
                u++;
            }
            a++;
        }
    }

    public static synchronized void b(String str) {
        synchronized (a.class) {
            if (c(str) != null) {
                return;
            }
            b++;
            str = l.a();
            if ("wifi".equalsIgnoreCase(str)) {
                j++;
            } else if ("3G".equalsIgnoreCase(str)) {
                h++;
            } else if ("4G".equalsIgnoreCase(str)) {
                i++;
            } else if ("2G".equalsIgnoreCase(str) != null) {
                g++;
            } else {
                k++;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.util.List<com.alibaba.mtl.log.model.a> r13, int r14) {
        /*
        r0 = com.alibaba.mtl.log.b.a.class;
        monitor-enter(r0);
        if (r13 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r0);
        return;
    L_0x0007:
        r1 = 0;
        r2 = r1;
        r3 = r2;
    L_0x000a:
        r4 = r13.size();	 Catch:{ all -> 0x0082 }
        r5 = 1;
        if (r2 >= r4) goto L_0x003d;
    L_0x0011:
        r4 = r13.get(r2);	 Catch:{ all -> 0x0082 }
        r4 = (com.alibaba.mtl.log.model.a) r4;	 Catch:{ all -> 0x0082 }
        if (r4 == 0) goto L_0x003a;
    L_0x0019:
        r6 = "6005";
        r7 = r4.b;	 Catch:{ all -> 0x0082 }
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ all -> 0x0082 }
        if (r6 != 0) goto L_0x0025;
    L_0x0023:
        r3 = r3 + 1;
    L_0x0025:
        r6 = y;	 Catch:{ all -> 0x0082 }
        r4 = r4.f;	 Catch:{ all -> 0x0082 }
        r6.append(r4);	 Catch:{ all -> 0x0082 }
        r4 = r13.size();	 Catch:{ all -> 0x0082 }
        r4 = r4 - r5;
        if (r2 == r4) goto L_0x003a;
    L_0x0033:
        r4 = y;	 Catch:{ all -> 0x0082 }
        r5 = ",";
        r4.append(r5);	 Catch:{ all -> 0x0082 }
    L_0x003a:
        r2 = r2 + 1;
        goto L_0x000a;
    L_0x003d:
        r13 = "CoreStatics";
        r2 = 4;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0082 }
        r4 = "[uploadInc]:";
        r2[r1] = r4;	 Catch:{ all -> 0x0082 }
        r6 = c;	 Catch:{ all -> 0x0082 }
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0082 }
        r2[r5] = r4;	 Catch:{ all -> 0x0082 }
        r4 = "count:";
        r6 = 2;
        r2[r6] = r4;	 Catch:{ all -> 0x0082 }
        r4 = 3;
        r7 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x0082 }
        r2[r4] = r7;	 Catch:{ all -> 0x0082 }
        com.alibaba.mtl.log.e.i.a(r13, r2);	 Catch:{ all -> 0x0082 }
        r7 = c;	 Catch:{ all -> 0x0082 }
        r9 = (long) r14;	 Catch:{ all -> 0x0082 }
        r11 = r7 + r9;
        c = r11;	 Catch:{ all -> 0x0082 }
        r13 = "CoreStatics";
        r2 = new java.lang.Object[r6];	 Catch:{ all -> 0x0082 }
        r4 = "[uploadInc]:";
        r2[r1] = r4;	 Catch:{ all -> 0x0082 }
        r6 = c;	 Catch:{ all -> 0x0082 }
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0082 }
        r2[r5] = r1;	 Catch:{ all -> 0x0082 }
        com.alibaba.mtl.log.e.i.a(r13, r2);	 Catch:{ all -> 0x0082 }
        if (r3 == r14) goto L_0x0080;
    L_0x0079:
        r13 = "CoreStatics";
        r14 = "Mutil Process Upload Error";
        com.alibaba.mtl.log.e.i.b(r13, r14);	 Catch:{ all -> 0x0082 }
    L_0x0080:
        monitor-exit(r0);
        return;
    L_0x0082:
        r13 = move-exception;
        monitor-exit(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.b.a.a(java.util.List, int):void");
    }

    public static synchronized void a(int i) {
        synchronized (a.class) {
            d += i;
        }
    }

    public static synchronized void a() {
        synchronized (a.class) {
            e++;
        }
    }

    public static synchronized void b() {
        synchronized (a.class) {
            f++;
        }
    }

    public static synchronized void c() {
        synchronized (a.class) {
            m++;
        }
    }

    public static synchronized void d() {
        synchronized (a.class) {
            n++;
        }
    }

    public static synchronized void e() {
        synchronized (a.class) {
            o++;
        }
    }

    public static synchronized void f() {
        synchronized (a.class) {
            p++;
        }
    }

    public static synchronized void g() {
        synchronized (a.class) {
            q++;
        }
    }

    public static synchronized void h() {
        synchronized (a.class) {
            r++;
        }
    }

    public static synchronized void i() {
        synchronized (a.class) {
            s++;
        }
    }

    public static synchronized void j() {
        synchronized (a.class) {
            t++;
        }
    }

    private static synchronized void l() {
        synchronized (a.class) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void k() {
        /*
        r0 = com.alibaba.mtl.log.b.a.class;
        monitor-enter(r0);
        r1 = l;	 Catch:{ all -> 0x0027 }
        r1 = r1 + 1;
        l = r1;	 Catch:{ all -> 0x0027 }
        r1 = a;	 Catch:{ all -> 0x0027 }
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0019;
    L_0x0011:
        r1 = c;	 Catch:{ all -> 0x0027 }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r0);
        return;
    L_0x0019:
        r1 = com.alibaba.mtl.log.a.a;	 Catch:{ all -> 0x0027 }
        if (r1 != 0) goto L_0x0022;
    L_0x001d:
        r1 = l;	 Catch:{ all -> 0x0027 }
        r2 = 6;
        if (r1 < r2) goto L_0x0025;
    L_0x0022:
        l();	 Catch:{ all -> 0x0027 }
    L_0x0025:
        monitor-exit(r0);
        return;
    L_0x0027:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.b.a.k():void");
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }
}
