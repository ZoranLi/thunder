package com.xunlei.downloadprovider.search.c;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.search.ui.search.bq;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SearchReporter */
public class a {
    private static final String a = "a";

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_search", "search_top_click");
        build.add("from", str);
        build.add("clickid", str2);
        build.add("word", bq.a().a);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_search", "search_top_click");
        build.add("from", str);
        build.add("to", str2);
        build.add("clickid", str3);
        build.add("word", str4);
        a(build);
    }

    public static void a() {
        a(HubbleEventBuilder.build("android_search", "search_think_show"));
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6) {
        StatEvent build = HubbleEventBuilder.build("android_search", "search_hotsearchTab_click");
        build.add("cardid", str);
        build.add("clickid", str2);
        build.add("word", str3);
        build.add("link_to", str4);
        build.add("gameid", str5);
        build.add("game_position", str6);
        a(build);
    }

    public static void b(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_search", "search_start_1");
        build.add("from", str);
        build.add("word", str2);
        build.add("website_or_word", str3);
        build.add("type", str4);
        a(build);
    }

    private static void a(Map<String, String> map, String str) {
        StatEvent build = HubbleEventBuilder.build("android_search", str);
        for (String str2 : map.keySet()) {
            build.add(str2, (String) map.get(str2));
        }
        a(build);
    }

    public static void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("has_result", z ? "0" : "1");
        hashMap.put("if_think", z2 ? "1" : "2");
        hashMap.put("if_shortvideo", z3 ? "1" : "2");
        hashMap.put("if_channelflow", z4 ? "1" : "2");
        hashMap.put("if_zhannei", z5 ? "1" : "2");
        hashMap.put("from", str);
        hashMap.put("keyword", str2);
        a(hashMap, "searchResult_show");
    }

    public static void a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("clickid", str);
        a(hashMap, "searchResult_click");
    }

    public static void a(int i) {
        Map hashMap = new HashMap();
        if (i != 0) {
            switch (i) {
                case 4:
                    hashMap.put("area", "zhannei");
                    break;
                case 5:
                    hashMap.put("area", "channel");
                    break;
                case 6:
                    hashMap.put("area", "shortvideo");
                    break;
                default:
                    break;
            }
        }
        hashMap.put("area", "think");
        a(hashMap, "searchResult_more_click");
    }

    public static void a(String str, String str2, String str3, String str4, int i) {
        StatEvent build = HubbleEventBuilder.build("android_search", "search_start_1");
        build.add("from", str);
        build.add("word", str2);
        build.add("website_or_word", str3);
        build.add("type", str4);
        build.add("is_default", String.valueOf(i));
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_search", "search_copy_tips_show");
        build.add("content", str);
        a(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_search", "search_copy_tips_click");
        build.add("content", str);
        build.add("clickid", str2);
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("reportData --> ").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
