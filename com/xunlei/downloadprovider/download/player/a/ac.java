package com.xunlei.downloadprovider.download.player.a;

import android.os.SystemClock;
import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;

/* compiled from: DownloadVodPlayerController */
final class ac implements e {
    final /* synthetic */ m a;

    ac(m mVar) {
        this.a = mVar;
    }

    public final void a(c cVar) {
        m.O();
        if (m.q(this.a).g() != null) {
            m.r(this.a);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - m.s(this.a);
        long j = 1000;
        if (elapsedRealtime >= 1000) {
            m.r(this.a);
            return;
        }
        if (elapsedRealtime > 500) {
            j = 500;
        }
        m.g(this.a).postDelayed(new ad(this), j);
    }
}
