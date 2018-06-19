package com.alipay.apmobilesecuritysdk.g;

final class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
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
        r2 = this;
        r0 = 0;
        android.os.Process.setThreadPriority(r0);	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
    L_0x0004:
        r0 = r2.a;	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        r0 = r0.c;	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        r0 = r0.isEmpty();	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        if (r0 != 0) goto L_0x0022;	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
    L_0x0010:
        r0 = r2.a;	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        r0 = r0.c;	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        r0 = r0.pollFirst();	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        r0 = (java.lang.Runnable) r0;	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        if (r0 == 0) goto L_0x0004;	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
    L_0x001e:
        r0.run();	 Catch:{ Exception -> 0x0022, all -> 0x0028 }
        goto L_0x0004;
    L_0x0022:
        r0 = r2.a;
        r0.b = null;
        return;
    L_0x0028:
        r0 = move-exception;
        r1 = r2.a;
        r1.b = null;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.g.c.run():void");
    }
}
