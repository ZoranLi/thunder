package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.a;

/* compiled from: ShortMovieDetailDataLoader */
final class au implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ as b;

    au(as asVar, b bVar) {
        this.b = asVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.b.e.a != null) {
            a b = this.b.e.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.a);
            b.a(4, stringBuilder.toString());
        }
    }
}
