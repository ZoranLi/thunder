package com.xunlei.downloadprovider.publiser.websitetopic.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: WebsiteTopicNetworkHelper */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        b bVar = new b();
        if (jSONObject != null && ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
            bVar.a = true;
            bVar.b = jSONObject.optBoolean("is_more");
            bVar.c = jSONObject.optString("cursor");
            bVar.d = jSONObject.optString("topic_name");
            bVar.e = jSONObject.optString("topic_pic_top");
            obj = jSONObject.optJSONArray("site_info");
            List arrayList = new ArrayList();
            if (obj != null) {
                for (int i = 0; i < obj.length(); i++) {
                    arrayList.add(c.a(obj.optJSONObject(i)));
                }
            }
            bVar.f = arrayList;
        }
        this.a.c.onSuccess(bVar);
    }
}
