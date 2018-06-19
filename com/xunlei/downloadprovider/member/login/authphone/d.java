package com.xunlei.downloadprovider.member.login.authphone;

import com.xunlei.common.base.XLLog;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: AuthDlgActivity */
final class d implements c<r$a> {
    final /* synthetic */ String a;
    final /* synthetic */ AuthDlgActivity b;

    d(AuthDlgActivity authDlgActivity, String str) {
        this.b = authDlgActivity;
        this.a = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        r$a com_xunlei_downloadprovider_member_login_authphone_r_a = (r$a) obj;
        String c = AuthDlgActivity.c;
        StringBuilder stringBuilder = new StringBuilder("authPhoneNumber--");
        stringBuilder.append(com_xunlei_downloadprovider_member_login_authphone_r_a);
        XLLog.d(c, stringBuilder.toString());
        this.b.n = false;
        if ("OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a)) {
            AuthDlgActivity.a(true);
            this.b.finish();
        } else {
            this.b.a("验证失败");
            AuthDlgActivity.a(false);
        }
        k.a(this.b.p, this.a, "OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a), com_xunlei_downloadprovider_member_login_authphone_r_a.a);
    }

    public final void onFail(String str) {
        XLLog.d(AuthDlgActivity.c, "authPhoneNumber--onFail");
        this.b.n = false;
        this.b.a("验证失败");
        AuthDlgActivity.a(false);
        k.a(this.b.p, this.a, false, str);
    }
}
