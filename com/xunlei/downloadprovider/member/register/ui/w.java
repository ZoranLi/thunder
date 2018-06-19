package com.xunlei.downloadprovider.member.register.ui;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.register.view.d.a;

/* compiled from: MobileSetupActivity */
final class w implements a {
    final /* synthetic */ MobileSetupActivity a;

    w(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void a() {
        this.a.k();
        LoginHelper.a().a(this.a.z);
    }

    public final void a(String str) {
        this.a.a(str, false);
    }
}
