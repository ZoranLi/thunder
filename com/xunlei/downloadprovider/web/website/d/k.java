package com.xunlei.downloadprovider.web.website.d;

import android.app.Activity;
import com.xunlei.downloadprovider.web.website.g.b$b;

/* compiled from: WebsiteMoreOperationDialog */
final class k implements b$b {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void a() {
        Activity activity = (Activity) this.a.a.g;
        if (activity != null) {
            activity.runOnUiThread(new l(this));
        }
    }
}
