package com.xunlei.downloadprovider.contentpublish.website.a;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: WebsiteNetworkHelper */
final class e implements b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    e(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = l.a((JSONObject) obj);
        if (obj == null) {
            this.a.onFail("");
        } else {
            this.a.onSuccess(obj);
        }
    }
}
