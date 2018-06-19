package com.xunlei.downloadprovider.comment;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.n;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.entity.h;
import com.xunlei.downloadprovider.comment.entity.j;

/* compiled from: CommentManager */
public final class p implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;
    final /* synthetic */ a d;

    public p(a aVar, long j, int i, a aVar2) {
        this.d = aVar;
        this.a = j;
        this.b = i;
        this.c = aVar2;
    }

    public final void run() {
        j jVar = new j();
        jVar.d = this.a;
        jVar.a = this.d.c.b;
        jVar.b = this.d.c.c;
        jVar.c = this.d.c.a;
        jVar.e = this.b;
        b qVar = new q(this);
        n.a rVar = new r(this);
        StringBuilder stringBuilder = new StringBuilder("https://comment-shoulei-ssl.xunlei.com/comment/api/report?");
        stringBuilder.append(jVar.c());
        Request hVar = new h(0, stringBuilder.toString(), null, qVar, rVar);
        hVar.setRetryPolicy(new d(10000, 1, 1.0f));
        hVar.setTag(a.a);
        this.d.b.a(hVar);
    }
}
