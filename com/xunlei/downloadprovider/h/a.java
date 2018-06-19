package com.xunlei.downloadprovider.h;

import android.content.Context;
import android.os.Binder;
import java.lang.reflect.Method;

/* compiled from: AppOpUtil */
public final class a {
    public static boolean a;

    public static boolean a(Context context) {
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService == null) {
                return false;
            }
            Method method = systemService.getClass().getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            if (method == null) {
                return false;
            }
            if (((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == null) {
                return true;
            }
            return false;
        } catch (Context context2) {
            context2.printStackTrace();
            return false;
        }
    }
}
