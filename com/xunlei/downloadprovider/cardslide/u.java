package com.xunlei.downloadprovider.cardslide;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.b.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CommunityReport */
public class u {
    public static List<String> a = new ArrayList();
    private static final String b = "u";

    public static void a(List<String> list) {
        if (list != null) {
            if (list.size() != 0) {
                String str = "";
                if (list.size() > 0) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        String str2 = (String) list.get(i);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append(str2);
                        stringBuilder.append("_");
                        str = stringBuilder.toString();
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append((String) list.get(list.size() - 1));
                    str = stringBuilder2.toString();
                }
                StatEvent build = HubbleEventBuilder.build("android_community", "hot_or_not_content_show");
                build.add("hot_or_not_auto_play", str);
                a(build);
            }
        }
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_community", "hot_or_not_page_show");
        build.add("from", str);
        build.add("has_video", z ? "yes" : "no");
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_community", "hot_or_not_content_click");
        build.add("moveid", str);
        build.add("format_type", "hot_or_not_auto_play");
        a(build);
    }

    public static void a(String str, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build("android_community", "hot_or_not_action");
        build.add("movieid", str);
        build.add("action", z ? "slide" : "button");
        build.add("type", z2 ? "like" : "unlike");
        a(build);
    }

    public static void a(String str, String str2, String str3, boolean z, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_community", "hot_or_not_follow_click_result");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        str = "login_type";
        LoginHelper.a();
        build.add(str, l.c() != null ? "1" : "0");
        build.add("result", z ? "success" : "fail");
        if (!z) {
            build.add("error", str4);
        }
        a(build);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_community", "hot_or_not_zan");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("result", z ? "success" : "fail");
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_community", "hot_or_not_discuss_result");
        build.add("movieid", str);
        build.add("discussid", str2);
        build.add("author_type", str3);
        build.add("wordid", k.c(str4, "UTF-8"));
        build.add("result", "success");
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_community", "share_success_float_show");
        build.add("position", str);
        a(build);
    }

    public static void c(String str) {
        StatEvent build = HubbleEventBuilder.build("android_community", "share_success_float_click");
        build.add("position", str);
        a(build);
    }

    public static void b(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_community", "packet_income_share_float_show");
        build.add("from", str);
        build.add("movieid", str2);
        build.add("content_type", str4);
        build.add("author_id", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_community", "packet_income_share_to");
        build.add("from", str);
        build.add("to", str2);
        build.add("movieid", str3);
        build.add("content_type", str5);
        build.add("author_id", str4);
        a(build);
    }

    public static void a(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_community", "packet_income_share_result");
        build.add("from", str);
        build.add("to", str2);
        str = "";
        if (i == 0) {
            str = "success";
        } else if (1 == i) {
            str = "fail";
        } else if (2 == i) {
            str = "cancel";
        }
        build.add("result", str);
        build.add("errorcode", i2);
        build.add("movieid", str3);
        build.add("content_type", str5);
        build.add("author_id", str4);
        a(build);
    }
}
