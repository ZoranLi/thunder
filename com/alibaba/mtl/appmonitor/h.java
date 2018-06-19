package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class h implements Runnable {
    h() {
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
        r0 = com.alibaba.mtl.appmonitor.AppMonitor.a;	 Catch:{ RemoteException -> 0x0006 }
        r0.a();	 Catch:{ RemoteException -> 0x0006 }
        return;
    L_0x0006:
        com.alibaba.mtl.appmonitor.AppMonitor.l();
        r0 = com.alibaba.mtl.appmonitor.AppMonitor.a;	 Catch:{ Throwable -> 0x000f }
        r0.a();	 Catch:{ Throwable -> 0x000f }
        return;
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.h.run():void");
    }
}
