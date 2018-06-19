package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: PublisherActivity */
final class bz extends c {
    final /* synthetic */ String a;
    final /* synthetic */ PublisherActivity b;

    bz(PublisherActivity publisherActivity, String str) {
        this.b = publisherActivity;
        this.a = str;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        this.b.M;
        if (l.c()) {
            if (this.b.k == this.b.M.g.c()) {
                this.b.c();
                this.b.s.postDelayed(new ca(this), 800);
            } else if (this.b.P.b(this.b.k)) {
                XLToast.showToast(this.b, "您已关注");
                this.b.a((boolean) 1);
            } else {
                this.b.c(this.a);
            }
        }
    }
}
