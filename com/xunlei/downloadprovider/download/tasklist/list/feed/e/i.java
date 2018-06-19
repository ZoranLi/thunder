package com.xunlei.downloadprovider.download.tasklist.list.feed.e;

import com.android.volley.VolleyError;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;

/* compiled from: TaskListFeedNetwork */
final class i implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ h b;

    i(h hVar, VolleyError volleyError) {
        this.b = hVar;
        this.a = volleyError;
    }

    public final void run() {
        this.b.a.b.e.a(-1, "");
        if (f.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f.a(this.a));
            b.a(stringBuilder.toString(), f.b(this.a));
        }
    }
}
