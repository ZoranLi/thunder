package com.xunlei.downloadprovider.member.login.ui;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: LoginReport */
public final class ai {
    static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_user_login", "user_login_float_click");
        build.add("from", str);
        build.add("clickid", str2);
        a(build);
    }

    public static void a(int i, String str, int i2, boolean z, boolean z2) {
        int i3 = 2;
        if (i == 0) {
            i = HubbleEventBuilder.build("android_user_login", "user_login_success");
            i.add("from_src", str);
            i.add("vip_type", i2);
            i.add("is_vip", (int) z);
            str = "is_syscheck";
            if (z2) {
                i3 = 1;
            }
            i.add(str, i3);
            a(i);
            return;
        }
        str = HubbleEventBuilder.build("android_user_login", "user_login_fail");
        str.add("failtype", i);
        String str2 = "is_syscheck";
        if (z2) {
            i3 = 1;
        }
        str.add(str2, i3);
        a(str);
    }

    public static void a(String str, int i) {
        StatEvent build = HubbleEventBuilder.build("android_logout", "logout");
        if (str.equals("active_exit") == null) {
            build.add("logout_reason", i);
        }
        a(build);
    }
}
