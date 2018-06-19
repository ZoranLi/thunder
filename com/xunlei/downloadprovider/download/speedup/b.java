package com.xunlei.downloadprovider.download.speedup;

/* compiled from: AnimationDrawableWrapper */
final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        this.a.d.stop();
        if (this.a.b >= this.a.c) {
            this.a.a.removeCallbacks(this);
            if (this.a.g != null) {
                this.a.g.a();
            }
            this.a.b = 0;
            return;
        }
        a aVar = this.a;
        aVar.b++;
        this.a.d.start();
        this.a.a.postDelayed(this.a.f, this.a.e);
    }
}
