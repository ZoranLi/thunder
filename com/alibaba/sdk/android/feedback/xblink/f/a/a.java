package com.alibaba.sdk.android.feedback.xblink.f.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.alibaba.sdk.android.feedback.xblink.i.g;

public class a extends com.alibaba.sdk.android.feedback.xblink.f.a {
    private static final String d = "a";

    public void a(b bVar, String str) {
        m mVar = new m();
        mVar.a("os", DispatchConstants.ANDROID);
        mVar.a("version", "4.5.1");
        if (g.a()) {
            g.a("Base", "isWindVaneSDK: version=4.5.1");
        }
        bVar.a(mVar);
    }

    public boolean a(String str, String str2, b bVar) {
        if ("isWindVaneSDK".equals(str)) {
            a(bVar, str2);
        } else if ("plusUT".equals(str)) {
            b(bVar, str2);
        } else if ("isInstall".equals(str)) {
            c(bVar, str2);
        } else if (!"isAppsInstalled".equals(str)) {
            return false;
        } else {
            d(bVar, str2);
        }
        return true;
    }

    public void b(com.alibaba.sdk.android.feedback.xblink.f.b r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0024 }
        r1.<init>(r6);	 Catch:{ JSONException -> 0x0024 }
        r2 = "eid";	 Catch:{ JSONException -> 0x0024 }
        r2 = r1.getInt(r2);	 Catch:{ JSONException -> 0x0024 }
        r3 = "a1";	 Catch:{ JSONException -> 0x0024 }
        r1.getString(r3);	 Catch:{ JSONException -> 0x0024 }
        r3 = "a2";	 Catch:{ JSONException -> 0x0024 }
        r1.getString(r3);	 Catch:{ JSONException -> 0x0024 }
        r3 = "a3";	 Catch:{ JSONException -> 0x0024 }
        r1.getString(r3);	 Catch:{ JSONException -> 0x0024 }
        r1 = 9100; // 0x238c float:1.2752E-41 double:4.496E-320;
        if (r2 < r1) goto L_0x0024;
    L_0x001f:
        r1 = 9200; // 0x23f0 float:1.2892E-41 double:4.5454E-320;
        if (r2 >= r1) goto L_0x0024;
    L_0x0023:
        r0 = 1;
    L_0x0024:
        r1 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r1.<init>();
        if (r0 == 0) goto L_0x0048;
    L_0x002b:
        r5.a(r1);
        r5 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r5 == 0) goto L_0x0063;
    L_0x0034:
        r5 = "Base";
        r0 = new java.lang.StringBuilder;
        r1 = "plusUT: param=";
        r0.<init>(r1);
        r0.append(r6);
        r6 = r0.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r5, r6);
        return;
    L_0x0048:
        r0 = "Base";
        r2 = new java.lang.StringBuilder;
        r3 = "plusUT: parameter error, param=";
        r2.<init>(r3);
        r2.append(r6);
        r6 = r2.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r6);
        r6 = "HY_PARAM_ERR";
        r1.a(r6);
        r5.b(r1);
    L_0x0063:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.a.b(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public void c(com.alibaba.sdk.android.feedback.xblink.f.b r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000c }
        r0.<init>(r7);	 Catch:{ JSONException -> 0x000c }
        r1 = "android";	 Catch:{ JSONException -> 0x000c }
        r0 = r0.getString(r1);	 Catch:{ JSONException -> 0x000c }
        goto L_0x0020;
    L_0x000c:
        r0 = "Base";
        r1 = new java.lang.StringBuilder;
        r2 = "isInstall parse params error, params: ";
        r1.<init>(r2);
        r1.append(r7);
        r7 = r1.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r7);
        r0 = 0;
    L_0x0020:
        r7 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r7.<init>();
        r1 = r5.a;
        r1 = com.alibaba.sdk.android.feedback.xblink.i.a.a(r1, r0);
        r2 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r2 == 0) goto L_0x004c;
    L_0x0031:
        r2 = "Base";
        r3 = new java.lang.StringBuilder;
        r4 = "isInstall ";
        r3.<init>(r4);
        r3.append(r1);
        r4 = " for package ";
        r3.append(r4);
        r3.append(r0);
        r0 = r3.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r2, r0);
    L_0x004c:
        if (r1 == 0) goto L_0x0052;
    L_0x004e:
        r6.a(r7);
        return;
    L_0x0052:
        r6.b(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.a.c(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public void d(com.alibaba.sdk.android.feedback.xblink.f.b r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0053 }
        r0.<init>(r9);	 Catch:{ JSONException -> 0x0053 }
        r9 = r0.keys();
        r1 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r1.<init>();
        r2 = r7.a;
        r2 = r2.getPackageManager();
    L_0x0014:
        r3 = r9.hasNext();
        if (r3 == 0) goto L_0x0048;
    L_0x001a:
        r3 = r9.next();
        r3 = (java.lang.String) r3;
        r4 = r0.getJSONObject(r3);	 Catch:{ JSONException -> 0x0038 }
        r5 = "android";	 Catch:{ JSONException -> 0x0038 }
        r4 = r4.optString(r5);	 Catch:{ JSONException -> 0x0038 }
        r5 = 0;
        r6 = 0;
        r4 = r2.getPackageInfo(r4, r6);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0032;
    L_0x0031:
        r4 = r5;
    L_0x0032:
        if (r4 != 0) goto L_0x0035;
    L_0x0034:
        goto L_0x0042;
    L_0x0035:
        r4 = "1";
        goto L_0x0044;
    L_0x0038:
        r4 = move-exception;
        r5 = d;
        r4 = java.lang.String.valueOf(r4);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r5, r4);
    L_0x0042:
        r4 = "0";
    L_0x0044:
        r1.a(r3, r4);
        goto L_0x0014;
    L_0x0048:
        r1.a();
        r9 = r1.b();
        com.alibaba.sdk.android.feedback.xblink.f.c.a(r8, r9);
        return;
    L_0x0053:
        r9 = move-exception;
        r0 = d;
        r9 = java.lang.String.valueOf(r9);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r9);
        r9 = "{}";
        com.alibaba.sdk.android.feedback.xblink.f.c.b(r8, r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.a.d(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }
}
