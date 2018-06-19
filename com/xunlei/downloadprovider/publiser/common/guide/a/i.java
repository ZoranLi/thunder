package com.xunlei.downloadprovider.publiser.common.guide.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.common.browser.WebViewADActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.launch.dispatch.c;
import com.xunlei.downloadprovider.launch.dispatch.t;

/* compiled from: GuideNewUserDispatchBusiness */
public final class i extends a {
    private String c;

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final boolean d() {
        return true;
    }

    public final int f() {
        return 10;
    }

    public final void a(Context context) {
        if (!TextUtils.isEmpty(this.c)) {
            if (!b(context)) {
                WebViewADActivity.startWebViewADActivity(context, "promote_channel_launch", this.c, null, null);
            }
            e();
            m.a().b();
        }
    }

    private boolean b(Context context) {
        try {
            Intent parseUri = Intent.parseUri(this.c, 1);
            c cVar = new c();
            cVar.a(new t());
            return cVar.a(context, parseUri);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public final boolean a() {
        this.c = d.a().f.d();
        return (!super.a() || f.b(BrothersApplication.getApplicationInstance(), "guide_new_user_dispatch_show") || TextUtils.isEmpty(this.c)) ? false : true;
    }

    public final void e() {
        f.a(BrothersApplication.getApplicationInstance(), "guide_new_user_dispatch_show", true);
    }
}
