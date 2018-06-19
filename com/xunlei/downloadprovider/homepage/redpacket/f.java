package com.xunlei.downloadprovider.homepage.redpacket;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.c.j;
import com.xunlei.downloadprovider.member.register.view.a;

/* compiled from: RedPacketGuideDlg */
final class f implements d {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (z) {
            this.a.a();
            return;
        }
        this.a.a(true);
        a.a(BrothersApplication.getApplicationInstance(), true, j.a(i)).a();
    }
}
