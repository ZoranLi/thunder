package com.xunlei.downloadprovider.download.tasklist.list.feed.a;

import com.google.gson.Gson;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a;
import com.xunlei.downloadprovider.h.f;

/* compiled from: TouTiaoAuthManager */
final class c implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    c(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final void run() {
        f.a(BrothersApplication.getApplicationInstance(), "tou_tiao_token_info", new Gson().toJson(this.a));
    }
}
