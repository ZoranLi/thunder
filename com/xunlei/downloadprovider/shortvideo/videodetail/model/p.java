package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: ShortMovieDetailDataLoader */
final class p implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ n b;

    p(n nVar, b bVar) {
        this.b = nVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.b.b.a != null) {
            this.b.b.a.a(9, this.a.b);
        }
    }
}
