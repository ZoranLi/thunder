package com.xunlei.downloadprovider.web.base.core;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomWebView */
final class d implements OnClickListener {
    final /* synthetic */ CustomWebView a;

    d(CustomWebView customWebView) {
        this.a = customWebView;
    }

    public final void onClick(View view) {
        if (TextUtils.isEmpty(this.a.b.getUrl()) != null) {
            this.a.a(this.a.g);
        } else {
            this.a.b.reload();
        }
        this.a.a();
        this.a.c();
    }
}
