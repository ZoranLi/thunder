package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsitePublishHelper */
public final class be implements c<String> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ c c = null;
    final /* synthetic */ az d;

    public be(az azVar, String str, String str2) {
        this.d = azVar;
        this.a = str;
        this.b = str2;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        String str = (String) obj;
        bf.a(this.a, this.b, "", "success");
        if (this.c != null) {
            this.c.onSuccess(str);
        }
    }

    public final void onFail(String str) {
        bf.a(this.a, this.b, "", str);
        if (this.c != null) {
            this.c.onFail(str);
        }
    }
}
