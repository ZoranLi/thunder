package com.xunlei.downloadprovider.launch.guide;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: GuideLoginReporter */
public class k {
    private static final String a = "k";

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_installCloud", "installCloud_show");
        build.add("is_login", str);
        a(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_installCloud", "installCloud_click");
        build.add("is_login", str);
        build.add("clickid", str2);
        a(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_installCloud", "installCloud_leave");
        build.add("is_tick_show", str);
        build.add("is_tick_click", str2);
        a(build);
    }

    public static void a() {
        a(HubbleEventBuilder.build("android_installCloud", "installPush_conf_alert"));
    }

    public static void a(int i) {
        StatEvent build = HubbleEventBuilder.build("android_installCloud", "installPush_conf_click");
        build.add("clickid", i);
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
