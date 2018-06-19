package com.xunlei.downloadprovider.pushmessage.report;

import android.text.TextUtils;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.pushmessage.p;
import java.util.List;
import org.json.JSONObject;

/* compiled from: PushNetworkHelper */
public final class b extends e {
    public final void a(boolean z, String str, String str2, String str3, String str4, String str5, String str6, List<String> list, String str7, boolean z2) {
        XLThreadPool.execute(new c(this, str2, str3, str4, str5, str6, list, str7, str, z, z2));
    }

    public final void a(boolean z) {
        XLThreadPool.execute(new f(this, z));
    }

    private static org.json.JSONObject b(boolean r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0028 }
        r1.<init>();	 Catch:{ JSONException -> 0x0028 }
        r2 = "uid";	 Catch:{ JSONException -> 0x0028 }
        r3 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ JSONException -> 0x0028 }
        r3 = r3.g;	 Catch:{ JSONException -> 0x0028 }
        r3 = r3.c();	 Catch:{ JSONException -> 0x0028 }
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x0028 }
        r2 = "success";	 Catch:{ JSONException -> 0x0028 }
        r1.put(r2, r5);	 Catch:{ JSONException -> 0x0028 }
        r5 = "detail";	 Catch:{ JSONException -> 0x0028 }
        r1.put(r5, r6);	 Catch:{ JSONException -> 0x0028 }
        r5 = "data";	 Catch:{ JSONException -> 0x0028 }
        r0.put(r5, r1);	 Catch:{ JSONException -> 0x0028 }
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.report.b.b(boolean, java.lang.String):org.json.JSONObject");
    }

    private static org.json.JSONObject b(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.util.List<java.lang.String> r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0056 }
        r1.<init>();	 Catch:{ JSONException -> 0x0056 }
        r2 = "peerid";	 Catch:{ JSONException -> 0x0056 }
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x0056 }
        r3 = "uid";	 Catch:{ JSONException -> 0x0056 }
        r1.put(r3, r4);	 Catch:{ JSONException -> 0x0056 }
        r3 = "services_id";	 Catch:{ JSONException -> 0x0056 }
        r1.put(r3, r5);	 Catch:{ JSONException -> 0x0056 }
        r3 = "status";	 Catch:{ JSONException -> 0x0056 }
        r1.put(r3, r6);	 Catch:{ JSONException -> 0x0056 }
        r3 = "detail";	 Catch:{ JSONException -> 0x0056 }
        r1.put(r3, r7);	 Catch:{ JSONException -> 0x0056 }
        r3 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0056 }
        r3.<init>();	 Catch:{ JSONException -> 0x0056 }
        r4 = r8.iterator();	 Catch:{ JSONException -> 0x0056 }
    L_0x002c:
        r5 = r4.hasNext();	 Catch:{ JSONException -> 0x0056 }
        if (r5 == 0) goto L_0x003c;	 Catch:{ JSONException -> 0x0056 }
    L_0x0032:
        r5 = r4.next();	 Catch:{ JSONException -> 0x0056 }
        r5 = (java.lang.String) r5;	 Catch:{ JSONException -> 0x0056 }
        r3.put(r5);	 Catch:{ JSONException -> 0x0056 }
        goto L_0x002c;	 Catch:{ JSONException -> 0x0056 }
    L_0x003c:
        r4 = "tags";	 Catch:{ JSONException -> 0x0056 }
        r1.put(r4, r3);	 Catch:{ JSONException -> 0x0056 }
        if (r9 == 0) goto L_0x0048;	 Catch:{ JSONException -> 0x0056 }
    L_0x0043:
        r3 = "pusher";	 Catch:{ JSONException -> 0x0056 }
        r1.put(r3, r9);	 Catch:{ JSONException -> 0x0056 }
    L_0x0048:
        r3 = "time";	 Catch:{ JSONException -> 0x0056 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x0056 }
        r1.put(r3, r4);	 Catch:{ JSONException -> 0x0056 }
        r3 = "data";	 Catch:{ JSONException -> 0x0056 }
        r0.put(r3, r1);	 Catch:{ JSONException -> 0x0056 }
    L_0x0056:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.report.b.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String):org.json.JSONObject");
    }

    static /* synthetic */ void a(b bVar, boolean z, JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, boolean z2) {
        JSONObject jSONObject2 = jSONObject;
        String str8 = str4;
        String str9 = str7;
        if (jSONObject2 != null) {
            CharSequence optString = jSONObject2.optString("result");
            if (!TextUtils.isEmpty(optString) && ITagManager.SUCCESS.equals(optString)) {
                com.xunlei.downloadprovider.pushmessage.b.b a = com.xunlei.downloadprovider.pushmessage.b.b.a();
                if (a.a != null) {
                    a.a.edit().putInt("last_register_version_code", 11100).apply();
                }
                if (z) {
                    a = com.xunlei.downloadprovider.pushmessage.b.b.a();
                    LoginHelper.a();
                    a.a(l.c());
                    return;
                }
                if ("upush".equals(str9)) {
                    com.xunlei.downloadprovider.pushmessage.b.b.a().a("umeng_register_id", str8);
                }
                if ("mipush".equals(str9)) {
                    com.xunlei.downloadprovider.pushmessage.b.b.a().a("xiao_mi_register_id", str8);
                }
                if ("hwpush".equals(str9)) {
                    com.xunlei.downloadprovider.pushmessage.b.b.a().a("huawei_register_id", str8);
                }
                return;
            }
        }
        if (z2) {
            bVar.a(z, str, str2, str3, str8, str5, str6, list, str9, false);
        }
    }

    static /* synthetic */ void a(b bVar, JSONObject jSONObject, boolean z) {
        boolean z2 = false;
        if (jSONObject == null && z) {
            bVar.a(false);
            return;
        }
        CharSequence optString = jSONObject.optString("result");
        if (TextUtils.isEmpty(optString) || !ITagManager.SUCCESS.equals(optString)) {
            if (z) {
                bVar.a(false);
            }
            return;
        }
        bVar = jSONObject.optJSONObject("data");
        if (bVar != null) {
            bVar = bVar.optJSONArray("tags");
            if (!(bVar == null || bVar.length() == null)) {
                String[] strArr = new String[bVar.length()];
                while (z2 < bVar.length()) {
                    strArr[z2] = (String) bVar.opt(z2);
                    z2++;
                }
                p.a(strArr);
            }
        }
    }
}
