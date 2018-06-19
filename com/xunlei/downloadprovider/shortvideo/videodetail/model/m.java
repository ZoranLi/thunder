package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.VolleyError;

/* compiled from: ShortMovieDetailDataLoader */
final class m implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ l b;

    m(l lVar, VolleyError volleyError) {
        this.b = lVar;
        this.a = volleyError;
    }

    public final void run() {
        if (this.b.a.c.a != null) {
            this.b.a.c.a.a(1, this.a.getMessage());
        }
    }
}
