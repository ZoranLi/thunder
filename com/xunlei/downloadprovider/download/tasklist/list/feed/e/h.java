package com.xunlei.downloadprovider.download.tasklist.list.feed.e;

import android.os.Handler;
import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: TaskListFeedNetwork */
final class h implements a {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new Handler(BrothersApplication.getApplicationInstance().getMainLooper()).post(new i(this, volleyError));
    }
}
