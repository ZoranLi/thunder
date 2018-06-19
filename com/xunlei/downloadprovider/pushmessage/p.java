package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.umeng.message.PushAgent;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.getui.a;

/* compiled from: XLPushUtil */
public final class p {
    public static boolean a = false;

    public static boolean a(Context context) {
        try {
            context = context.getPackageManager().getPackageInfo(HuaweiApiAvailability.SERVICES_PACKAGE, 0);
            if (context != null) {
                context = context.versionCode;
                if (context < 20502300) {
                    return true;
                }
                return false;
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        context2 = null;
        if (context2 < 20502300) {
            return false;
        }
        return true;
    }

    public static void a(Context context, String str) {
        e.a(context, str);
        if (BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER.equals(str) != null) {
            a.g().a(context);
        }
    }

    public static void a(String[] strArr) {
        if (strArr.length != 0) {
            e.c().a(strArr);
        }
    }

    public static void b(Context context) {
        if (e.c().a() == "upush") {
            PushAgent.getInstance(context).onAppStart();
        }
    }

    public static void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.downloadprovider.pushmessage.b.b.a();	 Catch:{ Exception -> 0x003e }
        r1 = 0;	 Catch:{ Exception -> 0x003e }
        r2 = r0.a;	 Catch:{ Exception -> 0x003e }
        r3 = -1;	 Catch:{ Exception -> 0x003e }
        if (r2 != 0) goto L_0x000d;	 Catch:{ Exception -> 0x003e }
    L_0x000b:
        r5 = r3;	 Catch:{ Exception -> 0x003e }
        goto L_0x0015;	 Catch:{ Exception -> 0x003e }
    L_0x000d:
        r0 = r0.a;	 Catch:{ Exception -> 0x003e }
        r2 = "update_last_time";	 Catch:{ Exception -> 0x003e }
        r5 = r0.getLong(r2, r3);	 Catch:{ Exception -> 0x003e }
    L_0x0015:
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x003e }
        r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));	 Catch:{ Exception -> 0x003e }
        r2 = 1;	 Catch:{ Exception -> 0x003e }
        if (r0 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x003e }
    L_0x001e:
        goto L_0x0030;	 Catch:{ Exception -> 0x003e }
    L_0x001f:
        r3 = 0;	 Catch:{ Exception -> 0x003e }
        r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));	 Catch:{ Exception -> 0x003e }
        if (r0 <= 0) goto L_0x002f;	 Catch:{ Exception -> 0x003e }
    L_0x0025:
        r3 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Exception -> 0x003e }
        r9 = r5 + r3;	 Catch:{ Exception -> 0x003e }
        r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));	 Catch:{ Exception -> 0x003e }
        if (r0 > 0) goto L_0x002f;	 Catch:{ Exception -> 0x003e }
    L_0x002e:
        goto L_0x0030;	 Catch:{ Exception -> 0x003e }
    L_0x002f:
        r2 = r1;	 Catch:{ Exception -> 0x003e }
    L_0x0030:
        if (r2 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x003e }
    L_0x0032:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ Exception -> 0x003e }
        r0 = com.xunlei.downloadprovider.pushmessage.report.a.a(r0);	 Catch:{ Exception -> 0x003e }
        r0.a();	 Catch:{ Exception -> 0x003e }
    L_0x003d:
        return;
    L_0x003e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.p.a():void");
    }
}
