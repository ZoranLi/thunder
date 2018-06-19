package com.xunlei.downloadprovider.homepage.photoarticle;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: PhotoArticleReporter */
public final class y {
    static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_zan");
        build.add("news_id", str);
        build.add("author_id", str2);
        build.add("position", str3);
        a(build);
    }

    public static void b(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_discuss_show");
        build.add("position", str);
        build.add("news_id", str2);
        build.add("author_id", str3);
        a(build);
    }

    public static void a(boolean z, String str, String str2, String str3, long j, long j2, boolean z2) {
        StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_discuss_result");
        build.add("result", z ? "success" : "fail");
        build.add("errorCode", str);
        build.add("news_id", str2);
        build.add("author_id", str3);
        build.add("discussid", j);
        build.add("new_discussid", j2);
        build.add("level", z2);
        a(build);
    }

    public static void a(String str, String str2, String str3, long j) {
        StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_discuss_click");
        build.add("news_id", str);
        build.add("author_id", str2);
        build.add("discussid", j);
        build.add("clickid", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, boolean z, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_follow_click_result");
        build.add("news_id", str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("result", z ? "success" : "fail");
        build.add("error", str4);
        build.add("position", str5);
        a(build);
    }
}
