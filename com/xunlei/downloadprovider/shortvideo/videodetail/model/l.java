package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ShortMovieDetailDataLoader */
final class l implements a {
    final /* synthetic */ h a;

    l(h hVar) {
        this.a = hVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.c.p.post(new m(this, volleyError));
    }
}
