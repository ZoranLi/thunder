package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MobileSetupActivity */
final class s implements OnClickListener {
    final /* synthetic */ MobileSetupActivity a;

    s(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onClick(View view) {
        this.a.b(view);
        this.a.onBackPressed();
    }
}
