package com.xunlei.downloadprovider.ad.downloadlist.c;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;
import java.util.Map;

/* compiled from: HubReporter */
public final class h {
    public static void a(String str, Map<String, String> map, boolean z) {
        str = StatEvent.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, str);
        for (String str2 : map.keySet()) {
            str.addString(str2, (String) map.get(str2));
        }
        if (z) {
            map = "net_type";
            z = b.b(BrothersApplication.getApplicationInstance());
            if (z && z.equals("null")) {
                z = "0";
            }
            str.addString(map, z);
        }
        ThunderReport.reportEvent(str);
    }
}
