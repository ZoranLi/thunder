package com.xunlei.downloadprovider.download.privatespace.ui;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.register.view.d.a;

/* compiled from: PrivateSpaceFindPwdActivity */
final class f implements a {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    f(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void a() {
        this.a.o.a(false);
        XLThreadPool.execute(new g(this.a));
    }

    public final void a(String str) {
        if (this.a.p != null) {
            this.a.p.c = str;
        }
        PrivateSpaceFindPwdActivity.a(this.a);
    }
}
