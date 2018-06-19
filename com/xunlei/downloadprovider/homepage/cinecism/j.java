package com.xunlei.downloadprovider.homepage.cinecism;

import com.xunlei.downloadprovider.homepage.cinecism.a.a.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: CinecismDetailActivity */
final class j implements c<a> {
    final /* synthetic */ CinecismDetailActivity a;

    j(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        a aVar = (a) obj;
        if (aVar != null) {
            if (aVar.a()) {
                this.a.t = 2;
                this.a.f = aVar.c;
                this.a.g = aVar.b;
                this.a.b();
                CinecismDetailActivity.c(this.a);
                CinecismDetailActivity.d(this.a);
                return;
            }
        }
        this.a.h();
        this.a.t = 1;
    }

    public final void onFail(String str) {
        this.a.t = 1;
        this.a.h();
    }
}
