package com.xunlei.downloadprovider.member.login.ui;

import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.register.ui.RegisterSuccessActivity;

/* compiled from: LoginActivity */
final class k implements h {
    final /* synthetic */ LoginActivity a;

    k(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (z) {
            if (RegisterSuccessActivity.a || LoginActivity.z(this.a)) {
                LoginActivity.p(this.a);
            } else {
                r.a().a(new l(this.a, this.a));
            }
        }
        if (RegisterSuccessActivity.a) {
            LoginActivity.c = true;
        }
        LoginActivity.y(this.a).b(LoginActivity.A(this.a));
    }
}
