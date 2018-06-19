package com.xunlei.downloadprovider.member.login.ui;

import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: LoginDlgActivity */
final class ag implements h {
    final /* synthetic */ LoginDlgActivity a;

    ag(LoginDlgActivity loginDlgActivity) {
        this.a = loginDlgActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        StringBuilder stringBuilder = new StringBuilder("onRefreshUserInfoCompleted--isSuccess=");
        stringBuilder.append(z);
        stringBuilder.append("|errCode=");
        stringBuilder.append(i);
        stringBuilder.append("|sIsFirstRefresh=");
        stringBuilder.append(LoginDlgActivity.a());
        if (LoginDlgActivity.a() != 0) {
            if (z) {
                r.a().a(this.a, LoginDlgActivity.c(this.a));
            }
            LoginDlgActivity.b();
        }
        LoginDlgActivity.g(this.a).b(LoginDlgActivity.k(this.a));
        LoginDlgActivity.g(this.a).b(LoginDlgActivity.l(this.a));
    }
}
