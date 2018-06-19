package com.xunlei.downloadprovider.personal.a;

import com.taobao.accs.AccsClientConfig;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.a.b.h;
import com.xunlei.xllib.b.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UserCenterReport */
public class j {
    private static final String a = "j";
    private static List<String> b = new ArrayList();

    public static void a() {
        if (b != null && b.size() > 0) {
            b.clear();
        }
    }

    public static void a(String str, String str2) {
        if (!b.contains(str2)) {
            StatEvent build = HubbleEventBuilder.build("android_per_center", "per_cl_finance_show");
            build.add("card_type", str);
            build.add("card_id", str2);
            a(build);
            b.add(str2);
        }
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(List<h> list, boolean z, boolean z2) {
        if (list != null) {
            StatEvent build = HubbleEventBuilder.build("android_per_center", "per_config_entry_show");
            for (int i = 0; i < list.size(); i++) {
                h hVar = (h) list.get(i);
                String str;
                StringBuilder stringBuilder;
                if ("score_center".equals(hVar.c)) {
                    str = hVar.c;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(z ? "red" : AccsClientConfig.DEFAULT_CONFIGTAG);
                    stringBuilder.append("_");
                    stringBuilder.append(i + 1);
                    build.add(str, stringBuilder.toString());
                } else if ("my_gift".equals(hVar.c)) {
                    str = hVar.c;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(z2 ? "red" : AccsClientConfig.DEFAULT_CONFIGTAG);
                    stringBuilder.append("_");
                    stringBuilder.append(i + 1);
                    build.add(str, stringBuilder.toString());
                } else {
                    String str2 = hVar.c;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(hVar.k == 1 ? "red" : AccsClientConfig.DEFAULT_CONFIGTAG);
                    stringBuilder2.append("_");
                    stringBuilder2.append(i + 1);
                    build.add(str2, stringBuilder2.toString());
                }
            }
            a(build);
        }
    }

    public static void a(String str, boolean z, int i, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "per_config_entry_click");
        build.add("keyword", str);
        build.add("red", z ? "red" : AccsClientConfig.DEFAULT_CONFIGTAG);
        build.add("rn", i);
        build.add("word", k.a(str2));
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "per_message_tips_show");
        build.add("word", k.a(str));
        a(build);
    }

    public static void a(String str, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "per_cl_common_click");
        build.add("clickid", str);
        build.add("is_vip", LoginHelper.a().l());
        LoginHelper.a();
        build.add("is_login", l.c());
        build.add("if_red_point", z);
        a(build);
    }

    public static void a(String str, boolean z, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "per_guidbar_show");
        build.add("degree", str);
        build.add("is_bind", z);
        build.add("bar_type", str2);
        a(build);
    }

    public static void b(String str, boolean z, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "per_guidbar_click");
        build.add("degree", str);
        build.add("is_bind", z);
        build.add("bar_type", str2);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "per_cl_finance_redpoint_show");
        build.add("tabid", str);
        a(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "per_cl_finance_click");
        build.add("card_type", str);
        build.add("card_id", str2);
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "get_icon_alert_show");
        build.add("task", str);
        build.add("type", str2);
        build.add("position", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_per_center", "get_icon_alert_click");
        build.add("task", str);
        build.add("type", str2);
        build.add("position", str3);
        build.add("clickid", str4);
        a(build);
    }
}
