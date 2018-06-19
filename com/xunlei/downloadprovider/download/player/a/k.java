package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.plugin.q.a;

/* compiled from: DNLAController */
final class k implements a {
    final /* synthetic */ g a;

    public final void onPluginFail(int i) {
    }

    public final void onPluginProgressUpdate(int i) {
    }

    k(g gVar) {
        this.a = gVar;
    }

    public final void onPluginPrepared() {
        g.e(this.a);
    }
}
