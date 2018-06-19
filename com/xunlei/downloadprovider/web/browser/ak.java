package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.downloadprovider.web.browser.InputAutoCompleteView.b;

/* compiled from: BrowserTitleBarFragment */
final class ak implements b {
    final /* synthetic */ a a;

    ak(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        this.a.d.a();
    }

    public final void a(String str, boolean z) {
        str = a.e(str);
        this.a.d.c.setText(str);
        if (z) {
            this.a.a();
            if (this.a.d.k) {
                this.a.d.k.a(str);
                return;
            }
        }
        this.a.d.c.requestFocus();
        this.a.d.c.setSelection(this.a.d.c.getText().length());
    }
}
