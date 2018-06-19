package com.xunlei.downloadprovider.app;

import android.os.Looper;

/* compiled from: PerformanceTrace */
public final class e {
    public static void a(String str) {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            StringBuilder stringBuilder = new StringBuilder("MainThreadError: ");
            stringBuilder.append(str);
            Exception exception = new Exception(stringBuilder.toString());
        }
    }
}
