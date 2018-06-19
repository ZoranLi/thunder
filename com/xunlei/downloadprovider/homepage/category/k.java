package com.xunlei.downloadprovider.homepage.category;

import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: ShortVideoCategoryActivity */
final class k implements c<List<e>> {
    final /* synthetic */ g a;

    k(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List list = (List) obj;
        if (this.a.a.i != null) {
            this.a.a.g.a();
            this.a.a.runOnUiThread(new l(this, list));
        }
    }

    public final void onFail(String str) {
        this.a.a.runOnUiThread(new m(this));
    }
}
