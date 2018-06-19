package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigStringRequest;

/* compiled from: CherryNetWork */
public final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;
    final /* synthetic */ a c;
    final /* synthetic */ a d;

    public c(a aVar, String str, b bVar, a aVar2) {
        this.d = aVar;
        this.a = str;
        this.b = bVar;
        this.c = aVar2;
    }

    public final void run() {
        Request sigStringRequest = new SigStringRequest(2, this.a, null, this.b, this.c);
        sigStringRequest.setShouldCache(false);
        sigStringRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        this.d.c(sigStringRequest);
    }
}
