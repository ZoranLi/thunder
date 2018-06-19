package com.xunlei.downloadprovider.vod.subtitle;

/* compiled from: SmoothScrollTimerTask */
final class f implements Runnable {
    int a = Integer.MAX_VALUE;
    int b = null;
    int c;
    final LoopView d;

    f(LoopView loopView, int i) {
        this.d = loopView;
        this.c = i;
    }

    public final void run() {
        if (this.a == Integer.MAX_VALUE) {
            this.a = this.c;
        }
        this.b = (int) (((float) this.a) * 0.1f);
        if (this.b == 0) {
            if (this.a < 0) {
                this.b = -1;
            } else {
                this.b = 1;
            }
        }
        if (Math.abs(this.a) <= 0) {
            this.d.a();
            this.d.a.sendEmptyMessage(3000);
            return;
        }
        this.d.o += this.b;
        this.d.a.sendEmptyMessage(1000);
        this.a -= this.b;
    }
}
