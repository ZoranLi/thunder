package com.xunlei.downloadprovider.comment;

import com.alipay.sdk.util.e;
import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CommentManager */
final class n implements b<JSONObject> {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a.a;
        new StringBuilder("delete comment response=>").append(jSONObject);
        try {
            obj = jSONObject.getInt("result");
        } catch (Object obj2) {
            a.a;
            new StringBuilder("delete comment error=>").append(obj2.getMessage());
            obj2.printStackTrace();
            obj2 = -1;
        }
        if (this.a.b != null) {
            if (obj2 >= null) {
                this.a.b.a(null);
                return;
            }
            a.b bVar = new a.b();
            bVar.a = obj2;
            bVar.b = e.b;
            this.a.b.a(bVar);
        }
    }
}
