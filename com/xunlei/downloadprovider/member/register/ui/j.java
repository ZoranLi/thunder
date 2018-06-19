package com.xunlei.downloadprovider.member.register.ui;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: AuthMobileActivity */
final class j implements OnFocusChangeListener {
    final /* synthetic */ AuthMobileActivity a;

    j(AuthMobileActivity authMobileActivity) {
        this.a = authMobileActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        AuthMobileActivity.d(this.a).setImageDrawable(ContextCompat.getDrawable(BrothersApplication.getApplicationInstance(), z ? true : true));
    }
}
