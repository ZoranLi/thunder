package com.xunlei.downloadprovider.member.login.authphone;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: AuthDlgActivity */
final class i implements OnFocusChangeListener {
    final /* synthetic */ AuthDlgActivity a;

    i(AuthDlgActivity authDlgActivity) {
        this.a = authDlgActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.h.setImageDrawable(ContextCompat.getDrawable(BrothersApplication.getApplicationInstance(), z ? true : true));
    }
}
