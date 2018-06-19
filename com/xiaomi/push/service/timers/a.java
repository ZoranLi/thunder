package com.xiaomi.push.service.timers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.logger.b;

public final class a {
    private static a a;

    interface a {
        void a();

        void a(boolean z);

        boolean b();
    }

    public static synchronized void a() {
        synchronized (a.class) {
            if (a == null) {
                return;
            }
            a.a();
        }
    }

    public static void a(Context context) {
        a bVar;
        context = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            bVar = new b(context);
        } else {
            Object obj = null;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if ("com.xiaomi.push.service.XMJobService".equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            obj = 1;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("check service err : ");
                stringBuilder.append(e.getMessage());
                b.a(stringBuilder.toString());
            }
            if (obj == null && h.b(context)) {
                throw new RuntimeException("Should export service: com.xiaomi.push.service.XMJobService with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
            int i = VERSION.SDK_INT;
            bVar = new b(context);
        }
        a = bVar;
    }

    public static synchronized void a(boolean z) {
        synchronized (a.class) {
            if (a == null) {
                b.a("timer is not initialized");
                return;
            }
            a.a(z);
        }
    }

    public static synchronized boolean b() {
        synchronized (a.class) {
            if (a == null) {
                return false;
            }
            boolean b = a.b();
            return b;
        }
    }
}
