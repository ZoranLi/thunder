package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: BUGLY */
public class e {
    private static Handler a;

    private static Handler a() {
        if (a == null && Looper.getMainLooper() != null) {
            a = new Handler(Looper.getMainLooper());
        }
        return a;
    }

    public static void a(Runnable runnable) {
        if (a() != null) {
            a.post(runnable);
        }
    }

    public static void b(Runnable runnable) {
        if (a() != null) {
            a.removeCallbacks(runnable);
        }
    }

    public static void a(Runnable runnable, long j) {
        if (a() != null) {
            a.postDelayed(runnable, j);
        }
    }
}
