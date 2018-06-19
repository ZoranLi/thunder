package com.xunlei.common.new_ptl.member.task.d;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserTokenLoginTask */
final class f$1 extends b {
    private /* synthetic */ f a;

    f$1(f fVar) {
        this.a = fVar;
    }

    public final void a(int r7, org.apache.http.Header[] r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r7 = "UserTokenLoginTask";
        com.xunlei.common.base.XLLog.v(r7, r9);
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00bf }
        r7.<init>(r9);	 Catch:{ JSONException -> 0x00bf }
        r8 = "errorCode";	 Catch:{ JSONException -> 0x00bf }
        r8 = r7.getInt(r8);	 Catch:{ JSONException -> 0x00bf }
        if (r8 == 0) goto L_0x0025;	 Catch:{ JSONException -> 0x00bf }
    L_0x0012:
        r9 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ JSONException -> 0x00bf }
        if (r8 >= r9) goto L_0x0025;	 Catch:{ JSONException -> 0x00bf }
    L_0x0016:
        r9 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r0 = "errorDesc";	 Catch:{ JSONException -> 0x00bf }
        r0 = r7.optString(r0);	 Catch:{ JSONException -> 0x00bf }
        r0 = com.xunlei.common.base.XLUtilTools.transformUTF8String(r0);	 Catch:{ JSONException -> 0x00bf }
        com.xunlei.common.new_ptl.member.task.d.f.a(r9, r0);	 Catch:{ JSONException -> 0x00bf }
    L_0x0025:
        r9 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r0 = "errorDescUrl";	 Catch:{ JSONException -> 0x00bf }
        r0 = r7.optString(r0);	 Catch:{ JSONException -> 0x00bf }
        com.xunlei.common.new_ptl.member.task.d.f.b(r9, r0);	 Catch:{ JSONException -> 0x00bf }
        if (r8 != 0) goto L_0x00b9;	 Catch:{ JSONException -> 0x00bf }
    L_0x0032:
        r8 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.e();	 Catch:{ JSONException -> 0x00bf }
        r8.clearUserData();	 Catch:{ JSONException -> 0x00bf }
        r8 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.d();	 Catch:{ JSONException -> 0x00bf }
        r9 = "secureKey";	 Catch:{ JSONException -> 0x00bf }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00bf }
        r8.b(r9);	 Catch:{ JSONException -> 0x00bf }
        r8 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.e();	 Catch:{ JSONException -> 0x00bf }
        r8.a(r7);	 Catch:{ JSONException -> 0x00bf }
        r8 = "loginKey";	 Catch:{ JSONException -> 0x00bf }
        r5 = r7.optString(r8);	 Catch:{ JSONException -> 0x00bf }
        r7 = android.text.TextUtils.isEmpty(r5);	 Catch:{ JSONException -> 0x00bf }
        if (r7 != 0) goto L_0x0084;	 Catch:{ JSONException -> 0x00bf }
    L_0x005f:
        r7 = new com.xunlei.common.new_ptl.member.a.d;	 Catch:{ JSONException -> 0x00bf }
        r8 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.e();	 Catch:{ JSONException -> 0x00bf }
        r9 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.UserID;	 Catch:{ JSONException -> 0x00bf }
        r1 = r8.getLongValue(r9);	 Catch:{ JSONException -> 0x00bf }
        r3 = "";	 Catch:{ JSONException -> 0x00bf }
        r4 = "";	 Catch:{ JSONException -> 0x00bf }
        r0 = r7;	 Catch:{ JSONException -> 0x00bf }
        r0.<init>(r1, r3, r4, r5);	 Catch:{ JSONException -> 0x00bf }
        r8 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.d();	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.h();	 Catch:{ JSONException -> 0x00bf }
        r9 = com.xunlei.common.new_ptl.member.a.d.a.b;	 Catch:{ JSONException -> 0x00bf }
        com.xunlei.common.new_ptl.member.a.d.a(r7, r8, r9);	 Catch:{ JSONException -> 0x00bf }
    L_0x0084:
        r7 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r7 = r7.e();	 Catch:{ JSONException -> 0x00bf }
        r8 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.d();	 Catch:{ JSONException -> 0x00bf }
        r8 = r8.h();	 Catch:{ JSONException -> 0x00bf }
        r7.a(r8);	 Catch:{ JSONException -> 0x00bf }
        r7 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r7 = r7.c();	 Catch:{ JSONException -> 0x00bf }
        r8 = com.xunlei.common.new_ptl.member.task.a.a.d;	 Catch:{ JSONException -> 0x00bf }
        r9 = 0;	 Catch:{ JSONException -> 0x00bf }
        if (r7 == r8) goto L_0x00ac;	 Catch:{ JSONException -> 0x00bf }
    L_0x00a2:
        r7 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        r7 = r7.d();	 Catch:{ JSONException -> 0x00bf }
        r8 = 1;	 Catch:{ JSONException -> 0x00bf }
        r7.a(r8, r9);	 Catch:{ JSONException -> 0x00bf }
    L_0x00ac:
        r7 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        com.xunlei.common.new_ptl.member.task.d.f.a(r7, r9);	 Catch:{ JSONException -> 0x00bf }
        r7 = com.xunlei.common.new_ptl.member.a.p.a();	 Catch:{ JSONException -> 0x00bf }
        r7.o();	 Catch:{ JSONException -> 0x00bf }
        goto L_0x00c7;	 Catch:{ JSONException -> 0x00bf }
    L_0x00b9:
        r7 = r6.a;	 Catch:{ JSONException -> 0x00bf }
        com.xunlei.common.new_ptl.member.task.d.f.a(r7, r8);	 Catch:{ JSONException -> 0x00bf }
        goto L_0x00c7;
    L_0x00bf:
        r7 = r6.a;
        r8 = 16781314; // 0x1001002 float:2.3521372E-38 double:8.2910707E-317;
        com.xunlei.common.new_ptl.member.task.d.f.a(r7, r8);
    L_0x00c7:
        r7 = r6.a;
        r8 = com.xunlei.common.new_ptl.member.task.a.a.c;
        r7.a(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.d.f$1.a(int, org.apache.http.Header[], java.lang.String):void");
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserTokenLoginTask", stringBuilder.toString());
        f.a(this.a, a.a(th));
        this.a.a(a.a.c);
    }
}
