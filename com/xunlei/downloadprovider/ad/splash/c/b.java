package com.xunlei.downloadprovider.ad.splash.c;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.List;

/* compiled from: SplashAdModel */
final class b implements a {
    final /* synthetic */ long a;
    final /* synthetic */ a b;

    b(a aVar, long j) {
        this.b = aVar;
        this.a = j;
    }

    public final void a(List<l> list) {
        if (this.b.h.a(this.a)) {
            a.a(this.b, (List) list);
            this.b.d();
        }
    }

    public final void a(int i, String str) {
        if (this.b.h.a(this.a)) {
            StringBuilder stringBuilder = new StringBuilder("onLoadFail. errorCode: ");
            stringBuilder.append(i);
            stringBuilder.append(" errorInfo: ");
            stringBuilder.append(str);
            this.b.a(i, str);
            this.b.d();
        }
    }
}
