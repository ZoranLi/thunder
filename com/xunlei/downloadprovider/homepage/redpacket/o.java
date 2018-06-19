package com.xunlei.downloadprovider.homepage.redpacket;

import android.app.Activity;
import com.xunlei.downloadprovider.plugin.q.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.b.c;
import com.xunlei.downloadprovidershare.k;

/* compiled from: RedPacketHelper */
final class o implements a {
    final /* synthetic */ Activity a;
    final /* synthetic */ String b;
    final /* synthetic */ BaseVideoInfo c;
    final /* synthetic */ int d;
    final /* synthetic */ k e;
    final /* synthetic */ c f;
    final /* synthetic */ j g;

    public final void onPluginFail(int i) {
    }

    public final void onPluginProgressUpdate(int i) {
    }

    o(j jVar, Activity activity, String str, BaseVideoInfo baseVideoInfo, int i, k kVar, c cVar) {
        this.g = jVar;
        this.a = activity;
        this.b = str;
        this.c = baseVideoInfo;
        this.d = i;
        this.e = kVar;
        this.f = cVar;
    }

    public final void onPluginPrepared() {
        f a = com.xunlei.downloadprovider.f.c.a(this.a, this.b, this.c, this.d);
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.b(this.a, a, this.e, this.f);
    }
}
