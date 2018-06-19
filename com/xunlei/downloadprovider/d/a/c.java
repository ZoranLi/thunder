package com.xunlei.downloadprovider.d.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigStringRequest;

/* compiled from: AbsConfig */
final class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Request sigStringRequest = new SigStringRequest(0, this.a.c, null, new d(this), new e(this));
        sigStringRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 2, 1.0f));
        sigStringRequest.setShouldCache(false);
        a.a.a(sigStringRequest);
    }
}
