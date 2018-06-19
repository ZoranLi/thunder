package com.xunlei.downloadprovider.download.player.a;

/* compiled from: DNLAController */
final class i implements Runnable {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        this.a.c = g.b(this.a);
        this.a.h.post(new j(this));
    }
}
