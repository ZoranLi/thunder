package com.xunlei.downloadprovider.homepage.recommend.feed;

import org.json.JSONObject;

/* compiled from: FeedDataManager */
final class h implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ a b;

    h(a aVar, JSONObject jSONObject) {
        this.b = aVar;
        this.a = jSONObject;
    }

    public final void run() {
        this.b.b.edit().clear();
        this.b.b.edit().putString("feed_video_list", this.a.toString()).apply();
    }
}
