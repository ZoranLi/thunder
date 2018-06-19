package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.f;
import com.xunlei.downloadprovider.member.payment.a.e$e;
import com.xunlei.downloadprovider.member.payment.a.e$f;
import java.util.Iterator;
import java.util.List;

/* compiled from: FollowManager */
public final class z implements e$f<Integer, List<a>, String, Boolean> {
    final /* synthetic */ e$e a;
    final /* synthetic */ b b;

    public z(b bVar, e$e com_xunlei_downloadprovider_member_payment_a_e_e) {
        this.b = bVar;
        this.a = com_xunlei_downloadprovider_member_payment_a_e_e;
    }

    public final /* synthetic */ void a(Object obj, Object obj2, Object obj3, Object obj4) {
        a aVar;
        Integer num = (Integer) obj;
        List<a> list = (List) obj2;
        String str = (String) obj3;
        Boolean bool = (Boolean) obj4;
        this.b.f = num.intValue();
        obj = this.b;
        for (a aVar2 : list) {
            long j = aVar2.b;
            f fVar = (f) obj.j.get(Long.valueOf(j));
            if (fVar == null) {
                fVar = new f(j, aVar2.i, aVar2.i);
                obj.j.put(Long.valueOf(j), fVar);
                b.a(new f(obj, fVar));
            } else if (aVar2.i > fVar.c) {
                f fVar2 = new f(j, aVar2.i, fVar.d);
                obj.j.put(Long.valueOf(j), fVar2);
                b.a(new g(obj, fVar2));
            }
        }
        for (a aVar3 : list) {
            aVar3.i -= this.b.a(aVar3.b);
        }
        obj = this.b;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aVar2 = (a) it.next();
            if (obj.i.contains(Long.valueOf(aVar2.b))) {
                it.remove();
            } else {
                obj.h.add(aVar2);
            }
        }
        this.a.a(list, str, bool);
    }

    public final void a(String str) {
        this.a.a();
    }
}
