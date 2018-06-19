package com.xunlei.downloadprovider.homepage.category;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.xllib.b.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ShortVideoCategoryReporter */
public final class v {
    private static List<e> a = new ArrayList();
    private static Set<e> b = new HashSet();

    public static void a(boolean z, e eVar, String str) {
        if (eVar != null) {
            if (!eVar.d()) {
                if (!z || !b.contains(eVar)) {
                    a.add(eVar);
                    b.add(eVar);
                    if (a.size() >= true) {
                        a(str);
                    }
                }
            }
        }
    }

    public static void a(String str) {
        if (!a.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (e eVar : a) {
                if (eVar.e()) {
                    stringBuilder.append(eVar.b());
                    stringBuilder.append("_");
                }
            }
            if (stringBuilder.length() <= 0) {
                a.clear();
                return;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_content_show");
            build.add("tag", k.a(str, "UTF-8"));
            build.add("contentlist", stringBuilder.toString());
            ThunderReport.reportEvent(build);
            a.clear();
        }
    }

    public static void a() {
        b.clear();
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_show");
        build.add("from", str);
        build.add("tag", k.a(str2, "UTF-8"));
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_content_click");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_zan");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        build.add("action", str4);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_share_click");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_share_to");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        build.add("to", str4);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_share_result");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        build.add("to", str4);
        build.add("result", str5);
        build.add("errorcode", str6);
        ThunderReport.reportEvent(build);
    }

    public static void c(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_discuss_click");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        ThunderReport.reportEvent(build);
    }

    public static void c(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_follow_click");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        build.add("author_type", str4);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_follow_click_result");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("movieid", str2);
        build.add("author_id", str3);
        build.add("author_type", str4);
        build.add("result", str5);
        build.add("error", str6);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, long j) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_exit");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("stay_period", j);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_vtagCollect", "vtagCollect_common_click");
        build.add("tag", k.a(str, "UTF-8"));
        build.add("clickid", str2);
        ThunderReport.reportEvent(build);
    }
}
