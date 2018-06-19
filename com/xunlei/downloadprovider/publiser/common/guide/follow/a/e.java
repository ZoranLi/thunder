package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: GuideFollowModel */
final class e implements c<List<Long>> {
    final /* synthetic */ n a;
    final /* synthetic */ d b;

    e(d dVar, n nVar) {
        this.b = dVar;
        this.a = nVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.a.a((List) obj);
    }

    public final void onFail(String str) {
        this.a.a(-1, str);
    }
}
