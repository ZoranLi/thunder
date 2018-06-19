package com.xunlei.common.new_ptl.member.task.h;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdTypeId;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.act.XLThirdLoginBindMobileActivity;
import com.xunlei.common.new_ptl.member.act.XLWxParam;
import com.xunlei.common.new_ptl.member.task.a;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserWxLoginTask */
public final class d extends a implements com.xunlei.common.new_ptl.member.task.helpertask.a {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private XLWxParam f;
    private String g;
    private IWXAPI h;
    private int i;
    private String j;
    private String k;

    public d(p pVar) {
        super(pVar);
        this.e = 0;
        this.f = null;
        this.g = "";
        this.h = null;
        this.i = 0;
        this.j = "";
        this.k = "";
        this.e = 255;
    }

    public final void a() {
        super.a();
    }

    public final void b(Object obj) {
        this.f = (XLWxParam) obj;
    }

    public final void a(int i, String str) {
        XLLog.e("UserWxLoginTask", "recieve wx code.");
        XLStatPack xLStatPack = new XLStatPack();
        xLStatPack.mCommandID = XLStatCommandID.XLCID_WX_LOGIN_AUTH;
        xLStatPack.mErrorCode = i;
        xLStatPack.mFlowId = System.currentTimeMillis();
        xLStatPack.mFinal = 1;
        XLStatUtil.getInstance().report(g(), xLStatPack);
        XLStatUtil.getInstance().registerStatReq(g());
        if (i == 0) {
            this.g = str;
            this.e = 256;
            p.a().n().postDelayed(new 1(this), 0);
            return;
        }
        f(i);
    }

    public final void a(int i, String str, String str2) {
        XLLog.e("UserWxLoginTask", "recieve client session.");
        this.e = 258;
        this.j = str;
        this.k = str2;
        f(i);
    }

    public final boolean h() {
        if (a.a.d == c()) {
            return false;
        }
        a(a.a.b);
        if (this.e == 255) {
            XLLog.e("UserWxLoginTask", "get wx code.");
            this.h = WXAPIFactory.createWXAPI(d().h(), this.f.mWxAppId, false);
            this.h.registerApp(this.f.mWxAppId);
            if (this.h.isWXAppInstalled()) {
                BaseReq req = new Req();
                req.scope = "snsapi_userinfo";
                StringBuilder stringBuilder = new StringBuilder("xl_sdk_get_access_code#");
                stringBuilder.append(g());
                req.transaction = stringBuilder.toString();
                req.state = String.valueOf(g());
                if (!this.h.sendReq(req)) {
                    f(XLErrorCode.WX_REQ_FAIL);
                }
            } else {
                f(XLErrorCode.WX_NOT_INSTALLED);
            }
        } else if (this.e == 256) {
            XLLog.e("UserWxLoginTask", "get web session.");
            JSONObject j = j();
            try {
                j.put("thirdType", XLThirdTypeId.getXLThirdTypeName(21));
                j.put("code", this.g);
                j.put("thirdAppId", getThirdAppId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            d().k().a(j.toString().getBytes(), 11, new 2(this));
        }
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserThirdLogin(bundle.getInt("errorCode"), bundle.getString("errorDesc"), this.k, e(), 21, this.i, f(), g());
            }
        }
        return null;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.j)) {
            this.j = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.j);
        d().a((a) this, bundle);
        d().b(g());
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Intent intent = new Intent(d().h(), XLThirdLoginBindMobileActivity.class);
        intent.putExtra("XL_BIND_MOBILE_TASK_ID", g());
        intent.putExtra("XL_BIND_MOBILE_TASK_URL", str);
        intent.addFlags(268435456);
        d().h().startActivity(intent);
        return true;
    }

    public final String getThirdAppId() {
        return this.f.mWxAppId;
    }

    public final void onThirdLoginBindMobile(int i, String str, String str2, String str3, int i2) {
        str2 = new StringBuilder("onThirdLoginBindMobileCallBack error = ");
        str2.append(i);
        XLLog.v("UserWxLoginTask", str2.toString());
        if (i == 0) {
            b(str3);
        } else {
            f(a.e(i));
        }
    }

    private void b(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00de }
        r0.<init>(r8);	 Catch:{ Exception -> 0x00de }
        r8 = "errorCode";	 Catch:{ Exception -> 0x00de }
        r8 = r0.getInt(r8);	 Catch:{ Exception -> 0x00de }
        if (r8 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x00de }
    L_0x000d:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x00de }
        if (r8 >= r1) goto L_0x001d;	 Catch:{ Exception -> 0x00de }
    L_0x0011:
        r1 = "errorDesc";	 Catch:{ Exception -> 0x00de }
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x00de }
        r1 = com.xunlei.common.base.XLUtilTools.transformUTF8String(r1);	 Catch:{ Exception -> 0x00de }
        r7.j = r1;	 Catch:{ Exception -> 0x00de }
    L_0x001d:
        r1 = "errorDescUrl";	 Catch:{ Exception -> 0x00de }
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x00de }
        r7.k = r1;	 Catch:{ Exception -> 0x00de }
        if (r8 != 0) goto L_0x009c;	 Catch:{ Exception -> 0x00de }
    L_0x0027:
        r8 = r7.e();	 Catch:{ Exception -> 0x00de }
        r8.clearUserData();	 Catch:{ Exception -> 0x00de }
        r8 = r7.d();	 Catch:{ Exception -> 0x00de }
        r1 = "secureKey";	 Catch:{ Exception -> 0x00de }
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x00de }
        r8.b(r1);	 Catch:{ Exception -> 0x00de }
        r8 = r7.e();	 Catch:{ Exception -> 0x00de }
        r8.a(r0);	 Catch:{ Exception -> 0x00de }
        r8 = "loginKey";	 Catch:{ Exception -> 0x00de }
        r6 = r0.optString(r8);	 Catch:{ Exception -> 0x00de }
        r8 = new com.xunlei.common.new_ptl.member.a.d;	 Catch:{ Exception -> 0x00de }
        r1 = r7.e();	 Catch:{ Exception -> 0x00de }
        r2 = com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY.UserID;	 Catch:{ Exception -> 0x00de }
        r2 = r1.getLongValue(r2);	 Catch:{ Exception -> 0x00de }
        r4 = "";	 Catch:{ Exception -> 0x00de }
        r5 = "";	 Catch:{ Exception -> 0x00de }
        r1 = r8;	 Catch:{ Exception -> 0x00de }
        r1.<init>(r2, r4, r5, r6);	 Catch:{ Exception -> 0x00de }
        r1 = r7.d();	 Catch:{ Exception -> 0x00de }
        r1 = r1.h();	 Catch:{ Exception -> 0x00de }
        r2 = com.xunlei.common.new_ptl.member.a.d.a.a;	 Catch:{ Exception -> 0x00de }
        com.xunlei.common.new_ptl.member.a.d.a(r8, r1, r2);	 Catch:{ Exception -> 0x00de }
        r8 = r7.e();	 Catch:{ Exception -> 0x00de }
        r1 = r7.d();	 Catch:{ Exception -> 0x00de }
        r1 = r1.h();	 Catch:{ Exception -> 0x00de }
        r8.a(r1);	 Catch:{ Exception -> 0x00de }
        r8 = "first_login";	 Catch:{ Exception -> 0x00de }
        r1 = 0;	 Catch:{ Exception -> 0x00de }
        r8 = r0.optInt(r8, r1);	 Catch:{ Exception -> 0x00de }
        r7.i = r8;	 Catch:{ Exception -> 0x00de }
        r8 = r7.c();	 Catch:{ Exception -> 0x00de }
        r0 = com.xunlei.common.new_ptl.member.task.a.a.d;	 Catch:{ Exception -> 0x00de }
        if (r8 == r0) goto L_0x0091;	 Catch:{ Exception -> 0x00de }
    L_0x0089:
        r8 = r7.d();	 Catch:{ Exception -> 0x00de }
        r0 = 1;	 Catch:{ Exception -> 0x00de }
        r8.a(r0, r1);	 Catch:{ Exception -> 0x00de }
    L_0x0091:
        r7.f(r1);	 Catch:{ Exception -> 0x00de }
        r8 = com.xunlei.common.new_ptl.member.a.p.a();	 Catch:{ Exception -> 0x00de }
        r8.o();	 Catch:{ Exception -> 0x00de }
        return;	 Catch:{ Exception -> 0x00de }
    L_0x009c:
        r1 = 18;	 Catch:{ Exception -> 0x00de }
        if (r8 != r1) goto L_0x00da;	 Catch:{ Exception -> 0x00de }
    L_0x00a0:
        r8 = "mobileBindUrl";	 Catch:{ Exception -> 0x00de }
        r8 = r0.optString(r8);	 Catch:{ Exception -> 0x00de }
        r0 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Exception -> 0x00de }
        if (r0 != 0) goto L_0x00d9;	 Catch:{ Exception -> 0x00de }
    L_0x00ac:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00de }
        r1 = r7.d();	 Catch:{ Exception -> 0x00de }
        r1 = r1.h();	 Catch:{ Exception -> 0x00de }
        r2 = com.xunlei.common.new_ptl.member.act.XLThirdLoginBindMobileActivity.class;	 Catch:{ Exception -> 0x00de }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x00de }
        r1 = "XL_BIND_MOBILE_TASK_ID";	 Catch:{ Exception -> 0x00de }
        r2 = r7.g();	 Catch:{ Exception -> 0x00de }
        r0.putExtra(r1, r2);	 Catch:{ Exception -> 0x00de }
        r1 = "XL_BIND_MOBILE_TASK_URL";	 Catch:{ Exception -> 0x00de }
        r0.putExtra(r1, r8);	 Catch:{ Exception -> 0x00de }
        r8 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x00de }
        r0.addFlags(r8);	 Catch:{ Exception -> 0x00de }
        r8 = r7.d();	 Catch:{ Exception -> 0x00de }
        r8 = r8.h();	 Catch:{ Exception -> 0x00de }
        r8.startActivity(r0);	 Catch:{ Exception -> 0x00de }
    L_0x00d9:
        return;	 Catch:{ Exception -> 0x00de }
    L_0x00da:
        r7.f(r8);	 Catch:{ Exception -> 0x00de }
        return;
    L_0x00de:
        r8 = 16781314; // 0x1001002 float:2.3521372E-38 double:8.2910707E-317;
        r7.f(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.h.d.b(java.lang.String):void");
    }
}
