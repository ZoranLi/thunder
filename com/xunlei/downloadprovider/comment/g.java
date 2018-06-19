package com.xunlei.downloadprovider.comment;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: CommentManager */
final class g implements a {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        b bVar = new b();
        bVar.a = -1001;
        bVar.b = volleyError.getMessage();
        this.a.b.a(bVar);
    }
}
