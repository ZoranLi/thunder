package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: FollowManager */
public final class j implements e$d<List<a>, Boolean> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    public j(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj;
        if (list != null && list.size() > 0) {
            this.b.c.a(((a) list.get(0)).m);
        }
        com.xunlei.downloadprovider.homepage.follow.b.c cVar = new com.xunlei.downloadprovider.homepage.follow.b.c();
        cVar.a = list;
        cVar.b = false;
        this.a.onSuccess(cVar);
    }

    public final void a(String str) {
        this.a.onFail(str);
    }
}
