package com.xunlei.downloadprovider.ad.splash.b;

import android.support.annotation.NonNull;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.report.a;
import com.xunlei.downloadprovider.ad.common.report.j;

/* compiled from: SplashADReporter */
public final class b {
    @NonNull
    public static String b(int i) {
        switch (i) {
            case 1:
                return "forground";
            case 2:
                return "forground_fake_exit_app";
            default:
                return "launch";
        }
    }

    public static void a(int i) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_launch_pv").addString("ad_from", b(i)).add("session", j.a()).addString("net_type", a.a()));
    }
}
