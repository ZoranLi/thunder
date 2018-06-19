package com.xunlei.downloadprovider.member.login.authphone;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AuthDlgActivity */
final class l implements OnClickListener {
    final /* synthetic */ AuthDlgActivity a;

    l(AuthDlgActivity authDlgActivity) {
        this.a = authDlgActivity;
    }

    public final void onClick(View view) {
        this.a.a(view);
        this.a.onBackPressed();
    }
}
