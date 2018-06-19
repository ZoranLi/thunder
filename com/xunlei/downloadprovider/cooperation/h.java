package com.xunlei.downloadprovider.cooperation;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CooperationLoader */
final class h implements b<JSONObject> {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        g.a(this.a, (JSONObject) obj);
    }
}
