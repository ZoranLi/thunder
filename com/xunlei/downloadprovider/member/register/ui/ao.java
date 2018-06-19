package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: RegisterSuccessActivity */
final class ao implements OnFocusChangeListener {
    final /* synthetic */ RegisterSuccessActivity a;

    ao(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.l.setImageDrawable(this.a.getResources().getDrawable(z ? true : true));
    }
}
