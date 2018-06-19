package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: FreeTrialRedPacketHelper */
final class g implements d {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (i == 0 && !f.h() && !f.a(this.a)) {
            f.b(this.a);
        }
    }
}
