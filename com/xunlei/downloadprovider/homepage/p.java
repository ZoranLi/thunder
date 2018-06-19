package com.xunlei.downloadprovider.homepage;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.d.i;

/* compiled from: HomeTabReporter */
public final class p {
    public static String a = "android_hometab";
    public static String b = "home_point_status";
    private static String c = "home_collect_show";
    private static String d = "home_fun_show";
    private static String e = "hotvideo_show";
    private static String f = "home_tab_show";

    public static void a(StatEvent statEvent) {
        b(statEvent);
    }

    public static void a(String str, int i) {
        StatEvent build = HubbleEventBuilder.build(a, f);
        build.add("tabid", str);
        build.add("point_status", i.a().e(str) != null ? "point" : "0");
        build.add("if_login", i);
        b(build);
    }

    private static void b(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
