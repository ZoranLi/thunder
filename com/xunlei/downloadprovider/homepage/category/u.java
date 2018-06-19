package com.xunlei.downloadprovider.homepage.category;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ShortVideoCategoryDataHelper */
final class u implements a {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.onFail(volleyError.getMessage());
    }
}
