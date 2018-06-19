package com.xunlei.common.new_ptl.member.task.h;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdTypeId;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.act.XLAlipayLoginActivity;
import com.xunlei.common.new_ptl.member.act.XLAlipayParam;
import com.xunlei.common.new_ptl.member.act.XLThirdLoginBindMobileActivity;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserAlipayLoginTask */
public final class a extends com.xunlei.common.new_ptl.member.task.a implements com.xunlei.common.new_ptl.member.task.helpertask.a {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private XLAlipayParam h;
    private int i;
    private String j;
    private String k;

    public a(p pVar) {
        super(pVar);
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = "";
        this.k = "";
        this.e = 255;
    }

    public final void a() {
        super.a();
    }

    public final boolean h() {
        if (255 == this.e) {
            Intent intent = new Intent(p.a().h(), XLAlipayLoginActivity.class);
            intent.putExtra("ali_task", g());
            intent.putExtra("ali_auth_param", this.h);
            intent.addFlags(268435456);
            d().h().startActivity(intent);
            XLLog.v("UserAlipayLoginTask ", "get alipay auth code.");
        } else if (256 == this.e) {
            JSONObject j = j();
            try {
                j.put("thirdType", XLThirdTypeId.getXLThirdTypeName(4));
                j.put("code", this.f);
                j.put("thirdAppId", getThirdAppId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            d().k().a(j.toString().getBytes(), 11, new 1(this));
        }
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserThirdLogin(bundle.getInt("errorCode"), bundle.getString("errorDesc"), this.k, e(), 4, this.i, f(), g());
            }
        }
        return null;
    }

    public final void b(Object obj) {
        this.h = (XLAlipayParam) obj;
    }

    public final void b(int i, String str, String str2) {
        XLStatPack xLStatPack = new XLStatPack();
        xLStatPack.mCommandID = XLStatCommandID.XLCID_ALIPAY_LOGIN_AUTH;
        xLStatPack.mErrorCode = i;
        xLStatPack.mFlowId = System.currentTimeMillis();
        xLStatPack.mFinal = 1;
        XLStatUtil.getInstance().report(g(), xLStatPack);
        XLStatUtil.getInstance().registerStatReq(g());
        if (i == 0) {
            this.f = str;
            this.g = str2;
            this.e = 256;
            h();
            return;
        }
        this.e = 258;
        f(i);
    }

    public final void a(int i, String str, String str2) {
        XLLog.e("UserAlipayLoginTask", "recieve client session.");
        this.e = 258;
        this.j = str;
        this.k = str2;
        f(i);
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.j)) {
            this.j = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.j);
        d().a((com.xunlei.common.new_ptl.member.task.a) this, bundle);
        d().b(g());
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(d().h(), XLThirdLoginBindMobileActivity.class);
        intent.putExtra("XL_BIND_MOBILE_TASK_ID", g());
        intent.putExtra("XL_BIND_MOBILE_TASK_URL", str);
        intent.addFlags(268435456);
        d().h().startActivity(intent);
        return true;
    }

    public final String getThirdAppId() {
        return this.g;
    }

    public final void onThirdLoginBindMobile(int i, String str, String str2, String str3, int i2) {
        if (i == 0) {
            b(str3);
        } else {
            f(com.xunlei.common.new_ptl.member.task.a.e(i));
        }
    }

    private void b(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00de }
        r0.<init>(r9);	 Catch:{ Exception -> 0x00de }
        r9 = "errorCode";	 Catch:{ Exception -> 0x00de }
        r9 = r0.getInt(r9);	 Catch:{ Exception -> 0x00de }
        if (r9 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x00de }
    L_0x000d:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x00de }
        if (r9 >= r1) goto L_0x001d;	 Catch:{ Exception -> 0x00de }
    L_0x0011:
        r1 = "errorDesc";	 Catch:{ Exception -> 0x00de }
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x00de }
        r1 = com.xunlei.common.base.XLUtilTools.transformUTF8String(r1);	 Catch:{ Exception -> 0x00de }
        r8.j = r1;	 Catch:{ Exception -> 0x00de }
    L_0x001d:
        r1 = "errorDescUrl";	 Catch:{ Exception -> 0x00de }
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x00de }
        r8.k = r1;	 Catch:{ Exception -> 0x00de }
        if (r9 != 0) goto L_0x009c;	 Catch:{ Exception -> 0x00de }
    L_0x0027:
        r9 = r8.e();	 Catch:{ Exception -> 0x00de }
        r9.clearUserData();	 Catch:{ Exception -> 0x00de }
        r9 = r8.d();	 Catch:{ Exception -> 0x00de }
        r1 = "secureKey";	 Catch:{ Exception -> 0x00de }
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x00de }
        r9.b(r1);	 Catch:{ Exception -> 0x00de }
        r9 = r8.e();	 Catch:{ Exception -> 0x00de }
        r9.a(r0);	 Catch:{ Exception -> 0x00de }
        r9 = "first_login";	 Catch:{ Exception -> 0x00de }
        r1 = 0;	 Catch:{ Exception -> 0x00de }
        r9 = r0.optInt(r9, r1);	 Catch:{ Exception -> 0x00de }
        r8.i = r9;	 Catch:{ Exception -> 0x00de }
        r9 = "loginKey";	 Catch:{ Exception -> 0x00de }
        r7 = r0.optString(r9);	 Catch:{ Exception -> 0x00de }
        r9 = new com.xunlei.common.new_ptl.member.a.d;	 Catch:{ Exception -> 0x00de }
        r0 = r8.e();	 Catch:{ Exception -> 0x00de }
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.UserID;	 Catch:{ Exception -> 0x00de }
        r3 = r0.getLongValue(r2);	 Catch:{ Exception -> 0x00de }
        r5 = "";	 Catch:{ Exception -> 0x00de }
        r6 = "";	 Catch:{ Exception -> 0x00de }
        r2 = r9;	 Catch:{ Exception -> 0x00de }
        r2.<init>(r3, r5, r6, r7);	 Catch:{ Exception -> 0x00de }
        r0 = r8.d();	 Catch:{ Exception -> 0x00de }
        r0 = r0.h();	 Catch:{ Exception -> 0x00de }
        r2 = com.xunlei.common.new_ptl.member.a.d.a.a;	 Catch:{ Exception -> 0x00de }
        com.xunlei.common.new_ptl.member.a.d.a(r9, r0, r2);	 Catch:{ Exception -> 0x00de }
        r9 = r8.e();	 Catch:{ Exception -> 0x00de }
        r0 = r8.d();	 Catch:{ Exception -> 0x00de }
        r0 = r0.h();	 Catch:{ Exception -> 0x00de }
        r9.a(r0);	 Catch:{ Exception -> 0x00de }
        r9 = r8.c();	 Catch:{ Exception -> 0x00de }
        r0 = com.xunlei.common.new_ptl.member.task.a.a.d;	 Catch:{ Exception -> 0x00de }
        if (r9 == r0) goto L_0x0091;	 Catch:{ Exception -> 0x00de }
    L_0x0089:
        r9 = r8.d();	 Catch:{ Exception -> 0x00de }
        r0 = 1;	 Catch:{ Exception -> 0x00de }
        r9.a(r0, r1);	 Catch:{ Exception -> 0x00de }
    L_0x0091:
        r8.f(r1);	 Catch:{ Exception -> 0x00de }
        r9 = com.xunlei.common.new_ptl.member.a.p.a();	 Catch:{ Exception -> 0x00de }
        r9.o();	 Catch:{ Exception -> 0x00de }
        return;	 Catch:{ Exception -> 0x00de }
    L_0x009c:
        r1 = 18;	 Catch:{ Exception -> 0x00de }
        if (r9 != r1) goto L_0x00da;	 Catch:{ Exception -> 0x00de }
    L_0x00a0:
        r9 = "mobileBindUrl";	 Catch:{ Exception -> 0x00de }
        r9 = r0.optString(r9);	 Catch:{ Exception -> 0x00de }
        r0 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x00de }
        if (r0 != 0) goto L_0x00d9;	 Catch:{ Exception -> 0x00de }
    L_0x00ac:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00de }
        r1 = r8.d();	 Catch:{ Exception -> 0x00de }
        r1 = r1.h();	 Catch:{ Exception -> 0x00de }
        r2 = com.xunlei.common.new_ptl.member.act.XLThirdLoginBindMobileActivity.class;	 Catch:{ Exception -> 0x00de }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x00de }
        r1 = "XL_BIND_MOBILE_TASK_ID";	 Catch:{ Exception -> 0x00de }
        r2 = r8.g();	 Catch:{ Exception -> 0x00de }
        r0.putExtra(r1, r2);	 Catch:{ Exception -> 0x00de }
        r1 = "XL_BIND_MOBILE_TASK_URL";	 Catch:{ Exception -> 0x00de }
        r0.putExtra(r1, r9);	 Catch:{ Exception -> 0x00de }
        r9 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x00de }
        r0.addFlags(r9);	 Catch:{ Exception -> 0x00de }
        r9 = r8.d();	 Catch:{ Exception -> 0x00de }
        r9 = r9.h();	 Catch:{ Exception -> 0x00de }
        r9.startActivity(r0);	 Catch:{ Exception -> 0x00de }
    L_0x00d9:
        return;	 Catch:{ Exception -> 0x00de }
    L_0x00da:
        r8.f(r9);	 Catch:{ Exception -> 0x00de }
        return;
    L_0x00de:
        r9 = 16781314; // 0x1001002 float:2.3521372E-38 double:8.2910707E-317;
        r8.f(r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.h.a.b(java.lang.String):void");
    }
}
