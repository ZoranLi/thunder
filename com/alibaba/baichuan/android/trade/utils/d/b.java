package com.alibaba.baichuan.android.trade.utils.d;

import java.util.HashMap;
import java.util.Map;

public final class b {
    private static String a = "group1";
    private static Map b = new HashMap();

    public static Object a(String str, String str2) {
        Map map = (Map) b.get(str);
        return (map == null || map.get(str2) == null) ? null : map.get(str2);
    }

    public static boolean a(String str, String str2, Object obj) {
        if (obj == null) {
            return null;
        }
        Map map = (Map) b.get(str);
        if (map == null) {
            map = new HashMap();
            b.put(str, map);
        }
        map.put(str2, obj);
        return true;
    }
}
