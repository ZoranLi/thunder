package com.xunlei.downloadprovider.publiser.visitors.view;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: VisitViewHolder */
final class p implements a {
    final /* synthetic */ long a;
    final /* synthetic */ LoginHelper b;
    final /* synthetic */ i c;

    p(i iVar, long j, LoginHelper loginHelper) {
        this.c = iVar;
        this.a = j;
        this.b = loginHelper;
    }

    public final void a() {
        this.c.i.setBackgroundResource(R.drawable.btn_unfollow_selector2);
        this.c.i.setText("已关注");
        com.xunlei.downloadprovider.homepage.recommend.a.a(this.a, l.c(), "success", null, this.c.a);
    }

    public final void a(String str) {
        com.xunlei.downloadprovider.homepage.recommend.a.a(this.a, l.c(), "fail", str, this.c.a);
    }
}
