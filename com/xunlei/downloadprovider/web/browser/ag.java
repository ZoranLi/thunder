package com.xunlei.downloadprovider.web.browser;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BrowserTitleBarFragment */
final class ag implements TextWatcher {
    final /* synthetic */ BrowserTitleBarFragment a;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    ag(BrowserTitleBarFragment browserTitleBarFragment) {
        this.a = browserTitleBarFragment;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String trim = charSequence.toString().trim();
        this.a.c(trim);
        if (trim.length() <= null) {
            this.a.m.setVisibility(8);
        } else if (this.a.c.hasFocus() != null) {
            this.a.m.setVisibility(0);
        }
    }
}
