package com.xunlei.downloadprovider.vod.subtitle;

/* compiled from: InertiaTimerTask */
final class a implements Runnable {
    float a = 2.14748365E9f;
    final float b;
    final LoopView c;

    a(LoopView loopView, float f) {
        this.c = loopView;
        this.b = f;
    }

    public final void run() {
        if (this.a == 2.14748365E9f) {
            if (Math.abs(this.b) <= 2000.0f) {
                this.a = this.b;
            } else if (this.b > 0.0f) {
                this.a = 2000.0f;
            } else {
                this.a = -2000.0f;
            }
        }
        if (Math.abs(this.a) < 0.0f || Math.abs(this.a) > 20.0f) {
            int i = (int) ((this.a * 10.0f) / 1000.0f);
            LoopView loopView = this.c;
            loopView.o -= i;
            if (!this.c.l) {
                float f = this.c.k * ((float) this.c.g);
                if (this.c.o <= ((int) (((float) (-this.c.p)) * f))) {
                    this.a = 40.0f;
                    this.c.o = (int) (((float) (-this.c.p)) * f);
                } else if (this.c.o >= ((int) (((float) ((this.c.e.size() - 1) - this.c.p)) * f))) {
                    this.c.o = (int) (((float) ((this.c.e.size() - 1) - this.c.p)) * f);
                    this.a = -40.0f;
                }
            }
            if (this.a < 0.0f) {
                this.a += 20.0f;
            } else {
                this.a -= 20.0f;
            }
            this.c.a.sendEmptyMessage(1000);
            return;
        }
        this.c.a();
        this.c.a.sendEmptyMessage(2000);
    }
}
