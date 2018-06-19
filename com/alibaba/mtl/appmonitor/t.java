package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.log.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SdkMeta */
public final class t {
    private static final Map<String, String> a;

    public static Map<String, String> a() {
        a.c();
        if (!a.containsKey("sdk-version")) {
            a.put("sdk-version", "2.5.1_for_bc");
        }
        return a;
    }

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put("sdk-version", "2.5.1_for_bc");
    }
}
