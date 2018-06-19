package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.android.volley.n.b;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import org.json.JSONObject;

/* compiled from: FeedDataManager */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        o a = o.a(false, jSONObject);
        if (a.a()) {
            this.a.c.e = false;
            a aVar = this.a.c;
            if (aVar.b != null) {
                XLThreadPool.execute(new h(aVar, jSONObject));
            }
            obj = a.a;
            this.a.c.d.addAll(0, obj);
            VideoFeedReporter.a(this.a.a, VideoFeedReporter.a(a.a));
            this.a.b.a(obj.size());
            return;
        }
        this.a.b.a();
        VideoFeedReporter.a(this.a.a, f.a(null));
    }
}
