package com.xunlei.downloadprovider.launch.guide;

import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.common.i.a;
import com.xunlei.downloadprovider.launch.guide.p.b;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: GuideLoginHelper */
public class d implements a {
    private static final String e = "d";
    m a = null;
    b b = null;
    h c;
    com.xunlei.downloadprovider.member.login.b.d d;
    private boolean f;
    private i g = null;

    public d(m mVar, b bVar) {
        this.a = mVar;
        this.b = bVar;
    }

    public final void b() {
        if (this.g != null) {
            this.g.b(this);
            this.g.d.cancel();
            this.g = null;
        }
    }

    public final void g_() {
        this.a.f();
    }

    static /* synthetic */ void c(d dVar) {
        if (com.xunlei.downloadprovider.d.d.a().e.b() == 0) {
            dVar.a.f();
        } else {
            r.a().a(new i(dVar));
        }
    }
}
