package com.xunlei.downloadprovider.personal.user;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: PersonalClickReport */
public final class f {
    public static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "setting_page_click");
        build.add("button", str);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "per_sign_alert_click");
        build.add("days", str);
        a(build);
    }
}
