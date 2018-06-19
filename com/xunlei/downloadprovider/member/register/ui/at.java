package com.xunlei.downloadprovider.member.register.ui;

import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.e.h;
import com.xunlei.downloadprovider.member.register.view.a;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: RegisterSuccessActivity */
final class at implements h {
    final /* synthetic */ RegisterSuccessActivity a;

    at(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("setOnUserAvatarListener errorCode=");
        stringBuilder.append(i);
        stringBuilder.append(" errorDesc=");
        stringBuilder.append(XLErrorCode.getErrorDesc(i));
        if (i == 0) {
            if (this.a.t != 0) {
                this.a.u;
                LoginHelper.a().e();
                this.a.t = false;
            }
            LoginHelper.a().b();
            a.b(this.a, R.string.user_account_set_avatar_success);
            this.a.p.setEnabled(true);
            k.a("phone_register_login", str, "success");
        } else if (i == XLErrorCode.AVATAR_MANUAL_AUDIT) {
            a.b(this.a, R.string.user_account_set_avatar_waiting_manual_audit);
            this.a.p.setEnabled(true);
        } else {
            a.c(this.a, R.string.user_account_set_avatar_fail);
            k.a("phone_register_login", str, "fail");
        }
    }
}
