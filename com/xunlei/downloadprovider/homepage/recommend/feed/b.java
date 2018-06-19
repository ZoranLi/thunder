package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.android.volley.Request;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter.RefreshType;

/* compiled from: FeedDataManager */
public final class b implements Runnable {
    final /* synthetic */ RefreshType a;
    final /* synthetic */ p b;
    final /* synthetic */ a c;

    public b(a aVar, RefreshType refreshType, p pVar) {
        this.c = aVar;
        this.a = refreshType;
        this.b = pVar;
    }

    public final void run() {
        Request arVar = new ar(0, a.a(this.c.e, true), new c(this), new d(this));
        arVar.putHeader(HttpRequest.HEADER_USER_AGENT, AndroidConfig.getUserAgent());
        this.c.a.a(arVar);
    }
}
