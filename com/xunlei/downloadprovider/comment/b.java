package com.xunlei.downloadprovider.comment;

import com.android.volley.Request;
import com.android.volley.n;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.entity.d;
import com.xunlei.downloadprovider.comment.entity.h;

/* compiled from: CommentManager */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ a d;
    final /* synthetic */ a e;

    b(a aVar, String str, String str2, long j, a aVar2) {
        this.e = aVar;
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = aVar2;
    }

    public final void run() {
        d dVar = new d();
        dVar.a = this.e.c.b;
        dVar.d = this.e.c.c;
        dVar.b = this.e.c.a;
        dVar.f = this.a;
        dVar.g = this.b;
        dVar.c = this.c;
        dVar.e = this.e.d;
        com.android.volley.n.b cVar = new c(this);
        n.a dVar2 = new d(this);
        StringBuilder stringBuilder = new StringBuilder("https://comment-shoulei-ssl.xunlei.com/comment/api/comment_v2?");
        stringBuilder.append(dVar.c());
        Request hVar = new h(0, stringBuilder.toString(), null, cVar, dVar2);
        a.a;
        StringBuilder stringBuilder2 = new StringBuilder("loadCommentList categoryType=");
        stringBuilder2.append(this.a);
        stringBuilder2.append(" url=");
        stringBuilder2.append(hVar.getUrl());
        hVar.setRetryPolicy(new com.android.volley.d(10000, 1, 1.0f));
        hVar.setTag(a.a);
        this.e.b.a(hVar);
    }
}
