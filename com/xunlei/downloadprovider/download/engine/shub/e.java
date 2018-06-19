package com.xunlei.downloadprovider.download.engine.shub;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: GcidManager */
final class e implements b<JSONObject> {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        StringBuilder stringBuilder = new StringBuilder("Gcid Response: ");
        stringBuilder.append(this.a.d);
        stringBuilder.append(" ");
        stringBuilder.append(jSONObject);
        obj = jSONObject.optJSONObject("data");
        if (obj != null && obj.has("gcid")) {
            try {
                String string = obj.getString("gcid");
                String optString = obj.optString("cid");
                long optLong = obj.optLong("filesize");
                this.a.b = new GcidInfo(optString, string, optLong);
            } catch (Object obj2) {
                obj2.printStackTrace();
            }
        }
        b.a(this.a);
    }
}
