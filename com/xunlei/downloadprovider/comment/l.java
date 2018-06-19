package com.xunlei.downloadprovider.comment;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: CommentManager */
public final class l implements a {
    final /* synthetic */ a.a a;
    final /* synthetic */ a b;

    public l(a aVar, a.a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        b bVar = new b();
        bVar.a = -1;
        bVar.b = volleyError.getMessage();
        this.a.a(bVar);
    }
}
