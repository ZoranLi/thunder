package com.alibaba.baichuan.android.trade.utils.c;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final Map a = new HashMap();
    private static final Map b = new HashMap();
    private static final Map c = new HashMap();
    private static final Map d = new HashMap();
    private static final String e = "a";

    static {
        a.put("short", Short.TYPE);
        a.put("int", Integer.TYPE);
        a.put("long", Long.TYPE);
        a.put("double", Double.TYPE);
        a.put("float", Float.TYPE);
        a.put("char", Character.TYPE);
    }

    private static Object a(Class cls, Class[] clsArr, Object[] objArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length != 0) {
                    return cls.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("Fail to create the instance of type ");
                stringBuilder.append(cls != null ? cls.getName() : null);
                stringBuilder.append(", the error is ");
                stringBuilder.append(e.getMessage());
                com.alibaba.baichuan.android.trade.utils.g.a.b();
                return null;
            }
        }
        return cls.newInstance();
    }

    public static Object a(String str, String str2, String[] strArr, Object obj, Object[] objArr) {
        try {
            Class cls = (Class) b.get(str);
            if (cls == null) {
                cls = Class.forName(str);
                b.put(str, cls);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 2; i++) {
                stringBuffer.append(strArr[i]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(stringBuffer.toString());
            String stringBuilder2 = stringBuilder.toString();
            Method method = (Method) c.get(stringBuilder2);
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            Method method2 = cls.getMethod(str2, a(strArr));
            if (method2 != null) {
                c.put(stringBuilder2, method2);
                return method2.invoke(obj, objArr);
            }
            return null;
        } catch (Exception e) {
            StringBuilder stringBuilder3 = new StringBuilder("Fail to invoke the ");
            stringBuilder3.append(str);
            stringBuilder3.append(".");
            stringBuilder3.append(str2);
            stringBuilder3.append(", the error is ");
            stringBuilder3.append(e.getMessage());
            com.alibaba.baichuan.android.trade.utils.g.a.b();
        }
    }

    public static Object a(String str, String[] strArr, Object[] objArr) {
        try {
            return a(Class.forName(str), a(strArr), objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder stringBuilder = new StringBuilder("Fail to create the instance of type ");
            stringBuilder.append(str);
            stringBuilder.append(", the error is ");
            stringBuilder.append(e2.getMessage());
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return null;
        }
    }

    private static Class[] a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        Class[] clsArr = new Class[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str.length() < 7) {
                clsArr[i] = (Class) a.get(str);
            }
            if (clsArr[i] == null) {
                if ("boolean".equals(str)) {
                    clsArr[i] = Boolean.TYPE;
                } else {
                    clsArr[i] = Class.forName(str);
                }
            }
        }
        return clsArr;
    }
}
