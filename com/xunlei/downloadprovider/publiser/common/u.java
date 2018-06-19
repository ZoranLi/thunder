package com.xunlei.downloadprovider.publiser.common;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: VisitorNetworkHelper */
final class u implements b<JSONObject> {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("getVisitCount response=>").append(jSONObject);
        if (TextUtils.equals(ITagManager.SUCCESS, jSONObject.optString("result"))) {
            obj = jSONObject.optJSONObject("info");
            if (obj == null) {
                this.a.b.a(0);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.a);
            this.a.b.a(obj.optInt(stringBuilder.toString()));
            return;
        }
        new StringBuilder("getVisitCount failed,error=>").append(jSONObject.optString("info"));
        this.a.b.a(0);
    }
}
