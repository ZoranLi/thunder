package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: ShortMovieDetailDataLoader */
final class s implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ q b;

    s(q qVar, b bVar) {
        this.b = qVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.b.c.a != null) {
            this.b.c.a.a(8, this.a.b);
        }
    }
}
