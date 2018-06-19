package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.VolleyError;

/* compiled from: RequestRedPacketProfit */
final class p implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ o b;

    p(o oVar, VolleyError volleyError) {
        this.b = oVar;
        this.a = volleyError;
    }

    public final void run() {
        this.b.a.a.onFail(this.a.toString());
    }
}
