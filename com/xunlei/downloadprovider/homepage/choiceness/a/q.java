package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.search.b.b;

/* compiled from: ChoicenessNetworkHelper */
public final class q implements Runnable {
    final /* synthetic */ m a;
    final /* synthetic */ b b;
    final /* synthetic */ int c = 1;
    final /* synthetic */ j d;

    public q(j jVar, m mVar, b bVar) {
        this.d = jVar;
        this.a = mVar;
        this.b = bVar;
    }

    public final void run() {
        if (this.a != null) {
            if (this.a.b != null) {
                StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/cataract/api/v2/dynamic_card?page=0&size=");
                stringBuilder.append(this.c);
                stringBuilder.append("&video_id=");
                stringBuilder.append(this.a.b.getVideoId());
                Request arVar = new ar(0, stringBuilder.toString(), new r(this), new s(this));
                arVar.setShouldCache(false);
                arVar.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
                this.d.a(arVar);
                return;
            }
        }
        j.b(null, this.b);
    }
}
