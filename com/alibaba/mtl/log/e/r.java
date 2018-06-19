package com.alibaba.mtl.log.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.appmonitor.b.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TaskExecutor */
public final class r {
    public static r a = null;
    private static ThreadPoolExecutor b = null;
    private static int c = 1;
    private static int d = 2;
    private static int e = 10;
    private static int f = 60;
    private static final AtomicInteger i = new AtomicInteger();
    private HandlerThread g = new HandlerThread("AppMonitor");
    private Handler h;

    /* compiled from: TaskExecutor */
    static class a implements ThreadFactory {
        private int a;

        public a(int i) {
            this.a = i;
        }

        public final Thread newThread(Runnable runnable) {
            int andIncrement = r.i.getAndIncrement();
            StringBuilder stringBuilder = new StringBuilder("AppMonitor:");
            stringBuilder.append(andIncrement);
            Thread thread = new Thread(runnable, stringBuilder.toString());
            thread.setPriority(this.a);
            return thread;
        }
    }

    private static synchronized ThreadPoolExecutor d() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (r.class) {
            if (b == null) {
                int i = c;
                int i2 = d;
                int i3 = e;
                int i4 = f;
                b = new ThreadPoolExecutor(i2, i3, (long) i4, TimeUnit.SECONDS, new LinkedBlockingQueue(500), new a(i), new DiscardOldestPolicy());
            }
            threadPoolExecutor = b;
        }
        return threadPoolExecutor;
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (a == null) {
                a = new r();
            }
            rVar = a;
        }
        return rVar;
    }

    private r() {
        this.g.start();
        this.h = new s(this, this.g.getLooper());
    }

    public final void a(int i, Runnable runnable, long j) {
        try {
            i = Message.obtain(this.h, i);
            i.obj = runnable;
            this.h.sendMessageDelayed(i, j);
        } catch (int i2) {
            b.a(i2);
        }
    }

    public final void a(int i) {
        this.h.removeMessages(i);
    }

    public final boolean b(int i) {
        return this.h.hasMessages(i);
    }

    public static void a(java.lang.Runnable r1) {
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
        r0 = d();	 Catch:{ Throwable -> 0x0008 }
        r0.submit(r1);	 Catch:{ Throwable -> 0x0008 }
        return;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.r.a(java.lang.Runnable):void");
    }
}
