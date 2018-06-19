package com.xunlei.downloadprovidershare.a;

import android.text.TextUtils;
import com.xunlei.downloadprovidershare.z.a;

/* compiled from: ShareDownloadTaskInfo */
final class e implements a {
    final /* synthetic */ com.xunlei.downloadprovidershare.a.a a;
    final /* synthetic */ c b;

    e(c cVar, com.xunlei.downloadprovidershare.a.a aVar) {
        this.b = cVar;
        this.a = aVar;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.a(false, this.b);
            return;
        }
        this.b.f = c.a(this.b, str);
        this.a.a(true, this.b);
    }
}
