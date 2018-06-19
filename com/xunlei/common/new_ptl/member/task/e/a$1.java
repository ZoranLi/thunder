package com.xunlei.common.new_ptl.member.task.e;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserMobileLoginTask */
final class a$1 extends b {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void a(int r8, org.apache.http.Header[] r9, java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r8 = com.xunlei.common.new_ptl.member.task.e.a.m();
        com.xunlei.common.base.XLLog.v(r8, r10);
        r8 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00df }
        r8.<init>(r10);	 Catch:{ JSONException -> 0x00df }
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r10 = "errorCode";	 Catch:{ JSONException -> 0x00df }
        r10 = r8.getInt(r10);	 Catch:{ JSONException -> 0x00df }
        r9 = com.xunlei.common.new_ptl.member.task.e.a.a(r9, r10);	 Catch:{ JSONException -> 0x00df }
        if (r9 == 0) goto L_0x002d;	 Catch:{ JSONException -> 0x00df }
    L_0x001a:
        r10 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ JSONException -> 0x00df }
        if (r9 >= r10) goto L_0x002d;	 Catch:{ JSONException -> 0x00df }
    L_0x001e:
        r10 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r0 = "errorDesc";	 Catch:{ JSONException -> 0x00df }
        r0 = r8.optString(r0);	 Catch:{ JSONException -> 0x00df }
        r0 = com.xunlei.common.base.XLUtilTools.transformUTF8String(r0);	 Catch:{ JSONException -> 0x00df }
        com.xunlei.common.new_ptl.member.task.e.a.a(r10, r0);	 Catch:{ JSONException -> 0x00df }
    L_0x002d:
        r10 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r0 = "errorDescUrl";	 Catch:{ JSONException -> 0x00df }
        r0 = r8.optString(r0);	 Catch:{ JSONException -> 0x00df }
        com.xunlei.common.new_ptl.member.task.e.a.b(r10, r0);	 Catch:{ JSONException -> 0x00df }
        if (r9 != 0) goto L_0x00d9;	 Catch:{ JSONException -> 0x00df }
    L_0x003a:
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = com.xunlei.common.new_ptl.member.task.e.a.a(r9);	 Catch:{ JSONException -> 0x00df }
        r10 = 0;	 Catch:{ JSONException -> 0x00df }
        r0 = 1;	 Catch:{ JSONException -> 0x00df }
        if (r9 == 0) goto L_0x0054;	 Catch:{ JSONException -> 0x00df }
    L_0x0044:
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = com.xunlei.common.new_ptl.member.task.e.a.a(r9);	 Catch:{ JSONException -> 0x00df }
        if (r9 != r0) goto L_0x00cc;	 Catch:{ JSONException -> 0x00df }
    L_0x004c:
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = com.xunlei.common.new_ptl.member.task.e.a.b(r9);	 Catch:{ JSONException -> 0x00df }
        if (r9 == 0) goto L_0x00cc;	 Catch:{ JSONException -> 0x00df }
    L_0x0054:
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = r9.e();	 Catch:{ JSONException -> 0x00df }
        r9.clearUserData();	 Catch:{ JSONException -> 0x00df }
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = r9.d();	 Catch:{ JSONException -> 0x00df }
        r1 = "secureKey";	 Catch:{ JSONException -> 0x00df }
        r1 = r8.optString(r1);	 Catch:{ JSONException -> 0x00df }
        r9.b(r1);	 Catch:{ JSONException -> 0x00df }
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = r9.e();	 Catch:{ JSONException -> 0x00df }
        r9.a(r8);	 Catch:{ JSONException -> 0x00df }
        r9 = "loginKey";	 Catch:{ JSONException -> 0x00df }
        r6 = r8.optString(r9);	 Catch:{ JSONException -> 0x00df }
        r8 = android.text.TextUtils.isEmpty(r6);	 Catch:{ JSONException -> 0x00df }
        if (r8 != 0) goto L_0x00a6;	 Catch:{ JSONException -> 0x00df }
    L_0x0081:
        r8 = new com.xunlei.common.new_ptl.member.a.d;	 Catch:{ JSONException -> 0x00df }
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = r9.e();	 Catch:{ JSONException -> 0x00df }
        r1 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.UserID;	 Catch:{ JSONException -> 0x00df }
        r2 = r9.getLongValue(r1);	 Catch:{ JSONException -> 0x00df }
        r4 = "";	 Catch:{ JSONException -> 0x00df }
        r5 = "";	 Catch:{ JSONException -> 0x00df }
        r1 = r8;	 Catch:{ JSONException -> 0x00df }
        r1.<init>(r2, r4, r5, r6);	 Catch:{ JSONException -> 0x00df }
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = r9.d();	 Catch:{ JSONException -> 0x00df }
        r9 = r9.h();	 Catch:{ JSONException -> 0x00df }
        r1 = com.xunlei.common.new_ptl.member.a.d.a.b;	 Catch:{ JSONException -> 0x00df }
        com.xunlei.common.new_ptl.member.a.d.a(r8, r9, r1);	 Catch:{ JSONException -> 0x00df }
    L_0x00a6:
        r8 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r8 = r8.e();	 Catch:{ JSONException -> 0x00df }
        r9 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r9 = r9.d();	 Catch:{ JSONException -> 0x00df }
        r9 = r9.h();	 Catch:{ JSONException -> 0x00df }
        r8.a(r9);	 Catch:{ JSONException -> 0x00df }
        r8 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r8 = r8.c();	 Catch:{ JSONException -> 0x00df }
        r9 = com.xunlei.common.new_ptl.member.task.a.a.d;	 Catch:{ JSONException -> 0x00df }
        if (r8 == r9) goto L_0x00cc;	 Catch:{ JSONException -> 0x00df }
    L_0x00c3:
        r8 = r7.a;	 Catch:{ JSONException -> 0x00df }
        r8 = r8.d();	 Catch:{ JSONException -> 0x00df }
        r8.a(r0, r10);	 Catch:{ JSONException -> 0x00df }
    L_0x00cc:
        r8 = r7.a;	 Catch:{ JSONException -> 0x00df }
        com.xunlei.common.new_ptl.member.task.e.a.b(r8, r10);	 Catch:{ JSONException -> 0x00df }
        r8 = com.xunlei.common.new_ptl.member.a.p.a();	 Catch:{ JSONException -> 0x00df }
        r8.o();	 Catch:{ JSONException -> 0x00df }
        goto L_0x00e7;	 Catch:{ JSONException -> 0x00df }
    L_0x00d9:
        r8 = r7.a;	 Catch:{ JSONException -> 0x00df }
        com.xunlei.common.new_ptl.member.task.e.a.b(r8, r9);	 Catch:{ JSONException -> 0x00df }
        goto L_0x00e7;
    L_0x00df:
        r8 = r7.a;
        r9 = 16781314; // 0x1001002 float:2.3521372E-38 double:8.2910707E-317;
        com.xunlei.common.new_ptl.member.task.e.a.b(r8, r9);
    L_0x00e7:
        r8 = r7.a;
        r9 = com.xunlei.common.new_ptl.member.task.a.a.c;
        r8.a(r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.e.a$1.a(int, org.apache.http.Header[], java.lang.String):void");
    }

    public final void a(Throwable th) {
        String m = a.m();
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e(m, stringBuilder.toString());
        a.b(this.a, a.a(th));
        this.a.a(a.a.c);
    }
}
