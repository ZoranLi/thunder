package com.xunlei.downloadprovider.member.login.authphone;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: AuthDlgActivity */
final class j implements OnFocusChangeListener {
    final /* synthetic */ AuthDlgActivity a;

    j(AuthDlgActivity authDlgActivity) {
        this.a = authDlgActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        view = 8;
        if (z) {
            z = this.a.k;
            if (this.a.g.length() > 0) {
                view = null;
            }
            z.setVisibility(view);
            this.a.i.setImageDrawable(ContextCompat.getDrawable(BrothersApplication.getApplicationInstance(), R.drawable.icon_verify_code_focused));
            return;
        }
        this.a.k.setVisibility(8);
        this.a.i.setImageDrawable(ContextCompat.getDrawable(BrothersApplication.getApplicationInstance(), R.drawable.icon_verify_code));
    }
}
