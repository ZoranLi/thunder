package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FollowManager */
final class u implements c<List<a>> {
    final /* synthetic */ List a;
    final /* synthetic */ e.a b;
    final /* synthetic */ b c;

    u(b bVar, List list, e.a aVar) {
        this.c = bVar;
        this.a = list;
        this.b = aVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List arrayList = new ArrayList(((List) obj).size());
        for (a aVar : this.a) {
            if (!this.c.b(aVar.b)) {
                aVar.h = System.currentTimeMillis() / 1000;
                b.a(this.c, aVar);
                arrayList.add(String.valueOf(aVar.b));
            }
        }
        b.a(new v(this, arrayList));
        ab.a().a(false, arrayList);
        this.b.a();
    }

    public final void onFail(String str) {
        this.b.a(str);
    }
}
