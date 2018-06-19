package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: JoinActivityNetwork */
final class d implements b<JSONObject> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            new StringBuilder("JoinActivityIsNewRequest. success: ").append(jSONObject.toString());
            int i = 0;
            if (ITagManager.SUCCESS.contentEquals(jSONObject.optString("result"))) {
                i = jSONObject.optInt("is_newbie", 0);
            }
            if (this.a.a != null) {
                this.a.a.a(Integer.valueOf(i));
            }
        }
    }
}
