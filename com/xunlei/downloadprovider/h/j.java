package com.xunlei.downloadprovider.h;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.DispatchConstants;

/* compiled from: StatusBarUtil */
public final class j {
    private static boolean a = false;
    private static boolean b;

    public static boolean a(Activity activity) {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        activity = activity.getWindow().getDecorView();
        if (activity != null) {
            activity.setSystemUiVisibility(activity.getSystemUiVisibility() | 8192);
        }
        return true;
    }

    public static boolean b(Activity activity) {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        activity = activity.getWindow().getDecorView();
        if (activity != null) {
            activity.setSystemUiVisibility(activity.getSystemUiVisibility() & -8193);
        }
        return true;
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : null;
    }

    public static boolean b(Context context) {
        if (!a) {
            if (!c(context) && context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism") == null) {
                if (a() == null) {
                    context = null;
                    b = context;
                    a = true;
                }
            }
            context = 1;
            b = context;
            a = true;
        }
        return b;
    }

    private static boolean a() {
        try {
            return ((Boolean) Class.forName("android.util.FtFeature").getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r3 = r3.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r1 = "com.huawei.android.util.HwNotchSizeUtil";	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r3 = r3.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r1 = "hasNotchInScreen";	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r2 = new java.lang.Class[r0];	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r1 = r3.getMethod(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r2 = new java.lang.Object[r0];	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r3 = r1.invoke(r3, r2);	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        r3 = r3.booleanValue();	 Catch:{ ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020, ClassNotFoundException -> 0x0020 }
        return r3;
    L_0x0020:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.h.j.c(android.content.Context):boolean");
    }

    public static void a(android.view.Window r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r6 = r6.getAttributes();
        r0 = "com.huawei.android.view.LayoutParamsEx";	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r1 = 1;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r2 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r3 = android.view.WindowManager.LayoutParams.class;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r4 = 0;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r2[r4] = r3;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r2 = r0.getConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r3 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r3[r4] = r6;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r6 = r2.newInstance(r3);	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r2 = "addHwFlags";	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r3 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r5 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r3[r4] = r5;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r0 = r0.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r1 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r1[r4] = r2;	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        r0.invoke(r6, r1);	 Catch:{ ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, ClassNotFoundException -> 0x003c, Exception -> 0x003b }
        return;
    L_0x003b:
        return;
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.h.j.a(android.view.Window):void");
    }
}
