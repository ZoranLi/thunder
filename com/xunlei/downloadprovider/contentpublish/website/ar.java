package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.contentpublish.website.a.l;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsiteEditActivity */
final class ar implements c<l> {
    final /* synthetic */ String a;
    final /* synthetic */ WebsiteEditActivity b;

    ar(WebsiteEditActivity websiteEditActivity, String str) {
        this.b = websiteEditActivity;
        this.a = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        l lVar = (l) obj;
        this.b.a();
        if (lVar != null) {
            if (lVar.a()) {
                this.b.b();
                bf.c(this.b.g, this.a, "success");
                return;
            } else if (lVar.a == 10) {
                WebsiteEditActivity.a(this.b, this.a, "暂不支持此链接，请重新输入");
                return;
            }
        }
        WebsiteEditActivity.a(this.b, this.a, "解析失败，请重新输入");
    }

    public final void onFail(String str) {
        this.b.a();
        WebsiteEditActivity.a(this.b, this.a, "解析失败，请重新输入");
    }
}
