package com.xunlei.xllib.android;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.lang.reflect.Method;

/* compiled from: ScreenUtil */
public abstract class d {
    public static int a(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int b(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int c(Context context) {
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        } catch (Context context22) {
            context22.printStackTrace();
            return null;
        } catch (Context context222) {
            context222.printStackTrace();
            return null;
        } catch (Context context2222) {
            context2222.printStackTrace();
            return null;
        }
    }

    public static int d(Context context) {
        int identifier = context.getResources().getIdentifier("config_showNavigationBar", "bool", DispatchConstants.ANDROID);
        if (identifier == 0 || !context.getResources().getBoolean(identifier)) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static Point e(Context context) {
        Point point = new Point(0, 0);
        if (context == null) {
            return point;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        try {
            if (VERSION.SDK_INT >= 17) {
                context.getRealMetrics(displayMetrics);
                point.x = displayMetrics.widthPixels;
                point.y = displayMetrics.heightPixels;
            } else {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                try {
                    point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(context, new Object[0])).intValue();
                    point.y = ((Integer) method.invoke(context, new Object[0])).intValue();
                } catch (Context context2) {
                    context2.printStackTrace();
                } catch (Context context22) {
                    context22.printStackTrace();
                } catch (Context context222) {
                    context222.printStackTrace();
                }
            }
        } catch (Context context2222) {
            context2222.printStackTrace();
        }
        return point;
    }

    public static float f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static int a(Context context, float f) {
        return (int) ((f(context) * f) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public static boolean g(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = r2.getContentResolver();	 Catch:{ SettingNotFoundException -> 0x000f }
        r1 = "accelerometer_rotation";	 Catch:{ SettingNotFoundException -> 0x000f }
        r2 = android.provider.Settings.System.getInt(r2, r1);	 Catch:{ SettingNotFoundException -> 0x000f }
        r1 = 1;
        if (r2 != r1) goto L_0x000f;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.android.d.g(android.content.Context):boolean");
    }
}
