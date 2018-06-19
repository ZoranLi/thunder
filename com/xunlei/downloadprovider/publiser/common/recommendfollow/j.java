package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import org.android.agoo.common.AgooConstants;

/* compiled from: FollowRecommendReport */
public final class j {
    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_followrec", "followrec_show");
        build.add("from", str);
        a(build);
    }

    public static void a(long j, String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_followrec", "followrec_follow_click_result");
        build.add(AgooConstants.MESSAGE_ID, j);
        build.add("result", str);
        build.add("error", str2);
        build.add("from", str3);
        a(build);
    }

    public static void a(long j, int i, String str) {
        StatEvent build = HubbleEventBuilder.build("android_followrec", "followrec_common_click");
        build.add("clickid", "followrec_area");
        build.add(AgooConstants.MESSAGE_ID, j);
        build.add("from", str);
        build.add("login_type", i);
        a(build);
    }
}
