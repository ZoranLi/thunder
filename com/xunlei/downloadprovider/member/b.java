package com.xunlei.downloadprovider.member;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: NewUserManager */
public final class b implements Runnable {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest("http://api-shoulei-ssl.xunlei.com/pepper/api/is_newbie", new c(this), new d(this));
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        sigJsonObjectRequest.setShouldCache(false);
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
