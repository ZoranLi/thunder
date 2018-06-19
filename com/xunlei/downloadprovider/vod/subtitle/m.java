package com.xunlei.downloadprovider.vod.subtitle;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: SubtitleManager */
public final class m implements a {
    final /* synthetic */ g a;

    public m(g gVar) {
        this.a = gVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("exect request error =>").append(volleyError.getMessage());
    }
}
