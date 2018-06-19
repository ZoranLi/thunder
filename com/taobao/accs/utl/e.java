package com.taobao.accs.utl;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class e {
    public static String a(JSONObject jSONObject, String str, String str2) throws JSONException {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : str2;
    }
}
