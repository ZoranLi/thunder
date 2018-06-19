package com.xunlei.downloadprovider.member.login.authphone;

import com.xunlei.common.base.XLLog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: AuthDlgActivity */
final class c implements com.xunlei.downloadprovider.member.payment.a.e.c<r$a> {
    final /* synthetic */ AuthDlgActivity a;

    c(AuthDlgActivity authDlgActivity) {
        this.a = authDlgActivity;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        r$a com_xunlei_downloadprovider_member_login_authphone_r_a = (r$a) obj;
        String c = AuthDlgActivity.c;
        StringBuilder stringBuilder = new StringBuilder("sendCode--");
        stringBuilder.append(com_xunlei_downloadprovider_member_login_authphone_r_a);
        XLLog.d(c, stringBuilder.toString());
        if (com_xunlei_downloadprovider_member_login_authphone_r_a == null || !"OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a)) {
            this.a.b();
            this.a.a((int) R.string.register_error_msg_getVerifyFail_retry);
        } else {
            this.a.q = com_xunlei_downloadprovider_member_login_authphone_r_a.b;
            this.a.b();
            AuthDlgActivity authDlgActivity = this.a;
            authDlgActivity.a = new a(new b(authDlgActivity));
            authDlgActivity.a.c.start();
        }
        if (com_xunlei_downloadprovider_member_login_authphone_r_a != null) {
            k.a("OK".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a), com_xunlei_downloadprovider_member_login_authphone_r_a.a);
        }
    }

    public final void onFail(String str) {
        XLLog.d(AuthDlgActivity.c, "sendCode--onFail");
        this.a.b();
        this.a.a((int) R.string.register_error_msg_getVerifyFail_retry);
        k.a(false, str);
    }
}
