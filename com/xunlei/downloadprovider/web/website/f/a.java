package com.xunlei.downloadprovider.web.website.f;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;

/* compiled from: SiteReporter */
public final class a {
    public static void a(String str, String str2, boolean z) {
        str = HubbleEventBuilder.build("android_url_action", "url_click").addString("position", str);
        String str3 = "url";
        if (str2 == null) {
            str2 = "";
        }
        ThunderReport.reportEvent(str.addString(str3, str2).addString("if_collect_redpoint", z ? "1" : "0"));
    }
}
