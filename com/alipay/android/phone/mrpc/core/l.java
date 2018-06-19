package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public final class l implements ab {
    private static l b;
    private static final ThreadFactory i = new n();
    Context a;
    private ThreadPoolExecutor c = new ThreadPoolExecutor(10, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new CallerRunsPolicy());
    private b d = b.a(DispatchConstants.ANDROID);
    private long e;
    private long f;
    private long g;
    private int h;

    private l(android.content.Context r10) {
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
        r9 = this;
        r9.<init>();
        r9.a = r10;
        r10 = "android";
        r10 = com.alipay.android.phone.mrpc.core.b.a(r10);
        r9.d = r10;
        r10 = new java.util.concurrent.ThreadPoolExecutor;
        r5 = java.util.concurrent.TimeUnit.SECONDS;
        r6 = new java.util.concurrent.ArrayBlockingQueue;
        r0 = 20;
        r6.<init>(r0);
        r7 = i;
        r8 = new java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy;
        r8.<init>();
        r1 = 10;
        r2 = 11;
        r3 = 3;
        r0 = r10;
        r0.<init>(r1, r2, r3, r5, r6, r7, r8);
        r9.c = r10;
        r10 = 1;
        r0 = r9.c;	 Catch:{ Exception -> 0x0031 }
        r0.allowCoreThreadTimeOut(r10);	 Catch:{ Exception -> 0x0031 }
    L_0x0031:
        r0 = r9.a;
        android.webkit.CookieSyncManager.createInstance(r0);
        r0 = android.webkit.CookieManager.getInstance();
        r0.setAcceptCookie(r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.l.<init>(android.content.Context):void");
    }

    public static final l a(Context context) {
        return b != null ? b : b(context);
    }

    private static final synchronized l b(Context context) {
        synchronized (l.class) {
            if (b != null) {
                l lVar = b;
                return lVar;
            }
            l lVar2 = new l(context);
            b = lVar2;
            return lVar2;
        }
    }

    public final b a() {
        return this.d;
    }

    public final Future<u> a(t tVar) {
        if (s.a(this.a)) {
            StringBuilder stringBuilder = new StringBuilder("HttpManager");
            stringBuilder.append(hashCode());
            stringBuilder.append(": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times");
            String stringBuilder2 = stringBuilder.toString();
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.c.getActiveCount());
            objArr[1] = Long.valueOf(this.c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.c.getTaskCount());
            long j = 0;
            objArr[3] = Long.valueOf(this.g == 0 ? 0 : ((this.e * 1000) / this.g) >> 10);
            if (this.h != 0) {
                j = this.f / ((long) this.h);
            }
            objArr[4] = Long.valueOf(j);
            objArr[5] = Long.valueOf(this.e);
            objArr[6] = Long.valueOf(this.f);
            objArr[7] = Long.valueOf(this.g);
            objArr[8] = Integer.valueOf(this.h);
            String.format(stringBuilder2, objArr);
        }
        Object qVar = new q(this, (o) tVar);
        Object mVar = new m(this, qVar, qVar);
        this.c.execute(mVar);
        return mVar;
    }

    public final void a(long j) {
        this.e += j;
    }

    public final void b(long j) {
        this.f += j;
        this.h++;
    }

    public final void c(long j) {
        this.g += j;
    }
}
