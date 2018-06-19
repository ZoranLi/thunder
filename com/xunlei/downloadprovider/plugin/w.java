package com.xunlei.downloadprovider.plugin;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: XLPluginReporter */
public final class w {
    public static void a(String str, int i, String str2, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_download", "dl_plugin_download_result");
        build.add("package", str);
        build.add("version", i);
        build.add("type", str2);
        build.add("result", z);
        new StringBuilder("[NEW_STAT_EVENT]").append(build);
        ThunderReport.reportEvent(build);
    }
}
