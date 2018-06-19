package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: BrowserTitleBarFragment */
final class ah implements OnFocusChangeListener {
    final /* synthetic */ BrowserTitleBarFragment a;

    ah(BrowserTitleBarFragment browserTitleBarFragment) {
        this.a = browserTitleBarFragment;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            if (this.a.c.getText() == null || (this.a.j != null && this.a.j.equals(this.a.c.getText().toString()) == null)) {
                this.a.c.setText(!this.a.j ? "" : this.a.j);
            }
            if (this.a.c.getText() != null && TextUtils.isEmpty(this.a.c.getText().toString()) == null) {
                this.a.c.selectAll();
                this.a.c.scrollTo(0, 0);
                this.a.m.setVisibility(0);
                return;
            }
        }
        this.a.m.setVisibility(true);
        this.a.a();
        this.a.d();
    }
}
