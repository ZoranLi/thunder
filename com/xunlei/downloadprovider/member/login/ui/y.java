package com.xunlei.downloadprovider.member.login.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: LoginActivity */
final class y implements OnClickListener {
    final /* synthetic */ LoginActivity a;

    y(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onClick(View view) {
        LoginActivity.c(this.a).requestFocus();
    }
}
