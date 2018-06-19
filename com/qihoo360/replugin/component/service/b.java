package com.qihoo360.replugin.component.service;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

/* compiled from: PluginServiceServerFetcher */
public final class b {
    private static final byte[] b = new byte[0];
    private com.qihoo360.replugin.utils.a.a<Integer, com.qihoo360.replugin.component.service.server.b> a = new com.qihoo360.replugin.utils.a.a();

    /* compiled from: PluginServiceServerFetcher */
    private final class a implements DeathRecipient {
        final int a;
        final IBinder b;
        final /* synthetic */ b c;

        a(b bVar, int i, IBinder iBinder) {
            this.c = bVar;
            this.a = i;
            this.b = iBinder;
        }

        public final void binderDied() {
            new StringBuilder("psc.dm: d, rm p ").append(this.a);
            synchronized (b.b) {
                this.c.a.remove(Integer.valueOf(this.a));
            }
        }
    }

    public final com.qihoo360.replugin.component.service.server.b a(int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r6 != r1) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r1 = b;
        monitor-enter(r1);
        r2 = r5.a;	 Catch:{ all -> 0x0089 }
        r3 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0089 }
        r2 = r2.get(r3);	 Catch:{ all -> 0x0089 }
        r2 = (com.qihoo360.replugin.component.service.server.b) r2;	 Catch:{ all -> 0x0089 }
        if (r2 == 0) goto L_0x0031;	 Catch:{ all -> 0x0089 }
    L_0x0018:
        r0 = com.qihoo360.replugin.b.c.a;	 Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x002f;	 Catch:{ all -> 0x0089 }
    L_0x001c:
        r0 = "ws001";	 Catch:{ all -> 0x0089 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0089 }
        r4 = "PluginServiceClient.fsmbp(): Exists! p=";	 Catch:{ all -> 0x0089 }
        r3.<init>(r4);	 Catch:{ all -> 0x0089 }
        r3.append(r6);	 Catch:{ all -> 0x0089 }
        r6 = r3.toString();	 Catch:{ all -> 0x0089 }
        com.qihoo360.replugin.b.c.a(r0, r6);	 Catch:{ all -> 0x0089 }
    L_0x002f:
        monitor-exit(r1);	 Catch:{ all -> 0x0089 }
        return r2;	 Catch:{ all -> 0x0089 }
    L_0x0031:
        monitor-exit(r1);	 Catch:{ all -> 0x0089 }
        r1 = com.qihoo360.replugin.b.c.a;
        if (r1 == 0) goto L_0x0049;
    L_0x0036:
        r1 = "ws001";
        r3 = new java.lang.StringBuilder;
        r4 = "PluginServiceClient.fsmbp(): Create a new one! p=";
        r3.<init>(r4);
        r3.append(r6);
        r3 = r3.toString();
        com.qihoo360.replugin.b.c.a(r1, r3);
    L_0x0049:
        r1 = -2;
        r3 = 0;
        if (r6 != r1) goto L_0x0057;
    L_0x004d:
        r0 = com.qihoo360.loader2.ac.c();	 Catch:{ Throwable -> 0x0075 }
        r0 = r0.d();	 Catch:{ Throwable -> 0x0075 }
    L_0x0055:
        r2 = r0;	 Catch:{ Throwable -> 0x0075 }
        goto L_0x0065;	 Catch:{ Throwable -> 0x0075 }
    L_0x0057:
        r1 = new com.qihoo360.loader2.PluginBinderInfo;	 Catch:{ Throwable -> 0x0075 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0075 }
        r0 = com.qihoo360.loader2.m.a(r0, r6, r1);	 Catch:{ Throwable -> 0x0075 }
        r0 = r0.c();	 Catch:{ Throwable -> 0x0075 }
        goto L_0x0055;	 Catch:{ Throwable -> 0x0075 }
    L_0x0065:
        r0 = r2.asBinder();	 Catch:{ Throwable -> 0x0075 }
        r1 = new com.qihoo360.replugin.component.service.b$a;	 Catch:{ Throwable -> 0x0075 }
        r4 = r2.asBinder();	 Catch:{ Throwable -> 0x0075 }
        r1.<init>(r5, r6, r4);	 Catch:{ Throwable -> 0x0075 }
        r0.linkToDeath(r1, r3);	 Catch:{ Throwable -> 0x0075 }
    L_0x0075:
        if (r2 == 0) goto L_0x0088;
    L_0x0077:
        r0 = b;
        monitor-enter(r0);
        r1 = r5.a;	 Catch:{ all -> 0x0085 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0085 }
        r1.put(r6, r2);	 Catch:{ all -> 0x0085 }
        monitor-exit(r0);	 Catch:{ all -> 0x0085 }
        goto L_0x0088;	 Catch:{ all -> 0x0085 }
    L_0x0085:
        r6 = move-exception;	 Catch:{ all -> 0x0085 }
        monitor-exit(r0);	 Catch:{ all -> 0x0085 }
        throw r6;
    L_0x0088:
        return r2;
    L_0x0089:
        r6 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0089 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.b.a(int):com.qihoo360.replugin.component.service.server.b");
    }
}
