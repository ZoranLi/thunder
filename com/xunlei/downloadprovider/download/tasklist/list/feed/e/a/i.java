package com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.c;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;
import org.json.JSONObject;

/* compiled from: TouTiaoNetwork */
final class i implements b<JSONObject> {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    i(b bVar, a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        b.a.a aVar = new b.a.a();
        b.a.a(aVar, jSONObject);
        if (b.a.a(aVar) != null) {
            aVar.a = new c();
        }
        if (b.a.a(aVar) != null) {
            this.a.a(aVar.a);
        } else {
            this.a.a(aVar.b, aVar.c);
        }
    }
}
