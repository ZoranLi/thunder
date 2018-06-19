package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: JoinActivityNetwork */
final class e implements a {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("JoinActivityIsNewRequest. fail. volleyErrorCode: ").append(b.b(volleyError));
        b.b(volleyError, this.a.a);
    }
}
