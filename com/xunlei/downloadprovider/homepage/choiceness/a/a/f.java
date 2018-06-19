package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessLiveGroupInfo */
public final class f extends e {
    public List<g> a = new ArrayList();

    public static f a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        e fVar = new f();
        JSONArray jSONArray = jSONObject.getJSONArray("res_info");
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                a(fVar, jSONObject);
                for (jSONObject = null; jSONObject < jSONArray.length(); jSONObject++) {
                    g a = g.a(jSONArray.getJSONObject(jSONObject));
                    if (a != null) {
                        fVar.a.add(a);
                    }
                }
                return fVar;
            }
        }
        return null;
    }
}
