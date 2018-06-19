package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.Set;

/* compiled from: FollowTabFragment */
final class y implements c<Set<Long>> {
    final /* synthetic */ FollowTabFragment a;

    y(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Set set = (Set) obj;
        new StringBuilder("getFollowingIdList() onSuccess size=").append(set.size());
        if (set.size() == null) {
            this.a.c.b();
            if (this.a.m != null) {
                this.a.a(2);
                this.a.e.c();
                return;
            }
            FollowTabFragment.n(this.a);
            return;
        }
        this.a.a(6);
        FollowTabFragment.o(this.a);
        this.a.a.put("live_hosts", Boolean.valueOf(false));
        this.a.a.put("latest_feeds", Boolean.valueOf(false));
        FollowTabFragment.q(this.a);
        FollowTabFragment.r(this.a);
    }

    public final void onFail(String str) {
        this.a.c.b();
        this.a.f();
    }
}
