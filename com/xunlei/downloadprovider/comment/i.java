package com.xunlei.downloadprovider.comment;

import com.alipay.sdk.util.e;
import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CommentManager */
final class i implements b<JSONObject> {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a.a;
        new StringBuilder("send zan response=>").append(jSONObject);
        try {
            obj = jSONObject.getInt("result");
        } catch (Object obj2) {
            a.a;
            new StringBuilder("send comment error=>").append(obj2.getMessage());
            obj2.printStackTrace();
            obj2 = -1;
        }
        if (this.a.c != null) {
            if (obj2 == null) {
                this.a.c.a(null);
                return;
            }
            a.b bVar = new a.b();
            bVar.a = obj2;
            bVar.b = e.b;
            this.a.c.a(bVar);
        }
    }
}
