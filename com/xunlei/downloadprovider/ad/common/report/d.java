package com.xunlei.downloadprovider.ad.common.report;

import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import java.util.Map;

/* compiled from: CommonReporter */
public final class d {
    public static void a(b bVar) {
        a.a("ad_pv", bVar.a(), true);
    }

    public static void a(b bVar, String str) {
        bVar.putExtra("ad_from", str);
        a.a("ad_nopv", bVar.a(), true);
    }

    public static void a(String str, String str2, CommonReportInfo commonReportInfo) {
        commonReportInfo = commonReportInfo.getReportParams();
        commonReportInfo.put("deeplink_type", str);
        str = Uri.encode(str2);
        str2 = "landing_url";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        commonReportInfo.put(str2, str);
        a.a("ad_deeplink", commonReportInfo, null);
    }

    public static void a(String str, String str2, CommonReportInfo commonReportInfo, int i) {
        commonReportInfo = commonReportInfo.getReportParams();
        commonReportInfo.put("deeplink_type", str);
        str = Uri.encode(str2);
        str2 = "landing_url";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        commonReportInfo.put(str2, str);
        commonReportInfo.put("error_code", String.valueOf(i));
        a.a("ad_deeplink_fail", commonReportInfo, null);
    }

    public static void a(String str, Map<String, String> map) {
        if (THUNDER_AD_INFO.SPLASH.getPositionId().equalsIgnoreCase(str) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j.a());
            map.put("session", stringBuilder.toString());
            map.put("ad_from", j.b());
        }
    }
}
