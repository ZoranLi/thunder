package com.xunlei.downloadprovider.member.login.ui;

import android.content.Context;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.authphone.r$a;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: LoginActivity */
final class l implements c<r$a> {
    final /* synthetic */ Context a;
    final /* synthetic */ LoginActivity b;

    l(LoginActivity loginActivity, Context context) {
        this.b = loginActivity;
        this.a = context;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        r$a com_xunlei_downloadprovider_member_login_authphone_r_a = (r$a) obj;
        new StringBuilder("checkIsAuth--").append(com_xunlei_downloadprovider_member_login_authphone_r_a);
        if ("ISAUTH".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a)) {
            LoginActivity.p(this.b);
            r.a().a(com_xunlei_downloadprovider_member_login_authphone_r_a, LoginActivity.a(this.b));
            return;
        }
        if (r.c == null) {
            r.a();
            r.b(this.a, LoginActivity.a(this.b));
        }
        LoginActivity.c = true;
        r.c = true;
        h.a().d();
        LoginActivity.c(this.b, LoginActivity.a(this.b));
    }

    public final void onFail(String str) {
        LoginActivity.p(this.b);
        r.a().a(null, LoginActivity.a(this.b));
    }
}
