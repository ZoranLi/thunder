package com.xunlei.common.accelerator.js;

import org.json.JSONObject;

public class KNJsBuildJson {
    public static String callBackJsonBuild(int i, int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("statuCode", i);
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorDesc", str);
        } catch (int i3) {
            i3.printStackTrace();
        }
        return jSONObject.toString();
    }
}
