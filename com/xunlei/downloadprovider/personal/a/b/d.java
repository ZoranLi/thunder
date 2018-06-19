package com.xunlei.downloadprovider.personal.a.b;

import com.android.volley.n.b;
import org.json.JSONArray;

/* compiled from: UserGridDataManager */
public final class d implements b<JSONArray> {
    final /* synthetic */ com.xunlei.downloadprovider.personal.a.d.d.b a;
    final /* synthetic */ a b;

    public d(a aVar, com.xunlei.downloadprovider.personal.a.d.d.b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONArray jSONArray = (JSONArray) obj;
        a.c;
        new StringBuilder("requestGridListData onResponse = ").append(jSONArray.toString());
        a.a(this.b, jSONArray);
        this.a.a();
    }
}
