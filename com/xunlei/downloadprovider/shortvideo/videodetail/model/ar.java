package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.a;

/* compiled from: ShortMovieDetailDataLoader */
final class ar implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ ap b;

    ar(ap apVar, b bVar) {
        this.b = apVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.b.a.a != null) {
            a b = this.b.a.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.a);
            b.a(10, stringBuilder.toString());
        }
    }
}
