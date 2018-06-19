package com.xunlei.downloadprovider.member.login.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: LoginActivity */
final class n implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ LoginActivity b;

    n(LoginActivity loginActivity, Dialog dialog) {
        this.b = loginActivity;
        this.a = dialog;
    }

    public final void onClick(View view) {
        this.a.dismiss();
    }
}
