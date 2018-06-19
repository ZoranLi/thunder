package com.xunlei.downloadprovider.publiser.common.guide.interesttag;

import com.xunlei.downloadprovider.publiser.common.guide.interesttag.c.a;
import java.util.List;

/* compiled from: GuideInterestTagPresenter */
public final class b implements a {
    private com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.a a = null;
    private com.xunlei.downloadprovider.publiser.common.guide.interesttag.c.b b = null;

    public b(com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.a aVar, com.xunlei.downloadprovider.publiser.common.guide.interesttag.c.b bVar) {
        this.a = aVar;
        this.b = bVar;
    }

    public final void a() {
        List a = this.a.a();
        if (a != null) {
            this.b.a(a);
        }
        this.a.a(a);
        this.b.b(false);
    }

    public final void b() {
        List c = this.a.c();
        boolean isEmpty = c.isEmpty() ^ 1;
        if (isEmpty) {
            this.a.b();
            this.a.b(c);
        }
        this.b.a(isEmpty);
    }

    public final void a(com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.b bVar, boolean z) {
        if (z) {
            this.a.a(bVar);
        } else {
            this.a.b(bVar);
        }
        this.b.b(this.a.c().isEmpty() ^ 1);
    }
}
