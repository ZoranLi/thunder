package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;

/* compiled from: ShortMovieDetailDataLoader */
final class q implements a<Void> {
    final /* synthetic */ CommentInfo a;
    final /* synthetic */ a.a b;
    final /* synthetic */ g c;

    q(g gVar, CommentInfo commentInfo, a.a aVar) {
        this.c = gVar;
        this.a = commentInfo;
        this.b = aVar;
    }

    public final void a(b bVar) {
        this.c.p.post(new s(this, bVar));
        this.b.d = false;
    }

    public final /* synthetic */ void a(Object obj) {
        this.c.p.post(new r(this));
        this.b.d = true;
    }
}
