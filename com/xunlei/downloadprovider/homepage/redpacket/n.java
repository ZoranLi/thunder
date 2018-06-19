package com.xunlei.downloadprovider.homepage.redpacket;

import android.app.Activity;
import com.xunlei.downloadprovider.f.c;
import com.xunlei.downloadprovider.plugin.q.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: RedPacketHelper */
public final class n implements a {
    final /* synthetic */ Activity a;
    final /* synthetic */ String b;
    final /* synthetic */ BaseVideoInfo c;
    final /* synthetic */ int d;
    final /* synthetic */ ShareOperationType e;
    final /* synthetic */ k f;
    final /* synthetic */ j g;

    public final void onPluginFail(int i) {
    }

    public final void onPluginProgressUpdate(int i) {
    }

    public n(j jVar, Activity activity, String str, BaseVideoInfo baseVideoInfo, int i, ShareOperationType shareOperationType, k kVar) {
        this.g = jVar;
        this.a = activity;
        this.b = str;
        this.c = baseVideoInfo;
        this.d = i;
        this.e = shareOperationType;
        this.f = kVar;
    }

    public final void onPluginPrepared() {
        f a = c.a(this.a, this.b, this.c, this.d);
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a(this.a, this.e, a, this.f);
    }
}
