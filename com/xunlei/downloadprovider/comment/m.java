package com.xunlei.downloadprovider.comment;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.n;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.entity.h;
import com.xunlei.downloadprovider.comment.entity.i;

/* compiled from: CommentManager */
public final class m implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    public m(a aVar, long j, a aVar2) {
        this.c = aVar;
        this.a = j;
        this.b = aVar2;
    }

    public final void run() {
        i iVar = new i();
        iVar.d = this.a;
        iVar.a = this.c.c.b;
        iVar.b = this.c.c.c;
        iVar.c = this.c.c.a;
        b nVar = new n(this);
        n.a oVar = new o(this);
        StringBuilder stringBuilder = new StringBuilder("https://comment-shoulei-ssl.xunlei.com/comment/api/comment_del?");
        stringBuilder.append(iVar.c());
        Request hVar = new h(0, stringBuilder.toString(), null, nVar, oVar);
        hVar.setRetryPolicy(new d(10000, 1, 1.0f));
        hVar.setTag(a.a);
        this.c.b.a(hVar);
    }
}
