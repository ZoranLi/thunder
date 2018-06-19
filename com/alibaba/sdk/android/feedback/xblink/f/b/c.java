package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.alibaba.sdk.android.feedback.xblink.i.g;

public class c extends a {
    private int a(String str) {
        String[] split = str.split("\\.");
        String[] split2 = "0.2.0".split("\\.");
        int i = 0;
        int i2 = 0;
        while (i2 < split.length) {
            Integer valueOf = Integer.valueOf(Integer.parseInt(split[i2]));
            Integer valueOf2 = Integer.valueOf(0);
            if (i2 < split2.length) {
                valueOf2 = Integer.valueOf(Integer.parseInt(split2[i2]));
            }
            if (valueOf.intValue() > valueOf2.intValue()) {
                i = 1;
                break;
            } else if (valueOf.intValue() < valueOf2.intValue()) {
                i = -1;
                break;
            } else {
                i2++;
            }
        }
        return (i != 0 || split2.length <= split.length) ? i : -1;
    }

    private void a(com.alibaba.sdk.android.feedback.xblink.f.b r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new com.alibaba.sdk.android.feedback.xblink.f.m;
        r0.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0043 }
        r1.<init>(r4);	 Catch:{ JSONException -> 0x0043 }
        r4 = "version";	 Catch:{ JSONException -> 0x0043 }
        r4 = r1.has(r4);	 Catch:{ JSONException -> 0x0043 }
        if (r4 == 0) goto L_0x0019;	 Catch:{ JSONException -> 0x0043 }
    L_0x0012:
        r4 = "version";	 Catch:{ JSONException -> 0x0043 }
        r4 = r1.getString(r4);	 Catch:{ JSONException -> 0x0043 }
        goto L_0x001a;
    L_0x0019:
        r4 = 0;
    L_0x001a:
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 == 0) goto L_0x0029;
    L_0x0020:
        r4 = "HY_PARAM_ERR";
        r0.a(r4);
        r3.b(r0);
        return;
    L_0x0029:
        r4 = r2.a(r4);	 Catch:{ Exception -> 0x003a }
        r1 = "isHigher";
        r4 = java.lang.String.valueOf(r4);
        r0.a(r1, r4);
        r3.a(r0);
        return;
    L_0x003a:
        r4 = "HY_PARAM_ERR";
        r0.a(r4);
        r3.b(r0);
        return;
    L_0x0043:
        r4 = "HY_PARAM_ERR";
        r0.a(r4);
        r3.b(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.b.c.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    private void b(b bVar, String str) {
        m mVar = new m();
        mVar.a("os", DispatchConstants.ANDROID);
        mVar.a("version", "0.2.0");
        mVar.a("clientversion", "1");
        mVar.a("osversion", VERSION.RELEASE);
        if (g.a()) {
            g.a("Base", "getVersion: version=4.5.1");
        }
        bVar.a(mVar);
    }

    public boolean a(String str, String str2, b bVar) {
        if ("getVersion".equals(str)) {
            b(bVar, str2);
        } else if (!"checkXBlinkSDK".equals(str)) {
            return false;
        } else {
            a(bVar, str2);
        }
        return true;
    }
}
