package com.xunlei.downloadprovider.download.player.a;

/* compiled from: VipAccelerateTryController */
final class bo implements Runnable {
    final /* synthetic */ bn a;

    bo(bn bnVar) {
        this.a = bnVar;
    }

    public final void run() {
        this.a.e.removeCallbacks(this);
        bn.a(this.a);
    }
}
