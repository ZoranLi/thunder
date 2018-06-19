package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.contentpublish.website.a.l;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsitePublishHelper */
final class bb implements c<l> {
    final /* synthetic */ ba a;

    bb(ba baVar) {
        this.a = baVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        l lVar = (l) obj;
        new StringBuilder("parseWebsiteFromServer--onSuccess--data=").append(lVar);
        if (lVar == null) {
            this.a.b.onFail("");
            return;
        }
        if (lVar.a()) {
            this.a.c.a = new au();
            this.a.c.a.a = this.a.a;
            this.a.c.a.b = lVar.c;
            this.a.c.a.c = lVar.b;
        }
        this.a.b.onSuccess(lVar);
    }

    public final void onFail(String str) {
        this.a.b.onFail(str);
    }
}
