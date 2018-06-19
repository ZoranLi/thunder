package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: BrowserActivity */
final class f implements OnClickListener {
    final /* synthetic */ BrowserActivity a;

    f(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.a();
            if (this.a.m != null) {
                view = BrowserActivity.a;
                if (TextUtils.isEmpty(this.a.m.g()) == null) {
                    this.a.q;
                    BrowserToolBarFragment.a();
                    this.a.m.b();
                    this.a.m.i();
                    return;
                }
                this.a.c();
            }
        }
    }
}
