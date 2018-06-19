package com.xunlei.downloadprovider.personal.score;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: UserScoreManager */
final class n implements a {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a.a();
    }
}
