package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;

/* compiled from: SubtitleController */
final class be implements Runnable {
    final /* synthetic */ ba a;

    be(ba baVar) {
        this.a = baVar;
    }

    public final void run() {
        this.a.o.a(this.a.e);
        this.a.a(0);
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_play", "subtitle_pannel_show"));
    }
}
