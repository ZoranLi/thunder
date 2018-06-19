package com.xunlei.downloadprovider.download.util;

import com.xunlei.a.b.b;
import com.xunlei.downloadprovider.plugin.q.a;

/* compiled from: TaskShareHelper */
final class o implements a {
    final /* synthetic */ String a;
    final /* synthetic */ n.a b;

    public final void onPluginFail(int i) {
    }

    public final void onPluginProgressUpdate(int i) {
    }

    o(n.a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void onPluginPrepared() {
        n.a aVar = this.b;
        String str = this.a;
        aVar.f = null;
        try {
            b bVar = new b();
            aVar.f = b.a(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        aVar.d.runOnUiThread(new p(aVar));
    }
}
