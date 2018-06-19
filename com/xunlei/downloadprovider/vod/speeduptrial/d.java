package com.xunlei.downloadprovider.vod.speeduptrial;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: BubbleReport */
public final class d {
    public static int a() {
        LoginHelper.a();
        return l.c() ? 1 : 0;
    }

    public static void a(boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_xfc_trying_click");
        build.add("is_login", a());
        build.add("type", z ? true : true);
        ThunderReport.reportEvent(build);
    }
}
