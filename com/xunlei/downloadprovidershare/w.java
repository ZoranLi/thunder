package com.xunlei.downloadprovidershare;

import android.text.TextUtils;
import com.alipay.sdk.util.e;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: ShareThunderCommandHelper */
final class w implements b<JSONObject> {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
            obj = jSONObject.optString("url");
            if (TextUtils.isEmpty(obj)) {
                this.a.b.a(null);
                return;
            } else {
                this.a.b.a(obj);
                return;
            }
        }
        this.a.b.a(e.b);
    }
}
