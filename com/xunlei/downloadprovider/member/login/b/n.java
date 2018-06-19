package com.xunlei.downloadprovider.member.login.b;

import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: XLLoginInitImpl */
public class n {
    private static boolean a;
    private static n b;

    private n() {
    }

    public static n a() {
        if (b == null) {
            synchronized (n.class) {
                if (b == null) {
                    b = new n();
                }
            }
        }
        return b;
    }

    public static boolean a(String str, XLOnUserListener xLOnUserListener) {
        str = XLUserUtil.getInstance().Init(BrothersApplication.getApplicationInstance(), 40, "5.60.2.5510", AndroidConfig.getHubbleDeviceGUID(), str, false);
        XLUserUtil.getInstance().setKeepAliveListener(xLOnUserListener);
        a = str;
        return str;
    }

    public static void b() {
        XLUserUtil.getInstance().Uninit();
    }

    public static String c() {
        return XLDeviceGen.getInstance().getDeviceId();
    }
}
