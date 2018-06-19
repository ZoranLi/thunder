package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (ITagManager.SUCCESS.equalsIgnoreCase(jSONObject.optString("result"))) {
            a a = a.a(jSONObject.optJSONObject("follow_info"));
            a.h = System.currentTimeMillis() / 1000;
            obj = jSONObject.optJSONArray("recommend_list");
            List arrayList = new ArrayList();
            if (obj != null) {
                for (int i = 0; i < obj.length(); i++) {
                    arrayList.add(a.a(obj.optJSONObject(i)));
                }
            }
            this.a.c.a(a, arrayList);
            return;
        }
        this.a.c.a(jSONObject.optString("code"));
    }
}
