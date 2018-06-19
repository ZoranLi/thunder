package com.alibaba.baichuan.android.trade.c.a.a;

import com.alibaba.baichuan.android.trade.c.a.a.b.a;
import com.alibaba.baichuan.android.trade.c.a.a.b.c;
import java.util.concurrent.CountDownLatch;

final class f implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ a b;
    final /* synthetic */ c c;
    final /* synthetic */ CountDownLatch d;
    final /* synthetic */ e e;

    f(e eVar, a aVar, a aVar2, c cVar, CountDownLatch countDownLatch) {
        this.e = eVar;
        this.a = aVar;
        this.b = aVar2;
        this.c = cVar;
        this.d = countDownLatch;
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
        r0 = r3.a;	 Catch:{ Throwable -> 0x0018 }
        r1 = r3.b;	 Catch:{ Throwable -> 0x0018 }
        r2 = r3.c;	 Catch:{ Throwable -> 0x0018 }
        r1 = r1.a(r2);	 Catch:{ Throwable -> 0x0018 }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Throwable -> 0x0018 }
        r0.a = r1;	 Catch:{ Throwable -> 0x0018 }
        r0 = r3.d;
        r0.countDown();
        return;
    L_0x0016:
        r0 = move-exception;
        goto L_0x003d;
    L_0x0018:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0016 }
        r1 = "fail to execute the Handler ";	 Catch:{ all -> 0x0016 }
        r0.<init>(r1);	 Catch:{ all -> 0x0016 }
        r1 = r3.b;	 Catch:{ all -> 0x0016 }
        if (r1 == 0) goto L_0x0030;	 Catch:{ all -> 0x0016 }
    L_0x0023:
        r1 = r3.b;	 Catch:{ all -> 0x0016 }
        r1 = r1.a;	 Catch:{ all -> 0x0016 }
        if (r1 == 0) goto L_0x0030;	 Catch:{ all -> 0x0016 }
    L_0x0029:
        r1 = r3.b;	 Catch:{ all -> 0x0016 }
        r1 = r1.a;	 Catch:{ all -> 0x0016 }
        r1 = r1.a;	 Catch:{ all -> 0x0016 }
        goto L_0x0031;	 Catch:{ all -> 0x0016 }
    L_0x0030:
        r1 = 0;	 Catch:{ all -> 0x0016 }
    L_0x0031:
        r0.append(r1);	 Catch:{ all -> 0x0016 }
        com.alibaba.baichuan.android.trade.utils.g.a.a();	 Catch:{ all -> 0x0016 }
        r0 = r3.d;
        r0.countDown();
        return;
    L_0x003d:
        r1 = r3.d;
        r1.countDown();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.c.a.a.f.run():void");
    }
}
