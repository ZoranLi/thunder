package com.xunlei.downloadprovider.member.register.ui;

import com.xunlei.common.base.XLLog;
import com.xunlei.downloadprovider.member.login.authphone.r$a;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: AuthMobileActivity */
final class f implements c<r$a> {
    final /* synthetic */ String a;
    final /* synthetic */ AuthMobileActivity b;

    f(AuthMobileActivity authMobileActivity, String str) {
        this.b = authMobileActivity;
        this.a = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        r$a com_xunlei_downloadprovider_member_login_authphone_r_a = (r$a) obj;
        String c = AuthMobileActivity.c();
        StringBuilder stringBuilder = new StringBuilder("authPhoneNumber--");
        stringBuilder.append(com_xunlei_downloadprovider_member_login_authphone_r_a);
        XLLog.d(c, stringBuilder.toString());
        if ("OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a)) {
            AuthMobileActivity.h(this.b);
            this.b.finish();
        } else {
            this.b.a("验证失败");
        }
        k.a("", this.a, "OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a), com_xunlei_downloadprovider_member_login_authphone_r_a.a);
    }

    public final void onFail(String str) {
        XLLog.d(AuthMobileActivity.c(), "authPhoneNumber--onFail");
        this.b.a("验证失败");
        k.a("", this.a, false, str);
    }
}
