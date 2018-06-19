package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: UserAccountCurrentMobileActivity */
final class f implements h {
    final /* synthetic */ UserAccountCurrentMobileActivity a;

    f(UserAccountCurrentMobileActivity userAccountCurrentMobileActivity) {
        this.a = userAccountCurrentMobileActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        z = new StringBuilder("你的手机号：");
        z.append(this.a.c.i());
        this.a.a.setText(z.toString());
    }
}
