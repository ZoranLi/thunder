package com.alipay.sdk.auth;

final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ AuthActivity b;

    c(AuthActivity authActivity, String str) {
        this.b = authActivity;
        this.a = str;
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
        r0 = r3.b;	 Catch:{ Exception -> 0x001a }
        r0 = r0.c;	 Catch:{ Exception -> 0x001a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x001a }
        r2 = "javascript:";	 Catch:{ Exception -> 0x001a }
        r1.<init>(r2);	 Catch:{ Exception -> 0x001a }
        r2 = r3.a;	 Catch:{ Exception -> 0x001a }
        r1.append(r2);	 Catch:{ Exception -> 0x001a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x001a }
        r0.loadUrl(r1);	 Catch:{ Exception -> 0x001a }
        return;
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.c.run():void");
    }
}
