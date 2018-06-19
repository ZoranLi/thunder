package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: FollowTabFragment */
final class x implements c<List<d>> {
    final /* synthetic */ FollowTabFragment a;

    public final void onFail(String str) {
    }

    x(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List list = (List) obj;
        if (list != null && list.size() > 0) {
            this.a.n = true;
            this.a.k.e();
            this.a.k.a(list);
            this.a.a(4);
            this.a.e.c();
        }
        FollowTabFragment.b(this.a);
    }
}
