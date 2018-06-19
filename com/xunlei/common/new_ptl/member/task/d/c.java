package com.xunlei.common.new_ptl.member.task.d;

import android.os.Bundle;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.o;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserLogoutTask */
public final class c extends a {
    private o a;

    public c(p pVar) {
        super(pVar);
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "UserLogoutTask") {
                return xLOnUserListener.onUserLogout(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.a, f(), g());
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
        r6 = this;
        r0 = r6.e();
        r0 = r0.e();
        r6.a = r0;
        r0 = r6.d();
        r0 = r0.r();
        r1 = 0;
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = 16781313; // 0x1001001 float:2.352137E-38 double:8.29107E-317;
        r6.f(r0);
        return r1;
    L_0x001c:
        r0 = r6.i();	 Catch:{ JSONException -> 0x007f }
        r2 = "userID";	 Catch:{ JSONException -> 0x007f }
        r3 = r6.e();	 Catch:{ JSONException -> 0x007f }
        r4 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.UserID;	 Catch:{ JSONException -> 0x007f }
        r3 = r3.getLongValue(r4);	 Catch:{ JSONException -> 0x007f }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ JSONException -> 0x007f }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x007f }
        r2 = "sessionID";	 Catch:{ JSONException -> 0x007f }
        r3 = r6.e();	 Catch:{ JSONException -> 0x007f }
        r4 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.SessionID;	 Catch:{ JSONException -> 0x007f }
        r3 = r3.getStringValue(r4);	 Catch:{ JSONException -> 0x007f }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x007f }
        r2 = r6.d();	 Catch:{ JSONException -> 0x007f }
        r2 = r2.k();	 Catch:{ JSONException -> 0x007f }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x007f }
        r0 = r0.getBytes();	 Catch:{ JSONException -> 0x007f }
        r3 = 3;	 Catch:{ JSONException -> 0x007f }
        r4 = new com.xunlei.common.new_ptl.member.task.d.c$1;	 Catch:{ JSONException -> 0x007f }
        r4.<init>(r6);	 Catch:{ JSONException -> 0x007f }
        r5 = r6.g();	 Catch:{ JSONException -> 0x007f }
        r2.a(r0, r3, r4, r5);	 Catch:{ JSONException -> 0x007f }
        r0 = r6.e();
        r0.clearUserData();
        r0 = r6.d();
        r0.a(r1, r1);
        r0 = r6.d();
        r0 = r0.h();
        r2 = com.xunlei.common.new_ptl.member.a.d.a.b;
        com.xunlei.common.new_ptl.member.a.d.a(r0, r2);
        r6.f(r1);
        r0 = 1;
        return r0;
    L_0x007f:
        r0 = 16781315; // 0x1001003 float:2.3521375E-38 double:8.291071E-317;
        r6.f(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.d.c.h():boolean");
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserLogoutTask");
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }
}
