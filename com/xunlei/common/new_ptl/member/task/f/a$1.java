package com.xunlei.common.new_ptl.member.task.f;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;

/* compiled from: UserPortalTask */
final class a$1 extends b {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void a(int r1, org.apache.http.Header[] r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0027 }
        r1.<init>(r3);	 Catch:{ JSONException -> 0x0027 }
        r2 = "errorCode";	 Catch:{ JSONException -> 0x0027 }
        r2 = r1.getInt(r2);	 Catch:{ JSONException -> 0x0027 }
        if (r2 != 0) goto L_0x0026;	 Catch:{ JSONException -> 0x0027 }
    L_0x000d:
        r2 = "loginSrvIpList";	 Catch:{ JSONException -> 0x0027 }
        r2 = r1.optJSONArray(r2);	 Catch:{ JSONException -> 0x0027 }
        r3 = "portalSrvIpList";	 Catch:{ JSONException -> 0x0027 }
        r1 = r1.optJSONArray(r3);	 Catch:{ JSONException -> 0x0027 }
        r3 = r0.a;	 Catch:{ JSONException -> 0x0027 }
        r3 = r3.d();	 Catch:{ JSONException -> 0x0027 }
        r3 = r3.k();	 Catch:{ JSONException -> 0x0027 }
        r3.a(r2, r1);	 Catch:{ JSONException -> 0x0027 }
    L_0x0026:
        return;
    L_0x0027:
        r1 = r0.a;
        r1 = com.xunlei.common.new_ptl.member.task.f.a.a(r1);
        r2 = "portal response body unpack error!";
        com.xunlei.common.base.XLLog.v(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.f.a$1.a(int, org.apache.http.Header[], java.lang.String):void");
    }

    public final void a(Throwable th) {
        String b = a.b(this.a);
        StringBuilder stringBuilder = new StringBuilder("portal error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(b, stringBuilder.toString());
    }
}
