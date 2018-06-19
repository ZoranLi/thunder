package com.taobao.accs.utl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.d.a;
import com.xunlei.download.Downloads.Impl.RequestHeaders;

/* compiled from: Taobao */
public class l {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";
    private static final byte[] a = new byte[0];

    public static void a(Context context, int i) {
        try {
            synchronized (a) {
                ALog.i("Utils", "setMode", Constants.KEY_MODE, Integer.valueOf(i));
                context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                context.putInt(Constants.SP_KEY_DEBUG_MODE, i);
                context.commit();
            }
        } catch (Context context2) {
            ALog.e("Utils", "setMode", context2, new Object[0]);
        }
    }

    public static int a(Context context) {
        Throwable th;
        Throwable th2;
        try {
            synchronized (a) {
                try {
                    context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.SP_KEY_DEBUG_MODE, 0);
                    ALog.i("Utils", "getMode", Constants.KEY_MODE, Integer.valueOf(context));
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            context = null;
            ALog.e("Utils", "getMode", th2, new Object[0]);
            return context;
        }
    }

    public static void b(Context context) {
        try {
            synchronized (a) {
                context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                context.clear();
                context.commit();
            }
        } catch (Context context2) {
            ALog.e("Utils", "clearAllSharePreferences", context2, new Object[0]);
        }
    }

    public static void c(Context context) {
        try {
            Class loadClass = a.a().b().loadClass("com.taobao.accs.utl.UtilityImpl");
            loadClass.getMethod("killService", new Class[]{Context.class}).invoke(loadClass, new Object[]{context});
        } catch (Context context2) {
            ALog.e("Utils", "killservice", context2, new Object[0]);
            context2.printStackTrace();
        }
    }

    public static boolean d(Context context) {
        try {
            Class loadClass = a.a().b().loadClass("com.taobao.accs.utl.UtilityImpl");
            context = ((Boolean) loadClass.getMethod("isMainProcess", new Class[]{Context.class}).invoke(loadClass, new Object[]{context})).booleanValue();
        } catch (Context context2) {
            ALog.e("Utils", "killservice", context2, new Object[0]);
            context2.printStackTrace();
            context2 = 1;
        }
        ALog.i("Utils", "isMainProcess", "result", Boolean.valueOf(context2));
        return context2;
    }

    public static void a(Context context, String str) {
        try {
            Class loadClass = a.a().b().loadClass("org.android.agoo.common.Config");
            loadClass.getMethod("setAgooAppKey", new Class[]{Context.class, String.class}).invoke(loadClass, new Object[]{context, str});
        } catch (Context context2) {
            ALog.e("Utils", "setAgooAppkey", context2, new Object[0]);
            context2.printStackTrace();
        }
    }

    @Deprecated
    public static void a() {
        try {
            Class loadClass = a.a().b().loadClass("com.taobao.accs.client.AccsConfig");
            loadClass.getMethod("build", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (Throwable th) {
            ALog.e("Utils", "initConfig", th, new Object[0]);
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ALog.e("Utils", "setSpValue null", new Object[0]);
            return;
        }
        try {
            synchronized (a) {
                context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                context.putString(str, str2);
                context.apply();
            }
            ALog.i("Utils", "setSpValue", "key", str, RequestHeaders.COLUMN_VALUE, str2);
        } catch (Context context2) {
            ALog.e("Utils", "setSpValue fail", context2, new Object[0]);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = a;	 Catch:{ Throwable -> 0x003a }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x003a }
        r3 = "ACCS_SDK";
        r4 = r4.getSharedPreferences(r3, r1);	 Catch:{ all -> 0x0037 }
        r4 = r4.getString(r5, r0);	 Catch:{ all -> 0x0037 }
        monitor-exit(r2);	 Catch:{ all -> 0x0034 }
        r5 = "Utils";
        r0 = "getSpValue";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0032 }
        r3 = "value";
        r2[r1] = r3;	 Catch:{ Throwable -> 0x0032 }
        r3 = 1;
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0032 }
        com.taobao.accs.utl.ALog.i(r5, r0, r2);	 Catch:{ Throwable -> 0x0032 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0032 }
        if (r5 == 0) goto L_0x0045;
    L_0x0027:
        r5 = "Utils";
        r0 = "getSpValue use default!";
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0032 }
        com.taobao.accs.utl.ALog.e(r5, r0, r2);	 Catch:{ Throwable -> 0x0032 }
        r4 = r6;
        goto L_0x0045;
    L_0x0032:
        r5 = move-exception;
        goto L_0x003c;
    L_0x0034:
        r5 = move-exception;
        r0 = r4;
        goto L_0x0038;
    L_0x0037:
        r5 = move-exception;
    L_0x0038:
        monitor-exit(r2);	 Catch:{ all -> 0x0037 }
        throw r5;	 Catch:{ Throwable -> 0x003a }
    L_0x003a:
        r5 = move-exception;
        r4 = r0;
    L_0x003c:
        r6 = "Utils";
        r0 = "getSpValue fail";
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r6, r0, r5, r1);
    L_0x0045:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.l.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void e(Context context) {
        try {
            context = context.getSharedPreferences("AGOO_BIND", 0).edit();
            context.clear();
            context.apply();
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static Bundle f(Context context) {
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context != null) {
                return context.metaData;
            }
            return null;
        } catch (Context context2) {
            ALog.e("Utils", "getMetaInfo", context2, new Object[0]);
            return null;
        }
    }
}
