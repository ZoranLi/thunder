package com.alibaba.fastjson.c;

import com.alipay.sdk.util.h;
import java.lang.reflect.Method;

/* compiled from: ASMUtils */
public class c {
    public static final String a;
    public static final boolean b;

    static {
        boolean z;
        String property = System.getProperty("java.vm.name");
        a = property;
        if (property != null) {
            property = property.toLowerCase();
            if (property.contains("dalvik") || property.contains("lemur")) {
                z = true;
                b = z;
            }
        }
        z = false;
        b = z;
    }

    public static String a(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder stringBuilder = new StringBuilder((parameterTypes.length + 1) << 4);
        stringBuilder.append('(');
        for (Class a : parameterTypes) {
            stringBuilder.append(a(a));
        }
        stringBuilder.append(')');
        stringBuilder.append(a(method.getReturnType()));
        return stringBuilder.toString();
    }

    public static String a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return c(cls);
        }
        if (cls.isArray()) {
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(a(cls.getComponentType()));
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder("L");
        stringBuilder.append(b(cls));
        stringBuilder.append(h.b);
        return stringBuilder.toString();
    }

    public static String b(Class<?> cls) {
        if (cls.isArray()) {
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(a(cls.getComponentType()));
            return stringBuilder.toString();
        } else if (cls.isPrimitive()) {
            return c(cls);
        } else {
            return cls.getName().replace('.', '/');
        }
    }

    private static String c(Class<?> cls) {
        if (Integer.TYPE.equals(cls)) {
            return "I";
        }
        if (Void.TYPE.equals(cls)) {
            return "V";
        }
        if (Boolean.TYPE.equals(cls)) {
            return "Z";
        }
        if (Character.TYPE.equals(cls)) {
            return "C";
        }
        if (Byte.TYPE.equals(cls)) {
            return "B";
        }
        if (Short.TYPE.equals(cls)) {
            return "S";
        }
        if (Float.TYPE.equals(cls)) {
            return "F";
        }
        if (Long.TYPE.equals(cls)) {
            return "J";
        }
        if (Double.TYPE.equals(cls)) {
            return "D";
        }
        StringBuilder stringBuilder = new StringBuilder("Type: ");
        stringBuilder.append(cls.getCanonicalName());
        stringBuilder.append(" is not a primitive type");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static boolean a(String str) {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt > '\u0000') {
                if (charAt <= '') {
                    i++;
                }
            }
            return false;
        }
        return true;
    }
}
