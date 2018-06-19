package com.xunlei.downloadprovider.homepage.photoarticle.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: PhotoArticleNetworkHelper */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("PhotoArticle--onErrorResponse=").append(volleyError);
        this.a.b.onFail("");
    }
}
