package com.alipay.b.a.a.b;

public final class a {
    private static a a = new a();

    private a() {
    }

    public static a a() {
        return a;
    }

    public static java.lang.String a(android.content.Context r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r2.getPackageManager();	 Catch:{ Exception -> 0x0011 }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x0011 }
        r1 = 16;	 Catch:{ Exception -> 0x0011 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ Exception -> 0x0011 }
        r2 = r2.versionName;	 Catch:{ Exception -> 0x0011 }
        return r2;
    L_0x0011:
        r2 = "0.0.0";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.a.a(android.content.Context):java.lang.String");
    }
}
