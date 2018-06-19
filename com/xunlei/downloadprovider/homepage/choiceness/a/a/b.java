package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessAdInfo */
public final class b extends e {
    public JSONObject a;

    public static b a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        e bVar = new b();
        e.a(bVar, jSONObject);
        bVar.a = jSONObject.getJSONObject("res_info");
        return bVar;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof b) || b().equals(((b) obj).b()) == null) ? null : true;
    }
}
