package com.xunlei.downloadprovider.ad.home;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HomeFeedReporter */
public final class a {
    public static void a(String str, String str2, Map<String, String> map) {
        str = StatEvent.build(str).addString(HubbleEventBuilder.KEY_ATTRIBUTE1, str2);
        for (String str3 : map.keySet()) {
            str.addString(str3, (String) map.get(str3));
        }
        ThunderReport.reportEvent(str);
    }

    public static void a(String str, Map<String, String> map) {
        a(str, (Map) map, false);
    }

    public static void a(String str, Map<String, String> map, boolean z) {
        str = StatEvent.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                str.addString(str2, (String) map.get(str2));
            }
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

    public static void a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("net_type", b.b(BrothersApplication.getApplicationInstance()));
        hashMap.put("ad_position", str);
        hashMap.put("contentlist", str2);
        a("adv_homeflow_pv", hashMap);
    }

    public static void a(l lVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("position", str);
        if (lVar.F == null) {
            lVar.F = new HashMap();
        }
        lVar.F.putAll(hashMap);
    }
}
