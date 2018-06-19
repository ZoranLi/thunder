package com.xunlei.downloadprovider.personal.lixianspace.ui;

import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: LXSpaceActivity */
final class g extends c {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z) {
            this.a.a.d();
            this.a.a.a();
            if (!a.a.b()) {
                this.a.a.l.setVisibility(8);
            }
        }
    }
}
