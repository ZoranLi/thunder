package com.xunlei.downloadprovider.h;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.app.PollingService;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.xllib.android.XLIntent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/* compiled from: PollingUtil */
public class i {
    private static final String a = "i";
    private static Map<String, Boolean> b = new HashMap();

    public static void a(Context context, String str) {
        if (!b.containsKey(str)) {
            Intent xLIntent = new XLIntent(context, PollingService.class);
            xLIntent.setAction(str);
            context = PendingIntent.getService(context, 0, xLIntent, 134217728);
            g a = g.a();
            a.a.scheduleAtFixedRate(new h(a, context), 0, 60000, TimeUnit.MILLISECONDS);
        }
        b.put(str, Boolean.valueOf(true));
    }

    public static void a(String str) {
        b.put(str, Boolean.valueOf(false));
        boolean z = true;
        for (Entry value : b.entrySet()) {
            if (((Boolean) value.getValue()).booleanValue()) {
                z = false;
            }
        }
        if (z) {
            g.a().a.shutdownNow();
        }
    }

    public static void b(Context context, String str) {
        if ("com.xunlei.downloadprovider.app.action.CHECK_LIVE_UPDATE".equals(str)) {
            f.a(context, "last_live_check_time", 0);
            f.a(context, "next_live_check_interval", 0);
            return;
        }
        if ("com.xunlei.downloadprovider.app.action.CHECK_FOLLOW_UPDATE".equals(str) != null) {
            f.a(context, "last_follow_check_time", 0);
            f.a(context, "next_follow_check_interval", 0);
        }
    }

    public static long a() {
        return (long) (d.a().b.g() * 60000.0d);
    }

    public static boolean b(String str) {
        Boolean bool = (Boolean) b.get(str);
        if (bool == null) {
            return null;
        }
        return bool.booleanValue();
    }
}
