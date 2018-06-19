package com.xunlei.downloadprovider.ad.common.report;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.a;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.xllib.android.b;

/* compiled from: SplashAdAnalyzeReporter */
public final class j {
    private static long a = 0;
    private static String b = "";
    private static boolean c = false;

    public static long a() {
        return a;
    }

    public static String b() {
        return b;
    }

    public static void c() {
        a = System.currentTimeMillis();
        c = false;
    }

    public static void a(String str) {
        b = str;
    }

    public static void a(String str, long j) {
        if (b(str)) {
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_launch_saved_time").add("positionId", str).add("session", a).add("saved_time", j));
        }
    }

    public static void a(String str, String str2, b$a com_xunlei_downloadprovider_ad_common_c_b_a) {
        if (b(str)) {
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_sdk_request_success").add("ad_from", b).add("session", a).add("positionId", str).add("styleId", str2).add("request_duration", com_xunlei_downloadprovider_ad_common_c_b_a.b()));
        }
    }

    public static void a(String str, String str2, int i, b$a com_xunlei_downloadprovider_ad_common_c_b_a) {
        if (b(str)) {
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_sdk_request_fail").add("ad_from", b).add("session", a).add("positionId", str).add("styleId", str2).add("errorcode", i).add("request_duration", com_xunlei_downloadprovider_ad_common_c_b_a.b()));
        }
    }

    public static void a(l lVar) {
        if (b(lVar.A()) && !c) {
            c = true;
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_fetch_result").add("ad_from", b).add("session", a).add("positionId", lVar.A()).add("styleId", lVar.v.mStyleId).add("ad_type", b(lVar)).add("result", "success").add("error_code", 0));
        }
    }

    public static void a(String str, int i, String str2) {
        if (b(str) && !c) {
            c = true;
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_fetch_result").add("ad_from", b).add("session", a).add("positionId", str).add("styleId", -1).add("ad_type", -1).add("result", "fail").add("error_code", i).add("error_msg", str2));
        }
    }

    public static void b(String str, int i, String str2) {
        if (b(str)) {
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_noshow").add("positionId", str).add("ad_from", b).add("session", a).add("error_code", i).add("error_msg", str2));
        }
    }

    public static void a(l lVar, b$a com_xunlei_downloadprovider_ad_common_c_b_a) {
        if (b(lVar.A())) {
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_img_request_success").add("ad_from", b).add("session", a).add("positionId", lVar.A()).add("styleId", lVar.v.mStyleId).add("ad_type", b(lVar)).add("net_type", d()).add("request_duration", com_xunlei_downloadprovider_ad_common_c_b_a.b()));
        }
    }

    public static void a(l lVar, b$a com_xunlei_downloadprovider_ad_common_c_b_a, String str) {
        if (b(lVar.A())) {
            ThunderReport.reportEvent(StatEvent.build("android_advertise").add(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_img_request_fail").add("ad_from", b).add("session", a).add("positionId", lVar.A()).add("styleId", lVar.v.mStyleId).add("ad_type", b(lVar)).add("net_type", d()).add("request_duration", com_xunlei_downloadprovider_ad_common_c_b_a.b()).add("error_code", -1).add("error_msg", str));
        }
    }

    private static String b(l lVar) {
        switch (a.a[lVar.c().ordinal()]) {
            case 1:
                return "baidu";
            case 2:
                return SocializeProtocolConstants.PROTOCOL_KEY_TENCENT;
            case 3:
                return "xunlei";
            default:
                return "";
        }
    }

    private static boolean b(String str) {
        return THUNDER_AD_INFO.SPLASH.getPositionId().equalsIgnoreCase(str);
    }

    private static String d() {
        String b = b.b(com.xunlei.downloadprovider.ad.a.a());
        return (b == null || !b.equals("null")) ? b : "0";
    }
}
