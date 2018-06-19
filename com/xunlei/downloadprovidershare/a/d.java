package com.xunlei.downloadprovidershare.a;

import android.text.TextUtils;
import com.xunlei.downloadprovidershare.a.a;
import com.xunlei.downloadprovidershare.q$a;

/* compiled from: ShareDownloadTaskInfo */
final class d implements q$a {
    final /* synthetic */ a a;
    final /* synthetic */ c b;

    d(c cVar, a aVar) {
        this.b = cVar;
        this.a = aVar;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.a(false, this.b);
            return;
        }
        this.b.f = str;
        this.a.a(true, this.b);
    }
}
