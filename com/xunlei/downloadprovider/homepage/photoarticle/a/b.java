package com.xunlei.downloadprovider.homepage.photoarticle.a;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: PhotoArticleNetworkHelper */
public final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ a c;

    public b(a aVar, String str, c cVar) {
        this.c = aVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/ivideo_v2/photo_info?res_id=");
        stringBuilder.append(this.a);
        this.c.a(new ar(stringBuilder.toString(), new c(this), new d(this)));
    }
}
