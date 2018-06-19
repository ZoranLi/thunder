package com.alibaba.sdk.android.feedback.xblink.a;

import android.os.Build.VERSION;
import android.util.LruCache;

public class b {
    private static b a;
    private LruCache b;

    public b() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 10240);
        if (VERSION.SDK_INT > 11) {
            this.b = new c(this, maxMemory);
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public void b() {
        if (this.b != null) {
            this.b.evictAll();
        }
    }
}
