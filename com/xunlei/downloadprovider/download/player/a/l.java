package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.vod.dlna.OnDLNADialogListener;

/* compiled from: DNLAController */
final class l implements OnDLNADialogListener {
    final /* synthetic */ g a;

    l(g gVar) {
        this.a = gVar;
    }

    public final void a() {
        this.a.e.f();
        this.a.e.j();
    }

    public final void a(boolean z) {
        if (z) {
            this.a.i;
        }
    }

    public final void b() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_player", "player_dlna_use"));
    }
}
