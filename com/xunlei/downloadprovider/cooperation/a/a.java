package com.xunlei.downloadprovider.cooperation.a;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: ChangeAmountReport */
public abstract class a {
    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("change_amount_model", "clearnSpace_page_show");
        build.add("app_display_station", str);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, boolean z) {
        StatEvent build = HubbleEventBuilder.build("change_amount_model", "change_amount_loaction_show");
        build.add("app_display_locations", str);
        str = "app_package_name";
        if (str2 == null) {
            str2 = "";
        }
        build.add(str, str2);
        build.add("app_install_tips", z);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, boolean z, boolean z2, String str3) {
        StatEvent build = HubbleEventBuilder.build("change_amount_model", "change_amount_location_click");
        build.add("app_display_locations", str);
        build.add("app_package_name", str2);
        build.add("app_install_tips", z);
        build.addString("if_install", z2 ? "1" : "0");
        build.add("if_load", str3);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("change_amount_model", "change_amount_download_click");
        build.add("app_display_locations", str);
        str = "app_package_name";
        if (str2 == null) {
            str2 = "";
        }
        build.add(str, str2);
        build.add("clickid", str3);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("change_amount_model", "change_amount_download_alert");
        build.add("app_display_locations", str);
        build.add("app_package_name", str2);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("change_amount_model", "change_amount_station_show");
        build.add("app_display_station", str);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("change_amount_model", "change_amount_station_click");
        String str3 = "app_display_station";
        if (str == null) {
            str = "";
        }
        ThunderReport.reportEvent(build.addString(str3, str).add("clickid", str2));
    }

    public static void b(String str, String str2, String str3) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("change_amount_model", "change_amount_download_entry_click").addString("position", str).add("action", str2).add("app", str3));
    }

    public static void c(String str, String str2) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("change_amount_model", "change_amount_download").addString("position", str).add("app", str2));
    }
}
