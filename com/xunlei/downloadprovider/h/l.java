package com.xunlei.downloadprovider.h;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: XLUtil */
public class l {
    private static final String a = "l";

    public static String a() {
        return BrothersApplication.getApplicationInstance().getPackageName();
    }

    public static void a(Context context) {
        try {
            StringBuilder stringBuilder = new StringBuilder("package:");
            stringBuilder.append(BrothersApplication.getApplicationInstance().getPackageName());
            Intent xLIntent = new XLIntent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(stringBuilder.toString()));
            if (VERSION.SDK_INT >= 21) {
                xLIntent.setFlags(524288);
            } else {
                xLIntent.setFlags(524288);
            }
            context.startActivity(xLIntent);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static boolean b() {
        return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.equalsIgnoreCase("Xiaomi");
    }

    public static boolean c() {
        int parseInt;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            parseInt = Integer.parseInt((String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.hw_emui_api_level"}));
        } catch (Exception e) {
            e.printStackTrace();
            parseInt = 0;
        }
        return parseInt >= 8;
    }

    public static boolean e() {
        return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.equalsIgnoreCase("OPPO");
    }

    public static void a(java.lang.Object r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r1.getClass();	 Catch:{ Throwable -> 0x0011 }
        r2 = r0.getDeclaredField(r2);	 Catch:{ Throwable -> 0x0011 }
        r0 = 1;	 Catch:{ Throwable -> 0x0011 }
        r2.setAccessible(r0);	 Catch:{ Throwable -> 0x0011 }
        r0 = 0;	 Catch:{ Throwable -> 0x0011 }
        r2.set(r1, r0);	 Catch:{ Throwable -> 0x0011 }
        return;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.h.l.a(java.lang.Object, java.lang.String):void");
    }

    public static boolean d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.util.Properties;	 Catch:{ Exception -> 0x0036 }
        r1.<init>();	 Catch:{ Exception -> 0x0036 }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0036 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0036 }
        r4 = android.os.Environment.getRootDirectory();	 Catch:{ Exception -> 0x0036 }
        r5 = "build.prop";	 Catch:{ Exception -> 0x0036 }
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x0036 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0036 }
        r1.load(r2);	 Catch:{ Exception -> 0x0036 }
        r2 = "ro.vivo.build.version.sdk";	 Catch:{ Exception -> 0x0036 }
        r3 = 0;	 Catch:{ Exception -> 0x0036 }
        r2 = r1.getProperty(r2, r3);	 Catch:{ Exception -> 0x0036 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ Exception -> 0x0036 }
    L_0x0022:
        r2 = "ro.vivo.product.platform";	 Catch:{ Exception -> 0x0036 }
        r2 = r1.getProperty(r2, r3);	 Catch:{ Exception -> 0x0036 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ Exception -> 0x0036 }
    L_0x002a:
        r2 = "ro.vivo.rom.style";	 Catch:{ Exception -> 0x0036 }
        r1 = r1.getProperty(r2, r3);	 Catch:{ Exception -> 0x0036 }
        if (r1 == 0) goto L_0x0033;
    L_0x0032:
        goto L_0x0034;
    L_0x0033:
        return r0;
    L_0x0034:
        r0 = 1;
        return r0;
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.h.l.d():boolean");
    }
}
