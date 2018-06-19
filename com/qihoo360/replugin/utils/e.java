package com.qihoo360.replugin.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReflectUtils */
public final class e {
    public static java.lang.reflect.Field a(java.lang.Class<?> r10, java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r10;
    L_0x0001:
        if (r0 == 0) goto L_0x0010;
    L_0x0003:
        r1 = r0.getDeclaredField(r11);	 Catch:{ NoSuchFieldException -> 0x000b }
        a(r1);	 Catch:{ NoSuchFieldException -> 0x000b }
        return r1;
    L_0x000b:
        r0 = r0.getSuperclass();
        goto L_0x0001;
    L_0x0010:
        r0 = 0;
        r1 = r10.getInterfaces();
        r2 = 0;
        r3 = r1.length;
        r4 = r0;
        r0 = r2;
    L_0x0019:
        if (r0 >= r3) goto L_0x0037;
    L_0x001b:
        r5 = r1[r0];
        r5 = r5.getField(r11);	 Catch:{ NoSuchFieldException -> 0x0034 }
        r6 = 1;	 Catch:{ NoSuchFieldException -> 0x0034 }
        if (r4 != 0) goto L_0x0026;	 Catch:{ NoSuchFieldException -> 0x0034 }
    L_0x0024:
        r7 = r6;	 Catch:{ NoSuchFieldException -> 0x0034 }
        goto L_0x0027;	 Catch:{ NoSuchFieldException -> 0x0034 }
    L_0x0026:
        r7 = r2;	 Catch:{ NoSuchFieldException -> 0x0034 }
    L_0x0027:
        r8 = "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.";	 Catch:{ NoSuchFieldException -> 0x0034 }
        r9 = 2;	 Catch:{ NoSuchFieldException -> 0x0034 }
        r9 = new java.lang.Object[r9];	 Catch:{ NoSuchFieldException -> 0x0034 }
        r9[r2] = r11;	 Catch:{ NoSuchFieldException -> 0x0034 }
        r9[r6] = r10;	 Catch:{ NoSuchFieldException -> 0x0034 }
        com.qihoo360.replugin.utils.f.a(r7, r8, r9);	 Catch:{ NoSuchFieldException -> 0x0034 }
        r4 = r5;
    L_0x0034:
        r0 = r0 + 1;
        goto L_0x0019;
    L_0x0037:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.e.a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    public static Object a(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        return a(obj.getClass(), obj, str);
    }

    public static Object a(Class<?> cls, Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        return a((Class) cls, str).get(obj);
    }

    public static void a(Class<?> cls, Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        a((Class) cls, str).set(obj, obj2);
    }

    public static List<Field> a(Class<?> cls) {
        f.a(cls != null, "The class must not be null", new Object[0]);
        List<Field> arrayList = new ArrayList();
        while (cls != null) {
            for (Object add : cls.getDeclaredFields()) {
                arrayList.add(add);
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static java.lang.reflect.Method a(java.lang.Class<?> r10, java.lang.String r11, java.lang.Class<?>... r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r10;
    L_0x0001:
        if (r0 == 0) goto L_0x0010;
    L_0x0003:
        r1 = r0.getDeclaredMethod(r11, r12);	 Catch:{ NoSuchMethodException -> 0x000b }
        a(r1);	 Catch:{ NoSuchMethodException -> 0x000b }
        return r1;
    L_0x000b:
        r0 = r0.getSuperclass();
        goto L_0x0001;
    L_0x0010:
        r0 = 0;
        r1 = r10.getInterfaces();
        r2 = 0;
        r3 = r1.length;
        r4 = r0;
        r0 = r2;
    L_0x0019:
        if (r0 >= r3) goto L_0x0037;
    L_0x001b:
        r5 = r1[r0];
        r5 = r5.getMethod(r11, r12);	 Catch:{ NoSuchMethodException -> 0x0034 }
        r6 = 1;	 Catch:{ NoSuchMethodException -> 0x0034 }
        if (r4 != 0) goto L_0x0026;	 Catch:{ NoSuchMethodException -> 0x0034 }
    L_0x0024:
        r7 = r6;	 Catch:{ NoSuchMethodException -> 0x0034 }
        goto L_0x0027;	 Catch:{ NoSuchMethodException -> 0x0034 }
    L_0x0026:
        r7 = r2;	 Catch:{ NoSuchMethodException -> 0x0034 }
    L_0x0027:
        r8 = "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.";	 Catch:{ NoSuchMethodException -> 0x0034 }
        r9 = 2;	 Catch:{ NoSuchMethodException -> 0x0034 }
        r9 = new java.lang.Object[r9];	 Catch:{ NoSuchMethodException -> 0x0034 }
        r9[r2] = r11;	 Catch:{ NoSuchMethodException -> 0x0034 }
        r9[r6] = r10;	 Catch:{ NoSuchMethodException -> 0x0034 }
        com.qihoo360.replugin.utils.f.a(r7, r8, r9);	 Catch:{ NoSuchMethodException -> 0x0034 }
        r4 = r5;
    L_0x0034:
        r0 = r0 + 1;
        goto L_0x0019;
    L_0x0037:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.e.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return a(obj.getClass(), str, (Class[]) clsArr).invoke(objArr, new Object[null]);
    }

    private static void a(AccessibleObject accessibleObject) {
        if (!accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
    }
}
