package com.alipay.android.phone.mrpc.core;

public final class s {
    private static Boolean a;

    public static final boolean a(android.content.Context r2) {
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
        r0 = a;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r2 = a;
        r2 = r2.booleanValue();
        return r2;
    L_0x000b:
        r0 = 0;
        r1 = r2.getPackageManager();	 Catch:{ Exception -> 0x002c }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x002c }
        r2 = r1.getApplicationInfo(r2, r0);	 Catch:{ Exception -> 0x002c }
        r2 = r2.flags;	 Catch:{ Exception -> 0x002c }
        r2 = r2 & 2;	 Catch:{ Exception -> 0x002c }
        if (r2 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x002c }
    L_0x001e:
        r2 = 1;	 Catch:{ Exception -> 0x002c }
        goto L_0x0021;	 Catch:{ Exception -> 0x002c }
    L_0x0020:
        r2 = r0;	 Catch:{ Exception -> 0x002c }
    L_0x0021:
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x002c }
        a = r2;	 Catch:{ Exception -> 0x002c }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x002c }
        return r2;
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.s.a(android.content.Context):boolean");
    }
}
