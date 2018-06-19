package com.xunlei.downloadprovider.vod.subtitle;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: SubtitleManager */
public final class j implements a {
    final /* synthetic */ g a;

    public j(g gVar) {
        this.a = gVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        g.a;
        new StringBuilder("exect request error =>").append(volleyError.getMessage());
        if (this.a.h != null) {
            this.a.d.post(new k(this));
        }
    }
}
