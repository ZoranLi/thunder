package com.xunlei.downloadprovider.member.register.ui;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: AuthMobileActivity */
final class k implements OnFocusChangeListener {
    final /* synthetic */ AuthMobileActivity a;

    k(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        view = 8;
        if (z) {
            z = AuthMobileActivity.e(this.a);
            if (AuthMobileActivity.b(this.a).length() > 0) {
                view = null;
            }
            z.setVisibility(view);
            AuthMobileActivity.f(this.a).setImageDrawable(ContextCompat.getDrawable(BrothersApplication.getApplicationInstance(), R.drawable.icon_verify_code_focused));
            return;
        }
        AuthMobileActivity.e(this.a).setVisibility(8);
        AuthMobileActivity.f(this.a).setImageDrawable(ContextCompat.getDrawable(BrothersApplication.getApplicationInstance(), R.drawable.icon_verify_code));
    }
}
