package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;

/* compiled from: FeedDataManager */
final class g implements a {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a.a();
        VideoFeedReporter.a(this.a.b, f.a(volleyError));
    }
}
