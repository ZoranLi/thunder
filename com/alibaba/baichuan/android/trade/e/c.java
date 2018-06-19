package com.alibaba.baichuan.android.trade.e;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

public final class c {
    String a = com.alibaba.baichuan.android.trade.f.a.a();
    Context b;
    a c;
    private final long d = 5000000;

    public interface a {
        void a(com.alibaba.baichuan.android.trade.e.a.a aVar);
    }

    static String a(com.alibaba.baichuan.android.trade.e.a.a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : aVar.a.keySet()) {
            stringBuilder.append(str);
            Map map = (Map) aVar.a.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append(str2);
                stringBuilder.append((String) map.get(str2));
            }
        }
        try {
            stringBuilder.append("ALITRADE20160628");
            char[] toCharArray = stringBuilder.toString().toCharArray();
            Arrays.sort(toCharArray);
            return com.alibaba.baichuan.android.trade.utils.e.a.a(new String(toCharArray).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            new StringBuilder("生成摘要错误").append(e.getMessage());
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return null;
        }
    }

    public c(Context context, a aVar) {
        this.b = context;
        this.c = aVar;
        this.a = com.alibaba.baichuan.android.trade.f.a.a();
    }
}
