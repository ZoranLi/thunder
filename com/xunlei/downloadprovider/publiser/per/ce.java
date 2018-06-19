package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.common.o;
import java.util.List;

/* compiled from: PublisherActivity */
final class ce implements e$d<a, List<a>> {
    final /* synthetic */ String a;
    final /* synthetic */ PublisherActivity b;

    ce(PublisherActivity publisherActivity, String str) {
        this.b = publisherActivity;
        this.a = str;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj2;
        com.xunlei.downloadprovider.homepage.recommend.a.a(this.a, this.b.k, 1, "success", "", o.a(this.b.l), "publish", this.b.W);
        PublisherActivity.a(this.b, this.a, list);
    }

    public final void a(String str) {
        if (!this.b.isFinishing()) {
            this.b.b(true);
            this.b.d(false);
            com.xunlei.downloadprovider.homepage.recommend.a.a(this.a, this.b.k, 1, "fail", str, o.a(this.b.l), "", this.b.W);
        }
    }
}
