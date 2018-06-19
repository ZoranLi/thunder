package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsitePublishHelper */
final class bd implements c<String> {
    final /* synthetic */ bc a;

    bd(bc bcVar) {
        this.a = bcVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        String str = (String) obj;
        this.a.c.b.remove(this.a.a.a);
        if (this.a.b != null) {
            this.a.b.onSuccess(str);
        }
    }

    public final void onFail(String str) {
        this.a.c.b.remove(this.a.a.a);
        if (this.a.b != null) {
            this.a.b.onFail(str);
        }
    }
}
