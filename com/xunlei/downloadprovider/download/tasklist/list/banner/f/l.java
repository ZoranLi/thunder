package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import com.xunlei.downloadprovider.h.e;
import org.json.JSONObject;

/* compiled from: VoucherPacketHelper */
final class l implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ f b;

    l(f fVar, JSONObject jSONObject) {
        this.b = fVar;
        this.a = jSONObject;
    }

    public final void run() {
        e.b(f.q(), this.a.toString());
    }
}
