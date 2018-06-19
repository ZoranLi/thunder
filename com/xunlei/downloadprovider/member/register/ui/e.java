package com.xunlei.downloadprovider.member.register.ui;

import com.xunlei.common.base.XLLog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.authphone.r$a;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: AuthMobileActivity */
final class e implements c<r$a> {
    final /* synthetic */ AuthMobileActivity a;

    e(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        r$a com_xunlei_downloadprovider_member_login_authphone_r_a = (r$a) obj;
        String c = AuthMobileActivity.c();
        StringBuilder stringBuilder = new StringBuilder("sendCode--");
        stringBuilder.append(com_xunlei_downloadprovider_member_login_authphone_r_a);
        XLLog.d(c, stringBuilder.toString());
        if (com_xunlei_downloadprovider_member_login_authphone_r_a == null || !"OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a)) {
            this.a.b();
            this.a.a(R.string.register_error_msg_getVerifyFail_retry);
        } else {
            AuthMobileActivity.a(this.a, com_xunlei_downloadprovider_member_login_authphone_r_a.b);
            this.a.b();
            AuthMobileActivity authMobileActivity = this.a;
            authMobileActivity.c = new AuthMobileActivity$a(new d(authMobileActivity));
            authMobileActivity.c.c.start();
            AuthMobileActivity.g(this.a);
        }
        if (com_xunlei_downloadprovider_member_login_authphone_r_a != null) {
            k.a("OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a), com_xunlei_downloadprovider_member_login_authphone_r_a.a);
        }
    }

    public final void onFail(String str) {
        XLLog.d(AuthMobileActivity.c(), "sendCode--onFail");
        this.a.b();
        this.a.a(R.string.register_error_msg_getVerifyFail_retry);
        k.a(false, str);
    }
}
