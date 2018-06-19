package com.xunlei.downloadprovider.publiser.common.guide.follow;

import com.xunlei.downloadprovider.ad.common.n;
import java.util.List;

/* compiled from: GuideFollowPresenter */
final class b implements n<List<Long>> {
    final /* synthetic */ List a;
    final /* synthetic */ a b;

    b(a aVar, List list) {
        this.b = aVar;
        this.a = list;
    }

    public final /* synthetic */ void a(Object obj) {
        List list = (List) obj;
        if (this.b.d.c) {
            a.a;
            return;
        }
        a.b(this.b);
        a.a;
        a.c(this.b);
        this.b.b.b();
        a.a(true, list);
        if (list == null || list.isEmpty()) {
            this.b.c.c();
        } else {
            this.b.c.a(list.size());
        }
    }

    public final void a(int i, String str) {
        a.a;
        if (this.b.d.c != 0) {
            a.a;
            return;
        }
        a.b(this.b);
        this.b.e();
        a.a(0, this.a);
        this.b.c.c();
    }
}
