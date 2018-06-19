package com.xunlei.downloadprovider.homepage.follow.ui.view;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.member.payment.a.e.a;
import java.util.List;

/* compiled from: RecommendFollowListBaseView */
final class ac implements a {
    final /* synthetic */ g a;
    final /* synthetic */ List b;
    final /* synthetic */ y c;

    ac(y yVar, g gVar, List list) {
        this.c = yVar;
        this.a = gVar;
        this.b = list;
    }

    public final void a() {
        this.c.a(this.c.d);
        this.c.postDelayed(new ad(this), 1000);
        y.a(this.c, this.b, true, "success", "");
    }

    public final void a(String str) {
        this.c.a(this.c.d);
        y.a(this.c, this.b, true, "fail", str);
        XLToast.showToast(this.c.getContext(), com.xunlei.downloadprovider.homepage.follow.a.a(str));
    }
}
