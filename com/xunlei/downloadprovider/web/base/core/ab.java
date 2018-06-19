package com.xunlei.downloadprovider.web.base.core;

import com.android.volley.n.b;

/* compiled from: JsHttpClient */
final class ab implements b<String> {
    final /* synthetic */ d a;

    ab(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        if (this.a.f != null) {
            this.a.f.a(0, 200, str);
        }
    }
}
