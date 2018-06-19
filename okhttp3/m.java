package okhttp3;

/* compiled from: ConnectionPool */
final class m implements Runnable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
    L_0x0000:
        r0 = r8.a;
        r1 = java.lang.System.nanoTime();
        r0 = r0.a(r1);
        r2 = -1;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0000;
    L_0x0017:
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = r0 / r2;
        r2 = r2 * r4;
        r6 = r0 - r2;
        r0 = r8.a;
        monitor-enter(r0);
        r1 = r8.a;	 Catch:{ InterruptedException -> 0x002b }
        r2 = (int) r6;	 Catch:{ InterruptedException -> 0x002b }
        r1.wait(r4, r2);	 Catch:{ InterruptedException -> 0x002b }
        goto L_0x002b;
    L_0x0029:
        r1 = move-exception;
        goto L_0x002d;
    L_0x002b:
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        goto L_0x0000;	 Catch:{ all -> 0x0029 }
    L_0x002d:
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.m.run():void");
    }
}
