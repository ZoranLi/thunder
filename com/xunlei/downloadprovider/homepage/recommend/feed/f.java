package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.content.SharedPreferences.Editor;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import org.json.JSONObject;

/* compiled from: FeedDataManager */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = o.a(false, (JSONObject) obj);
        if (obj.a()) {
            this.a.c.e = false;
            Object obj2 = obj.a;
            this.a.c.d.addAll(obj2);
            this.a.a.a(obj2.size());
            k.a();
            if (k.a != null) {
                Editor edit = k.a.edit();
                edit.clear();
                edit.apply();
            }
            VideoFeedReporter.a(this.a.b, VideoFeedReporter.a(obj.a));
            return;
        }
        this.a.a.a();
        VideoFeedReporter.a(this.a.b, com.xunlei.downloadprovider.ad.common.f.a(null));
    }
}
