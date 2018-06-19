package com.alibaba.baichuan.android.trade.e.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static final String c = "a";
    public Map a = new HashMap();
    public Map b;

    public final void a(JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                Map hashMap = new HashMap();
                String str = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                Iterator keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String str2 = (String) keys2.next();
                    hashMap.put(str2, jSONObject2.getString(str2));
                }
                this.a.put(str, hashMap);
            }
        } catch (JSONException e) {
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            e.printStackTrace();
        }
    }
}
