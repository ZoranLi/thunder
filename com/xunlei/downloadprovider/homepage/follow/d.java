package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FollowManager */
final class d implements c<PublisherInfo> {
    final /* synthetic */ c a;

    public final void onFail(String str) {
    }

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        PublisherInfo publisherInfo = (PublisherInfo) obj;
        obj = a.a(publisherInfo.a(), publisherInfo.b());
        b.a(this.a.a, obj);
        ab a = ab.a();
        obj = String.valueOf(obj.b);
        List arrayList = new ArrayList(1);
        arrayList.add(String.valueOf(obj));
        a.a(null, arrayList);
    }
}
