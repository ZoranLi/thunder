package com.xunlei.downloadprovider.homepage.choiceness;

import com.xunlei.downloadprovider.homepage.choiceness.jointactivity.g;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessVipRenewalRemindItemView;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.b.a.a;
import com.xunlei.downloadprovider.member.b.c;
import com.xunlei.downloadprovider.member.b.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ChoicenessVipRenewalHelper */
final class l implements a {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void i() {
        k kVar = this.a;
        if (kVar.d == null) {
            kVar.d = c.a(kVar.h);
        }
        d b = kVar.d.b("13");
        if (!(b.a() || kVar.e == null)) {
            kVar.c();
        }
        if (b.a()) {
            if (kVar.e != null) {
                kVar.f = true;
                kVar.c();
                kVar.f = false;
            }
            kVar.e = new ChoicenessVipRenewalRemindItemView(kVar.a, b, kVar);
            if (kVar.b != null) {
                kVar.b.a(kVar.e);
                if (kVar.g != null) {
                    kVar.g.a();
                }
            }
            q.a("home_collect", b.f());
            g gVar = kVar.i;
            gVar.b().edit().putString("renew_banner_show", new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date())).commit();
        }
        if (this.a.i != null) {
            this.a.i.a(this.a.b);
        }
    }

    public final void j() {
        if (this.a.i != null) {
            this.a.i.a(this.a.b);
        }
    }
}
