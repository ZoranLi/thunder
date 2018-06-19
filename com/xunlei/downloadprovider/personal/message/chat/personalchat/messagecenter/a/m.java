package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.ad;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a.b;
import com.xunlei.downloadprovider.personal.message.data.d;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper;

/* compiled from: MessageCenterModel */
public final class m extends b implements c {
    public final void a() {
        f a = f.a();
        a.b();
        a.b = new j();
        a.c = new e();
        a.d = new o();
        a.e = new l();
        a.a = new k();
        a.f.add(a.c);
        a.f.add(a.d);
        a.f.add(a.e);
        a.f.add(a.b);
        a.a(3);
        a.a(2);
    }

    public final void a(i iVar) {
        f.a().registerObserver(iVar);
    }

    public final void b(i iVar) {
        try {
            f.a().unregisterObserver(iVar);
        } catch (i iVar2) {
            iVar2.printStackTrace();
        }
    }

    public final void a(ad adVar) {
        LoginHelper.a();
        if (l.c()) {
            d.a(BrothersApplication.getApplicationInstance()).a(LoginHelper.a().g.c(), adVar);
            return;
        }
        adVar.a();
    }

    public final void a(c<Integer> cVar) {
        LoginHelper.a();
        if (l.c()) {
            VisitorNetworkHelper.a().a(LoginHelper.a().g.c(), new n(this, cVar));
        } else {
            cVar.a(com.xunlei.downloadprovider.personal.message.chat.b.a(-1, "is logout."));
        }
    }
}
