package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.k;
import java.util.List;

/* compiled from: ChoicenessDataHelper */
public final class b implements com.xunlei.downloadprovider.search.b.b<k> {
    final /* synthetic */ ChoicenessReporter$RefreshType a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    public b(a aVar, ChoicenessReporter$RefreshType choicenessReporter$RefreshType, a aVar2) {
        this.c = aVar;
        this.a = choicenessReporter$RefreshType;
        this.b = aVar2;
    }

    public final /* synthetic */ void a(Object obj) {
        List a;
        k kVar = (k) obj;
        if (kVar != null) {
            List list = kVar.a;
            if (list != null) {
                new StringBuilder("refreshDataFromServer onDataResponse--size=").append(list.size());
            }
            a.a(this.c, kVar.b);
            a.a(this.c, kVar.e);
            if (!(list == null || list.isEmpty())) {
                a.e();
                a.a(this.c, false, list);
            }
            a = a.a(this.c, this.a, kVar);
            if (!(list == null || list.isEmpty())) {
                this.c.a(kVar.h);
            }
            if (kVar.a()) {
                a.b(this.c, kVar.d);
                if (this.c.c <= 0) {
                    a.c(this.c, kVar.c);
                }
            }
        } else {
            a = null;
        }
        a aVar = this.c;
        this.a.isAutoRefresh();
        aVar.b();
        a.b(this.c, ChoicenessReporter.a(this.a), a);
        this.b.a(this.c.e, kVar);
    }
}
