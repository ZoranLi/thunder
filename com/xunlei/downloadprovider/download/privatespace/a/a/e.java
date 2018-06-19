package com.xunlei.downloadprovider.download.privatespace.a.a;

import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: BindVerifyBusiness */
final class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        LoginHelper.a().b();
    }
}
