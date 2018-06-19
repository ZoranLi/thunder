package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.l;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: ChoicenessRecommendUserView */
final class ai implements a {
    final /* synthetic */ int a;
    final /* synthetic */ l.a b;
    final /* synthetic */ b c;

    ai(b bVar, int i, l.a aVar) {
        this.c = bVar;
        this.a = i;
        this.b = aVar;
    }

    public final void a() {
        this.c.a(true);
        ChoicenessReporter.a(this.c.g.c, this.a, this.b, true, true);
    }

    public final void a(String str) {
        if (b.a(this.b.a) == null) {
            this.c.a(false);
        }
        ChoicenessReporter.a(this.c.g.c, this.a, this.b, true, false);
    }
}
