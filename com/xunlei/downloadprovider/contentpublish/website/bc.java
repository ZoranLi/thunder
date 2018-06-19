package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsitePublishHelper */
final class bc implements Runnable {
    final /* synthetic */ au a;
    final /* synthetic */ c b;
    final /* synthetic */ az c;

    bc(az azVar, au auVar, c cVar) {
        this.c = azVar;
        this.a = auVar;
        this.b = cVar;
    }

    public final void run() {
        this.c.b.put(this.a.a, this.c.d.a(this.a, new bd(this)));
    }
}
