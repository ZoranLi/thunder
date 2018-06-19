package com.xunlei.downloadprovider.discovery.kuainiao;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: KuaiNiaoManager */
final class e implements Runnable {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ d b;

    e(d dVar, StringBuilder stringBuilder) {
        this.b = dVar;
        this.a = stringBuilder;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, this.a.toString(), new f(this), new g(this));
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
