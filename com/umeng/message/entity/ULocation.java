package com.umeng.message.entity;

import org.json.JSONObject;

public class ULocation {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public ULocation(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getString("cenx");
            this.b = jSONObject.getString("ceny");
            jSONObject = jSONObject.getJSONObject("revergeo");
            this.c = jSONObject.getString("country");
            this.d = jSONObject.getString("province");
            this.e = jSONObject.getString("city");
            this.f = jSONObject.getString("district");
            this.g = jSONObject.getString("road");
            this.h = jSONObject.getString("street");
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
    }

    public String getLongitude() {
        return this.a;
    }

    public String getLatitude() {
        return this.b;
    }

    public String getCountry() {
        return this.c;
    }

    public String getProvince() {
        return this.d;
    }

    public String getCity() {
        return this.e;
    }

    public String getDistrict() {
        return this.f;
    }

    public String getRoad() {
        return this.g;
    }

    public String getStreet() {
        return this.h;
    }
}
