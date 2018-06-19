package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: PublisherDataNetworkHelper */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ c c;
    final /* synthetic */ h d;

    i(h hVar, String str, long j, c cVar) {
        this.d = hVar;
        this.a = str;
        this.b = j;
        this.c = cVar;
    }

    public final void run() {
        Request arVar = new ar(0, this.a, new j(this), new k(this));
        arVar.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 2, 1.0f));
        this.d.a(arVar);
    }
}
