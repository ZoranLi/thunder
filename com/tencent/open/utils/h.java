package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: ProGuard */
public final class h {
    public static final Executor a = c();
    private static Object b = new Object();
    private static Handler c;
    private static HandlerThread d;

    /* compiled from: ProGuard */
    private static class a implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        private a() {
            this.a = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable(this) {
                final /* synthetic */ a b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.b.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        protected synchronized void a() {
            Runnable runnable = (Runnable) this.a.poll();
            this.b = runnable;
            if (runnable != null) {
                h.a.execute(this.b);
            }
        }
    }

    private static java.util.concurrent.Executor c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0018;
    L_0x0006:
        r0 = new java.util.concurrent.ThreadPoolExecutor;
        r3 = 1;
        r4 = 1;
        r5 = 0;
        r7 = java.util.concurrent.TimeUnit.SECONDS;
        r8 = new java.util.concurrent.LinkedBlockingQueue;
        r8.<init>();
        r2 = r0;
        r2.<init>(r3, r4, r5, r7, r8);
        goto L_0x003d;
    L_0x0018:
        r0 = android.os.AsyncTask.class;	 Catch:{ Exception -> 0x002c }
        r1 = "sExecutor";	 Catch:{ Exception -> 0x002c }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Exception -> 0x002c }
        r1 = 1;	 Catch:{ Exception -> 0x002c }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x002c }
        r1 = 0;	 Catch:{ Exception -> 0x002c }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x002c }
        r0 = (java.util.concurrent.Executor) r0;	 Catch:{ Exception -> 0x002c }
        goto L_0x003d;
    L_0x002c:
        r0 = new java.util.concurrent.ThreadPoolExecutor;
        r2 = 1;
        r3 = 1;
        r4 = 0;
        r6 = java.util.concurrent.TimeUnit.SECONDS;
        r7 = new java.util.concurrent.LinkedBlockingQueue;
        r7.<init>();
        r1 = r0;
        r1.<init>(r2, r3, r4, r6, r7);
    L_0x003d:
        r1 = r0 instanceof java.util.concurrent.ThreadPoolExecutor;
        if (r1 == 0) goto L_0x0048;
    L_0x0041:
        r1 = r0;
        r1 = (java.util.concurrent.ThreadPoolExecutor) r1;
        r2 = 3;
        r1.setCorePoolSize(r2);
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.h.c():java.util.concurrent.Executor");
    }

    public static Handler a() {
        if (c == null) {
            synchronized (h.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                d = handlerThread;
                handlerThread.start();
                c = new Handler(d.getLooper());
            }
        }
        return c;
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }

    public static Executor b() {
        return new a();
    }
}
