package com.xunlei.downloadprovider.web.base.core;

import com.android.volley.n.b;

/* compiled from: JsHttpClient */
final class y implements b<String> {
    final /* synthetic */ a a;

    y(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        if (this.a.f != null) {
            this.a.f.a(0, 200, str);
        }
    }
}
