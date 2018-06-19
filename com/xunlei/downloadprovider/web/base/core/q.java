package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: DefaultJsInterface */
final class q extends c {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ DefaultJsInterface c;

    q(DefaultJsInterface defaultJsInterface, String str, int i) {
        this.c = defaultJsInterface;
        this.a = str;
        this.b = i;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        LoginHelper.a().a(new r(this));
    }
}
