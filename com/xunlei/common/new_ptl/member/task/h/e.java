package com.xunlei.common.new_ptl.member.task.h;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.a.q;
import com.xunlei.common.new_ptl.member.act.XLXmLoginActivity;
import com.xunlei.common.new_ptl.member.act.XLXmParam;
import com.xunlei.common.new_ptl.member.task.a;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;

/* compiled from: UserXmLoginTask */
public final class e extends a {
    private int a;
    private int b;
    private int c;
    private String d;
    private int e;
    private XLXmParam f;
    private q g;
    private int h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;

    public final void a() {
        super.a();
    }

    public final void b(Object obj) {
        this.f = (XLXmParam) obj;
    }

    public e(p pVar) {
        super(pVar);
        this.e = 0;
        this.f = null;
        this.g = new q(this);
        this.h = 0;
        this.i = "";
        this.j = "";
        this.k = "";
        this.m = "";
        this.n = "";
        this.e = ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE;
    }

    public final boolean h() {
        if (this.e == ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE) {
            Intent intent = new Intent(p.a().h(), XLXmLoginActivity.class);
            intent.putExtra("xm_task", g());
            intent.putExtra("xm_client_from", this.f.mLoginReqFrom);
            intent.addFlags(268435456);
            d().h().startActivity(intent);
            XLLog.v("UserXmLoginTask", " step get xiaomi token.");
        } else if (this.e == 4133) {
            d().a("8", this.i, this.j, this.k, this.g, (Object) "get-client-sessionid", true);
            XLLog.v("UserXmLoginTask", " step get client session.");
        }
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserThirdLogin(bundle.getInt("errorCode"), bundle.getString("errorDesc"), this.n, e(), 8, this.h, f(), g());
            }
        }
        return null;
    }

    public final void a(int i, String str, String str2) {
        this.e = 4134;
        this.m = str;
        this.n = str2;
        g(i);
    }

    public final void f(int i) {
        this.h = i;
    }

    public final void a(int i, String str, String str2, String str3) {
        XLStatPack xLStatPack = new XLStatPack();
        xLStatPack.mCommandID = XLStatCommandID.XLCID_XM_LOGIN_AUTH;
        xLStatPack.mErrorCode = i;
        xLStatPack.mFlowId = System.currentTimeMillis();
        xLStatPack.mFinal = 1;
        XLStatUtil.getInstance().report(g(), xLStatPack);
        XLStatUtil.getInstance().registerStatReq(g());
        if (i == 0) {
            this.e = 4133;
            this.i = str;
            this.j = str2;
            this.k = str3;
            d().n().postDelayed(new 1(this), null);
        } else {
            g(i);
        }
        d().b(g());
    }

    private void g(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.m)) {
            this.m = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.m);
        d().a((a) this, bundle);
    }
}
