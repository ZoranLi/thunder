package com.xunlei.downloadprovider.personal.a.e;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.personal.a.a;
import org.json.JSONObject;

/* compiled from: UserScoreManager */
final class d implements b<JSONObject> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        i iVar = new i();
        if (jSONObject != null) {
            String optString = jSONObject.optString("result");
            obj = jSONObject.optJSONObject("data");
            if (obj != null && optString.equals(ITagManager.SUCCESS)) {
                int optInt = obj.optInt("signed");
                int optInt2 = obj.optInt("continues_sign");
                int optInt3 = obj.optInt("this_score");
                obj = obj.optInt("total_score");
                iVar.a = optInt;
                iVar.b = optInt2;
                iVar.c = optInt3;
                iVar.d = obj;
            }
        }
        Object obj2 = 1;
        if (iVar.a != 1) {
            obj2 = null;
        }
        if (obj2 != null) {
            a.a().d();
        }
        this.a.b.a(iVar);
    }
}
