package com.xunlei.downloadprovider.personal.a.e;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.a.a;
import org.json.JSONObject;

/* compiled from: UserScoreManager */
final class g implements b<JSONObject> {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        int optInt;
        int optInt2;
        int optInt3;
        JSONObject jSONObject = (JSONObject) obj;
        a aVar = new a();
        if (jSONObject != null) {
            if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
                obj = jSONObject.optJSONObject("data");
                optInt = obj.optInt("comment");
                optInt2 = obj.optInt("follow");
                optInt3 = obj.optInt("video");
                obj = obj.optInt("praise");
                aVar.a = optInt;
                aVar.b = optInt2;
                aVar.c = optInt3;
                aVar.d = obj;
            }
        }
        obj = aVar.a;
        optInt = aVar.b;
        optInt2 = aVar.c;
        optInt3 = aVar.d;
        a a = a.a();
        obj = ((obj + optInt) + optInt2) + optInt3;
        StringBuilder stringBuilder = new StringBuilder("key_user_total_not_receive_score");
        stringBuilder.append(LoginHelper.a().g.c());
        a.a(stringBuilder.toString(), obj);
        this.a.a.a(aVar);
    }
}
