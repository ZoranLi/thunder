package com.xunlei.downloadprovider.publiser.common;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: VisitorNetworkHelper */
final class r implements b<JSONObject> {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("addVisitLog response=>").append(jSONObject);
        if (!TextUtils.equals(ITagManager.SUCCESS, jSONObject.optString("result"))) {
            new StringBuilder("addVisitLog failed,error=>").append(jSONObject.optString("info"));
        }
    }
}
