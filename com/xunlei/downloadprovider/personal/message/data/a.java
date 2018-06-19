package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.l;
import com.android.volley.n.b;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import org.json.JSONObject;

/* compiled from: CherryNetWork */
public abstract class a {
    private l a = VolleyRequestManager.getRequestQueue();
    private l b = VolleyRequestManager.getMainThreadRequestQueue();

    protected final void a(String str, b<JSONObject> bVar, com.android.volley.n.a aVar) {
        XLThreadPool.execute(new b(this, str, bVar, aVar));
    }

    public void a(Request<?> request) {
        request.setShouldCache(false);
        request.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        d(request);
    }

    protected final void c(Request<?> request) {
        this.a.a((Request) request);
    }

    protected final void d(Request<?> request) {
        this.b.a((Request) request);
    }
}
