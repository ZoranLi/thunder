package com.xunlei.downloadprovider.download.privatespace.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.R;

/* compiled from: PrivateSpaceFindPwdActivity */
final class n implements OnFocusChangeListener {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    n(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        view = 8;
        if (z) {
            z = this.a.j;
            if (this.a.d.length() > 0) {
                view = null;
            }
            z.setVisibility(view);
            this.a.g.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_verify_code_focused));
            return;
        }
        this.a.j.setVisibility(8);
        this.a.g.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_verify_code));
    }
}
