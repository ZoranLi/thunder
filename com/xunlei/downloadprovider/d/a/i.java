package com.xunlei.downloadprovider.d.a;

import org.json.JSONObject;

/* compiled from: JSONObjectInterfaceConfig */
public abstract class i extends a {
    public final /* bridge */ /* synthetic */ void a(Runnable runnable) {
        super.a(runnable);
    }

    public final /* bridge */ /* synthetic */ void f(String str) {
        super.f(str);
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ String j() {
        return super.j();
    }

    public i(String str, String str2) {
        super(str, str2);
    }

    protected final boolean a(boolean r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = android.text.TextUtils.isEmpty(r6);
        r1 = 0;
        r2 = 0;
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r4.a(r5, r2, r2);
        return r1;
    L_0x000c:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0034 }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x0034 }
        r6 = "result";	 Catch:{ JSONException -> 0x0034 }
        r6 = r0.optString(r6);	 Catch:{ JSONException -> 0x0034 }
        r3 = "ok";	 Catch:{ JSONException -> 0x0034 }
        r6 = r3.equalsIgnoreCase(r6);	 Catch:{ JSONException -> 0x0034 }
        if (r6 == 0) goto L_0x0030;	 Catch:{ JSONException -> 0x0034 }
    L_0x001f:
        r6 = "values";	 Catch:{ JSONException -> 0x0034 }
        r6 = r0.optJSONObject(r6);	 Catch:{ JSONException -> 0x0034 }
        r3 = "ip_info";	 Catch:{ JSONException -> 0x0034 }
        r0 = r0.optString(r3);	 Catch:{ JSONException -> 0x0034 }
        r4.a(r5, r6, r0);	 Catch:{ JSONException -> 0x0034 }
        r1 = 1;	 Catch:{ JSONException -> 0x0034 }
        goto L_0x0037;	 Catch:{ JSONException -> 0x0034 }
    L_0x0030:
        r4.a(r5, r2, r2);	 Catch:{ JSONException -> 0x0034 }
        goto L_0x0037;
    L_0x0034:
        r4.a(r5, r2, r2);
    L_0x0037:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.d.a.i.a(boolean, java.lang.String):boolean");
    }

    public void a(boolean z, JSONObject jSONObject, String str) {
        StringBuilder stringBuilder = new StringBuilder("onConfigLoaded--isFromCache=");
        stringBuilder.append(z);
        stringBuilder.append("|FileName=");
        stringBuilder.append(super.j());
        stringBuilder.append("|valueJsonIsNull=");
        stringBuilder.append(jSONObject == null);
        stringBuilder.append(" ipInfo=");
        stringBuilder.append(str);
        if (jSONObject != null) {
            a(jSONObject);
        }
    }
}
