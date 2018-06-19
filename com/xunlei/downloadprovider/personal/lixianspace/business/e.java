package com.xunlei.downloadprovider.personal.lixianspace.business;

import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: LXSpaceTaskStateMgr */
final class e implements g {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onLogout() {
        if (this.a.a != null) {
            this.a.a.removeCallbacksAndMessages(null);
        }
        this.a.b.clear();
        a.a.a(this.a.b);
    }
}
