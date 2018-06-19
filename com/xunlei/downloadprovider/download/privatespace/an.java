package com.xunlei.downloadprovider.download.privatespace;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.payment.a.j;

/* compiled from: ReporterUtil */
public final class an {
    static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_alert_click");
        build.addString("clickid", str).addInt("vip_type", j.a().d());
        ThunderReport.reportEvent(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_pword_confirm_show");
        build.addString("status", str);
        ThunderReport.reportEvent(build);
    }

    static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_pword_confirm_click");
        build.addString("clickid", str).addString("status", str2);
        ThunderReport.reportEvent(build);
    }

    static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_pword_confirm_result");
        String str5 = "errorcode";
        if (str == null) {
            str = "";
        }
        str = build.addString(str5, str).addString("status", str2).addString("type", str3);
        str2 = "from";
        if (str4 == null) {
            str4 = "";
        }
        str.addString(str2, str4);
        ThunderReport.reportEvent(build);
    }

    static void c(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_view_click");
        build.addString("clickid", str);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_view_result");
        String str3 = "errorcode";
        if (str2 == null) {
            str2 = "";
        }
        build.addString(str3, str2).addString("status", str);
        ThunderReport.reportEvent(build);
    }
}
