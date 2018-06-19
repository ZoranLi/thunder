package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;

/* compiled from: FollowDialog */
final class d implements c<PublisherInfo> {
    final /* synthetic */ b a;

    public final void onFail(String str) {
    }

    d(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.a.r = (PublisherInfo) obj;
        b.c(this.a);
    }
}
