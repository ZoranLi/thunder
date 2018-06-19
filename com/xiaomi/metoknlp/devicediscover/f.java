package com.xiaomi.metoknlp.devicediscover;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class f {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final double e;
    private final double f;
    private final String g;
    private final String h;
    private final long i;
    private final long j;
    private final String k;
    private final String l;
    private final List m;

    private f(d dVar) {
        this.a = dVar.a;
        this.b = dVar.b;
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f = dVar.f;
        this.g = dVar.g;
        this.h = dVar.h;
        this.i = dVar.i;
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = dVar.l;
        this.m = dVar.m;
    }

    private void a(org.json.JSONObject r2, java.lang.String r3, java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0019;
    L_0x0002:
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r4 instanceof java.lang.String;
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = r4;
        r0 = (java.lang.String) r0;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0019;
    L_0x0012:
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0015 }
    L_0x0015:
        return;
    L_0x0016:
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0019 }
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.f.a(org.json.JSONObject, java.lang.String, java.lang.Object):void");
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "m", this.a);
        a(jSONObject, "i", this.b);
        a(jSONObject, "a", this.c);
        a(jSONObject, "o", this.d);
        a(jSONObject, "lg", Double.valueOf(this.e));
        a(jSONObject, "lt", Double.valueOf(this.f));
        a(jSONObject, "am", this.g);
        a(jSONObject, "as", this.h);
        a(jSONObject, "ast", Long.valueOf(this.i));
        a(jSONObject, "ad", Long.valueOf(this.j));
        a(jSONObject, "ds", this.k);
        a(jSONObject, "dm", this.l);
        JSONArray jSONArray = new JSONArray();
        for (String put : this.m) {
            jSONArray.put(put);
        }
        a(jSONObject, "devices", jSONArray);
        return jSONObject;
    }
}
