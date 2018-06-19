package com.xunlei.common.register.a;

import com.xunlei.common.device.XLDeviceGen;

/* compiled from: XLDeviceID */
public final class b {
    private b() {
    }

    private static String b() {
        return XLDeviceGen.getInstance().getDeviceId();
    }

    public static String a() {
        return XLDeviceGen.getInstance().getDeviceIdSign();
    }
}
