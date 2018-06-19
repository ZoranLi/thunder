package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;

public class v {
    public static Object a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        return a(obj, str, null, new Object[0]);
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Class cls = obj.getClass();
            Method method = VERSION.SDK_INT > 10 ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                return new String("AuthenticationFail");
            }
            if (str != null && (str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                return null;
            }
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            new StringBuilder("invokeInstance -- exceptions:").append(stringWriter.toString());
            return null;
        }
    }

    public static Object a(String str, String str2) {
        try {
            return Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            return null;
        }
    }

    public static java.lang.reflect.Method a(java.lang.Object r2, java.lang.String r3, java.lang.Class<?>... r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = r2.getClass();
    L_0x0004:
        r0 = java.lang.Object.class;
        r1 = 0;
        if (r2 == r0) goto L_0x0016;
    L_0x0009:
        if (r2 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r0 = r2.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0011 }
        return r0;
    L_0x0011:
        r2 = r2.getSuperclass();
        goto L_0x0004;
    L_0x0016:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.v.a(java.lang.Object, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
