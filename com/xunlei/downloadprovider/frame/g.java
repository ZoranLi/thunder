package com.xunlei.downloadprovider.frame;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;

/* compiled from: MainActivityReporter */
public final class g {
    public static void a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_appExit", "appExit_click").add("clickid", str).add("is_login", z ? "1" : "0").add("is_signshow", z2 ? "1" : "0").add("is_download", z3 ? "1" : "0").add("is_tick", z4 ? "1" : "0"));
    }
}
