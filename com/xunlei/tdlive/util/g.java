package com.xunlei.tdlive.util;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: MethodCompat */
public class g {
    private static Drawable a;

    public static void a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static Drawable a(Context context) {
        if (a == null) {
            a = new BitmapDrawable(context.getResources(), null);
        }
        return a;
    }

    public static android.graphics.drawable.Drawable a(android.content.Context r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0024 }
        r1.<init>();	 Catch:{ Throwable -> 0x0024 }
        r2 = r3.getPackageName();	 Catch:{ Throwable -> 0x0024 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0024 }
        r2 = ".R$drawable";	 Catch:{ Throwable -> 0x0024 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0024 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0024 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0024 }
        r2 = 0;	 Catch:{ Throwable -> 0x0024 }
        r4 = com.xunlei.tdlive.util.h.a(r1, r0, r4, r2);	 Catch:{ Throwable -> 0x0024 }
        r3 = a(r3, r4);	 Catch:{ Throwable -> 0x0024 }
        return r3;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.g.a(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }

    public static Drawable a(View view, int i) {
        return a(view.getResources(), i);
    }

    public static Drawable a(Context context, int i) {
        return a(context.getResources(), i);
    }

    public static android.graphics.drawable.Drawable a(android.content.res.Resources r1, int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r1.getDrawable(r2);	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        r1 = r1.getDrawable(r2, r0);	 Catch:{ Throwable -> 0x000b }
        return r1;
    L_0x000b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.g.a(android.content.res.Resources, int):android.graphics.drawable.Drawable");
    }
}
