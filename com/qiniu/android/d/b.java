package com.qiniu.android.d;

import android.os.Handler;
import android.os.Looper;

/* compiled from: AsyncRun */
public final class b {
    public static void a(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
