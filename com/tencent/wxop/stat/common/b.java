package com.tencent.wxop.stat.common;

import android.content.Context;
import com.tencent.wxop.stat.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class b {
    static d a;
    private static StatLogger d = l.b();
    private static JSONObject e = new JSONObject();
    Integer b = null;
    String c = null;

    public b(Context context) {
        try {
            a(context);
            this.b = l.k(context.getApplicationContext());
            this.c = a.a(context).b();
        } catch (Throwable th) {
            d.e(th);
        }
    }

    static synchronized d a(Context context) {
        d dVar;
        synchronized (b.class) {
            if (a == null) {
                a = new d(context.getApplicationContext());
            }
            dVar = a;
        }
        return dVar;
    }

    public static void a(Context context, Map<String, String> map) {
        if (map != null) {
            for (Entry entry : new HashMap(map).entrySet()) {
                e.put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    public void a(JSONObject jSONObject, Thread thread) {
        Object jSONObject2 = new JSONObject();
        try {
            String str;
            if (a != null) {
                a.a(jSONObject2, thread);
            }
            r.a(jSONObject2, "cn", this.c);
            if (this.b != null) {
                jSONObject2.put("tn", this.b);
            }
            if (thread == null) {
                str = "ev";
            } else {
                str = "errkv";
                jSONObject2 = jSONObject2.toString();
            }
            jSONObject.put(str, jSONObject2);
            if (e != null && e.length() > 0) {
                jSONObject.put("eva", e);
            }
        } catch (Throwable th) {
            d.e(th);
        }
    }
}
