package com.alibaba.sdk.android.httpdns;

import org.json.JSONArray;
import org.json.JSONObject;

class b {
    private long a;
    private String f2a;
    private String[] f3a;
    private long b;

    b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2a = jSONObject.getString("host");
            JSONArray jSONArray = jSONObject.getJSONArray("ips");
            int length = jSONArray.length();
            this.f3a = new String[length];
            for (int i = 0; i < length; i++) {
                this.f3a[i] = jSONArray.getString(i);
            }
            this.a = jSONObject.getLong("ttl");
            this.b = System.currentTimeMillis() / 1000;
        } catch (Throwable e) {
            e.a(e);
        }
    }

    long a() {
        return this.a;
    }

    boolean m9a() {
        return b() + a() < System.currentTimeMillis() / 1000;
    }

    String[] m10a() {
        return this.f3a;
    }

    long b() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("host: ");
        stringBuilder.append(this.f2a);
        stringBuilder.append(" ip cnt: ");
        stringBuilder.append(this.f3a.length);
        stringBuilder.append(" ttl: ");
        stringBuilder.append(this.a);
        String stringBuilder2 = stringBuilder.toString();
        for (String stringBuilder22 : this.f3a) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder22);
            stringBuilder3.append("\n ip: ");
            stringBuilder3.append(stringBuilder22);
            stringBuilder22 = stringBuilder3.toString();
        }
        return stringBuilder22;
    }
}
