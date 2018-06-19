package com.xunlei.downloadprovider.web.browser;

import android.app.Activity;
import com.xunlei.downloadprovider.web.website.g.b$b;

/* compiled from: BrowserToolBarFragment */
final class ap implements b$b {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    ap(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void a() {
        Activity activity = this.b.b.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new aq(this));
        }
    }
}
