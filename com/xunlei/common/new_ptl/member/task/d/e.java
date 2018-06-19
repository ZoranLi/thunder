package com.xunlei.common.new_ptl.member.task.d;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.d;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserSessionidLoginTask */
public final class e extends a {
    private boolean a;
    private long b = 0;
    private String c = "";
    private int d = null;
    private int e = 1;
    private String f = "";
    private String g = "";

    public final void b(boolean z) {
    }

    public e(p pVar) {
        super(pVar);
    }

    public final void a() {
        super.a();
    }

    public final void a(long j, String str, int i, int i2) {
        this.b = j;
        this.c = str;
        this.d = i;
        this.e = i2;
    }

    public final boolean h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = com.xunlei.common.new_ptl.member.task.a.a.d;
        r1 = r5.c();
        r2 = 0;
        if (r0 != r1) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r0 = com.xunlei.common.new_ptl.member.task.a.a.b;
        r5.a(r0);
        r0 = r5.i();
        r1 = "userID";	 Catch:{ JSONException -> 0x006d }
        r3 = r5.b;	 Catch:{ JSONException -> 0x006d }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ JSONException -> 0x006d }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x006d }
        r1 = "sessionID";	 Catch:{ JSONException -> 0x006d }
        r3 = r5.c;	 Catch:{ JSONException -> 0x006d }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x006d }
        r1 = "sessionType";	 Catch:{ JSONException -> 0x006d }
        r3 = r5.e;	 Catch:{ JSONException -> 0x006d }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ JSONException -> 0x006d }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x006d }
        r1 = "sessionFromAppid";	 Catch:{ JSONException -> 0x006d }
        r3 = r5.d;	 Catch:{ JSONException -> 0x006d }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ JSONException -> 0x006d }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x006d }
        r0 = r0.toString();
        r1 = "UserSessionidLoginTask";
        r2 = new java.lang.StringBuilder;
        r3 = "request package = ";
        r2.<init>(r3);
        r2.append(r0);
        r2 = r2.toString();
        com.xunlei.common.base.XLLog.v(r1, r2);
        r1 = r5.d();
        r1 = r1.k();
        r0 = r0.getBytes();
        r2 = 2;
        r3 = new com.xunlei.common.new_ptl.member.task.d.e$1;
        r3.<init>(r5);
        r4 = r5.g();
        r1.a(r0, r2, r3, r4);
        r0 = 1;
        return r0;
    L_0x006d:
        r0 = 16781315; // 0x1001003 float:2.3521375E-38 double:8.291071E-317;
        r5.f(r0);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.d.e.h():boolean");
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "UserSessionidLoginTask") {
                return xLOnUserListener.onUserSessionidLogin(bundle.getInt("errorCode"), bundle.getString("errorDesc"), this.g, e(), f(), g());
            }
        }
        return null;
    }

    private void f(int i) {
        if (a.b(i)) {
            d.a(d().h(), d.a.b);
        }
        if (a.c(i)) {
            e().clearUserData();
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserSessionidLoginTask");
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.f)) {
            this.f = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.f);
        d().a((a) this, bundle);
    }
}
