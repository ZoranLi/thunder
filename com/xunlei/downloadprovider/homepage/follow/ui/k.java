package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import java.util.List;

/* compiled from: FollowTabFragment */
final class k implements e$d<List<d>, Boolean> {
    final /* synthetic */ FollowTabFragment a;

    k(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj;
        if (((Boolean) obj2).booleanValue() != null) {
            this.a.a(4);
        } else {
            this.a.a(5);
        }
        this.a.c.a();
        if (list.size() > null) {
            obj2 = this.a.e.getItemCount();
            this.a.k.a(list);
            this.a.e.e();
            this.a.e.notifyItemRangeInserted(obj2, list.size());
        }
    }

    public final void a(String str) {
        this.a.c.a();
    }
}
