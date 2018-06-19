package com.xunlei.downloadprovider.homepage.recommend.fans;

import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: FansAndFollowItemView */
final class o extends c {
    final /* synthetic */ long a;
    final /* synthetic */ l b;

    o(l lVar, long j) {
        this.b = lVar;
        this.a = j;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i == 0 && !b.a().b(this.a) && this.a != this.b.j.g.c()) {
            this.b.a((long) this.a);
        }
    }
}
