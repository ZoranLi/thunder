package com.qihoo360.replugin.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;

/* compiled from: ThreadUtils */
public final class e {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static <T> T a(Callable<T> callable, int i) throws Throwable {
        if (a.getLooper() == Looper.myLooper()) {
            return callable.call();
        }
        return b(callable, i);
    }

    private static <T> T b(java.util.concurrent.Callable<T> r5, int r6) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.concurrent.atomic.AtomicReference;
        r0.<init>();
        r1 = new java.util.concurrent.atomic.AtomicReference;
        r1.<init>();
        r2 = new java.util.concurrent.CountDownLatch;
        r3 = 1;
        r2.<init>(r3);
        r3 = a;
        r4 = new com.qihoo360.replugin.a.f;
        r4.<init>(r0, r5, r1, r2);
        r3.post(r4);
        r5 = (long) r6;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0020 }
        r2.await(r5, r3);	 Catch:{ InterruptedException -> 0x0020 }
    L_0x0020:
        r5 = r1.get();
        r5 = (java.lang.Throwable) r5;
        if (r5 == 0) goto L_0x0029;
    L_0x0028:
        throw r5;
    L_0x0029:
        r5 = r0.get();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.a.e.b(java.util.concurrent.Callable, int):T");
    }
}
