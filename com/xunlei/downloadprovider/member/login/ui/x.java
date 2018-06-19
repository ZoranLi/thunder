package com.xunlei.downloadprovider.member.login.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.R;

/* compiled from: LoginActivity */
final class x implements OnFocusChangeListener {
    final /* synthetic */ LoginActivity a;

    x(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        view = 8;
        if (z) {
            z = LoginActivity.e(this.a);
            if (LoginActivity.c(this.a).length() > 0) {
                view = null;
            }
            z.setVisibility(view);
            LoginActivity.f(this.a).setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_account_focused));
            return;
        }
        LoginActivity.e(this.a).setVisibility(8);
        LoginActivity.f(this.a).setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_account));
    }
}
