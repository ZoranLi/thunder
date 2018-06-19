package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.xllib.b.k;
import java.util.regex.Pattern;

/* compiled from: BrowserReport */
public class aa {
    private static final String a = "aa";

    private aa() {
    }

    public static void a() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_browser", "browser_favorite"));
    }

    public static void b() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_browser", "browser_collect_show"));
    }

    public static void c() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_browser", "browser_his_show"));
    }

    public static void a(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str)) {
            String str3 = DispatchConstants.OTHER;
            Pattern compile = Pattern.compile("(?:m|www)\\.baidu\\.com");
            Pattern compile2 = Pattern.compile("(?:m|www)\\.so\\.com");
            Pattern compile3 = Pattern.compile("(?:m|www)\\.sm\\.cn");
            Pattern compile4 = Pattern.compile("(?:m|www)\\.sogou\\.com");
            if (compile.matcher(str).find()) {
                str3 = "baidu";
            } else if (compile2.matcher(str).find()) {
                str3 = "360";
            } else if (compile3.matcher(str).find()) {
                str3 = "shenma";
            } else if (compile4.matcher(str).find()) {
                str3 = "sougou";
            }
            str = HubbleEventBuilder.build("android_browser", "browser_web_pv").add("search_agent", str3).add("url", k.c(str, "UTF-8"));
            str3 = "from";
            if (str2 == null) {
                str2 = "";
            }
            ThunderReport.reportEvent(str.addString(str3, str2).addLong("sessionid", j));
        }
    }

    static void d() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_browser", "browser_copy_alert_show"));
    }

    static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_browser", "browser_copy_alert_click");
        build.add("clickid", str);
        build.add("word", str2);
        ThunderReport.reportEvent(build);
    }

    static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_browser", "browser_share_click");
        build.add("from", str);
        build.add("url", k.a(str2, "UTF-8"));
        ThunderReport.reportEvent(build);
    }

    static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_browser", "browser_share_to");
        build.add("from", str);
        build.add("to", str2);
        build.add("url", k.a(str3, "UTF-8"));
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_browser", "browser_share_result");
        build.add("url", k.a(str, "UTF-8"));
        build.add("from", str2);
        build.add("to", str3);
        build.add("result", str4);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_browser", "browser_reload_origin_click");
        build.add("url", k.a(str, "UTF-8"));
        ThunderReport.reportEvent(build);
    }
}
