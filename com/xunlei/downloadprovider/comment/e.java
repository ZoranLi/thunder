package com.xunlei.downloadprovider.comment;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.n;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.entity.h;
import com.xunlei.downloadprovider.comment.entity.k;
import org.json.JSONObject;

/* compiled from: CommentManager */
final class e implements Runnable {
    final /* synthetic */ k a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    e(a aVar, k kVar, a aVar2) {
        this.c = aVar;
        this.a = kVar;
        this.b = aVar2;
    }

    public final void run() {
        k kVar = this.a;
        b fVar = new f(this);
        n.a gVar = new g(this);
        JSONObject c = kVar.c();
        new StringBuilder("json obj=>").append(c.toString());
        Request hVar = new h(1, "https://comment-shoulei-ssl.xunlei.com/comment/api/comment_v2", c, fVar, gVar);
        hVar.setRetryPolicy(new d(10000, 1, 1.0f));
        hVar.setTag(a.a);
        this.c.a(hVar);
    }
}
