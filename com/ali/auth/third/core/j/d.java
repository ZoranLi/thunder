package com.ali.auth.third.core.j;

import com.ali.auth.third.core.config.a;
import java.util.HashMap;
import java.util.Map;

public class d {
    private static final Map<String, Class<?>> a = new HashMap();
    private static final String b = "d";

    static {
        a.put("short", Short.TYPE);
        a.put("int", Integer.TYPE);
        a.put("long", Long.TYPE);
        a.put("double", Double.TYPE);
        a.put("float", Float.TYPE);
        a.put("char", Character.TYPE);
        a.put("boolean", Boolean.TYPE);
    }

    private static <T> T a(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Fail to create the instance of type ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(", the error is ");
            stringBuilder.append(e.getMessage());
            cls = a.a;
            throw new RuntimeException(e);
        }
    }

    public static Object a(String str) {
        try {
            return a(Class.forName(str));
        } catch (String str2) {
            throw str2;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Fail to create the instance of type ");
            stringBuilder.append(str2);
            stringBuilder.append(", the error is ");
            stringBuilder.append(e.getMessage());
            str2 = a.a;
            throw new RuntimeException(e);
        }
    }
}
