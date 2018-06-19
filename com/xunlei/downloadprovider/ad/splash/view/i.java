package com.xunlei.downloadprovider.ad.splash.view;

import android.content.Context;
import com.xunlei.downloadprovider.ad.common.l;
import java.util.concurrent.TimeUnit;

/* compiled from: SplashAnotherCountDownView */
public abstract class i extends b {
    protected static final long r = TimeUnit.SECONDS.toMillis(5);
    protected static final long s = TimeUnit.SECONDS.toMillis(20);
    private static final String t = "i";
    protected l q = null;

    public i(Context context) {
        super(context);
    }

    public void setAnotherCountDown(long j) {
        this.q = new l(j);
        this.q.a(new j(this));
    }

    public final void r() {
        if (this.q != null) {
            this.q.b();
        }
    }

    public final void s() {
        if (this.q != null) {
            this.q.a();
        }
    }

    public void m() {
        super.m();
        s();
    }

    protected static long a(long j) {
        return (j <= 0 || j >= s) ? r : j;
    }
}
