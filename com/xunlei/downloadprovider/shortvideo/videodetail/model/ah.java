package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ShortMovieDetailDataLoader */
final class ah implements a {
    final /* synthetic */ ad a;

    ah(ad adVar) {
        this.a = adVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.d.p.post(new ai(this, volleyError));
    }
}
