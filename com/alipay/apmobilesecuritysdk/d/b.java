package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.f.h;
import com.alipay.b.a.a.a.a;
import java.util.HashMap;
import java.util.Map;

public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        Map<String, String> hashMap;
        synchronized (b.class) {
            hashMap = new HashMap();
            String a = a.a(map, com.alipay.sdk.cons.b.c, "");
            String a2 = a.a(map, "utdid", "");
            String a3 = a.a(map, "userId", "");
            String a4 = a.a(map, "appName", "");
            String a5 = a.a(map, "appKeyClient", "");
            String a6 = a.a(map, "tmxSessionId", "");
            String c = h.c(context);
            hashMap.put("AC1", a);
            hashMap.put("AC2", a2);
            hashMap.put("AC3", "");
            hashMap.put("AC4", c);
            hashMap.put("AC5", a3);
            hashMap.put("AC6", a6);
            hashMap.put("AC7", "");
            hashMap.put("AC8", a4);
            hashMap.put("AC9", a5);
        }
        return hashMap;
    }
}
