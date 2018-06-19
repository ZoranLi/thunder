package com.qihoo360.loader2;

import android.os.Build.VERSION;
import com.qihoo360.mobilesafe.a.a;
import java.lang.reflect.Method;

/* compiled from: VMRuntimeCompat */
public final class at {
    private static final byte[] a = new byte[0];
    private static volatile Boolean b;

    public static boolean a() {
        if (b != null) {
            return b.booleanValue();
        }
        synchronized (a) {
            if (b != null) {
                boolean booleanValue = b.booleanValue();
                return booleanValue;
            }
            Boolean valueOf = Boolean.valueOf(c());
            b = valueOf;
            booleanValue = valueOf.booleanValue();
            return booleanValue;
        }
    }

    private static boolean c() {
        try {
            if (VERSION.SDK_INT < 21) {
                return false;
            }
            Class cls = Class.forName("dalvik.system.VMRuntime");
            if (cls == null) {
                return false;
            }
            Method declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0]);
            if (declaredMethod == null) {
                return false;
            }
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke == null) {
                return false;
            }
            Method declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0]);
            if (declaredMethod2 == null) {
                return false;
            }
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                return ((Boolean) invoke2).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            if (a.a) {
                th.printStackTrace();
            }
        }
    }

    public static String b() {
        return a() ? "arm64" : "arm";
    }
}
