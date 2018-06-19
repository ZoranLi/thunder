package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.a;

/* compiled from: ShortMovieDetailDataLoader */
final class ao implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ am b;

    ao(am amVar, b bVar) {
        this.b = amVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.b.a.a != null) {
            a b = this.b.a.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.a);
            b.a(12, stringBuilder.toString());
        }
    }
}
