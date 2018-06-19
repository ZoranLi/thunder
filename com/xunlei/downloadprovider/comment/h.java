package com.xunlei.downloadprovider.comment;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.entity.l;

/* compiled from: CommentManager */
public final class h implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ a c;
    final /* synthetic */ a d;

    public h(a aVar, long j, long j2, a aVar2) {
        this.d = aVar;
        this.a = j;
        this.b = j2;
        this.c = aVar2;
    }

    public final void run() {
        l lVar = new l();
        lVar.c = this.d.c.c;
        lVar.a = this.d.c.b;
        lVar.b = this.d.c.a;
        lVar.d = this.a;
        lVar.e = this.b;
        Request a = lVar.a(new i(this), new j(this));
        a.setRetryPolicy(new d(10000, 1, 1.0f));
        a.setTag(a.a);
        this.d.b.a(a);
    }
}
