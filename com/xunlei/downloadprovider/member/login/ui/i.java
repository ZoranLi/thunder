package com.xunlei.downloadprovider.member.login.ui;

import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.authphone.o;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: LoginActivity */
final class i implements d {
    final /* synthetic */ LoginActivity a;

    i(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        z = new StringBuilder("OnLoginCompleted() errorCode=");
        z.append(i);
        z.append(" errorDesc=");
        z.append(XLErrorCode.getErrorDesc(i));
        z.append(" isAutoLog=");
        z.append(z2);
        LoginActivity.a(this.a, i);
        LoginActivity.n(this.a);
        LoginActivity.j(this.a);
        if (!(LoginActivity.o(this.a).getVisibility() || i == true)) {
            LoginActivity.m(this.a);
        }
        switch (i) {
            case 0:
                this.a.a(false, true);
                if (com.xunlei.downloadprovider.d.d.a().e.b() || o.a(LoginActivity.a(this.a))) {
                    LoginActivity.q(this.a);
                    return;
                } else {
                    LoginActivity.p(this.a);
                    return;
                }
            case 2:
                this.a.a(false, false);
                LoginActivity.c(this.a).requestFocus();
                LoginActivity.b(this.a, 2);
                return;
            case 3:
                this.a.a(false, false);
                LoginActivity.c(this.a, R.string.user_account_password_error);
                LoginActivity.d(this.a).setText("");
                LoginActivity.b(this.a, LoginActivity.d(this.a));
                return;
            case 6:
                this.a.a(false, false);
                LoginActivity.y(this.a).a(new j(this));
                return;
            case 7:
                this.a.a(false, false);
                LoginActivity.c(this.a).requestFocus();
                LoginActivity.c(this.a, R.string.user_account_account_locked);
                return;
            default:
                this.a.a(false, false);
                LoginActivity.b(this.a, i);
                return;
        }
    }
}
