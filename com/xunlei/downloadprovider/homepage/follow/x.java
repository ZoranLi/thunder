package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.xllib.android.XLIntent;
import java.util.Set;

/* compiled from: FollowManager */
final class x implements c<Set<Long>> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    x(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Set set = (Set) obj;
        this.b.g = set;
        b.a(new y(this, set));
        this.b.b.sendBroadcast(new XLIntent("following_id_list_loaded"));
        if (this.a != null) {
            this.a.onSuccess(set);
        }
    }

    public final void onFail(String str) {
        if (this.a != null) {
            this.a.onFail(str);
        }
    }
}
