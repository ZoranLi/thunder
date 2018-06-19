package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessLiveGroupSecondInfo */
public final class h extends e {
    public g a;
    public g b;
    public g c;

    public static e a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        e hVar = new h();
        JSONArray jSONArray = jSONObject.getJSONArray("res_info");
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                e.a(hVar, jSONObject);
                hVar.a = g.a(jSONArray.optJSONObject(null));
                hVar.b = g.a(jSONArray.optJSONObject(1));
                hVar.c = g.a(jSONArray.optJSONObject(2));
                return hVar;
            }
        }
        return null;
    }
}
