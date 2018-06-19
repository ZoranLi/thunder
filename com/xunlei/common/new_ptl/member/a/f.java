package com.xunlei.common.new_ptl.member.a;

import com.xunlei.common.device.XLDeviceGen;

/* compiled from: XLDeviceID */
public final class f {
    private f() {
    }

    public static String a() {
        return XLDeviceGen.getInstance().getDeviceId();
    }

    public static String b() {
        return XLDeviceGen.getInstance().getDeviceIdSign();
    }
}
