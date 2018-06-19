package com.xunlei.downloadprovider.member.login.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.R;

/* compiled from: LoginActivity */
final class z implements OnFocusChangeListener {
    final /* synthetic */ LoginActivity a;

    z(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        view = 8;
        if (z) {
            LoginActivity.d(this.a).setCompoundDrawables(null, null, null, null);
            LoginActivity.g(this.a).setVisibility(LoginActivity.d(this.a).length() > 0 ? 0 : 8);
            z = LoginActivity.h(this.a);
            if (LoginActivity.d(this.a).length() <= 0) {
                view = null;
            }
            z.setVisibility(view);
            LoginActivity.i(this.a).setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_password_focused));
            LoginActivity.f(this.a).setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_account));
            return;
        }
        LoginActivity.d(this.a).setCompoundDrawables(null, null, null, null);
        LoginActivity.g(this.a).setVisibility(8);
        LoginActivity.i(this.a).setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_password));
    }
}
