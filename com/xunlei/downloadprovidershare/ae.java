package com.xunlei.downloadprovidershare;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovidershare.ad.a;
import org.json.JSONObject;

/* compiled from: ShortUrlHelper */
public final class ae implements b<JSONObject> {
    final /* synthetic */ a a;

    public ae(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (ITagManager.SUCCESS.equalsIgnoreCase(jSONObject.optString("result"))) {
            a aVar = this.a;
            jSONObject.optString("dlj");
            aVar.a();
            return;
        }
        this.a.a();
    }
}
