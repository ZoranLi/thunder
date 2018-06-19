package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: UserAccountSecurityActivity */
final class an implements OnClickListener {
    final /* synthetic */ UserAccountSecurityActivity a;

    an(UserAccountSecurityActivity userAccountSecurityActivity) {
        this.a = userAccountSecurityActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
