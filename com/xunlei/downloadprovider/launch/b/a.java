package com.xunlei.downloadprovider.launch.b;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.tdlive.LivePlugin;

/* compiled from: XLLiveSDKManager */
public class a {
    private static volatile LivePlugin a;

    public static LivePlugin a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = LivePlugin.getInstance(BrothersApplication.getApplicationInstance());
                }
            }
        }
        return a.login();
    }
}
