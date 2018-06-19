package com.xunlei.downloadprovider.web.website.g;

import android.text.TextUtils;
import com.xunlei.downloadprovider.web.website.b.c;
import com.xunlei.downloadprovider.web.website.c.a;

/* compiled from: WebsiteHelper */
final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b$c b;
    final /* synthetic */ b c;

    d(b bVar, String str, b$c com_xunlei_downloadprovider_web_website_g_b_c) {
        this.c = bVar;
        this.a = str;
        this.b = com_xunlei_downloadprovider_web_website_g_b_c;
    }

    public final void run() {
        if (!TextUtils.isEmpty(this.a)) {
            c b = a.b(this.a);
            if (!(b == null || TextUtils.isEmpty(b.b) || !b.b.endsWith(this.a))) {
                this.b.a(true);
                return;
            }
        }
        this.b.a(false);
    }
}
