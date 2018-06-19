package com.duiba.maila.sdk.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d {
    String a;
    String b;
    private StringBuffer c;
    private String d;
    private String e;
    private String f;
    private String g;

    public final String a() {
        return this.c.toString();
    }

    public final String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdata", this.d);
            jSONObject.put("nsdata", this.e);
            jSONObject.put("time", this.f);
            jSONObject.put("token", this.g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
