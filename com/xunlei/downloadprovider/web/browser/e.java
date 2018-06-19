package com.xunlei.downloadprovider.web.browser;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BrowserActivity */
final class e implements OnClickListener {
    final /* synthetic */ BrowserActivity a;

    e(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void onClick(View view) {
        if (this.a.m != null) {
            new ab("btm_button", this.a).a(this.a.w, this.a.v, this.a.E);
        }
    }
}
