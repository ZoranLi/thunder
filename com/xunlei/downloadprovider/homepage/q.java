package com.xunlei.downloadprovider.homepage;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: RenewTipReport */
public final class q {
    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_renewTip", "renewTip_show");
        build.add("from", str);
        LoginHelper.a();
        build.add("is_login", l.c());
        build.add("is_vip", LoginHelper.a().l());
        build.add("tipsid", str2);
        a(build);
    }

    public static void a(String str, long j, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_renewTip", "renewTip_show");
        build.add("from", str);
        build.add("renewdays", j);
        LoginHelper.a();
        build.add("is_login", l.c());
        build.add("is_vip", LoginHelper.a().l());
        build.add("tipsid", str2);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_renewTip", "renewTip_click");
        build.add("from", str);
        build.add("clickid", str2);
        LoginHelper.a();
        build.add("is_login", l.c());
        build.add("is_vip", LoginHelper.a().l());
        build.add("tipsid", str3);
        build.add("aidfrom", str4);
        build.add("referfrom", str5);
        a(build);
    }
}
