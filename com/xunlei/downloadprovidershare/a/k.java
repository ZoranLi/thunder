package com.xunlei.downloadprovidershare.a;

import android.graphics.Bitmap;
import com.xunlei.downloadprovidershare.redpacket.g.a;

/* compiled from: ShareVideoInfo */
final class k implements a {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void a(boolean z, Bitmap bitmap) {
        if (!z || bitmap == null) {
            this.a.a.a(null, this.a.c);
            return;
        }
        this.a.c.g = bitmap;
        this.a.a.a(true, this.a.c);
    }
}
