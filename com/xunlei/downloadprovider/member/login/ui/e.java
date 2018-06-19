package com.xunlei.downloadprovider.member.login.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: LoginActivity */
final class e implements OnFocusChangeListener {
    final /* synthetic */ LoginActivity a;

    e(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        LoginActivity.l(this.a).setImageDrawable(this.a.getResources().getDrawable(z ? true : true));
    }
}
