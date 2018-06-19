package com.getui.gtc.c;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class d {
    private ScheduledThreadPoolExecutor a;

    public final class a {
        private static final d a = new d();
    }

    private d() {
        this.a = null;
        this.a = new ScheduledThreadPoolExecutor(5);
    }

    public final boolean a(java.lang.Runnable r2) {
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
        r1 = this;
        r0 = r1.a;	 Catch:{ Throwable -> 0x0007 }
        r0.execute(r2);	 Catch:{ Throwable -> 0x0007 }
        r2 = 1;
        return r2;
    L_0x0007:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.c.d.a(java.lang.Runnable):boolean");
    }

    public final boolean b(java.lang.Runnable r8) {
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
        r7 = this;
        r0 = r7.a;	 Catch:{ Throwable -> 0x000f }
        r2 = 0;	 Catch:{ Throwable -> 0x000f }
        r4 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;	 Catch:{ Throwable -> 0x000f }
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Throwable -> 0x000f }
        r1 = r8;	 Catch:{ Throwable -> 0x000f }
        r0.scheduleAtFixedRate(r1, r2, r4, r6);	 Catch:{ Throwable -> 0x000f }
        r8 = 1;
        return r8;
    L_0x000f:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.c.d.b(java.lang.Runnable):boolean");
    }
}
