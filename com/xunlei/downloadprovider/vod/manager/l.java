package com.xunlei.downloadprovider.vod.manager;

import com.qiniu.android.http.o;
import com.xunlei.downloadprovider.contentpublish.a.a;

/* compiled from: VideoPublishManager */
final class l implements a {
    final /* synthetic */ String a;
    final /* synthetic */ k b;

    l(k kVar, String str) {
        this.b = kVar;
        this.a = str;
    }

    public final void a(o oVar) {
        if (oVar.b() != null) {
            j.a(this.b.g, this.a, this.b.a, this.b.b, this.b.c, this.b.d, this.b.e, this.b.f);
            return;
        }
        if (this.b.f != null) {
            this.b.f.a(j.d);
        }
    }
}
