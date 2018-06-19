package anet.channel.a;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
class a implements Comparable<a>, Runnable, Future {
    Runnable a = null;
    int b = 0;
    long c = System.currentTimeMillis();
    volatile boolean d = false;
    volatile Future<?> e = null;

    public boolean isDone() {
        return false;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((a) obj);
    }

    public a(Runnable runnable, int i) {
        this.a = runnable;
        if (i < 0) {
            i = 0;
        }
        this.b = i;
        this.c = System.currentTimeMillis();
    }

    public int a(a aVar) {
        if (this.b != aVar.b) {
            return this.b - aVar.b;
        }
        return (int) (aVar.c - this.c);
    }

    public void run() {
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
        r0 = r3.d;	 Catch:{ RejectedExecutionException -> 0x0024 }
        if (r0 == 0) goto L_0x0005;	 Catch:{ RejectedExecutionException -> 0x0024 }
    L_0x0004:
        return;	 Catch:{ RejectedExecutionException -> 0x0024 }
    L_0x0005:
        r0 = r3.b;	 Catch:{ RejectedExecutionException -> 0x0024 }
        r1 = 6;	 Catch:{ RejectedExecutionException -> 0x0024 }
        if (r0 > r1) goto L_0x0017;	 Catch:{ RejectedExecutionException -> 0x0024 }
    L_0x000a:
        r0 = anet.channel.a.d.a();	 Catch:{ RejectedExecutionException -> 0x0024 }
        r1 = r3.a;	 Catch:{ RejectedExecutionException -> 0x0024 }
        r0 = r0.submit(r1);	 Catch:{ RejectedExecutionException -> 0x0024 }
        r3.e = r0;	 Catch:{ RejectedExecutionException -> 0x0024 }
        return;	 Catch:{ RejectedExecutionException -> 0x0024 }
    L_0x0017:
        r0 = anet.channel.a.d.b();	 Catch:{ RejectedExecutionException -> 0x0024 }
        r1 = r3.a;	 Catch:{ RejectedExecutionException -> 0x0024 }
        r0 = r0.submit(r1);	 Catch:{ RejectedExecutionException -> 0x0024 }
        r3.e = r0;	 Catch:{ RejectedExecutionException -> 0x0024 }
        return;
    L_0x0024:
        r0 = r3.b;
        r0 = r0 + 1;
        r3.b = r0;
        r0 = r3.b;
        r0 = r0 + 1;
        r0 = r0 * 500;
        r0 = (long) r0;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        anet.channel.a.c.a(r3, r0, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.a.a.run():void");
    }

    public boolean cancel(boolean z) {
        this.d = true;
        if (this.e != null) {
            return this.e.cancel(z);
        }
        return true;
    }

    public boolean isCancelled() {
        return this.d;
    }

    public Object get() throws InterruptedException, ExecutionException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }
}
