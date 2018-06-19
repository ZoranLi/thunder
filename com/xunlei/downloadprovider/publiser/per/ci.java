package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: PublisherActivity */
final class ci extends c {
    final /* synthetic */ String a;
    final /* synthetic */ PublisherActivity b;

    ci(PublisherActivity publisherActivity, String str) {
        this.b = publisherActivity;
        this.a = str;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        this.b.M;
        if (l.c()) {
            if (this.b.k == this.b.M.g.c()) {
                this.b.s.postDelayed(new cj(this), 800);
                return;
            }
            this.b.e((String) this.a);
        }
    }
}
