package com.xunlei.downloadprovider.publiser.campaign.a;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.xllib.b.k;

/* compiled from: TopicNetWork */
public final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ e c;

    public j(e eVar, String str, c cVar) {
        this.c = eVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/ivideo_v4/query_topic_stick?tag=");
        stringBuilder.append(k.c(this.a, "UTF-8"));
        this.c.d(new ar(0, stringBuilder.toString(), new k(this), new l(this)));
    }
}
