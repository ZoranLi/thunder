package com.alibaba.baichuan.android.trade.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.utils.d.b;
import com.taobao.accs.common.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static Map a(Map map) {
        Map hashMap = new HashMap();
        hashMap.put(Constants.KEY_TTID, com.alibaba.baichuan.android.trade.e.a.g().e());
        StringBuilder stringBuilder = new StringBuilder("1-");
        stringBuilder.append(AlibcContext.c());
        hashMap.put("umpChannel", stringBuilder.toString());
        stringBuilder = new StringBuilder("1-");
        stringBuilder.append(AlibcContext.c());
        hashMap.put("u_channel", stringBuilder.toString());
        if (map == null || map.size() == 0) {
            return hashMap;
        }
        if (map.get("isv_code") == null && com.alibaba.baichuan.android.trade.e.a.g().f() != null) {
            hashMap.put("isv_code", com.alibaba.baichuan.android.trade.e.a.g().f());
        }
        Map hashMap2 = new HashMap();
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            if (!(str2 == null || TextUtils.isEmpty(str2))) {
                if (AlibcContext.c.contains(str)) {
                    hashMap.put(str, str2);
                } else {
                    hashMap2.put(str, str2);
                }
            }
        }
        hashMap2.put(Constants.KEY_TTID, com.alibaba.baichuan.android.trade.e.a.g().e());
        CharSequence b = b(hashMap2);
        if (!(b == null || TextUtils.isEmpty(b))) {
            hashMap.put("ybhpss", b);
        }
        return hashMap;
    }

    private static String b(Map map) {
        if (map.size() == 0) {
            return null;
        }
        map.put(Constants.KEY_TTID, com.alibaba.baichuan.android.trade.e.a.g().e());
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            if (i != 0) {
                stringBuilder.append("&");
            }
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("=");
                stringBuilder2.append(URLEncoder.encode(new String(str2), "utf-8"));
                stringBuilder.append(stringBuilder2.toString());
                i++;
            } catch (Map map2) {
                new StringBuilder("构建Ybhpss参数错误：").append(map2.getMessage());
                com.alibaba.baichuan.android.trade.utils.g.a.b();
                return null;
            }
        }
        if (TextUtils.isEmpty(stringBuilder) != null) {
            return stringBuilder.toString();
        }
        map2 = Base64.encodeToString(new String(stringBuilder).getBytes(), 0);
        b.a("trade", "ybhpss", map2);
        return map2;
    }
}
