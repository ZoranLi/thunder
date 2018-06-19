package com.xunlei.xllib.android;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;

/* compiled from: ScreenBrightnessTool */
public final class c {
    private boolean a;
    private Context b;

    private c(Context context, boolean z) {
        this.b = context;
        this.a = z;
    }

    public static com.xunlei.xllib.android.c a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getContentResolver();	 Catch:{ SettingNotFoundException -> 0x0015 }
        r1 = "screen_brightness_mode";	 Catch:{ SettingNotFoundException -> 0x0015 }
        r0 = android.provider.Settings.System.getInt(r0, r1);	 Catch:{ SettingNotFoundException -> 0x0015 }
        r1 = 1;
        if (r0 != r1) goto L_0x000e;
    L_0x000d:
        goto L_0x000f;
    L_0x000e:
        r1 = 0;
    L_0x000f:
        r0 = new com.xunlei.xllib.android.c;
        r0.<init>(r2, r1);
        return r0;
    L_0x0015:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.android.c.a(android.content.Context):com.xunlei.xllib.android.c");
    }

    public final int a() {
        try {
            return System.getInt(this.b.getContentResolver(), "screen_brightness");
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void a(int i, Activity activity) {
        if (activity != null) {
            LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = ((float) i) / 1132396544;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public static int a(Activity activity) {
        if (activity == null) {
            return 1;
        }
        return (int) (activity.getWindow().getAttributes().screenBrightness * 255.0f);
    }
}
