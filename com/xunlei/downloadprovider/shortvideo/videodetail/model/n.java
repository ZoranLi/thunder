package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: ShortMovieDetailDataLoader */
final class n implements a<Void> {
    final /* synthetic */ long a;
    final /* synthetic */ g b;

    n(g gVar, long j) {
        this.b = gVar;
        this.a = j;
    }

    public final void a(b bVar) {
        this.b.p.post(new p(this, bVar));
    }

    public final /* synthetic */ void a(Object obj) {
        this.b.p.post(new o(this));
    }
}
