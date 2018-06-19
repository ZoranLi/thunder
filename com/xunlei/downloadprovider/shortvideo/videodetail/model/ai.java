package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.VolleyError;

/* compiled from: ShortMovieDetailDataLoader */
final class ai implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ ah b;

    ai(ah ahVar, VolleyError volleyError) {
        this.b = ahVar;
        this.a = volleyError;
    }

    public final void run() {
        if (this.b.a.d.a != null) {
            this.b.a.d.a.a(2, this.a.getMessage());
        }
    }
}
