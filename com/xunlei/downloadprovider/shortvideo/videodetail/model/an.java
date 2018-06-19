package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.entity.f;

/* compiled from: ShortMovieDetailDataLoader */
final class an implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ am b;

    an(am amVar, f fVar) {
        this.b = amVar;
        this.a = fVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.a.d);
        stringBuilder.append("currentTimeMillis：");
        stringBuilder.append(System.currentTimeMillis());
        if (this.b.a.d > System.currentTimeMillis() - 1000) {
            this.b.a.p.postDelayed(this, 1000);
            return;
        }
        if (this.b.a.a != null) {
            this.b.a.a.a(this.a);
        }
    }
}
