package com.ali.auth.third.core.h.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class b implements com.ali.auth.third.core.h.b {
    private final Handler a = new Handler(Looper.getMainLooper());
    private ThreadPoolExecutor b;
    private final BlockingQueue<Runnable> c = new LinkedBlockingQueue(128);
    private final HandlerThread d = new HandlerThread("SDK Looper Thread");
    private final Handler e;

    public static class a implements RejectedExecutionHandler {
        private BlockingQueue<Runnable> a;

        public a(BlockingQueue<Runnable> blockingQueue) {
            this.a = blockingQueue;
        }

        private static Object a(Object obj) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return obj;
            }
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] toArray = this.a.toArray();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            for (Object obj : toArray) {
                stringBuilder.append(obj.getClass().isAnonymousClass() ? a(obj) : obj.getClass());
                stringBuilder.append(',');
                stringBuilder.append(' ');
            }
            stringBuilder.append(']');
            StringBuilder stringBuilder2 = new StringBuilder("Task ");
            stringBuilder2.append(runnable.toString());
            stringBuilder2.append(" rejected from ");
            stringBuilder2.append(threadPoolExecutor.toString());
            stringBuilder2.append(" in ");
            stringBuilder2.append(stringBuilder.toString());
            throw new RejectedExecutionException(stringBuilder2.toString());
        }
    }

    public b() {
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
        r11 = this;
        r11.<init>();
        r0 = new android.os.Handler;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r11.a = r0;
        r0 = new java.util.concurrent.LinkedBlockingQueue;
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0.<init>(r1);
        r11.c = r0;
        r0 = new android.os.HandlerThread;
        r1 = "SDK Looper Thread";
        r0.<init>(r1);
        r11.d = r0;
        r0 = r11.d;
        r0.start();
        r0 = r11.d;
        monitor-enter(r0);
    L_0x0028:
        r1 = r11.d;	 Catch:{ all -> 0x0063 }
        r1 = r1.getLooper();	 Catch:{ all -> 0x0063 }
        if (r1 != 0) goto L_0x0036;
    L_0x0030:
        r1 = r11.d;	 Catch:{ InterruptedException -> 0x0028 }
        r1.wait();	 Catch:{ InterruptedException -> 0x0028 }
        goto L_0x0028;
    L_0x0036:
        monitor-exit(r0);	 Catch:{ all -> 0x0063 }
        r0 = new android.os.Handler;
        r1 = r11.d;
        r1 = r1.getLooper();
        r0.<init>(r1);
        r11.e = r0;
        r9 = new com.ali.auth.third.core.h.a.c;
        r9.<init>(r11);
        r0 = new java.util.concurrent.ThreadPoolExecutor;
        r3 = 8;
        r4 = 16;
        r5 = 1;
        r7 = java.util.concurrent.TimeUnit.SECONDS;
        r8 = r11.c;
        r10 = new com.ali.auth.third.core.h.a.b$a;
        r1 = r11.c;
        r10.<init>(r1);
        r2 = r0;
        r2.<init>(r3, r4, r5, r7, r8, r9, r10);
        r11.b = r0;
        return;
    L_0x0063:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0063 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.h.a.b.<init>():void");
    }

    public final void a(Runnable runnable) {
        this.a.post(new d(this, runnable));
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.b.awaitTermination(j, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.b.execute(runnable);
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.b.invokeAll(collection);
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.b.invokeAll(collection, j, timeUnit);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.b.invokeAny(collection);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.b.invokeAny(collection, j, timeUnit);
    }

    public final boolean isShutdown() {
        return this.b.isShutdown();
    }

    public final boolean isTerminated() {
        return this.b.isTerminated();
    }

    public final void shutdown() {
        this.b.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.b.shutdownNow();
    }

    public final Future<?> submit(Runnable runnable) {
        return this.b.submit(runnable);
    }

    public final <T> Future<T> submit(Runnable runnable, T t) {
        return this.b.submit(runnable, t);
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return this.b.submit(callable);
    }
}
