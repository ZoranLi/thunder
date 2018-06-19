package com.xunlei.downloadprovider.publiser.visitors.view;

import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: UnfollowFooterViewHolder */
final class e extends c {
    final /* synthetic */ long a;
    final /* synthetic */ b b;

    e(b bVar, long j) {
        this.b = bVar;
        this.a = j;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i == 0) {
            if (LoginHelper.a().g.c() != this.a) {
                if (!b.a().b(Long.valueOf(this.a).longValue())) {
                    b.a(this.b, this.a);
                    return;
                }
            }
            this.b.b.a();
            this.b.a.a();
            return;
        }
        this.b.c.setEnabled(1);
    }
}
