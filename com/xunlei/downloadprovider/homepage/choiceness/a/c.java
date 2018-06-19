package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.k;
import com.xunlei.downloadprovider.search.b.b;
import java.util.List;

/* compiled from: ChoicenessDataHelper */
public final class c implements b<k> {
    final /* synthetic */ ChoicenessReporter$RefreshType a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    public c(a aVar, ChoicenessReporter$RefreshType choicenessReporter$RefreshType, a aVar2) {
        this.c = aVar;
        this.a = choicenessReporter$RefreshType;
        this.b = aVar2;
    }

    public final /* synthetic */ void a(Object obj) {
        List b;
        k kVar = (k) obj;
        if (kVar != null) {
            List list = kVar.a;
            a.a(this.c, false, list);
            a.a(this.c, kVar.b);
            a.a(this.c, kVar.e);
            b = a.b(this.c, this.a, kVar);
            if (kVar.a()) {
                a.c(this.c, kVar.c);
            }
            if (!(list == null || list.isEmpty())) {
                this.c.a(kVar.h);
            }
        } else {
            b = null;
        }
        this.c.b();
        a.b(this.c, ChoicenessReporter.a(this.a), b);
        this.b.a(this.c.e, kVar);
    }
}
