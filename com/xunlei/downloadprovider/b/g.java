package com.xunlei.downloadprovider.b;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: AppPraiseReporter */
public final class g {
    static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2, boolean z, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_alert", "alert_guid_click");
        build.add("from", str);
        build.add("clickid", str2);
        build.add("if_praise", z);
        build.add("pack_name", str3);
        a(build);
    }
}
