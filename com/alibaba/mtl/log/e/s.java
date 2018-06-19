package com.alibaba.mtl.log.e;

import android.os.Handler;
import android.os.Looper;

/* compiled from: TaskExecutor */
final class s extends Handler {
    final /* synthetic */ r a;

    s(r rVar, Looper looper) {
        this.a = rVar;
        super(looper);
    }

    public final void handleMessage(android.os.Message r2) {
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
        super.handleMessage(r2);
        r0 = r2.obj;	 Catch:{ Throwable -> 0x0019 }
        if (r0 == 0) goto L_0x0018;	 Catch:{ Throwable -> 0x0019 }
    L_0x0007:
        r0 = r2.obj;	 Catch:{ Throwable -> 0x0019 }
        r0 = r0 instanceof java.lang.Runnable;	 Catch:{ Throwable -> 0x0019 }
        if (r0 == 0) goto L_0x0018;	 Catch:{ Throwable -> 0x0019 }
    L_0x000d:
        r0 = com.alibaba.mtl.log.e.r.d();	 Catch:{ Throwable -> 0x0019 }
        r2 = r2.obj;	 Catch:{ Throwable -> 0x0019 }
        r2 = (java.lang.Runnable) r2;	 Catch:{ Throwable -> 0x0019 }
        r0.submit(r2);	 Catch:{ Throwable -> 0x0019 }
    L_0x0018:
        return;
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.s.handleMessage(android.os.Message):void");
    }
}
