package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.ad.recommend.a.a.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: GuideFollowNetwork */
final class h implements b<JSONObject> {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        c cVar = new c();
        Object obj2 = null;
        if (jSONObject != null) {
            if (ITagManager.SUCCESS.equalsIgnoreCase(jSONObject.optString("result"))) {
                obj2 = new b();
                int i = 0;
                int optInt = jSONObject.optInt("is_need_recommend", 0);
                obj2.b = optInt;
                if (optInt == 1) {
                    obj = jSONObject.optJSONArray("list");
                    if (obj != null) {
                        List arrayList = new ArrayList();
                        while (i < obj.length()) {
                            a a = c.a(obj.optJSONObject(i));
                            if (a != null) {
                                arrayList.add(a);
                            }
                            i++;
                        }
                        obj2.a = arrayList;
                    }
                }
            } else {
                new StringBuilder("result is not ok, result: ").append(jSONObject.optString("result"));
            }
        }
        if (obj2 != null) {
            this.a.b.a(obj2);
        } else {
            this.a.b.a(a.a.e, a.a.f);
        }
    }
}
