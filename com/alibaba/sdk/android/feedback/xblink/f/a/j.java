package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;

public class j extends a {
    private void a(com.alibaba.sdk.android.feedback.xblink.f.b r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0018 }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x0018 }
        r3 = "code";	 Catch:{ JSONException -> 0x0018 }
        r0.optInt(r3);	 Catch:{ JSONException -> 0x0018 }
        r3 = "msg";	 Catch:{ JSONException -> 0x0018 }
        r0.getString(r3);	 Catch:{ JSONException -> 0x0018 }
        r3 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ JSONException -> 0x0018 }
        r3.<init>();	 Catch:{ JSONException -> 0x0018 }
        r2.a(r3);	 Catch:{ JSONException -> 0x0018 }
        return;
    L_0x0018:
        r3 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r3.<init>();
        r0 = "HY_PARAM_ERR";
        r3.a(r0);
        r2.b(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.j.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public boolean a(String str, String str2, b bVar) {
        if (!"onLoginStatus".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
