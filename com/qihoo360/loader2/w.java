package com.qihoo360.loader2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.qihoo360.mobilesafe.a.a;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.utils.b;
import com.qihoo360.replugin.utils.d;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PluginDesc */
public class w {
    private static final String c = "w";
    private static final boolean d = a.a;
    private static final byte[] e = new byte[0];
    private static volatile BroadcastReceiver f;
    private static final byte[] g = new byte[0];
    private static volatile boolean h;
    private static volatile HashMap<String, w> k;
    String a;
    boolean b;
    private String i;
    private String j;

    public static w a(String str) {
        return (w) e().get(str);
    }

    private w(String str) {
        this.a = str;
    }

    private static boolean a(Context context) {
        context = b(context);
        int i = 0;
        if (context == null) {
            return false;
        }
        while (i < context.length()) {
            JSONObject optJSONObject = context.optJSONObject(i);
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString(c.e);
                if (!TextUtils.isEmpty(optString)) {
                    w wVar = new w(optString);
                    wVar.i = optJSONObject.optString("display");
                    wVar.j = optJSONObject.optString("desc");
                    wVar.b = optJSONObject.optBoolean("large");
                    k.put(optString, wVar);
                }
            }
            i++;
        }
        return true;
    }

    private static JSONArray b(Context context) {
        Closeable a;
        Exception e;
        Throwable th;
        try {
            RePlugin.getConfig();
            a = com.qihoo360.replugin.utils.b.a.a(context, "plugins-list.json");
            if (a != null) {
                try {
                    JSONArray jSONArray = new JSONArray(d.a((InputStream) a, com.qihoo360.replugin.utils.a.a));
                    b.a(a);
                    return jSONArray;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (d) {
                            e.getMessage();
                        }
                        b.a(a);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        b.a(a);
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            if (d) {
                e.getMessage();
            }
            b.a(a);
            return null;
        } catch (Context context2) {
            th = context2;
            a = null;
            b.a(a);
            throw th;
        }
        b.a(a);
        return null;
    }

    private static HashMap<String, w> e() {
        if (f == null) {
            synchronized (g) {
                if (f != null) {
                } else {
                    f = new x();
                    LocalBroadcastManager.getInstance(n.a).registerReceiver(f, new IntentFilter("com.qihoo360.mobilesafe.plugin_desc_update"));
                }
            }
        }
        if (k != null && !h) {
            return k;
        }
        synchronized (e) {
            if (k == null || h) {
                k = new HashMap();
                a(n.a);
                h = false;
                return k;
            }
            HashMap<String, w> hashMap = k;
            return hashMap;
        }
    }
}
