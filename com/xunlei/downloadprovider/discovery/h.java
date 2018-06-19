package com.xunlei.downloadprovider.discovery;

import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: DiscoveryFragment */
final class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        if (this.a.a.isVisible()) {
            LoginHelper.a().b();
            this.a.a.l = false;
            this.a.a.c();
        }
    }
}
