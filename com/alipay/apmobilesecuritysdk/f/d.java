package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import com.alipay.b.a.a.a.a;
import com.alipay.sdk.cons.b;
import org.json.JSONObject;

public final class d {
    private static c a(String str) {
        try {
            if (!a.a(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString(b.c), jSONObject.optString("utdid"));
            }
        } catch (Throwable e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (d.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            com.alipay.apmobilesecuritysdk.g.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            com.alipay.apmobilesecuritysdk.g.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    public static synchronized void a(Context context, c cVar) {
        synchronized (d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", cVar.a());
                jSONObject.put("deviceInfoHash", cVar.b());
                jSONObject.put("timestamp", cVar.c());
                jSONObject.put(b.c, cVar.d());
                jSONObject.put("utdid", cVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.g.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                com.alipay.apmobilesecuritysdk.g.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (Throwable e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
    }

    public static synchronized c b() {
        synchronized (d.class) {
            String a = com.alipay.apmobilesecuritysdk.g.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            if (a.a(a)) {
                return null;
            }
            c a2 = a(a);
            return a2;
        }
    }

    public static synchronized c b(Context context) {
        c a;
        synchronized (d.class) {
            String a2 = com.alipay.apmobilesecuritysdk.g.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (a.a(a2)) {
                a2 = com.alipay.apmobilesecuritysdk.g.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            }
            a = a(a2);
        }
        return a;
    }

    public static synchronized c c(Context context) {
        synchronized (d.class) {
            String a = com.alipay.apmobilesecuritysdk.g.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (a.a(a)) {
                return null;
            }
            c a2 = a(a);
            return a2;
        }
    }
}
