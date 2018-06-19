package com.xunlei.downloadprovider.shortvideo.videodetail.model;

/* compiled from: ShortMovieDetailDataLoader */
final class r implements Runnable {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final void run() {
        if (this.a.c.a != null) {
            this.a.c.a.b(this.a.a);
        }
    }
}
