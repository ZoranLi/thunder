package com.tencent.wxop.stat.common;

public class a {
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = "0";
    private int e;
    private int f = 0;
    private long g = 0;

    public a(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.e = i;
    }

    org.json.JSONObject a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "ui";	 Catch:{ JSONException -> 0x002f }
        r2 = r4.a;	 Catch:{ JSONException -> 0x002f }
        com.tencent.wxop.stat.common.r.a(r0, r1, r2);	 Catch:{ JSONException -> 0x002f }
        r1 = "mc";	 Catch:{ JSONException -> 0x002f }
        r2 = r4.b;	 Catch:{ JSONException -> 0x002f }
        com.tencent.wxop.stat.common.r.a(r0, r1, r2);	 Catch:{ JSONException -> 0x002f }
        r1 = "mid";	 Catch:{ JSONException -> 0x002f }
        r2 = r4.d;	 Catch:{ JSONException -> 0x002f }
        com.tencent.wxop.stat.common.r.a(r0, r1, r2);	 Catch:{ JSONException -> 0x002f }
        r1 = "aid";	 Catch:{ JSONException -> 0x002f }
        r2 = r4.c;	 Catch:{ JSONException -> 0x002f }
        com.tencent.wxop.stat.common.r.a(r0, r1, r2);	 Catch:{ JSONException -> 0x002f }
        r1 = "ts";	 Catch:{ JSONException -> 0x002f }
        r2 = r4.g;	 Catch:{ JSONException -> 0x002f }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x002f }
        r1 = "ver";	 Catch:{ JSONException -> 0x002f }
        r2 = r4.f;	 Catch:{ JSONException -> 0x002f }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x002f }
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.a.a():org.json.JSONObject");
    }

    public void a(int i) {
        this.e = i;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public String toString() {
        return a().toString();
    }
}
