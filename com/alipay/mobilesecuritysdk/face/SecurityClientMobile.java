package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.b.a.a.a.a;
import com.alipay.sdk.cons.b;
import java.util.HashMap;
import java.util.Map;

public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a;
        synchronized (SecurityClientMobile.class) {
            Map hashMap = new HashMap();
            hashMap.put("utdid", a.a(map, "utdid", ""));
            hashMap.put(b.c, a.a(map, b.c, ""));
            hashMap.put("userId", a.a(map, "userId", ""));
            APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
            a = com.alipay.apmobilesecuritysdk.a.a.a(context);
        }
        return a;
    }
}
