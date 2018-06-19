package com.xunlei.downloadprovider.comment;

import com.alipay.sdk.util.e;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.comment.a.a;
import org.json.JSONObject;

/* compiled from: CommentManager */
public final class k implements b<JSONObject> {
    final /* synthetic */ a a;
    final /* synthetic */ long b;
    final /* synthetic */ a c;

    public k(a aVar, a aVar2, long j) {
        this.c = aVar;
        this.a = aVar2;
        this.b = j;
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
        if (this.a != null) {
            if (obj2 == null) {
                this.a.a(Long.valueOf(this.b));
                return;
            }
            a.b bVar = new a.b();
            bVar.a = obj2;
            bVar.b = e.b;
            this.a.a(bVar);
        }
    }
}
