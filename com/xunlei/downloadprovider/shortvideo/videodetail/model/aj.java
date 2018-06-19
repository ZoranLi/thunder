package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.f;

/* compiled from: ShortMovieDetailDataLoader */
final class aj implements a<f> {
    final /* synthetic */ g a;

    aj(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void a(Object obj) {
        f fVar = (f) obj;
        int size = (fVar == null || fVar.e == null) ? 0 : fVar.e.size();
        g.a(this.a, fVar, false);
        this.a.p.post(new ak(this, size, fVar));
    }

    public final void a(b bVar) {
        this.a.p.post(new al(this, bVar));
    }
}
