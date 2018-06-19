package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f;
import java.util.List;
import org.json.JSONObject;

/* compiled from: RedEnvelopesManager */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            List a;
            a aVar = this.a.c;
            if (jSONObject != null) {
                aVar.b = jSONObject.optString("result");
                a = a.a(jSONObject.optJSONArray("list"));
            } else {
                a = null;
            }
            f.a().a(a, jSONObject);
            obj = jSONObject.optInt("cursor");
            if (this.a.b != null) {
                this.a.b.a(a, this.a.c.b, obj);
            }
        }
    }
}
