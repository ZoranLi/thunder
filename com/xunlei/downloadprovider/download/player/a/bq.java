package com.xunlei.downloadprovider.download.player.a;

/* compiled from: VipAccelerateTryController */
final class bq implements Runnable {
    final /* synthetic */ bn a;

    bq(bn bnVar) {
        this.a = bnVar;
    }

    public final void run() {
        if (this.a.e != null) {
            if (this.a.g) {
                bn.c(this.a);
                bn.d(this.a);
            } else {
                this.a.m();
            }
            bn.f(this.a);
            if (this.a.f() != null && this.a.f().E()) {
                this.a.i = 0;
                this.a.j = false;
            }
            this.a.e.postDelayed(this.a.h, 1000);
        }
    }
}
