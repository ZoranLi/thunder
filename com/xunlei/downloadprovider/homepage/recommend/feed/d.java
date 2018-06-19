package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;

/* compiled from: FeedDataManager */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.a();
        VideoFeedReporter.a(this.a.a, f.a(volleyError));
    }
}
