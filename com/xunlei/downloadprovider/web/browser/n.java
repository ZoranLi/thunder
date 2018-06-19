package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.cooperation.ui.a;

/* compiled from: BrowserActivity */
final class n implements a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ BrowserActivity e;

    public final void b() {
    }

    public final void onCancel() {
    }

    n(BrowserActivity browserActivity, String str, String str2, String str3, String str4) {
        this.e = browserActivity;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void a() {
        this.e.a(this.a, this.b, this.c, this.d);
    }
}
