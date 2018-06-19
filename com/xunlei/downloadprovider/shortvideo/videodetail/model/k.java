package com.xunlei.downloadprovider.shortvideo.videodetail.model;

/* compiled from: ShortMovieDetailDataLoader */
final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;
    final /* synthetic */ i c;

    k(i iVar, String str, b bVar) {
        this.c = iVar;
        this.a = str;
        this.b = bVar;
    }

    public final void run() {
        if (this.c.a.c.a != null) {
            this.c.a.c.a.a(this.a, this.b);
        }
    }
}
