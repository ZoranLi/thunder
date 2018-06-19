package com.xunlei.downloadprovider.publiser.campaign.a;

import com.android.volley.n.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: TopicNetWork */
final class k implements b<JSONObject> {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = ((JSONObject) obj).optJSONArray("data");
        List arrayList = new ArrayList();
        if (obj != null && obj.length() > 0) {
            for (int i = 0; i < obj.length(); i++) {
                n a = n.a(obj.optJSONObject(i));
                a.b.setTop(true);
                arrayList.add(a);
            }
        }
        this.a.b.onSuccess(arrayList);
    }
}
