package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.download.player.views.c;
import com.xunlei.downloadprovider.player.a;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.l;

/* compiled from: ShareController */
final class az implements l {
    final /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        a.b(fVar.j.contentEquals("local_player_share_guide") ? "share_float " : "normal", shareOperationType.getReportShareTo(), this.a.h);
        if (shareOperationType == ShareOperationType.COOPERATION) {
            ay.b(this.a);
        }
        if (shareOperationType == ShareOperationType.THUNDER_COMMAND) {
            new c(this.a.n(), fVar, this.a.c).show();
            com.xunlei.downloadprovider.download.report.a.f(this.a.c, ((com.xunlei.downloadprovidershare.a.c) fVar).a);
        }
        ay.b;
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        shareOperationType = shareOperationType.getReportShareTo();
        i = com.xunlei.downloadprovider.f.a.a(i);
        fVar = "local_player_share_guide".equals(fVar.j) != null ? "share_float " : "normal";
        String a = this.a.h;
        StatEvent build = HubbleEventBuilder.build("android_player", "player_share_result");
        build.add("from", fVar);
        fVar = "to";
        if (shareOperationType == null) {
            shareOperationType = "";
        }
        build.add(fVar, shareOperationType);
        build.add("sense", a);
        build.add("result", i);
        ThunderReport.reportEvent(build);
    }

    public final void a() {
        this.a.e.f();
        this.a.e.a();
        this.a.e.j();
        if (this.a.f && this.a.o() != null) {
            com.xunlei.downloadprovider.download.player.a.a(this.a.o());
        }
        ay.b;
    }
}
