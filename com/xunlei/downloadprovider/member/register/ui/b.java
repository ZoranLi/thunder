package com.xunlei.downloadprovider.member.register.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.ui.LoginActivity;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: AuthMobileActivity */
final class b implements OnClickListener {
    final /* synthetic */ AuthMobileActivity a;

    b(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        LoginHelper.a().a(null);
        this.a.finish();
        dialogInterface.dismiss();
        k.c(true);
        if (d.a().e.a() != null) {
            LoginHelper.a().a(LoginPageType.LOGIN_PAGE, this.a, null, LoginFrom.AUTH_PHONE_PAGE, -1, null);
            LoginActivity.c = null;
        }
    }
}
