package com.xunlei.analytics;

import android.content.Context;
import com.xunlei.analytics.b.e;
import com.xunlei.analytics.c.d;
import com.xunlei.analytics.config.AnalyticsReportConfiguration;
import com.xunlei.analytics.config.AnalyticsReportConfigurationBuilder;
import com.xunlei.analytics.config.a;
import com.xunlei.analytics.config.b;
import java.util.HashMap;

public class HubbleAgent {
    private static AnalyticsReportConfiguration mConfiguration;

    public static void forceUpdateBaseParams(Context context) {
        d.a(context).b();
    }

    public static String getHubbleDeviceId(Context context) {
        return d.a(context.getApplicationContext()).a();
    }

    public static AnalyticsReportConfiguration getReportConfiguration() {
        if (mConfiguration == null) {
            mConfiguration = new AnalyticsReportConfigurationBuilder().build();
        }
        return mConfiguration;
    }

    public static void init(Context context, String str, String str2, String str3) {
        a.a(str);
        a.b(str2);
        a.c(str3);
        a.a(context.getApplicationContext());
    }

    public static void onEvent(String str) {
        onEvent(str, null);
    }

    public static void onEvent(String str, HashMap<String, String> hashMap) {
        com.xunlei.analytics.b.a.a().a("3", str, hashMap);
    }

    public static void onPageEnd(String str) {
        e.c();
        b.b(str);
    }

    public static void onPageStart(String str) {
        e.b();
        b.a(str);
    }

    public static void onPause(Context context) {
        e.c();
        b.b(context);
    }

    public static void onResume(Context context) {
        e.b();
        b.a(context);
    }

    public static void setDebugMode(boolean z) {
        a.a(z);
    }

    public static void setEventReportSwitch(boolean z) {
        a.b(z);
    }

    public static void setReportConfiguration(AnalyticsReportConfiguration analyticsReportConfiguration) {
        mConfiguration = analyticsReportConfiguration;
    }

    public static void setReportEventServerMode(int i) {
        a.a(i);
    }

    public static void setSpecialCommonParams(HashMap<String, String> hashMap) {
        a.a((HashMap) hashMap);
    }
}
