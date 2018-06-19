package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.entity.f;

/* compiled from: ShortMovieDetailDataLoader */
final class aq implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ ap b;

    aq(ap apVar, f fVar) {
        this.b = apVar;
        this.a = fVar;
    }

    public final void run() {
        if (this.b.a.a != null) {
            this.b.a.a.b(this.a);
        }
    }
}
