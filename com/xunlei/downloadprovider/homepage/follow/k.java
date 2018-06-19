package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import java.util.List;

/* compiled from: FollowManager */
public final class k implements e$d<List<d>, Boolean> {
    final /* synthetic */ e$d a;
    final /* synthetic */ b b;

    public k(b bVar, e$d com_xunlei_downloadprovider_member_payment_a_e_d) {
        this.b = bVar;
        this.a = com_xunlei_downloadprovider_member_payment_a_e_d;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj;
        this.a.a(list, (Boolean) obj2);
        if (list != null && list.size() > null) {
            this.b.m = ((d) list.get(list.size() - 1)).a;
        }
    }

    public final void a(String str) {
        this.a.a(str);
    }
}
