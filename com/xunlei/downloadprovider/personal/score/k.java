package com.xunlei.downloadprovider.personal.score;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: UserScoreManager */
final class k implements a {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.a();
    }
}
