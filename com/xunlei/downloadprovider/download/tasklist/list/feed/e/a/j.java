package com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.b;

/* compiled from: TouTiaoNetwork */
final class j implements a {
    final /* synthetic */ com.xunlei.downloadprovider.download.tasklist.list.feed.e.a a;
    final /* synthetic */ b b;

    j(b bVar, com.xunlei.downloadprovider.download.tasklist.list.feed.e.a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a(b.a(volleyError), "");
    }
}
