package com.xunlei.downloadprovider.download.engine.util;

import android.os.SystemClock;

/* compiled from: CachedVariable */
public final class a<T> {
    protected T a;
    protected T b;
    private final long c;
    private long d = 0;
    private long e = 0;
    private boolean f = false;

    public a(T t, T t2) {
        this.a = t;
        this.b = t2;
        this.c = 10000;
    }

    public final T a() {
        return b(this.b);
    }

    public final synchronized void a(T t) {
        this.f = true;
        this.d = SystemClock.elapsedRealtime();
        this.a = t;
    }

    private synchronized T b(T t) {
        this.e = SystemClock.elapsedRealtime();
        if ((Math.abs(this.e - this.d) >= this.c ? 1 : null) != null) {
            return t;
        }
        return this.a;
    }
}
