package com.qiniu.android.c;

/* compiled from: UpToken */
public final class s {
    public static s a = new s("", "", "");
    public final String b;
    public final String c;
    public String d = null;

    private s(String str, String str2, String str3) {
        this.d = str;
        this.b = str2;
        this.c = str3;
    }

    public static com.qiniu.android.c.s a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = ":";	 Catch:{ Exception -> 0x004e }
        r0 = r4.split(r0);	 Catch:{ Exception -> 0x004e }
        r1 = r0.length;
        r2 = 3;
        if (r1 == r2) goto L_0x000d;
    L_0x000a:
        r4 = a;
        return r4;
    L_0x000d:
        r1 = 2;
        r1 = r0[r1];
        r2 = 10;
        r1 = android.util.Base64.decode(r1, r2);
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x004b }
        r3 = new java.lang.String;	 Catch:{ JSONException -> 0x004b }
        r3.<init>(r1);	 Catch:{ JSONException -> 0x004b }
        r2.<init>(r3);	 Catch:{ JSONException -> 0x004b }
        r1 = "scope";
        r1 = r2.optString(r1);
        r3 = "";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r4 = a;
        return r4;
    L_0x0031:
        r1 = "deadline";
        r1 = r2.optInt(r1);
        if (r1 != 0) goto L_0x003c;
    L_0x0039:
        r4 = a;
        return r4;
    L_0x003c:
        r1 = new com.qiniu.android.c.s;
        r3 = "returnUrl";
        r2 = r2.optString(r3);
        r3 = 0;
        r0 = r0[r3];
        r1.<init>(r2, r4, r0);
        return r1;
    L_0x004b:
        r4 = a;
        return r4;
    L_0x004e:
        r4 = a;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.c.s.a(java.lang.String):com.qiniu.android.c.s");
    }

    public final String toString() {
        return this.b;
    }
}
