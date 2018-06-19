package com.xunlei.downloadprovider.vod.speeduptrial;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: ScheduleTask */
public abstract class l implements Runnable {
    static final /* synthetic */ boolean b = true;
    private long a = 0;
    private long c;
    private Handler d;
    private boolean e = false;

    protected abstract boolean a();

    public l(Handler handler) {
        boolean z = b;
        this.c = 5000;
        this.d = handler;
    }

    public final void b() {
        this.e = true;
        this.d.removeCallbacks(this);
    }

    public final void c() {
        this.e = false;
        this.d.postDelayed(this, this.c);
    }

    public void run() {
        if (!this.e) {
            if (SystemClock.uptimeMillis() - this.a < this.c) {
                this.d.postDelayed(this, this.c - (SystemClock.uptimeMillis() - this.a));
                return;
            }
            this.a = SystemClock.uptimeMillis();
            a();
            this.e = true;
        }
    }
}
