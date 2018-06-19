package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.VolleyError;

/* compiled from: ShortMovieDetailDataLoader */
final class ac implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ ab b;

    ac(ab abVar, VolleyError volleyError) {
        this.b = abVar;
        this.a = volleyError;
    }

    public final void run() {
        if (this.b.a.a != null) {
            this.b.a.a.a(13, this.a.getMessage());
        }
    }
}
