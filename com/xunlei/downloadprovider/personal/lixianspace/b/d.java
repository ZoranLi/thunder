package com.xunlei.downloadprovider.personal.lixianspace.b;

import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: LXSpaceDataHelper */
final class d implements g {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void onLogout() {
        c cVar = this.a;
        cVar.a.removeCallbacksAndMessages(null);
        cVar.d = 0;
        cVar.c = 0;
    }
}
