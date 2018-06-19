package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: MobileSetupActivity */
final class ae implements OnFocusChangeListener {
    final /* synthetic */ MobileSetupActivity a;

    ae(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.i.setImageDrawable(this.a.getResources().getDrawable(z ? true : true));
    }
}
