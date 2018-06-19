package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;
import java.util.List;

/* compiled from: FollowTabFragment */
final class z implements e$d<List<d>, Boolean> {
    final /* synthetic */ FollowTabFragment a;

    z(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj;
        Boolean bool = (Boolean) obj2;
        StringBuilder stringBuilder = new StringBuilder("getFollowingLatestVideoFeedList() onSuccess size=");
        stringBuilder.append(list.size());
        stringBuilder.append(" isClearCache=");
        stringBuilder.append(bool);
        this.a.a.put("latest_feeds", Boolean.valueOf(true));
        this.a.c.b();
        if (list.size() != 0) {
            this.a.n = true;
            this.a.a(4);
            if (this.a.k.d()) {
                this.a.j.m = ((d) list.get(list.size() - 1)).a;
            }
            this.a.k.a(list, bool.booleanValue());
        } else if (this.a.k.d() != null) {
            this.a.a(3);
        }
        if (FollowTabFragment.u(this.a) != null) {
            this.a.e.c();
            ak.a().c(PlayerTag.FOLLOW_TAB);
        }
        this.a.r.a = false;
        this.a.p = true;
    }

    public final void a(String str) {
        this.a.a.put("latest_feeds", Boolean.valueOf(true));
        this.a.c.b();
    }
}
