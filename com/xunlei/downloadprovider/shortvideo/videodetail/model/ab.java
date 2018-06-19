package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ShortMovieDetailDataLoader */
final class ab implements a {
    final /* synthetic */ g a;

    ab(g gVar) {
        this.a = gVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("like users error response=>").append(volleyError.getMessage());
        this.a.p.post(new ac(this, volleyError));
    }
}
