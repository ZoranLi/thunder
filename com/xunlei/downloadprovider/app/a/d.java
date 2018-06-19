package com.xunlei.downloadprovider.app.a;

/* compiled from: InitializationManager */
public class d {
    static final String a = "d";
    public static boolean c = false;
    private static d d;
    public c[] b = new c[3];

    /* compiled from: InitializationManager */
    public interface a {
        void a();
    }

    /* compiled from: InitializationManager */
    interface b {
    }

    /* compiled from: InitializationManager */
    public static class c implements a {
        public void a() {
        }
    }

    private d() {
        this.b[0] = new a();
        this.b[1] = new i();
        this.b[2] = new p();
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (d == null) {
                d = new d();
            }
            dVar = d;
        }
        return dVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(int r7, com.xunlei.downloadprovider.app.a.d.a r8) {
        /*
        r6 = this;
        monitor-enter(r6);
        if (r7 < 0) goto L_0x0051;
    L_0x0003:
        r0 = 2;
        if (r7 <= r0) goto L_0x0007;
    L_0x0006:
        goto L_0x0051;
    L_0x0007:
        r1 = 0;
        r2 = r1;
    L_0x0009:
        r3 = 1;
        if (r2 >= r7) goto L_0x0028;
    L_0x000c:
        r4 = r6.b;	 Catch:{ all -> 0x0026 }
        r4 = r4[r2];	 Catch:{ all -> 0x0026 }
        if (r4 == 0) goto L_0x0023;
    L_0x0012:
        r5 = r4.b();	 Catch:{ all -> 0x0026 }
        if (r5 != 0) goto L_0x0023;
    L_0x0018:
        r4.a(r3);	 Catch:{ all -> 0x0026 }
        r3 = new com.xunlei.downloadprovider.app.a.f;	 Catch:{ all -> 0x0026 }
        r3.<init>(r6, r4);	 Catch:{ all -> 0x0026 }
        com.xunlei.common.concurrent.XLThreadPool.execute(r3);	 Catch:{ all -> 0x0026 }
    L_0x0023:
        r2 = r2 + 1;
        goto L_0x0009;
    L_0x0026:
        r7 = move-exception;
        goto L_0x004f;
    L_0x0028:
        r2 = r6.b;	 Catch:{ all -> 0x0026 }
        r2 = r2[r7];	 Catch:{ all -> 0x0026 }
        if (r7 == r3) goto L_0x0030;
    L_0x002e:
        if (r7 != r0) goto L_0x0031;
    L_0x0030:
        r1 = r3;
    L_0x0031:
        r7 = new com.xunlei.downloadprovider.app.a.g;	 Catch:{ all -> 0x0026 }
        r7.<init>(r2);	 Catch:{ all -> 0x0026 }
        r0 = new com.xunlei.downloadprovider.app.a.e;	 Catch:{ all -> 0x0026 }
        r0.<init>(r6, r8);	 Catch:{ all -> 0x0026 }
        r7.a = r0;	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x0047;
    L_0x003f:
        r7.b();	 Catch:{ all -> 0x0026 }
        r7.a();	 Catch:{ all -> 0x0026 }
        monitor-exit(r6);
        return;
    L_0x0047:
        r7.a();	 Catch:{ all -> 0x0026 }
        r7.b();	 Catch:{ all -> 0x0026 }
        monitor-exit(r6);
        return;
    L_0x004f:
        monitor-exit(r6);
        throw r7;
    L_0x0051:
        monitor-exit(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.app.a.d.a(int, com.xunlei.downloadprovider.app.a.d$a):void");
    }
}
