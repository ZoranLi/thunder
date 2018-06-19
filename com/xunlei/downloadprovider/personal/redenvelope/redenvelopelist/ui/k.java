package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: RedEnvelopesActivity */
final class k implements d {
    final /* synthetic */ RedEnvelopesActivity a;

    k(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (i == 0 && this.a.d) {
            this.a.d.setVisibility(8);
            this.a.a();
            if (this.a.f) {
                this.a.f.setMode(Mode.PULL_FROM_END);
            }
        }
    }
}
