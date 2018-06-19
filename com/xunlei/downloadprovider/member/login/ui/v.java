package com.xunlei.downloadprovider.member.login.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: LoginActivity */
final class v implements OnClickListener {
    final /* synthetic */ LoginActivity a;

    v(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onClick(View view) {
        LoginActivity.c(this.a).setText("");
        LoginActivity.c(this.a).requestFocus();
        LoginActivity.a(this.a, LoginActivity.c(this.a));
    }
}
