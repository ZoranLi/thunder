package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.android.volley.Request;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter.RefreshType;

/* compiled from: FeedDataManager */
public final class e implements Runnable {
    final /* synthetic */ p a;
    final /* synthetic */ RefreshType b;
    final /* synthetic */ a c;

    public e(a aVar, p pVar, RefreshType refreshType) {
        this.c = aVar;
        this.a = pVar;
        this.b = refreshType;
    }

    public final void run() {
        Request arVar = new ar(0, a.a(this.c.e, false), new f(this), new g(this));
        arVar.putHeader(HttpRequest.HEADER_USER_AGENT, AndroidConfig.getUserAgent());
        this.c.a.a(arVar);
    }
}
