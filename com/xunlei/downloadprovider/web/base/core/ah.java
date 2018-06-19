package com.xunlei.downloadprovider.web.base.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: WebTitleBar */
final class ah implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ WebTitleBar b;

    ah(WebTitleBar webTitleBar, Context context) {
        this.b = webTitleBar;
        this.a = context;
    }

    public final void onClick(View view) {
        this.b.a();
        if (this.b.c.h() != null) {
            this.b.c.i();
            WebTitleBar.c(this.b);
            return;
        }
        if (this.b.h != null) {
            this.b.h.a();
        }
        ((Activity) this.a).finish();
        this.b.c.d();
    }
}
