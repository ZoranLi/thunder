package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.b;
import java.util.List;

/* compiled from: ChoicenessDataHelper */
final class g implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ b b;

    g(b bVar, List list) {
        this.b = bVar;
        this.a = list;
    }

    public final void run() {
        if (this.b.b.e.isEmpty()) {
            boolean z = e.a().e.a().l != 0;
            a aVar = null;
            if (z && this.a != null && !this.a.isEmpty() && this.a.size() >= 3) {
                l lVar = f.a(BrothersApplication.getApplicationInstance()).c.e;
                if (lVar != null) {
                    aVar = new b();
                    aVar.l = "advertisement";
                    StringBuilder stringBuilder = new StringBuilder("first_ad_");
                    stringBuilder.append(System.currentTimeMillis());
                    aVar.i = stringBuilder.toString();
                    f.a(lVar);
                    f.a(lVar, aVar);
                }
                if (aVar != null) {
                    aVar.j = ChoicenessReporter$RefreshType.auto_pull;
                    this.a.add(3, aVar);
                }
            }
            a.a(this.b.b, true, this.a);
            a.a(this.b.b, this.a);
            this.b.b.b = this.b.b.h.a.getLong("maxId", 0);
            this.b.b.c = this.b.b.h.a.getLong("minId", 0);
            this.b.b.b();
            if (z && aVar != null) {
                com.xunlei.downloadprovider.ad.home.a.a("0", ChoicenessReporter.a(aVar));
            }
            this.b.a.a(this.b.b.e);
        }
    }
}
