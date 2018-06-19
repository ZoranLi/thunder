package com.xunlei.common.new_ptl.member.task.d;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.d;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.act.XLLoginVerifyMobileActivity;
import com.xunlei.common.new_ptl.member.task.a;
import com.xunlei.common.new_ptl.member.task.helpertask.c;

/* compiled from: UserLoginTask */
public final class b extends a implements c {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private long g = 0;
    private XLOnUserListener h = new 1(this);

    public b(p pVar) {
        super(pVar);
    }

    public final void a() {
        super.a();
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void a(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "userLoginTask") {
                return xLOnUserListener.onUserLogin(bundle.getInt("errorCode"), bundle.getString("errorDesc"), this.f, e(), f(), g());
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
        r5 = this;
        r0 = r5.a;
        r0 = android.text.TextUtils.isEmpty(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x000e;
    L_0x0009:
        r0 = 2;
        r5.f(r0);
        return r1;
    L_0x000e:
        r0 = r5.b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = 3;
        r5.f(r0);
        return r1;
    L_0x001b:
        r0 = r5.i();
        r2 = "userName";	 Catch:{ JSONException -> 0x0078 }
        r3 = r5.a;	 Catch:{ JSONException -> 0x0078 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0078 }
        r2 = "passWord";	 Catch:{ JSONException -> 0x0078 }
        r3 = r5.b;	 Catch:{ JSONException -> 0x0078 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0078 }
        r2 = "verifyKey";	 Catch:{ JSONException -> 0x0078 }
        r3 = r5.c;	 Catch:{ JSONException -> 0x0078 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0078 }
        r2 = "verifyCode";	 Catch:{ JSONException -> 0x0078 }
        r3 = r5.d;	 Catch:{ JSONException -> 0x0078 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0078 }
        r2 = "isMd5Pwd";	 Catch:{ JSONException -> 0x0078 }
        r3 = "0";	 Catch:{ JSONException -> 0x0078 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0078 }
        r1 = com.xunlei.common.new_ptl.member.task.a.a.b;
        r5.a(r1);
        r0 = r0.toString();
        r1 = "UserLoginTask";
        r2 = new java.lang.StringBuilder;
        r3 = "login request body = ";
        r2.<init>(r3);
        r2.append(r0);
        r2 = r2.toString();
        com.xunlei.common.base.XLLog.v(r1, r2);
        r1 = r5.d();
        r1 = r1.k();
        r0 = r0.getBytes();
        r2 = new com.xunlei.common.new_ptl.member.task.d.b$2;
        r2.<init>(r5);
        r3 = r5.g();
        r4 = 1;
        r1.a(r0, r4, r2, r3);
        return r4;
    L_0x0078:
        r0 = 16781315; // 0x1001003 float:2.3521375E-38 double:8.291071E-317;
        r5.f(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.d.b.h():boolean");
    }

    private void f(int i) {
        if (a.b(i)) {
            d.a(d().h(), d.a.b);
        }
        if (a.c(i)) {
            e().clearUserData();
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "userLoginTask");
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.e)) {
            this.e = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.e);
        d().a((a) this, bundle);
        d().b(g());
    }

    private void a(String str, long j) {
        Intent intent = new Intent(d().h(), XLLoginVerifyMobileActivity.class);
        intent.putExtra("XL_VERIFY_MOBILE_TASK_ID", g());
        intent.putExtra("XL_VERIFY_MOBILE_TASK_URL", str);
        intent.putExtra("XL_VERIFY_MOBILE_TASK_UID", j);
        intent.addFlags(268435456);
        d().h().startActivity(intent);
    }

    public final void onUserVerifyMobileCallBack(int i, String str, String str2, long j, String str3, Object obj, int i2) {
        if (i != 0) {
            f(i);
        } else if (TextUtils.isEmpty(str3) == 0) {
            d.a(new d(this.g, "", "", str3), d().h(), d.a.a);
            e().clearUserData();
            d().a(true, this.h, (Object) "xl-verify-mobile-auto-login");
        } else {
            f(XLErrorCode.AQ_USER_VERIFY_MOBILE_ERROR);
        }
    }

    static /* synthetic */ void a(b bVar, String str, long j) {
        Intent intent = new Intent(bVar.d().h(), XLLoginVerifyMobileActivity.class);
        intent.putExtra("XL_VERIFY_MOBILE_TASK_ID", bVar.g());
        intent.putExtra("XL_VERIFY_MOBILE_TASK_URL", str);
        intent.putExtra("XL_VERIFY_MOBILE_TASK_UID", j);
        intent.addFlags(268435456);
        bVar.d().h().startActivity(intent);
    }
}
