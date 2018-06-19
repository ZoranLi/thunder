package com.xunlei.downloadprovider.vod.subtitle;

/* compiled from: SubtitleManager */
final class o implements Runnable {
    final /* synthetic */ SubtitleManifest a;
    final /* synthetic */ g b;

    o(g gVar, SubtitleManifest subtitleManifest) {
        this.b = gVar;
        this.a = subtitleManifest;
    }

    public final void run() {
        this.b.h.a(this.a);
    }
}
