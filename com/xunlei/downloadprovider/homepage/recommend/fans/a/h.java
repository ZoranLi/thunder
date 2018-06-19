package com.xunlei.downloadprovider.homepage.recommend.fans.a;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import org.android.agoo.common.AgooConstants;

/* compiled from: FansAndFollowReport */
public class h {
    private static final String a = "h";

    public static void a(String str, String str2, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_community_page", "zan_list_follow_click");
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("author_type", str2);
        build.add("login_type", z);
        a(build);
    }

    public static void a(String str, String str2, boolean z, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_community_page", "zan_list_follow_click_result");
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("author_type", str2);
        build.add("login_type", z);
        build.add("result", str3);
        if (str4 != null) {
            build.add("error", str4);
        }
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "follownum_list_show");
        build.add("from", str);
        a(build);
    }

    public static void a(long j, String str, int i) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "follownum_list_follow_click");
        build.add("content_id", 0);
        build.add("author_id", j);
        build.add("content_type", null);
        build.add("author_type", str);
        build.add("login_type", i);
        build.add("is_guide_bar", 0);
        a(build);
    }

    public static void a(long j, String str, int i, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "follownum_list_follow_click_result");
        build.add("content_id", 0);
        build.add("author_id", j);
        build.add("content_type", null);
        build.add("author_type", str);
        build.add("login_type", i);
        build.add("result", str2);
        build.add("error", str3);
        a(build);
    }
}
