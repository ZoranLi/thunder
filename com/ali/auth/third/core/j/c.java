package com.ali.auth.third.core.j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static String a(JSONObject jSONObject, String str) {
        return jSONObject.has(str) ? jSONObject.optString(str) : null;
    }

    private static List<Object> a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        List<Object> arrayList = new ArrayList(jSONArray.length());
        int i = 0;
        int length = jSONArray.length();
        while (i < length) {
            Object obj = jSONArray.get(i);
            obj = obj instanceof JSONObject ? a((JSONObject) obj) : obj instanceof JSONArray ? a((JSONArray) obj) : jSONArray.get(i);
            arrayList.add(obj);
            i++;
        }
        return arrayList;
    }

    public static Map<String, Object> a(JSONObject jSONObject) throws JSONException {
        Map<String, Object> hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONObject) {
                opt = a((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = a((JSONArray) opt);
            }
            hashMap.put(str, opt);
        }
        return hashMap;
    }
}
