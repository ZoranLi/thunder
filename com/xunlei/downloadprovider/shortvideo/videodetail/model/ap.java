package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.f;

/* compiled from: ShortMovieDetailDataLoader */
final class ap implements a<f> {
    final /* synthetic */ g a;

    ap(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void a(Object obj) {
        f fVar = (f) obj;
        g.a(this.a, fVar, true);
        this.a.p.post(new aq(this, fVar));
    }

    public final void a(b bVar) {
        this.a.p.post(new ar(this, bVar));
    }
}
