package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: PersonalSettingReport */
public final class br {
    public static String a = "open";
    public static String b = "close";
    private static String c = "android_config";
    private static String d = "check_version";
    private static String e = "per_cl_set";
    private static String f = "per_cl_set_disk";
    private static String g = "per_home_autoplay_set";

    public static void a() {
        a(HubbleEventBuilder.build(c, d));
    }

    public static void b() {
        boolean l = LoginHelper.a().l();
        LoginHelper.a();
        boolean b = l.b();
        StatEvent build = HubbleEventBuilder.build(c, e);
        build.add("is_vip", l);
        build.add("is_login", b);
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build(c, g);
        build.add("status", str);
        a(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build(c, f);
        String str3 = "first_config";
        if (str == null) {
            str = "";
        }
        build.add(str3, str).add("user_config", str2);
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
