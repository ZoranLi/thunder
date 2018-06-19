package com.huawei.hms.update.f.a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MultiCardMTKImpl */
final class c extends a {
    c() {
    }

    public final int b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.e();	 Catch:{ ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = "MultiCardMTKImpl";
        r1 = "Failed to invoke [TelephonyManager].getDefaultSubscription()";
        com.huawei.hms.support.log.a.c(r0, r1);
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.f.a.c.b():int");
    }

    private int e() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("android.telephony.TelephonyManager");
        Object invoke = cls.getDeclaredMethod("getDefault", null).invoke(null, null);
        Method declaredMethod = cls.getDeclaredMethod("getDefaultSim", null);
        declaredMethod.setAccessible(true);
        return ((Integer) declaredMethod.invoke(invoke, null)).intValue();
    }

    final Object c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
        return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
    }

    public final boolean d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f();	 Catch:{ ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005, ClassNotFoundException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = "MultiCardMTKImpl";
        r1 = "Failed to invoke FeatureOption.MTK_GEMINI_SUPPORT";
        com.huawei.hms.support.log.a.c(r0, r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.f.a.c.d():boolean");
    }

    private boolean f() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
        declaredField.setAccessible(true);
        return declaredField.getBoolean(null);
    }
}
