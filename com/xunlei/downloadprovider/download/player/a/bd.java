package com.xunlei.downloadprovider.download.player.a;

/* compiled from: SubtitleController */
final class bd implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ba b;

    bd(ba baVar, int i) {
        this.b = baVar;
        this.a = i;
    }

    public final void run() {
        this.b.o.a(this.a, true);
        ba.m;
        new StringBuilder("select file pos=>").append(this.a);
    }
}
