package com.xunlei.downloadprovider.cardslide.c;

import com.android.volley.n.b;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.cardslide.a.a;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: CardSlideRequestManager */
final class d implements b<JSONObject> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        jSONObject.toString();
        obj = b.a(jSONObject);
        b.a = new ArrayList(obj);
        if (this.a.a != null) {
            this.a.a.a(obj);
        }
        XLThreadPool.execute(new com.xunlei.downloadprovider.cardslide.a.b(a.a(), obj));
        com.xunlei.downloadprovider.cardslide.d.a.a().b();
    }
}
