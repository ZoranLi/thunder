package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.xllib.b.g;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: JsInterfaceHelper */
public final class af {

    /* compiled from: JsInterfaceHelper */
    private static class a implements Comparator<String> {
        private a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((String) obj).compareTo((String) obj2);
        }
    }

    public static Map<String, Object> a(Map<String, Object> map) {
        if (map.isEmpty()) {
            return map;
        }
        if (map.isEmpty()) {
            map = null;
        } else {
            Map<String, Object> treeMap = new TreeMap(new a());
            treeMap.putAll(map);
            map = treeMap;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry value : map.entrySet()) {
            stringBuilder.append(value.getValue());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder2.append("#ThunderVerifyKey#");
        map.put("verify", g.a(stringBuilder2.toString().getBytes()));
        return map;
    }
}
