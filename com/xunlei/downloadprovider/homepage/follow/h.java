package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.Iterator;
import java.util.List;

/* compiled from: FollowManager */
final class h implements c<List<g>> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    h(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List list = (List) obj;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((g) it.next()).a().size() < 2) {
                it.remove();
            }
        }
        this.b.k = list;
        this.a.onSuccess(list);
    }

    public final void onFail(String str) {
        this.a.onFail(str);
    }
}
