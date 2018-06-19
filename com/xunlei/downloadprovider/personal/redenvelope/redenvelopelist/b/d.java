package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f;

/* compiled from: RedEnvelopesManager */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        f.a().a(null, null);
        if (this.a.b != null) {
            this.a.b.a(volleyError);
        }
        new StringBuilder("volleyError == ").append(volleyError.toString());
    }
}
