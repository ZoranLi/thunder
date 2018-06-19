package com.xunlei.common.new_ptl.pay.a;

import com.xunlei.common.device.XLDeviceGen;

/* compiled from: XLDeviceID */
public final class b {
    private b() {
    }

    public static String a() {
        return XLDeviceGen.getInstance().getDeviceId();
    }

    private static String b() {
        return XLDeviceGen.getInstance().getDeviceIdSign();
    }
}
