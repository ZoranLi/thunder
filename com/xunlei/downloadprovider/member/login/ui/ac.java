package com.xunlei.downloadprovider.member.login.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.register.a;

/* compiled from: LoginDlgActivity */
final class ac implements OnClickListener {
    final /* synthetic */ LoginDlgActivity a;

    ac(LoginDlgActivity loginDlgActivity) {
        this.a = loginDlgActivity;
    }

    public final void onClick(View view) {
        view = view.getId();
        if (view != R.id.iv_close) {
            switch (view) {
                case R.id.tv_third_login_weixin:
                    LoginDlgActivity.a(this.a);
                    LoginDlgActivity.b(this.a);
                    ai.a(LoginDlgActivity.c(this.a), Token.WX_TOKEN_PLATFORMID_VALUE);
                    a.a(Token.WX_TOKEN_PLATFORMID_VALUE, "login_float");
                    LoginDlgActivity.d(this.a);
                    return;
                case R.id.tv_third_login_qq:
                    LoginDlgActivity.e(this.a);
                    LoginDlgActivity.b(this.a);
                    ai.a(LoginDlgActivity.c(this.a), "qq");
                    a.a(Constants.SOURCE_QQ, "login_float");
                    LoginDlgActivity.f(this.a);
                    return;
                case R.id.tv_phone_login:
                    ai.a(LoginDlgActivity.c(this.a), "login");
                    LoginDlgActivity.g(this.a).a(LoginPageType.LOGIN_PAGE, this.a, LoginDlgActivity.c(this.a), -1);
                    return;
                case R.id.tv_register_account:
                    ai.a(LoginDlgActivity.c(this.a), "register");
                    LoginActivity.a(this.a, LoginDlgActivity.c(this.a), "login_dialog_register");
                    break;
                default:
                    break;
            }
            return;
        }
        this.a.finish();
    }
}
