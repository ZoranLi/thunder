package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: MobileSetupActivity */
final class ah implements OnFocusChangeListener {
    final /* synthetic */ MobileSetupActivity a;

    ah(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.k.setImageDrawable(this.a.getResources().getDrawable(z ? true : true));
    }
}
