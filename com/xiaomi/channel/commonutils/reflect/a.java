package com.xiaomi.channel.commonutils.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final Map<Class<?>, Class<?>> a;

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        a.put(Byte.class, Byte.TYPE);
        a.put(Character.class, Character.TYPE);
        a.put(Short.class, Short.TYPE);
        a.put(Integer.class, Integer.TYPE);
        a.put(Float.class, Float.TYPE);
        a.put(Long.class, Long.TYPE);
        a.put(Double.class, Double.TYPE);
        a.put(Boolean.TYPE, Boolean.TYPE);
        a.put(Byte.TYPE, Byte.TYPE);
        a.put(Character.TYPE, Character.TYPE);
        a.put(Short.TYPE, Short.TYPE);
        a.put(Integer.TYPE, Integer.TYPE);
        a.put(Float.TYPE, Float.TYPE);
        a.put(Long.TYPE, Long.TYPE);
        a.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T a(java.lang.Class<? extends java.lang.Object> r3, java.lang.Object r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
    L_0x0001:
        r1 = 1;
        if (r0 != 0) goto L_0x001a;
    L_0x0004:
        r2 = r3.getDeclaredField(r5);	 Catch:{ NoSuchFieldException -> 0x000e }
        r2.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x000d }
        r0 = r2;
        goto L_0x0012;
    L_0x000d:
        r0 = r2;
    L_0x000e:
        r3 = r3.getSuperclass();
    L_0x0012:
        if (r3 != 0) goto L_0x0001;
    L_0x0014:
        r3 = new java.lang.NoSuchFieldException;
        r3.<init>();
        throw r3;
    L_0x001a:
        r0.setAccessible(r1);
        r3 = r0.get(r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.reflect.a.a(java.lang.Class, java.lang.Object, java.lang.String):T");
    }

    public static <T> T a(Class<? extends Object> cls, String str) {
        try {
            return a((Class) cls, null, str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        return a((Class) cls, str, a(objArr)).invoke(null, b(objArr));
    }

    public static <T> T a(Object obj, String str) {
        try {
            return a(obj.getClass(), obj, str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T> T a(java.lang.Object r1, java.lang.String r2, java.lang.Object... r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = b(r1, r2, r3);	 Catch:{ Exception -> 0x0005 }
        return r3;
    L_0x0005:
        r3 = new java.lang.StringBuilder;
        r0 = "Meet exception when call Method '";
        r3.<init>(r0);
        r3.append(r2);
        r2 = "' in ";
        r3.append(r2);
        r3.append(r1);
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.reflect.a.a(java.lang.Object, java.lang.String, java.lang.Object[]):T");
    }

    public static <T> T a(java.lang.String r1, java.lang.String r2, java.lang.Object... r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0009 }
        r3 = a(r0, r2, r3);	 Catch:{ Exception -> 0x0009 }
        return r3;
    L_0x0009:
        r3 = new java.lang.StringBuilder;
        r0 = "Meet exception when call Method '";
        r3.<init>(r0);
        r3.append(r2);
        r2 = "' in ";
        r3.append(r2);
        r3.append(r1);
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.reflect.a.a(java.lang.String, java.lang.String, java.lang.Object[]):T");
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Class superclass;
            Method a = a(superclass.getDeclaredMethods(), str, (Class[]) clsArr);
            if (a != null) {
                a.setAccessible(true);
                return a;
            } else if (superclass.getSuperclass() != null) {
                superclass = superclass.getSuperclass();
            } else {
                throw new NoSuchMethodException();
            }
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), (Class[]) clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else {
            if (clsArr2 == null) {
                return clsArr.length == 0;
            } else {
                if (clsArr.length != clsArr2.length) {
                    return false;
                }
                int i = 0;
                while (i < clsArr.length) {
                    if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!a.containsKey(clsArr[i]) || !((Class) a.get(clsArr[i])).equals(a.get(clsArr2[i])))) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
    }

    private static Class<?>[] a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            Class cls = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).a;
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        return a(obj.getClass(), str, a(objArr)).invoke(obj, b(objArr));
    }

    private static Object[] b(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((a) obj).b;
            }
        }
        return objArr2;
    }
}
