package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: FollowTabFragment */
final class n implements c<List<g>> {
    final /* synthetic */ FollowTabFragment a;

    n(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List list = (List) obj;
        new StringBuilder("getRecommendGroupList() onSuccess size=").append(list.size());
        this.a.m = true;
        this.a.k.b(list);
        this.a.e.c();
        LoginHelper.a();
        if (l.c() == null) {
            this.a.c.b();
        }
    }

    public final void onFail(String str) {
        this.a.c.b();
        this.a.f();
    }
}
