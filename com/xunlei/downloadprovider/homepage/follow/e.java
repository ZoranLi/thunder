package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.payment.a.e$f;
import java.util.List;

/* compiled from: FollowManager */
public final class e implements e$f<Integer, List<a>, String, Boolean> {
    final /* synthetic */ com.xunlei.downloadprovider.member.payment.a.e.a a;
    final /* synthetic */ b b;

    public e(b bVar, com.xunlei.downloadprovider.member.payment.a.e.a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public final /* synthetic */ void a(Object obj, Object obj2, Object obj3, Object obj4) {
        List list = (List) obj2;
        this.b.h.clear();
        this.b.h.addAll(list);
        this.a.a();
    }

    public final void a(String str) {
        this.a.a(str);
    }
}
