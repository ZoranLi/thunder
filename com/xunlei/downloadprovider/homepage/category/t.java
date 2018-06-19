package com.xunlei.downloadprovider.homepage.category;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ShortVideoCategoryDataHelper */
final class t implements b<JSONObject> {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            try {
                if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
                    obj = jSONObject.optJSONArray("card_list");
                    if (obj != null) {
                        List arrayList = new ArrayList();
                        for (int i = 0; i < obj.length(); i++) {
                            m a = m.a(obj.optJSONObject(i));
                            a.o = this.a.a;
                            arrayList.add(a);
                        }
                        this.a.b.onSuccess(arrayList);
                        return;
                    }
                }
            } catch (Object obj2) {
                obj2.printStackTrace();
                this.a.b.onFail(null);
                return;
            }
        }
        this.a.b.onFail(null);
    }
}
