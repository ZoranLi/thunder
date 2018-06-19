package com.xunlei.downloadprovider.download.player.a;

import com.alipay.sdk.data.a;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;

/* compiled from: DownloadVodPlayerController */
final class n implements Runnable {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final void run() {
        m.a(this.a);
        m.b(this.a);
        if (this.a.g() != null) {
            this.a.g();
            if (!aq.m() || this.a.e() - this.a.k_() <= a.a) {
                this.a.g().d(false);
            } else {
                aq g = this.a.g();
                this.a.g();
                g.d(aq.m());
            }
        }
        if (m.c(this.a)) {
            m.O();
            if (this.a.j() != null) {
                this.a.j().b(true);
            }
            m.a(this.a, System.currentTimeMillis());
            m.d(this.a);
            com.xunlei.downloadprovider.player.a.a("play_end");
        } else if (m.e(this.a)) {
            m.O();
            if (this.a.j() != null) {
                this.a.j().b(false);
            }
            m.a(this.a, 0);
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_player", "player_share_float_dispear"));
        }
        m.g(this.a).postDelayed(m.f(this.a), 1000);
    }
}
