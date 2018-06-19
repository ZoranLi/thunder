package com.xunlei.downloadprovider.web.base;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: WebReport */
public final class f {
    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_browser", "business_browser_web_pv");
        String str3 = "from";
        if (str == null) {
            str = "";
        }
        str = build.addString(str3, str);
        String str4 = "url";
        if (str2 == null) {
            str2 = "";
        }
        ThunderReport.reportEvent(str.addString(str4, str2));
    }
}
