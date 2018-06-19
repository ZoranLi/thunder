package com.xunlei.downloadprovider.publiser.visitors.view;

import com.xunlei.downloadprovider.member.payment.a.e.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: UnfollowFooterViewHolder */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void a() {
        this.a.b.a();
        this.a.a.a();
        com.xunlei.downloadprovider.homepage.recommend.a.a("visit", this.a.d, 1, "success", "", o.a(this.a.e), "", 0);
    }

    public final void a(String str) {
        com.xunlei.downloadprovider.homepage.recommend.a.a("visit", this.a.d, 1, "fail", str, o.a(this.a.e), "", 0);
        this.a.c.setEnabled(true);
    }
}
