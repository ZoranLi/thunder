package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: UserAccountCurrentMobileActivity */
final class d implements OnClickListener {
    final /* synthetic */ UserAccountCurrentMobileActivity a;

    d(UserAccountCurrentMobileActivity userAccountCurrentMobileActivity) {
        this.a = userAccountCurrentMobileActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
