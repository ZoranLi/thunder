package com.xunlei.tdlive.util;

import android.content.Context;

/* compiled from: AppContext */
public class a {
    private static Context a;
    private static k<a> b;

    /* compiled from: AppContext */
    public interface a {
        void a(Context context);
    }

    public static void a(Context context) {
        if (context != null && a == null) {
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            if (applicationContext == null) {
                a = context;
            }
            if (b != null) {
                b.a(new com.xunlei.tdlive.util.k.a<a>() {
                    public final void a(a aVar, Object... objArr) {
                        aVar.a(a.a);
                    }
                }, new Object[0]);
            }
        }
    }

    public static android.content.Context a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a;
        if (r0 != 0) goto L_0x0021;
    L_0x0004:
        r0 = "android.app.ActivityThread";	 Catch:{ Throwable -> 0x0021 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0021 }
        r1 = "currentApplication";	 Catch:{ Throwable -> 0x0021 }
        r2 = 0;	 Catch:{ Throwable -> 0x0021 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0021 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Throwable -> 0x0021 }
        r1 = 0;	 Catch:{ Throwable -> 0x0021 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0021 }
        r0 = r0.invoke(r1, r2);	 Catch:{ Throwable -> 0x0021 }
        r0 = (android.app.Application) r0;	 Catch:{ Throwable -> 0x0021 }
        if (r0 == 0) goto L_0x0021;	 Catch:{ Throwable -> 0x0021 }
    L_0x001e:
        a(r0);	 Catch:{ Throwable -> 0x0021 }
    L_0x0021:
        r0 = a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.a.a():android.content.Context");
    }
}
