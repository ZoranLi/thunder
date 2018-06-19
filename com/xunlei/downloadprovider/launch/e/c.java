package com.xunlei.downloadprovider.launch.e;

import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.report.a;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: LaunchReport */
public abstract class c {
    public static void a() {
        StatEvent build = HubbleEventBuilder.build("android_forground", "forground");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.BRAND);
        stringBuilder.append("|");
        stringBuilder.append(Build.MODEL);
        build.addString("phone", stringBuilder.toString());
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_forground", "forground_protocol");
        build.addString("from", str);
        build.addString("page_type", str2);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, boolean z) {
        if (!BrothersApplication.getSingletonInstance().hasLaunched) {
            StatEvent build = HubbleEventBuilder.build("android_launch", "launch_loading");
            build.add("from", TextUtils.isEmpty(str) ? DispatchConstants.OTHER : str);
            ThunderReport.reportEvent(build);
            if (z) {
                a.a(str);
            }
        }
    }

    public static void a(boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_launch", "authority_click_result");
        build.addString("result", z ? "1" : "0");
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, int i, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_launch", "outapp_paste_click");
        build.addString("url", str);
        build.addString("clickid", String.valueOf(i));
        build.addString("by", str2);
        ThunderReport.reportEvent(build);
    }
}
