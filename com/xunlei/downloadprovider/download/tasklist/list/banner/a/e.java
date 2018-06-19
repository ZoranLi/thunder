package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import com.android.volley.Request;
import com.xunlei.common.net.volley.BaseStringRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: GiftQualificationManager */
public final class e implements c, d, g {
    private static e f = new e();
    public g a;
    public volatile boolean b;
    public boolean c;
    public long d;
    private d e;

    private e() {
        this.c = false;
        this.a = new g();
        this.e = new d();
        this.e.a = this;
        LoginHelper.a().a((d) this);
        LoginHelper.a().a((g) this);
    }

    public static e c() {
        return f;
    }

    public final void b(int i) {
        this.a.a(i);
    }

    public static void d() {
        f.a();
    }

    public final void a() {
        this.b = true;
    }

    public final void b() {
        this.b = false;
    }

    public final void a(int i) {
        this.a.a(i);
    }

    public final void onLogout() {
        this.b = false;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (z) {
            LoginHelper.a();
            z = l.c() && LoginHelper.a().l();
            if (z && this.a.c()) {
                z = this.e;
                Request baseStringRequest = new BaseStringRequest(String.format("http://msg.vip.xunlei.com/shoulei/giftValid?userid=%s&sessionid=%s", new Object[]{Long.valueOf(LoginHelper.a().g.c()), LoginHelper.a().c()}), z, z);
                baseStringRequest.setShouldCache(false);
                VolleyRequestManager.getMainThreadRequestQueue().a(baseStringRequest);
            }
        }
    }
}
