package com.xunlei.downloadprovider.personal.a.b;

import com.xunlei.downloadprovider.personal.a.d.d.a;
import org.json.JSONArray;

/* compiled from: UserGridDataManager */
public final class b implements com.android.volley.n.b<JSONArray> {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    public b(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONArray jSONArray = (JSONArray) obj;
        a.c;
        new StringBuilder("requestFixedGridData onResponse = ").append(jSONArray.toString());
        obj = h.a(jSONArray);
        if (obj.size() > 0) {
            this.a.a(obj);
        } else {
            this.a.a(null);
        }
    }
}
