package com.xunlei.downloadprovider.web.base.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: WebTitleBar */
final class ai implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ WebTitleBar b;

    ai(WebTitleBar webTitleBar, Context context) {
        this.b = webTitleBar;
        this.a = context;
    }

    public final void onClick(View view) {
        if (this.b.h != null) {
            this.b.h.a();
        }
        ((Activity) this.a).finish();
    }
}
