package com.xunlei.downloadprovider.member.login.c;

import com.android.volley.Request;
import com.android.volley.l;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;

/* compiled from: LoginBusinessHelper */
public final class d implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ l b;
    final /* synthetic */ a c;

    public d(a aVar, long j, l lVar) {
        this.c = aVar;
        this.a = j;
        this.b = lVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, "http://api-shoulei-ssl.xunlei.com/user_info/notify?uid=%uid".replace("%uid", String.valueOf(this.a)), new e(this), new f(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new com.android.volley.d(3000, 1, 1.0f));
        this.b.a(sigJsonObjectRequest);
    }
}
