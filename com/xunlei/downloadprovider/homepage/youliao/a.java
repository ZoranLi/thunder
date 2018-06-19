package com.xunlei.downloadprovider.homepage.youliao;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: YouliaoReporter */
public final class a {
    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_youliao", "youliao_banner_click");
        String str2 = "target";
        if (str == null) {
            str = "";
        }
        build.add(str2, str);
        ThunderReport.reportEvent(build);
    }
}
