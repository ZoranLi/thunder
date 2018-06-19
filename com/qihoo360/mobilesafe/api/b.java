package com.qihoo360.mobilesafe.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: Tasks */
public final class b {
    private static Handler a;
    private static Object b = new Object();
    private static Handler c;

    public static final boolean a(Runnable runnable) {
        return a.post(runnable);
    }

    public static final boolean b(Runnable runnable) {
        b();
        return c.post(runnable);
    }

    public static final boolean c(Runnable runnable) {
        b();
        return c.postDelayed(runnable, 300);
    }

    public static final void a() {
        a = new Handler(Looper.getMainLooper());
    }

    private static final void b() {
        synchronized (b) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread("daemon-handler-thread");
                handlerThread.start();
                c = new Handler(handlerThread.getLooper());
            }
        }
    }
}
