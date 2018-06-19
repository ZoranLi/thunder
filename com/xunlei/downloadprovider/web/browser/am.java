package com.xunlei.downloadprovider.web.browser;

import android.app.Activity;
import com.xunlei.downloadprovider.web.website.g.b$a;

/* compiled from: BrowserToolBarFragment */
final class am implements b$a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;

    am(a aVar, String str, String str2, String str3) {
        this.d = aVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void a() {
        Activity activity = this.d.b.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new an(this));
        }
    }

    public final void b() {
        this.d.b.getActivity().runOnUiThread(new ao(this));
    }
}
