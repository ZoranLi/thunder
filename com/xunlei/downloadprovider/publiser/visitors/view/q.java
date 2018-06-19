package com.xunlei.downloadprovider.publiser.visitors.view;

import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: VisitViewHolder */
final class q extends c {
    final /* synthetic */ long a;
    final /* synthetic */ LoginHelper b;
    final /* synthetic */ i c;

    q(i iVar, long j, LoginHelper loginHelper) {
        this.c = iVar;
        this.a = j;
        this.b = loginHelper;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i == 0 && !b.a().b(this.a) && this.a != this.b.g.c()) {
            i.a(this.c, this.a);
        }
    }
}
