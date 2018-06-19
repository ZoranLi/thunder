package com.xunlei.downloadprovider.download.tasklist.list.feed.e;

import android.text.TextUtils;
import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a;
import com.xunlei.downloadprovider.download.tasklist.list.feed.d.b;

/* compiled from: TaskListFeedNetwork */
final class e implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    e(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public final void run() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder("http://api-shoulei-ssl.xunlei.com/ally/api/v2/ally_timelines?");
        b.a(stringBuilder2, "toutiao_token", this.a.a);
        b.a(stringBuilder2, "s", (Object) "toutiao");
        b.a(stringBuilder2, "page", Integer.valueOf(this.b.a));
        b.a(stringBuilder2, "baidu_page_index", Integer.valueOf(b.a().a(this.b.b)));
        String str = "min_behot_time";
        if (this.b.c == -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis() - 10);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.c);
        }
        b.a(stringBuilder2, str, stringBuilder.toString());
        stringBuilder2.append(k.a(k.a(THUNDER_AD_INFO.DOWNLOAD_CENTER_FEED), true, 5));
        str = c.a;
        if (!TextUtils.isEmpty(this.b.d)) {
            b.a(stringBuilder2, "title", this.b.d);
        }
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder2.toString(), new f(this), new h(this));
        sigJsonObjectRequest.setShouldCache(false);
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
