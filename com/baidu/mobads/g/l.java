package com.baidu.mobads.g;

class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void run() {
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
        r6 = this;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0099 }
        r0 = r0.getURIUitls();	 Catch:{ Exception -> 0x0099 }
        r1 = r6.a;	 Catch:{ Exception -> 0x0099 }
        r1 = r1.a;	 Catch:{ Exception -> 0x0099 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0099 }
    L_0x000e:
        r1 = com.baidu.mobads.g.g.b;	 Catch:{ Exception -> 0x0099 }
        r1 = r1.a;	 Catch:{ Exception -> 0x0099 }
        goto L_0x0015;	 Catch:{ Exception -> 0x0099 }
    L_0x0013:
        r1 = 0;	 Catch:{ Exception -> 0x0099 }
    L_0x0015:
        r3 = new com.baidu.mobads.g.m;	 Catch:{ Exception -> 0x0099 }
        r3.<init>(r6, r1);	 Catch:{ Exception -> 0x0099 }
        r4 = new java.util.HashMap;	 Catch:{ Exception -> 0x0099 }
        r4.<init>();	 Catch:{ Exception -> 0x0099 }
        r5 = "v";	 Catch:{ Exception -> 0x0099 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x0099 }
        r4.put(r5, r1);	 Catch:{ Exception -> 0x0099 }
        r1 = "os";	 Catch:{ Exception -> 0x0099 }
        r2 = "android";	 Catch:{ Exception -> 0x0099 }
        r4.put(r1, r2);	 Catch:{ Exception -> 0x0099 }
        r1 = "tp";	 Catch:{ Exception -> 0x0099 }
        r2 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0099 }
        r2 = r2.getCommonUtils();	 Catch:{ Exception -> 0x0099 }
        r5 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x0099 }
        r2 = r2.getTextEncoder(r5);	 Catch:{ Exception -> 0x0099 }
        r4.put(r1, r2);	 Catch:{ Exception -> 0x0099 }
        r1 = "bdr";	 Catch:{ Exception -> 0x0099 }
        r2 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0099 }
        r2 = r2.getCommonUtils();	 Catch:{ Exception -> 0x0099 }
        r5 = android.os.Build.VERSION.SDK;	 Catch:{ Exception -> 0x0099 }
        r2 = r2.getTextEncoder(r5);	 Catch:{ Exception -> 0x0099 }
        r4.put(r1, r2);	 Catch:{ Exception -> 0x0099 }
        r1 = com.baidu.mobads.g.g.i;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.addParameters(r1, r4);	 Catch:{ Exception -> 0x0099 }
        r1 = new com.baidu.mobads.openad.d.c;	 Catch:{ Exception -> 0x0099 }
        r2 = "";	 Catch:{ Exception -> 0x0099 }
        r1.<init>(r0, r2);	 Catch:{ Exception -> 0x0099 }
        r0 = 1;	 Catch:{ Exception -> 0x0099 }
        r1.e = r0;	 Catch:{ Exception -> 0x0099 }
        r0 = r6.a;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0099 }
        r2 = new com.baidu.mobads.openad.d.a;	 Catch:{ Exception -> 0x0099 }
        r2.<init>();	 Catch:{ Exception -> 0x0099 }
        r0.j = r2;	 Catch:{ Exception -> 0x0099 }
        r0 = r6.a;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.j;	 Catch:{ Exception -> 0x0099 }
        r2 = "URLLoader.Load.Complete";	 Catch:{ Exception -> 0x0099 }
        r0.addEventListener(r2, r3);	 Catch:{ Exception -> 0x0099 }
        r0 = r6.a;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.j;	 Catch:{ Exception -> 0x0099 }
        r2 = "URLLoader.Load.Error";	 Catch:{ Exception -> 0x0099 }
        r0.addEventListener(r2, r3);	 Catch:{ Exception -> 0x0099 }
        r0 = r6.a;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0099 }
        r0 = r0.j;	 Catch:{ Exception -> 0x0099 }
        r0.a(r1);	 Catch:{ Exception -> 0x0099 }
        return;
    L_0x0099:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.l.run():void");
    }
}
