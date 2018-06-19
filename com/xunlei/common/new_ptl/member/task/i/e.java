package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserGetUserInfoTask */
public final class e extends a {
    private int[] a = new int[]{2};
    private String b = "";
    private String c = "";

    public e(p pVar) {
        super(pVar);
    }

    public final void a() {
        super.a();
    }

    public final void a(int... iArr) {
        this.a = iArr;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "userGetDetailTask") {
                return xLOnUserListener.onUserInfoCatched(bundle.getInt("errorCode"), bundle.getString("errorDesc"), this.c, e(), f(), g());
            }
        }
        return null;
    }

    public final boolean h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.d();
        r0 = r0.r();
        r1 = 0;
        if (r0 != 0) goto L_0x0012;
    L_0x000b:
        r0 = 16781313; // 0x1001001 float:2.352137E-38 double:8.29107E-317;
        r7.f(r0);
        return r1;
    L_0x0012:
        r0 = com.xunlei.common.new_ptl.member.task.a.a.b;
        r7.a(r0);
        r0 = r7.i();
        r2 = "userID";	 Catch:{ JSONException -> 0x0090 }
        r3 = r7.e();	 Catch:{ JSONException -> 0x0090 }
        r4 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.UserID;	 Catch:{ JSONException -> 0x0090 }
        r3 = r3.getLongValue(r4);	 Catch:{ JSONException -> 0x0090 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ JSONException -> 0x0090 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0090 }
        r2 = "sessionID";	 Catch:{ JSONException -> 0x0090 }
        r3 = r7.e();	 Catch:{ JSONException -> 0x0090 }
        r4 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.SessionID;	 Catch:{ JSONException -> 0x0090 }
        r3 = r3.getStringValue(r4);	 Catch:{ JSONException -> 0x0090 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0090 }
        r2 = new java.lang.StringBuffer;	 Catch:{ JSONException -> 0x0090 }
        r2.<init>();	 Catch:{ JSONException -> 0x0090 }
        r3 = r7.a;	 Catch:{ JSONException -> 0x0090 }
        r4 = r3.length;	 Catch:{ JSONException -> 0x0090 }
        r5 = r1;	 Catch:{ JSONException -> 0x0090 }
    L_0x0046:
        if (r5 >= r4) goto L_0x0055;	 Catch:{ JSONException -> 0x0090 }
    L_0x0048:
        r6 = r3[r5];	 Catch:{ JSONException -> 0x0090 }
        r2.append(r6);	 Catch:{ JSONException -> 0x0090 }
        r6 = ",";	 Catch:{ JSONException -> 0x0090 }
        r2.append(r6);	 Catch:{ JSONException -> 0x0090 }
        r5 = r5 + 1;	 Catch:{ JSONException -> 0x0090 }
        goto L_0x0046;	 Catch:{ JSONException -> 0x0090 }
    L_0x0055:
        r3 = "vasid";	 Catch:{ JSONException -> 0x0090 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0090 }
        r0.put(r3, r2);	 Catch:{ JSONException -> 0x0090 }
        r0 = r0.toString();
        r1 = "UserGetUserInfoTask";
        r2 = new java.lang.StringBuilder;
        r3 = "request package = ";
        r2.<init>(r3);
        r2.append(r0);
        r2 = r2.toString();
        com.xunlei.common.base.XLLog.v(r1, r2);
        r1 = r7.d();
        r1 = r1.k();
        r0 = r0.getBytes();
        r2 = 4;
        r3 = new com.xunlei.common.new_ptl.member.task.i.e$1;
        r3.<init>(r7);
        r4 = r7.g();
        r1.a(r0, r2, r3, r4);
        r0 = 1;
        return r0;
    L_0x0090:
        r0 = 16781315; // 0x1001003 float:2.3521375E-38 double:8.291071E-317;
        r7.f(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.i.e.h():boolean");
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "userGetDetailTask");
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.b)) {
            this.b = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.b);
        d().a((a) this, bundle);
    }
}
