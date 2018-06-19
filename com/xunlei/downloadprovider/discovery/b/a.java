package com.xunlei.downloadprovider.discovery.b;

import android.text.TextUtils;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;

/* compiled from: DiscoveryTabReporter */
public class a {
    private static final String a = "a";

    public static void a(HashMap<String, String> hashMap) {
        StatEvent build = HubbleEventBuilder.build("android_find", "find_show");
        for (String str : hashMap.keySet()) {
            build.add(str, (String) hashMap.get(str));
        }
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_find", "find_click");
        build.add(AgooConstants.MESSAGE_FLAG, str2);
        if (TextUtils.isEmpty(str3) == null) {
            build.add("source", str3);
        }
        build.add("clickid", str);
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
