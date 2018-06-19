package com.xunlei.downloadprovider.homepage.cinecism;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;

/* compiled from: CinecismReporter */
public class z {
    private static final String a = "z";

    private static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_show");
        build.add("from", str);
        build.add("cinecism_id", str2);
        build.add("author_id", str3);
        a(build);
    }

    public static void b(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_click");
        build.add("cinecism_id", str);
        build.add("author_id", str2);
        build.add("position", str3);
        a(build);
    }

    public static void a(int i, String str, long j, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_discuss_submit");
        build.add("level", i);
        build.add("cinecism_id", str);
        build.add("discussid", j);
        build.add("isVip", z);
        build.add("is_login", z2);
        a(build);
    }

    public static void a(String str, String str2, long j, long j2, int i, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_discuss_result");
        build.add("cinecism_id", str);
        build.add("author_id", str2);
        build.add("discussid", j);
        build.add("new_discussid", j2);
        build.add("level", i);
        build.add("result", str3);
        build.add("errorcode", str4);
        a(build);
    }

    public static void a(String str, String str2, long j, boolean z, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_discuss_click");
        build.add("cinecism_id", str);
        build.add("author_id", str2);
        build.add("discussid", j);
        build.add("is_login", z);
        build.add("clickid", str3);
        a(build);
    }

    public static void c(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_share_click");
        build.add("from", str);
        build.add("cinecism_id", str2);
        build.add("author_id", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_share_to");
        build.add("from", str);
        build.add("to", str2);
        build.add("cinecism_id", str3);
        build.add("author_id", str4);
        a(build);
    }

    public static void a(String str, String str2, String str3, int i, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_share_to_result");
        build.add("from", str);
        build.add("to", str2);
        build.add("result", str3);
        build.add("errorcode", i);
        build.add("cinecism_id", str4);
        build.add("author_id", str5);
        a(build);
    }

    public static void a(String str, String str2, long j, int i) {
        StatEvent build = HubbleEventBuilder.build("android_cinecismdetail", "cinecismDetail_exit");
        build.add("cinecism_id", str);
        build.add("author_id", str2);
        build.add("stay_period", j);
        str2 = new StringBuilder();
        str2.append(OpenPriceParam.div((double) i, 100.0d, 1));
        build.add("read_process", str2.toString());
        a(build);
    }
}
