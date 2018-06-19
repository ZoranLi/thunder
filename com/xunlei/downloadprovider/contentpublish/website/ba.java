package com.xunlei.downloadprovider.contentpublish.website;

import com.android.volley.Request;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsitePublishHelper */
final class ba implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ az c;

    ba(az azVar, String str, c cVar) {
        this.c = azVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        Request a = this.c.d.a(this.a, new bb(this));
        if (a != null) {
            this.c.e.put(this.a, a);
        }
    }
}
