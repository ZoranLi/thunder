package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class m extends FutureTask<u> {
    final /* synthetic */ q a;
    final /* synthetic */ l b;

    m(l lVar, Callable callable, q qVar) {
        this.b = lVar;
        this.a = qVar;
        super(callable);
    }

    protected final void done() {
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
        r0 = r3.a;
        r0 = r0.a();
        r1 = r0.f();
        if (r1 != 0) goto L_0x0010;
    L_0x000c:
        super.done();
        return;
    L_0x0010:
        r3.get();	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
        r1 = r3.isCancelled();	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
        if (r1 != 0) goto L_0x001f;	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
    L_0x0019:
        r1 = r0.h();	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
        if (r1 == 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
    L_0x001f:
        r0.g();	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
        r1 = r3.isCancelled();	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
        if (r1 == 0) goto L_0x002e;	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
    L_0x0028:
        r1 = r3.isDone();	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
        if (r1 != 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
    L_0x002e:
        r1 = 0;	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
        r3.cancel(r1);	 Catch:{ InterruptedException -> 0x0065, ExecutionException -> 0x0040, CancellationException -> 0x003c, Throwable -> 0x0033 }
    L_0x0032:
        return;
    L_0x0033:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = "An error occured while executing http request";
        r1.<init>(r2, r0);
        throw r1;
    L_0x003c:
        r0.g();
        return;
    L_0x0040:
        r0 = move-exception;
        r1 = r0.getCause();
        if (r1 == 0) goto L_0x005c;
    L_0x0047:
        r1 = r0.getCause();
        r1 = r1 instanceof com.alipay.android.phone.mrpc.core.HttpException;
        if (r1 == 0) goto L_0x005c;
    L_0x004f:
        r0 = r0.getCause();
        r0 = (com.alipay.android.phone.mrpc.core.HttpException) r0;
        r0.getCode();
        r0.getMsg();
        return;
    L_0x005c:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        return;
    L_0x0065:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.m.done():void");
    }
}
