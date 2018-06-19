package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: DefaultJsInterface */
final class r implements h {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        this.a.c.callbackGetUserInfo(this.a.a, this.a.b);
        LoginHelper.a().b(this);
    }
}
