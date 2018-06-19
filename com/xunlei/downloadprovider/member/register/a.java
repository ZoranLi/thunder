package com.xunlei.downloadprovider.member.register;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: LoginThirdReporter */
public final class a {
    public static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_login_third", "login_third");
        build.add("from", str2);
        build.add("login_account", str);
        a(build);
    }

    public static void a(String str, int i) {
        StatEvent build = HubbleEventBuilder.build("android_login_third", "login_third_bind_code_result");
        build.add("result", str);
        build.add("errorcode", i);
        a(build);
    }

    public static void b(String str, int i) {
        StatEvent build = HubbleEventBuilder.build("android_login_third", "login_third_bind_result");
        build.add("result", str);
        build.add("errorcode", i);
        a(build);
    }
}
