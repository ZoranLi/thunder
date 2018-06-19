package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.vod.audiotrack.a;
import com.xunlei.downloadprovider.vod.audiotrack.e.b;

/* compiled from: AudioTrackController */
final class c implements b {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void a(a aVar, boolean z) {
        if (aVar != null) {
            this.a.a = aVar.a;
        } else {
            this.a.a = -1;
        }
        if (z && aVar != null) {
            z = aVar.b;
            StatEvent build = HubbleEventBuilder.build("android_play", "player_audioselect");
            build.add("audio", z);
            ThunderReport.reportEvent(build);
            if (this.a.f()) {
                z = this.a.f().a;
                this.a.g;
                if (com.xunlei.downloadprovider.vod.audiotrack.b.a(z, aVar.a)) {
                    if (this.a.a()) {
                        this.a.a().audioTrackIndex = aVar.a;
                    }
                    if (this.a.n() != null) {
                        XLToast.showToast(this.a.n(), "音轨切换成功");
                    }
                } else if (this.a.n() != null) {
                    XLToast.showToast(this.a.n(), "音轨切换失败");
                }
            }
        }
    }
}
