package com.xunlei.downloadprovider.personal.score;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: UserScoreManager */
final class j implements b<JSONObject> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        o oVar = new o();
        if (jSONObject != null) {
            String optString = jSONObject.optString("result");
            obj = jSONObject.optJSONObject("data");
            if (obj != null && optString.equals(ITagManager.SUCCESS)) {
                int optInt = obj.optInt("signed");
                int optInt2 = obj.optInt("continues_sign");
                int optInt3 = obj.optInt("this_score");
                obj = obj.optInt("total_score");
                oVar.a = optInt;
                oVar.b = optInt2;
                oVar.c = optInt3;
                oVar.d = obj;
            }
        }
        this.a.b.a(oVar);
    }
}
