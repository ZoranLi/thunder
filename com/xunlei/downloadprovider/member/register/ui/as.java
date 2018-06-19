package com.xunlei.downloadprovider.member.register.ui;

import android.view.inputmethod.InputMethodManager;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.k;
import com.xunlei.downloadprovider.member.register.view.a;

/* compiled from: RegisterSuccessActivity */
final class as implements k {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public final void a(boolean z, int i, String str) {
        z = new StringBuilder("setOnUserInfoListener() errorCode=");
        z.append(i);
        z.append(" errorDesc=");
        z.append(XLErrorCode.getErrorDesc(i));
        if (i == 0) {
            ((InputMethodManager) this.a.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.a.k.getWindowToken(), 0);
            com.xunlei.downloadprovider.personal.user.account.k.b("phone_register_login", "success");
            com.xunlei.downloadprovider.personal.user.account.k.a((boolean) 1);
            this.a.a.e.b();
            RegisterSuccessActivity.m(this.a.a);
            this.a.a.p.setEnabled(false);
        } else if (i == XLErrorCode.NICK_NAME_SW) {
            a.c(this.a.a, R.string.user_account_set_nickname_sensitive_word);
            com.xunlei.downloadprovider.personal.user.account.k.b("phone_register_login", "fail");
            com.xunlei.downloadprovider.personal.user.account.k.a(false);
        } else {
            com.xunlei.downloadprovider.personal.user.account.k.b("phone_register_login", "fail");
            com.xunlei.downloadprovider.personal.user.account.k.a(false);
            a.c(this.a.a, R.string.user_account_set_nickname_fail);
        }
    }
}
