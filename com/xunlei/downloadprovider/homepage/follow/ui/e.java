package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: FollowFragment */
final class e implements c<List<g>> {
    final /* synthetic */ FollowFragment a;

    e(FollowFragment followFragment) {
        this.a = followFragment;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List<g> list = (List) obj;
        ab j = this.a.i;
        if (list != null) {
            if (list.size() != 0) {
                j.d.clear();
                j.d.add(new ap(12));
                for (g gVar : list) {
                    if (gVar.b() > 0) {
                        j.d.add(new ap(13, gVar));
                    }
                }
            }
        }
        if (this.a.b != null) {
            this.a.b.a();
        }
        this.a.d.setVisibility(8);
        this.a.a.setLoadingMoreEnabled(false);
    }

    public final void onFail(String str) {
        this.a.d.setVisibility(8);
    }
}
