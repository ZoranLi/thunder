package com.getui.gtc.event.eventbus;

final class b implements Runnable {
    final j a = new j();
    final c b;
    volatile boolean c;

    b(c cVar) {
        this.b = cVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = 0;
        r1 = r3.a;	 Catch:{ InterruptedException -> 0x0027, all -> 0x0023 }
        r1 = r1.b();	 Catch:{ InterruptedException -> 0x0027, all -> 0x0023 }
        if (r1 != 0) goto L_0x001d;	 Catch:{ InterruptedException -> 0x0027, all -> 0x0023 }
    L_0x0009:
        monitor-enter(r3);	 Catch:{ InterruptedException -> 0x0027, all -> 0x0023 }
        r1 = r3.a;	 Catch:{ all -> 0x001a }
        r1 = r1.a();	 Catch:{ all -> 0x001a }
        if (r1 != 0) goto L_0x0018;	 Catch:{ all -> 0x001a }
    L_0x0012:
        r3.c = r0;	 Catch:{ all -> 0x001a }
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        r3.c = r0;
        return;
    L_0x0018:
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        goto L_0x001d;	 Catch:{ all -> 0x001a }
    L_0x001a:
        r1 = move-exception;	 Catch:{ all -> 0x001a }
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        throw r1;	 Catch:{ InterruptedException -> 0x0027, all -> 0x0023 }
    L_0x001d:
        r2 = r3.b;	 Catch:{ InterruptedException -> 0x0027, all -> 0x0023 }
        r2.a(r1);	 Catch:{ InterruptedException -> 0x0027, all -> 0x0023 }
        goto L_0x0000;
    L_0x0023:
        r1 = move-exception;
        r3.c = r0;
        throw r1;
    L_0x0027:
        r3.c = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.event.eventbus.b.run():void");
    }
}
