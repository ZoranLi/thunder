package com.tencent.tinker.loader.shareutil;

import java.lang.reflect.Array;

/* compiled from: BUGLY */
public class ShareReflectUtil {
    public static java.lang.reflect.Field findField(java.lang.Object r3, java.lang.String r4) throws java.lang.NoSuchFieldException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r1 = r0.getDeclaredField(r4);	 Catch:{ NoSuchFieldException -> 0x0015 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchFieldException -> 0x0015 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ NoSuchFieldException -> 0x0015 }
    L_0x0010:
        r2 = 1;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0015 }
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x001a:
        r0 = new java.lang.NoSuchFieldException;
        r1 = new java.lang.StringBuilder;
        r2 = "Field ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r3 = r3.getClass();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(java.lang.Object, java.lang.String):java.lang.reflect.Field");
    }

    public static java.lang.reflect.Field findField(java.lang.Class<?> r3, java.lang.String r4) throws java.lang.NoSuchFieldException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3;
    L_0x0001:
        if (r0 == 0) goto L_0x0017;
    L_0x0003:
        r1 = r0.getDeclaredField(r4);	 Catch:{ NoSuchFieldException -> 0x0012 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchFieldException -> 0x0012 }
        if (r2 != 0) goto L_0x0011;	 Catch:{ NoSuchFieldException -> 0x0012 }
    L_0x000d:
        r2 = 1;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r0.getSuperclass();
        goto L_0x0001;
    L_0x0017:
        r0 = new java.lang.NoSuchFieldException;
        r1 = new java.lang.StringBuilder;
        r2 = "Field ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    public static java.lang.reflect.Method findMethod(java.lang.Object r3, java.lang.String r4, java.lang.Class<?>... r5) throws java.lang.NoSuchMethodException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r1 = r0.getDeclaredMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x0015 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0015 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0010:
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r1.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x001a:
        r0 = new java.lang.NoSuchMethodException;
        r1 = new java.lang.StringBuilder;
        r2 = "Method ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = " with parameters ";
        r1.append(r4);
        r4 = java.util.Arrays.asList(r5);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r3 = r3.getClass();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(java.lang.Object, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static java.lang.reflect.Method findMethod(java.lang.Class<?> r3, java.lang.String r4, java.lang.Class<?>... r5) throws java.lang.NoSuchMethodException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
    L_0x0000:
        if (r3 == 0) goto L_0x0016;
    L_0x0002:
        r0 = r3.getDeclaredMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x0011 }
        r1 = r0.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0011 }
        if (r1 != 0) goto L_0x0010;	 Catch:{ NoSuchMethodException -> 0x0011 }
    L_0x000c:
        r1 = 1;	 Catch:{ NoSuchMethodException -> 0x0011 }
        r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0011 }
    L_0x0010:
        return r0;
    L_0x0011:
        r3 = r3.getSuperclass();
        goto L_0x0000;
    L_0x0016:
        r0 = new java.lang.NoSuchMethodException;
        r1 = new java.lang.StringBuilder;
        r2 = "Method ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = " with parameters ";
        r1.append(r4);
        r4 = java.util.Arrays.asList(r5);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static java.lang.reflect.Constructor<?> findConstructor(java.lang.Object r3, java.lang.Class<?>... r4) throws java.lang.NoSuchMethodException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r1 = r0.getDeclaredConstructor(r4);	 Catch:{ NoSuchMethodException -> 0x0015 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0015 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0010:
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r1.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x001a:
        r0 = new java.lang.NoSuchMethodException;
        r1 = new java.lang.StringBuilder;
        r2 = "Constructor with parameters ";
        r1.<init>(r2);
        r4 = java.util.Arrays.asList(r4);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r3 = r3.getClass();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareReflectUtil.findConstructor(java.lang.Object, java.lang.Class[]):java.lang.reflect.Constructor<?>");
    }

    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        str = findField(obj, str);
        Object[] objArr2 = (Object[]) str.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        str.set(obj, objArr3);
    }

    public static void reduceFieldArray(Object obj, String str, int i) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (i > 0) {
            str = findField(obj, str);
            Object[] objArr = (Object[]) str.get(obj);
            int length = objArr.length - i;
            if (length > 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
                System.arraycopy(objArr, i, objArr2, 0, length);
                str.set(obj, objArr2);
            }
        }
    }

    public static java.lang.Object getActivityThread(android.content.Context r4, java.lang.Class<?> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0009;
    L_0x0003:
        r5 = "android.app.ActivityThread";	 Catch:{ Throwable -> 0x0043 }
        r5 = java.lang.Class.forName(r5);	 Catch:{ Throwable -> 0x0043 }
    L_0x0009:
        r1 = "currentActivityThread";	 Catch:{ Throwable -> 0x0043 }
        r2 = 0;	 Catch:{ Throwable -> 0x0043 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0043 }
        r5 = r5.getMethod(r1, r3);	 Catch:{ Throwable -> 0x0043 }
        r1 = 1;	 Catch:{ Throwable -> 0x0043 }
        r5.setAccessible(r1);	 Catch:{ Throwable -> 0x0043 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0043 }
        r5 = r5.invoke(r0, r2);	 Catch:{ Throwable -> 0x0043 }
        if (r5 != 0) goto L_0x0042;	 Catch:{ Throwable -> 0x0043 }
    L_0x001e:
        if (r4 == 0) goto L_0x0042;	 Catch:{ Throwable -> 0x0043 }
    L_0x0020:
        r5 = r4.getClass();	 Catch:{ Throwable -> 0x0043 }
        r2 = "mLoadedApk";	 Catch:{ Throwable -> 0x0043 }
        r5 = r5.getField(r2);	 Catch:{ Throwable -> 0x0043 }
        r5.setAccessible(r1);	 Catch:{ Throwable -> 0x0043 }
        r4 = r5.get(r4);	 Catch:{ Throwable -> 0x0043 }
        r5 = r4.getClass();	 Catch:{ Throwable -> 0x0043 }
        r2 = "mActivityThread";	 Catch:{ Throwable -> 0x0043 }
        r5 = r5.getDeclaredField(r2);	 Catch:{ Throwable -> 0x0043 }
        r5.setAccessible(r1);	 Catch:{ Throwable -> 0x0043 }
        r5 = r5.get(r4);	 Catch:{ Throwable -> 0x0043 }
    L_0x0042:
        return r5;
    L_0x0043:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareReflectUtil.getActivityThread(android.content.Context, java.lang.Class):java.lang.Object");
    }

    public static int getValueOfStaticIntField(java.lang.Class<?> r0, java.lang.String r1, int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = findField(r0, r1);	 Catch:{ Throwable -> 0x000a }
        r1 = 0;	 Catch:{ Throwable -> 0x000a }
        r0 = r0.getInt(r1);	 Catch:{ Throwable -> 0x000a }
        return r0;
    L_0x000a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareReflectUtil.getValueOfStaticIntField(java.lang.Class, java.lang.String, int):int");
    }
}
