package com.xunlei.downloadprovider.ad.common.report;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.xllib.android.b;
import java.util.Map;

/* compiled from: ADReporter */
public final class a {
    public static void a(String str, Map<String, String> map) {
        a(str, map, false);
    }

    public static void a(String str, Map<String, String> map, boolean z) {
        str = StatEvent.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                str.addString(str2, (String) map.get(str2));
            }
        }
        if (z) {
            str.addString("net_type", a());
        }
        ThunderReport.reportEvent(str);
    }

    public static String a() {
        String b = b.b(com.xunlei.downloadprovider.ad.a.a());
        return (b == null || !b.equals("null")) ? b : "0";
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_advertise", "adv_launch_nopv");
        String str2 = "nopv_detail";
        if (str == null) {
            str = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.a());
        ThunderReport.reportEvent(build.add(str2, str).add("session", stringBuilder.toString()).add("ad_from", j.b()));
    }
}
