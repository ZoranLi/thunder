package com.alipay.sdk.widget;

final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
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
        r4 = this;
        r0 = r4.a;
        r0 = r0.e;
        if (r0 != 0) goto L_0x001a;
    L_0x0008:
        r0 = r4.a;
        r1 = new com.alipay.sdk.widget.a$a;
        r2 = r4.a;
        r3 = r4.a;
        r3 = r3.f;
        r1.<init>(r2, r3);
        r0.e = r1;
    L_0x001a:
        r0 = r4.a;	 Catch:{ Exception -> 0x0030 }
        r0 = r0.e;	 Catch:{ Exception -> 0x0030 }
        r0 = r0.isShowing();	 Catch:{ Exception -> 0x0030 }
        if (r0 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x0030 }
    L_0x0026:
        r0 = r4.a;	 Catch:{ Exception -> 0x0030 }
        r0 = r0.e;	 Catch:{ Exception -> 0x0030 }
        r0.show();	 Catch:{ Exception -> 0x0030 }
    L_0x002f:
        return;
    L_0x0030:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.widget.b.run():void");
    }
}
