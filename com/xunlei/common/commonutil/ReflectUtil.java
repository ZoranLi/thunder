package com.xunlei.common.commonutil;

public class ReflectUtil {

    static class Arg {
        Class<?> type;
        Object value;

        Arg() {
        }
    }

    public static java.lang.String getFieldValue(java.lang.Class<?> r1, java.lang.Object r2, java.lang.String r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.xunlei.common.commonutil.ReflectUtil.getFieldValue(java.lang.Class, java.lang.Object, java.lang.String, java.lang.String):java.lang.String
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 4 more
*/
        /*
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.commonutil.ReflectUtil.getFieldValue(java.lang.Class, java.lang.Object, java.lang.String, java.lang.String):java.lang.String");
    }

    public static java.lang.String getFieldValue(java.lang.Object r1, java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.xunlei.common.commonutil.ReflectUtil.getFieldValue(java.lang.Object, java.lang.String, java.lang.String):java.lang.String
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 4 more
*/
        /*
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.commonutil.ReflectUtil.getFieldValue(java.lang.Object, java.lang.String, java.lang.String):java.lang.String");
    }

    public static Arg genArg(Class<?> cls, Object obj) {
        Arg arg = new Arg();
        arg.type = cls;
        arg.value = obj;
        return arg;
    }

    public static Object getFieldValue(Object obj, String str, Object obj2) {
        return obj != null ? getFieldValue(obj.getClass(), obj, str, obj2) : obj2;
    }

    public static java.lang.Object getFieldValue(java.lang.Class<?> r0, java.lang.Object r1, java.lang.String r2, java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getDeclaredField(r2);	 Catch:{ Throwable -> 0x000d }
        r2 = 1;	 Catch:{ Throwable -> 0x000d }
        r0.setAccessible(r2);	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x000d }
        return r0;
    L_0x000d:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.commonutil.ReflectUtil.getFieldValue(java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static boolean getFieldValue(Object obj, String str, boolean z) {
        return ((Boolean) getFieldValue(obj, str, Boolean.valueOf(z))).booleanValue();
    }

    public static boolean getFieldValue(Class<?> cls, Object obj, String str, boolean z) {
        return ((Boolean) getFieldValue((Class) cls, obj, str, Boolean.valueOf(z))).booleanValue();
    }

    public static int getFieldValue(Object obj, String str, int i) {
        return ((Integer) getFieldValue(obj, str, Integer.valueOf(i))).intValue();
    }

    public static int getFieldValue(Class<?> cls, Object obj, String str, int i) {
        return ((Integer) getFieldValue((Class) cls, obj, str, Integer.valueOf(i))).intValue();
    }

    public static long getFieldValue(Object obj, String str, long j) {
        return ((Long) getFieldValue(obj, str, Long.valueOf(j))).longValue();
    }

    public static long getFieldValue(Class<?> cls, Object obj, String str, long j) {
        return ((Long) getFieldValue((Class) cls, obj, str, Long.valueOf(j))).longValue();
    }

    public static void setFieldVaule(Object obj, String str, Object obj2) {
        if (obj != null) {
            setFieldVaule(obj.getClass(), obj, str, obj2);
        }
    }

    public static void setFieldVaule(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            cls = cls.getDeclaredField(str);
            cls.setAccessible(true);
            cls.set(obj, obj2);
        } catch (Class<?> cls2) {
            cls2.printStackTrace();
        }
    }

    public static java.lang.Object callMethod(java.lang.String r0, java.lang.Object r1, java.lang.String r2, java.lang.Object... r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0009 }
        r0 = callMethod(r0, r1, r2, r3);	 Catch:{ Throwable -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.commonutil.ReflectUtil.callMethod(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    public static java.lang.Object callMethod(java.lang.Class<?> r7, java.lang.Object r8, java.lang.String r9, java.lang.Object... r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = 1;
        if (r10 == 0) goto L_0x00ba;
    L_0x0004:
        r2 = r10.length;	 Catch:{ Throwable -> 0x00b8 }
        if (r2 <= 0) goto L_0x00ba;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0007:
        r2 = r10.length;	 Catch:{ Throwable -> 0x00b8 }
        r2 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x00b8 }
        r3 = r10.length;	 Catch:{ Throwable -> 0x00b8 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00b8 }
        r4 = r0;	 Catch:{ Throwable -> 0x00b8 }
    L_0x000e:
        r5 = r10.length;	 Catch:{ Throwable -> 0x00b8 }
        if (r4 >= r5) goto L_0x0075;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0011:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5 instanceof com.xunlei.common.commonutil.ReflectUtil.Arg;	 Catch:{ Throwable -> 0x00b8 }
        if (r5 == 0) goto L_0x0024;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0017:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = (com.xunlei.common.commonutil.ReflectUtil.Arg) r5;	 Catch:{ Throwable -> 0x00b8 }
        r6 = r5.type;	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r6;	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5.value;	 Catch:{ Throwable -> 0x00b8 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x0072;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0024:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5 instanceof java.lang.Integer;	 Catch:{ Throwable -> 0x00b8 }
        if (r5 == 0) goto L_0x002f;	 Catch:{ Throwable -> 0x00b8 }
    L_0x002a:
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x006e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x002f:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5 instanceof java.lang.Long;	 Catch:{ Throwable -> 0x00b8 }
        if (r5 == 0) goto L_0x003a;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0035:
        r5 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x006e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x003a:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5 instanceof java.lang.Boolean;	 Catch:{ Throwable -> 0x00b8 }
        if (r5 == 0) goto L_0x0045;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0040:
        r5 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x006e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0045:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5 instanceof java.lang.Byte;	 Catch:{ Throwable -> 0x00b8 }
        if (r5 == 0) goto L_0x0050;	 Catch:{ Throwable -> 0x00b8 }
    L_0x004b:
        r5 = java.lang.Byte.TYPE;	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x006e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0050:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5 instanceof java.lang.Double;	 Catch:{ Throwable -> 0x00b8 }
        if (r5 == 0) goto L_0x005b;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0056:
        r5 = java.lang.Double.TYPE;	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x006e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x005b:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5 instanceof java.lang.Float;	 Catch:{ Throwable -> 0x00b8 }
        if (r5 == 0) goto L_0x0066;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0061:
        r5 = java.lang.Float.TYPE;	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x006e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0066:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r5 = r5.getClass();	 Catch:{ Throwable -> 0x00b8 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
    L_0x006e:
        r5 = r10[r4];	 Catch:{ Throwable -> 0x00b8 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0072:
        r4 = r4 + 1;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x000e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0075:
        if (r9 == 0) goto L_0x00ac;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0077:
        r10 = r9.length();	 Catch:{ Throwable -> 0x00b8 }
        if (r10 > 0) goto L_0x007e;
    L_0x007d:
        goto L_0x00ac;
    L_0x007e:
        r10 = r7.getDeclaredMethod(r9, r2);	 Catch:{ NoSuchMethodException -> 0x008a }
        r10.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x008a }
        r10 = r10.invoke(r8, r3);	 Catch:{ NoSuchMethodException -> 0x008a }
        return r10;
    L_0x008a:
        r7 = r7.getDeclaredMethods();	 Catch:{ Throwable -> 0x00b8 }
    L_0x008e:
        r10 = r7.length;	 Catch:{ Throwable -> 0x00b8 }
        if (r0 >= r10) goto L_0x010b;	 Catch:{ Throwable -> 0x00b8 }
    L_0x0091:
        r10 = r7[r0];	 Catch:{ Throwable -> 0x00b8 }
        r10 = r10.getName();	 Catch:{ Throwable -> 0x00b8 }
        r10 = r10.equals(r9);	 Catch:{ Throwable -> 0x00b8 }
        if (r10 == 0) goto L_0x00a9;	 Catch:{ Throwable -> 0x00b8 }
    L_0x009d:
        r9 = r7[r0];	 Catch:{ Throwable -> 0x00b8 }
        r9.setAccessible(r1);	 Catch:{ Throwable -> 0x00b8 }
        r7 = r7[r0];	 Catch:{ Throwable -> 0x00b8 }
        r7 = r7.invoke(r8, r3);	 Catch:{ Throwable -> 0x00b8 }
        return r7;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00a9:
        r0 = r0 + 1;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x008e;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00ac:
        r7 = r7.getConstructor(r2);	 Catch:{ Throwable -> 0x00b8 }
        r7.setAccessible(r1);	 Catch:{ Throwable -> 0x00b8 }
        r7 = r7.newInstance(r3);	 Catch:{ Throwable -> 0x00b8 }
        return r7;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00b8:
        r7 = move-exception;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x0108;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00ba:
        if (r9 == 0) goto L_0x00f8;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00bc:
        r10 = r9.length();	 Catch:{ Throwable -> 0x00b8 }
        if (r10 > 0) goto L_0x00c3;
    L_0x00c2:
        goto L_0x00f8;
    L_0x00c3:
        r10 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x00d3 }
        r10 = r7.getDeclaredMethod(r9, r10);	 Catch:{ NoSuchMethodException -> 0x00d3 }
        r10.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x00d3 }
        r2 = new java.lang.Object[r0];	 Catch:{ NoSuchMethodException -> 0x00d3 }
        r10 = r10.invoke(r8, r2);	 Catch:{ NoSuchMethodException -> 0x00d3 }
        return r10;
    L_0x00d3:
        r7 = r7.getDeclaredMethods();	 Catch:{ Throwable -> 0x00b8 }
        r10 = r0;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00d8:
        r2 = r7.length;	 Catch:{ Throwable -> 0x00b8 }
        if (r10 >= r2) goto L_0x010b;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00db:
        r2 = r7[r10];	 Catch:{ Throwable -> 0x00b8 }
        r2 = r2.getName();	 Catch:{ Throwable -> 0x00b8 }
        r2 = r2.equals(r9);	 Catch:{ Throwable -> 0x00b8 }
        if (r2 == 0) goto L_0x00f5;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00e7:
        r9 = r7[r10];	 Catch:{ Throwable -> 0x00b8 }
        r9.setAccessible(r1);	 Catch:{ Throwable -> 0x00b8 }
        r7 = r7[r10];	 Catch:{ Throwable -> 0x00b8 }
        r9 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00b8 }
        r7 = r7.invoke(r8, r9);	 Catch:{ Throwable -> 0x00b8 }
        return r7;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00f5:
        r10 = r10 + 1;	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x00d8;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00f8:
        r8 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x00b8 }
        r7 = r7.getConstructor(r8);	 Catch:{ Throwable -> 0x00b8 }
        r7.setAccessible(r1);	 Catch:{ Throwable -> 0x00b8 }
        r8 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00b8 }
        r7 = r7.newInstance(r8);	 Catch:{ Throwable -> 0x00b8 }
        return r7;
    L_0x0108:
        r7.printStackTrace();
    L_0x010b:
        r7 = 0;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.commonutil.ReflectUtil.callMethod(java.lang.Class, java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
