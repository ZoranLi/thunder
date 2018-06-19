package com.xunlei.downloadprovider.ad.splash;

import android.os.Handler;

/* compiled from: CountDownCounter */
public abstract class a {
    long a;
    final long b;
    boolean c;
    public long d;
    Handler e = new Handler(new b(this));
    private final long f;

    public abstract void a();

    public abstract void a(long j);

    public a(long j, long j2) {
        this.f = j;
        this.a = j;
        this.b = j2;
        this.c = 0;
    }

    public final void b() {
        d();
        this.a = this.f;
        this.c = false;
    }

    public void c() {
        this.d = System.currentTimeMillis();
        this.e.sendEmptyMessage(1);
    }

    public void d() {
        this.c = true;
        this.e.removeCallbacksAndMessages(null);
    }
}
