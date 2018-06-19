package com.alipay.sdk.widget;

final class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
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
        r1 = this;
        r0 = r1.a;
        r0 = r0.e;
        if (r0 == 0) goto L_0x0012;
    L_0x0008:
        r0 = r1.a;	 Catch:{ Exception -> 0x0012 }
        r0 = r0.e;	 Catch:{ Exception -> 0x0012 }
        r0.dismiss();	 Catch:{ Exception -> 0x0012 }
        return;
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.widget.c.run():void");
    }
}
