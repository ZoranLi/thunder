package com.xunlei.downloadprovider.comment;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: CommentManager */
final class r implements a {
    final /* synthetic */ p a;

    r(p pVar) {
        this.a = pVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        b bVar = new b();
        bVar.a = -1;
        bVar.b = volleyError.getMessage();
        this.a.c.a(bVar);
    }
}
