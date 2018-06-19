package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.metoknlp.geofencing.a;
import com.xiaomi.xmpush.thrift.m;
import java.util.ArrayList;
import java.util.Iterator;

public class k {
    public static void a(Context context, String str) {
        ArrayList b = h.a(context).b(str);
        if (b != null && b.size() > 0) {
            if (h.a(context).e(str) == 0) {
                StringBuilder stringBuilder = new StringBuilder("appIsUninstalled. failed to delete geofencing with package name. name:");
                stringBuilder.append(str);
                b.a(stringBuilder.toString());
            }
            Iterator it = b.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (mVar == null) {
                    StringBuilder stringBuilder2 = new StringBuilder("appIsUninstalled. failed to find geofence with package name. name:");
                    stringBuilder2.append(str);
                    b.a(stringBuilder2.toString());
                    return;
                }
                a(mVar.a(), context);
                if (j.a(context).b(mVar.a()) == 0) {
                    StringBuilder stringBuilder3 = new StringBuilder("appIsUninstalled. failed to delete geoMessage with package name. name:");
                    stringBuilder3.append(str);
                    stringBuilder3.append(", geoId:");
                    stringBuilder3.append(mVar.a());
                    b.a(stringBuilder3.toString());
                }
            }
        }
    }

    public static void a(Context context, boolean z) {
        bb.a(context).a("mipush_extra", "geo_switch", Boolean.valueOf(z));
    }

    public static void a(String str, Context context) {
        new a(context).a(context, "com.xiaomi.xmsf", str);
    }

    public static boolean a(Context context) {
        return a(context, "com.xiaomi.metoknlp", 6);
    }

    public static boolean a(android.content.Context r1, java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000a }
        r1 = r1.getPackageInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x000a }
        goto L_0x000b;
    L_0x000a:
        r1 = 0;
    L_0x000b:
        if (r1 == 0) goto L_0x0013;
    L_0x000d:
        r1 = r1.versionCode;
        if (r1 < r3) goto L_0x0013;
    L_0x0011:
        r1 = 1;
        return r1;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.k.a(android.content.Context, java.lang.String, int):boolean");
    }

    public static boolean b(Context context) {
        return a(context, "com.xiaomi.xmsf", 106) && (a(context, "com.xiaomi.metok", 20) || a(context, "com.xiaomi.metoknlp", 6));
    }

    public static boolean c(Context context) {
        return TextUtils.equals(context.getPackageName(), "com.xiaomi.xmsf");
    }

    public static boolean d(Context context) {
        return a(context);
    }

    public static boolean e(Context context) {
        return bb.a(context).a("mipush_extra", "geo_switch", false);
    }
}
