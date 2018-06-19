package com.xunlei.downloadprovidershare.a;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.downloadprovidershare.redpacket.g;
import com.xunlei.downloadprovidershare.z.a;

/* compiled from: ShareVideoInfo */
final class j implements a {
    final /* synthetic */ com.xunlei.downloadprovidershare.a.a a;
    final /* synthetic */ Context b;
    final /* synthetic */ i c;

    j(i iVar, com.xunlei.downloadprovidershare.a.a aVar, Context context) {
        this.c = iVar;
        this.a = aVar;
        this.b = context;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.a(false, this.c);
            return;
        }
        this.c.f = i.a(this.c, str);
        if (this.c.d() != null) {
            new g(this.b, this.c, new k(this)).show();
        } else {
            this.a.a(true, this.c);
        }
    }
}
