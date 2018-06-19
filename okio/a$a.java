package okio;

/* compiled from: AsyncTimeout */
final class a$a extends Thread {
    a$a() {
        super("Okio Watchdog");
        setDaemon(true);
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = okio.a.class;	 Catch:{ InterruptedException -> 0x0000 }
        monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0000 }
        r1 = okio.a.e();	 Catch:{ all -> 0x0019 }
        if (r1 != 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
    L_0x0009:
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        goto L_0x0000;	 Catch:{ all -> 0x0019 }
    L_0x000b:
        r2 = okio.a.b;	 Catch:{ all -> 0x0019 }
        if (r1 != r2) goto L_0x0014;	 Catch:{ all -> 0x0019 }
    L_0x000f:
        r1 = 0;	 Catch:{ all -> 0x0019 }
        okio.a.b = r1;	 Catch:{ all -> 0x0019 }
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        return;	 Catch:{ all -> 0x0019 }
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        r1.a();	 Catch:{ InterruptedException -> 0x0000 }
        goto L_0x0000;
    L_0x0019:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        throw r1;	 Catch:{ InterruptedException -> 0x0000 }
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.a$a.run():void");
    }
}
