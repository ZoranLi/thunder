package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.a.a;
import com.xunlei.downloadprovider.homepage.follow.ac;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: FollowTabFragment */
final class p implements a {
    final /* synthetic */ FollowTabFragment a;

    public final int d() {
        return 30;
    }

    p(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final void a() {
        LoginHelper.a();
        if (l.c()) {
            this.a.c.d();
        }
    }

    public final long b() {
        return ac.a().a.getLong("follow_tab_last_refresh_time", 0);
    }

    public final void c() {
        ac a = ac.a();
        a.a.edit().putLong("follow_tab_last_refresh_time", System.currentTimeMillis()).apply();
    }
}
