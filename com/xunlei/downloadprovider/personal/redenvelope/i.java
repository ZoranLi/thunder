package com.xunlei.downloadprovider.personal.redenvelope;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.personal.redenvelope.g.a;
import org.json.JSONObject;

/* compiled from: RedPacketOpenHelper */
final class i implements b<JSONObject> {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a aVar = this.a.a;
        try {
            if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
                obj = jSONObject.optJSONObject("info");
                if ("0".equals(obj.optString("result"))) {
                    obj = obj.optJSONObject("data");
                    if (obj == null) {
                        aVar.a();
                        return;
                    } else {
                        aVar.a(obj.toString());
                        return;
                    }
                }
                aVar.a();
                return;
            }
            aVar.a();
        } catch (Object obj2) {
            aVar.a();
            obj2.printStackTrace();
        }
    }
}
