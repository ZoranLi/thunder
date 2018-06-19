package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.payment.a.j;

/* compiled from: VipAccelerateTryController */
final class bx implements h {
    final /* synthetic */ bn a;

    bx(bn bnVar) {
        this.a = bnVar;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (z && j.a().a.l() && this.a.l) {
            this.a.l.a(this.a.l.c, true);
        }
    }
}
