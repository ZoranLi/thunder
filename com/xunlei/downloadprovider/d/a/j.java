package com.xunlei.downloadprovider.d.a;

import org.json.JSONObject;

/* compiled from: JSONObjectStaticConfig */
public abstract class j extends a {
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

    public j(String str, String str2) {
        super(str, str2);
    }

    public j(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    protected final boolean a(boolean r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        r2 = 0;
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r3.a(r4, r2);
        return r1;
    L_0x000c:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0016 }
        r0.<init>(r5);	 Catch:{ JSONException -> 0x0016 }
        r3.a(r4, r0);	 Catch:{ JSONException -> 0x0016 }
        r4 = 1;
        return r4;
    L_0x0016:
        r3.a(r4, r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.d.a.j.a(boolean, java.lang.String):boolean");
    }

    public void a(boolean z, JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject);
        }
    }
}
