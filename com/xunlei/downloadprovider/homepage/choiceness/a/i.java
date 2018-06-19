package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.k;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.search.b.b;
import com.xunlei.xllib.b.d;

/* compiled from: ChoicenessDynamicRecommendHelper */
public final class i implements b<k> {
    final /* synthetic */ m a;
    final /* synthetic */ h b;

    public i(h hVar, m mVar) {
        this.b = hVar;
        this.a = mVar;
    }

    public final /* synthetic */ void a(Object obj) {
        k kVar = (k) obj;
        if (kVar.a() && !d.a(kVar.a)) {
            e eVar = (e) kVar.a.get(0);
            if (eVar instanceof m) {
                m mVar = (m) eVar;
                mVar.d = true;
                if (h.a(this.b, this.a, mVar)) {
                    this.b.i = eVar;
                    this.b.e = eVar;
                }
            }
        }
        this.b.a(2);
    }
}
