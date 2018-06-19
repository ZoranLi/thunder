package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: FollowTabFragment */
final class m implements c<com.xunlei.downloadprovider.homepage.follow.b.c> {
    final /* synthetic */ FollowTabFragment a;

    m(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        com.xunlei.downloadprovider.homepage.follow.b.c cVar = (com.xunlei.downloadprovider.homepage.follow.b.c) obj;
        new StringBuilder("getFollowingLivingHosts() onSuccess size=").append(cVar.a.size());
        this.a.a.put("live_hosts", Boolean.valueOf(true));
        this.a.k.c = cVar;
        if (FollowTabFragment.u(this.a) != null) {
            this.a.e.c();
            ak.a().c(PlayerTag.FOLLOW_TAB);
        }
        this.a.p = true;
    }

    public final void onFail(String str) {
        this.a.a.put("live_hosts", Boolean.valueOf(true));
    }
}
