package com.xunlei.downloadprovider.ad.common;

import java.util.HashMap;
import java.util.Map;

public final class CommonConst {
    public static final Map<Float, Integer> a;

    public enum AD_SYSTEM_TYPE {
        SOURCE_GDT_FLAG,
        SOURCE_BAIDU_FLAG,
        SOURCE_XUNLEI_FLAG
    }

    static {
        Map hashMap = new HashMap(3);
        a = hashMap;
        hashMap.put(Float.valueOf(3.0f), Integer.valueOf(33));
        a.put(Float.valueOf(4.0f), Integer.valueOf(33));
        a.put(Float.valueOf(5.0f), Integer.valueOf(34));
    }
}
