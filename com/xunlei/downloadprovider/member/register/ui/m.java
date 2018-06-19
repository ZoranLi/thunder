package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AuthMobileActivity */
final class m implements OnClickListener {
    final /* synthetic */ AuthMobileActivity a;

    m(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final void onClick(View view) {
        AuthMobileActivity.b(this.a, view);
        this.a.onBackPressed();
    }
}
