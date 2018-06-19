package com.xunlei.downloadprovider.search.ui.search;

import com.android.volley.n.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MultiLoader */
final class i implements b<JSONObject> {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        List list = this.a.b.h;
        Collection arrayList = new ArrayList();
        JSONObject optJSONObject = jSONObject.optJSONObject("site");
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    ak akVar = new ak();
                    akVar.a(optJSONObject2);
                    arrayList.add(akVar);
                }
            }
        }
        list.addAll(arrayList);
        this.a.b.j.addAll(g.c(jSONObject));
        this.a.b.i.addAll(g.a(jSONObject));
        if (this.a.c != null) {
            this.a.c.a();
        }
    }
}
