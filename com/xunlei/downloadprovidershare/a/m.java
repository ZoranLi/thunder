package com.xunlei.downloadprovidershare.a;

import android.text.TextUtils;
import com.xunlei.downloadprovidershare.ad.a;

/* compiled from: ShareWebsiteInfo */
final class m implements a {
    final /* synthetic */ String a;
    final /* synthetic */ com.xunlei.downloadprovidershare.a.a b;
    final /* synthetic */ l c;

    m(l lVar, String str, com.xunlei.downloadprovidershare.a.a aVar) {
        this.c = lVar;
        this.a = str;
        this.b = aVar;
    }

    public final void a() {
        if (TextUtils.isEmpty(this.a)) {
            this.b.a(false, this.c);
            return;
        }
        this.c.f = this.a;
        this.b.a(true, this.c);
    }
}
