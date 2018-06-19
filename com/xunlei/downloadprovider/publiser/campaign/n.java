package com.xunlei.downloadprovider.publiser.campaign;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: TopicHotFragment */
final class n implements c<List<com.xunlei.downloadprovider.publiser.campaign.a.n>> {
    final /* synthetic */ TopicHotFragment a;

    n(TopicHotFragment topicHotFragment) {
        this.a = topicHotFragment;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List<com.xunlei.downloadprovider.publiser.campaign.a.n> list = (List) obj;
        for (com.xunlei.downloadprovider.publiser.campaign.a.n nVar : list) {
            this.a.r.add(nVar.b.getGcid());
        }
        this.a.c(true);
        this.a.a((List) list);
        this.a.i();
    }

    public final void onFail(String str) {
        this.a.h();
    }
}
