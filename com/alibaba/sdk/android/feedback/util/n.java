package com.alibaba.sdk.android.feedback.util;

import android.app.Application;
import com.alibaba.mtl.appmonitor.AppMonitor.c;
import com.taobao.accs.common.Constants;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders.UTCustomHitBuilder;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;

public class n {
    public static void a() {
        UTCustomHitBuilder uTCustomHitBuilder = new UTCustomHitBuilder("80001");
        uTCustomHitBuilder.setProperty(Constants.KEY_MODEL, "feedback");
        uTCustomHitBuilder.setProperty("version", "2.5.1");
        UTAnalytics.getInstance().getTracker("5").send(uTCustomHitBuilder.build());
    }

    public static void a(String str, String str2) {
        c.a("feedback", str, str2, 0.0d);
    }

    public static void a(String str, String str2, Application application, int i) {
        if (i != 2 && i == 1) {
            UTAnalytics.getInstance().turnOnDebug();
            UTAnalytics.getInstance().setContext(application);
            UTAnalytics.getInstance().setAppApplicationInstance(application);
            if (str2 != null) {
                if (!str2.equals("")) {
                    UTAnalytics.getInstance().setRequestAuthentication(new UTBaseRequestAuthentication(str, str2));
                    return;
                }
            }
            UTAnalytics.getInstance().setRequestAuthentication(new UTSecuritySDKRequestAuthentication(str, ""));
        }
    }
}
