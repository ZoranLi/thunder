package com.ali.auth.third.a.c;

import android.app.Activity;
import android.webkit.WebView;
import com.ali.auth.third.core.i.b;

public final class a extends b<String, Void, Void> {
    private WebView b;

    public a(WebView webView) {
        super((Activity) webView.getContext());
        this.b = webView;
    }

    protected final void b() {
        com.ali.auth.third.core.j.a.a();
    }

    protected final /* synthetic */ Object a() {
        if (!com.ali.auth.third.core.c.a.e.a()) {
            com.ali.auth.third.ui.a.a.a(this.a);
            com.ali.auth.third.a.a.b.a(this.a);
        }
        return null;
    }
}
