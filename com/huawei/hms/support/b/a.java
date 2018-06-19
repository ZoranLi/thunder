package com.huawei.hms.support.b;

import android.content.Context;
import android.text.TextUtils;
import com.hianalytics.android.v1.HiAnalytics;
import com.huawei.hms.c.g;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: HiAnalyticsUtil */
public class a {
    private static a a;
    private static final Object b = new Object();

    public static a a() {
        a aVar;
        synchronized (b) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void a(Context context, String str, Map<String, String> map) {
        if (!b()) {
            map = a(map);
            if (!TextUtils.isEmpty(map)) {
                HiAnalytics.onEvent(context, str, map);
            }
        }
    }

    private String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (Map<String, String> map2) {
            StringBuilder stringBuilder = new StringBuilder("AnalyticsHelper create json exception");
            stringBuilder.append(map2.getMessage());
            com.huawei.hms.support.log.a.d("HiAnalyticsUtil", stringBuilder.toString());
        }
        return jSONObject.toString();
    }

    public boolean b() {
        if (g.a()) {
            return false;
        }
        com.huawei.hms.support.log.a.a("HiAnalyticsUtil", "not ChinaROM ");
        return true;
    }
}
