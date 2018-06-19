package com.xunlei.downloadprovidershare;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ShareThunderCommandHelper */
final class u implements a {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.b != null) {
            this.a.b.a(null);
        }
    }
}
