package com.xunlei.downloadprovider.member.register;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: RegisterReporter */
public final class b {
    public static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_phone_register", "phone_login");
        build.add("from", str);
        a(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_phone_register", "phone_reg_passcode_result");
        build.add("result", str);
        build.add("errcode", str2);
        a(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_phone_register", "phone_login_passcode_result");
        build.add("result", str);
        build.add("errcode", str2);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_phone_register", "phone_register_success");
        build.add("from_src", str);
        a(build);
    }
}
