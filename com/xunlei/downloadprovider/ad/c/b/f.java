package com.xunlei.downloadprovider.ad.c.b;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: LocationReporter */
public final class f {
    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_alert", "alert_location_pop_click");
        build.add("from", "youliao");
        build.add("button", str);
        a(build);
    }

    static void a(StatEvent statEvent) {
        new StringBuilder("reportData --> ").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
