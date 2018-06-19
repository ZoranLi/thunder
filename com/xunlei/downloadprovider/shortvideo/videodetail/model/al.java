package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.a;

/* compiled from: ShortMovieDetailDataLoader */
final class al implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ aj b;

    al(aj ajVar, b bVar) {
        this.b = ajVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.b.a.a != null) {
            a b = this.b.a.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.a);
            b.a(3, stringBuilder.toString());
        }
    }
}
