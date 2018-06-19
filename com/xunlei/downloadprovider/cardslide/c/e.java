package com.xunlei.downloadprovider.cardslide.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CardSlideRequestManager */
final class e implements a {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.toString();
        b.d = true;
        if (this.a.a != null) {
            this.a.a.a();
        }
    }
}
