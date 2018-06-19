package com.xunlei.downloadprovider.personal.lixianspace.business;

import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: LXSpaceTaskQueryMgr */
final class b implements g {
    final /* synthetic */ LXSpaceTaskQueryMgr a;

    b(LXSpaceTaskQueryMgr lXSpaceTaskQueryMgr) {
        this.a = lXSpaceTaskQueryMgr;
    }

    public final void onLogout() {
        this.a.a.clear();
        this.a.b.clear();
    }
}
