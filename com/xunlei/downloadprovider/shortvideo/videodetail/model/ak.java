package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.entity.f;

/* compiled from: ShortMovieDetailDataLoader */
final class ak implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ f b;
    final /* synthetic */ aj c;

    ak(aj ajVar, int i, f fVar) {
        this.c = ajVar;
        this.a = i;
        this.b = fVar;
    }

    public final void run() {
        if (this.c.a.a != null) {
            this.c.a.a.a(this.a, this.b);
        }
    }
}
