package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ShortMovieDetailDataLoader */
final class w implements a {
    final /* synthetic */ t a;

    w(t tVar) {
        this.a = tVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("loadRelatedGameInfo error =>").append(volleyError.getMessage());
        this.a.b.p.post(new x(this));
    }
}
