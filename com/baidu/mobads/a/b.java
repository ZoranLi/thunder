package com.baidu.mobads.a;

public class b {
    public static final Boolean a = Boolean.valueOf(false);
    public static final Boolean b = Boolean.valueOf(false);

    public static double a() {
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
        r0 = "8.7036";	 Catch:{ Exception -> 0x0007 }
        r0 = java.lang.Double.parseDouble(r0);	 Catch:{ Exception -> 0x0007 }
        goto L_0x0009;
    L_0x0007:
        r0 = 0;
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.a.b.a():double");
    }

    public static int b() {
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
        r0 = 0;
        r1 = "8.7036";	 Catch:{ Exception -> 0x0014 }
        r2 = "\\.";	 Catch:{ Exception -> 0x0014 }
        r1 = r1.split(r2);	 Catch:{ Exception -> 0x0014 }
        r1 = r1[r0];	 Catch:{ Exception -> 0x0014 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0014 }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x0014 }
        r0 = r1;
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.a.b.b():int");
    }
}
