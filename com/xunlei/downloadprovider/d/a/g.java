package com.xunlei.downloadprovider.d.a;

import org.json.JSONArray;

/* compiled from: JSONArrayInterfaceConfig */
public abstract class g extends a {
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

    public g(String str, String str2) {
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
        r4.a(r5, r2);
        return r1;
    L_0x000c:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x002e }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x002e }
        r6 = "result";	 Catch:{ JSONException -> 0x002e }
        r6 = r0.optString(r6);	 Catch:{ JSONException -> 0x002e }
        r3 = "ok";	 Catch:{ JSONException -> 0x002e }
        r6 = r3.equalsIgnoreCase(r6);	 Catch:{ JSONException -> 0x002e }
        if (r6 == 0) goto L_0x002a;	 Catch:{ JSONException -> 0x002e }
    L_0x001f:
        r6 = "values";	 Catch:{ JSONException -> 0x002e }
        r6 = r0.optJSONArray(r6);	 Catch:{ JSONException -> 0x002e }
        r4.a(r5, r6);	 Catch:{ JSONException -> 0x002e }
        r1 = 1;	 Catch:{ JSONException -> 0x002e }
        goto L_0x0031;	 Catch:{ JSONException -> 0x002e }
    L_0x002a:
        r4.a(r5, r2);	 Catch:{ JSONException -> 0x002e }
        goto L_0x0031;
    L_0x002e:
        r4.a(r5, r2);
    L_0x0031:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.d.a.g.a(boolean, java.lang.String):boolean");
    }

    public void a(boolean z, JSONArray jSONArray) {
        StringBuilder stringBuilder = new StringBuilder("onConfigLoaded--isFromCache=");
        stringBuilder.append(z);
        stringBuilder.append("|FileName=");
        stringBuilder.append(super.j());
        stringBuilder.append("|valueJsonIsNull=");
        stringBuilder.append(jSONArray == null);
    }
}
