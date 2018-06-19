package com.xunlei.downloadprovider.comment;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: CommentManager */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        a.a;
        new StringBuilder("error response=>").append(volleyError.getStackTrace()[0].toString());
        b bVar = new b();
        bVar.a = -1001;
        bVar.b = volleyError.getMessage();
        this.a.d.a(bVar);
    }
}
