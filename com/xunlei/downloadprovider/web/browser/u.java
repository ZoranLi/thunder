package com.xunlei.downloadprovider.web.browser;

import android.os.Build.VERSION;
import com.xunlei.downloadprovider.h.k;

/* compiled from: BrowserActivity */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ t e;

    u(t tVar, String str, String str2, String str3, String str4) {
        this.e = tVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void run() {
        if (!this.e.b.isFinishing()) {
            if (VERSION.SDK_INT < 17 || !this.e.b.isDestroyed()) {
                if (k.d(this.a)) {
                    BrowserActivity.a(this.e.b, this.a, this.b, this.c, this.d);
                } else {
                    this.e.b.a(this.a, this.b, this.c, this.d);
                }
            }
        }
    }
}
