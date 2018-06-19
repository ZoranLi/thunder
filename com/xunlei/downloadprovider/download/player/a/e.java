package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import java.util.List;

/* compiled from: AudioTrackController */
final class e implements Runnable {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.f() != null) {
            List a = this.a.g.a(this.a.f().a);
            if (a.size() > 0) {
                this.a.a(a);
                ThunderReport.reportEvent(HubbleEventBuilder.build("android_play", "player_audioselect_click"));
            }
        }
    }
}
