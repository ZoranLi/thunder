package com.xunlei.downloadprovider.ad.common.adget.b;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.ad.common.adget.k;

/* compiled from: MultiAgget */
final class g extends Handler {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        k.a("adv_request_success", k.a("xunlei", this.a.c.d), this.a.a);
        this.a.b.a(this.a.c.d);
    }
}
