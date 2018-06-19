package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class i implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    i(boolean z, String str, String str2, String str3) {
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = str3;
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
        r5 = this;
        r0 = com.alibaba.mtl.appmonitor.AppMonitor.a;	 Catch:{ Throwable -> 0x000e }
        r1 = r5.a;	 Catch:{ Throwable -> 0x000e }
        r2 = r5.b;	 Catch:{ Throwable -> 0x000e }
        r3 = r5.c;	 Catch:{ Throwable -> 0x000e }
        r4 = r5.d;	 Catch:{ Throwable -> 0x000e }
        r0.a(r1, r2, r3, r4);	 Catch:{ Throwable -> 0x000e }
        return;
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.i.run():void");
    }
}
