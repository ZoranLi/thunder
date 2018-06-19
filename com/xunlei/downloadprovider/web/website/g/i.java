package com.xunlei.downloadprovider.web.website.g;

import android.text.TextUtils;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.web.website.b.d;
import com.xunlei.downloadprovider.web.website.c.b;

/* compiled from: WebsiteHelper */
public final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    public i(b bVar, String str, String str2, String str3) {
        this.d = bVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void run() {
        if (!TextUtils.isEmpty(this.a)) {
            if (!TextUtils.isEmpty(this.b)) {
                if (!this.b.contains("about:blank")) {
                    if (!this.b.contains(BrothersApplication.getApplicationInstance().getString(R.string.about_blank))) {
                        d dVar = new d();
                        dVar.c = this.a;
                        dVar.b = this.b;
                        dVar.f = this.c;
                        dVar.d = System.currentTimeMillis();
                        dVar.e = 1;
                        if (b.b(this.b) != null) {
                            b.a(this.b);
                        }
                        b.a(dVar);
                    }
                }
            }
        }
    }
}
