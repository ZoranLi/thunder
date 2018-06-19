package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.xunlei.downloadprovider.R;

/* compiled from: MobileSetupActivity */
final class af implements OnFocusChangeListener {
    final /* synthetic */ MobileSetupActivity a;

    af(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        view = 8;
        if (z) {
            z = this.a.m;
            if (this.a.g.length() > 0) {
                view = null;
            }
            z.setVisibility(view);
            this.a.j.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_verify_code_focused));
            return;
        }
        this.a.m.setVisibility(8);
        this.a.j.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_verify_code));
    }
}
