package com.alibaba.fastjson.c;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a.a;
import com.alibaba.fastjson.a.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/* compiled from: JavaBeanInfo */
public final class g {
    public final Class<?> a;
    public final Class<?> b;
    public final Constructor<?> c;
    public final Constructor<?> d;
    public final Method e;
    public final Method f;
    public final int g;
    public final d[] h;
    public final d[] i;
    public final int j;
    public final d k;

    private g(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, d dVar, List<d> list) {
        this.a = cls;
        this.b = cls2;
        this.c = constructor;
        this.d = constructor2;
        this.e = method;
        this.j = j.b((Class) cls);
        this.f = method2;
        this.k = dVar;
        this.h = new d[list.size()];
        list.toArray(this.h);
        cls2 = null;
        cls = new d[this.h.length];
        System.arraycopy(this.h, 0, cls, 0, this.h.length);
        Arrays.sort(cls);
        if (Arrays.equals(this.h, cls) != null) {
            cls = this.h;
        }
        this.i = cls;
        if (constructor != null) {
            cls2 = constructor.getParameterTypes().length;
        }
        this.g = cls2;
    }

    private static d a(List<d> list, String str) {
        for (d dVar : list) {
            if (dVar.a.equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    private static boolean a(List<d> list, d dVar) {
        int size = list.size() - 1;
        while (size >= 0) {
            d dVar2 = (d) list.get(size);
            if (!dVar2.a.equals(dVar.a) || (dVar2.g && !dVar.g)) {
                size--;
            } else {
                if (dVar2.d.isAssignableFrom(dVar.d)) {
                    list.remove(size);
                } else if (dVar2.a(dVar) >= 0) {
                    return null;
                } else {
                    list.remove(size);
                }
                list.add(dVar);
                return true;
            }
        }
        list.add(dVar);
        return true;
    }

    public static com.alibaba.fastjson.c.g a(java.lang.Class<?> r36, java.lang.reflect.Type r37) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = r36;
        r0 = com.alibaba.fastjson.a.d.class;
        r0 = r11.getAnnotation(r0);
        r12 = r0;
        r12 = (com.alibaba.fastjson.a.d) r12;
        r13 = a(r12);
        r14 = r36.getDeclaredFields();
        r15 = r36.getMethods();
        if (r13 != 0) goto L_0x001b;
    L_0x0019:
        r0 = r11;
        goto L_0x001c;
    L_0x001b:
        r0 = r13;
    L_0x001c:
        r1 = r0.getModifiers();
        r1 = java.lang.reflect.Modifier.isAbstract(r1);
        r16 = 0;
        r10 = 1;
        r9 = 0;
        if (r1 == 0) goto L_0x002d;
    L_0x002a:
        r8 = r16;
        goto L_0x0075;
    L_0x002d:
        r1 = r0.getDeclaredConstructors();
        r2 = r1.length;
        r3 = r9;
    L_0x0033:
        if (r3 >= r2) goto L_0x0042;
    L_0x0035:
        r4 = r1[r3];
        r5 = r4.getParameterTypes();
        r5 = r5.length;
        if (r5 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0044;
    L_0x003f:
        r3 = r3 + 1;
        goto L_0x0033;
    L_0x0042:
        r4 = r16;
    L_0x0044:
        if (r4 != 0) goto L_0x0074;
    L_0x0046:
        r2 = r0.isMemberClass();
        if (r2 == 0) goto L_0x0074;
    L_0x004c:
        r2 = r0.getModifiers();
        r2 = java.lang.reflect.Modifier.isStatic(r2);
        if (r2 != 0) goto L_0x0074;
    L_0x0056:
        r2 = r1.length;
        r3 = r9;
    L_0x0058:
        if (r3 >= r2) goto L_0x0074;
    L_0x005a:
        r5 = r1[r3];
        r6 = r5.getParameterTypes();
        r7 = r6.length;
        if (r7 != r10) goto L_0x0071;
    L_0x0063:
        r6 = r6[r9];
        r7 = r0.getDeclaringClass();
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x0071;
    L_0x006f:
        r4 = r5;
        goto L_0x0074;
    L_0x0071:
        r3 = r3 + 1;
        goto L_0x0058;
    L_0x0074:
        r8 = r4;
    L_0x0075:
        r7 = new java.util.ArrayList;
        r7.<init>();
        if (r8 != 0) goto L_0x019f;
    L_0x007c:
        r0 = r36.isInterface();
        if (r0 != 0) goto L_0x019f;
    L_0x0082:
        r0 = r36.getModifiers();
        r0 = java.lang.reflect.Modifier.isAbstract(r0);
        if (r0 != 0) goto L_0x019f;
    L_0x008c:
        r8 = a(r36);
        if (r8 == 0) goto L_0x010e;
    L_0x0092:
        com.alibaba.fastjson.c.j.a(r8);
        r10 = r8.getParameterTypes();
        r0 = r10.length;
        if (r0 <= 0) goto L_0x00fe;
    L_0x009c:
        r15 = r8.getParameterAnnotations();
        r6 = r9;
    L_0x00a1:
        r0 = r10.length;
        if (r6 >= r0) goto L_0x00fe;
    L_0x00a4:
        r0 = r15[r6];
        r1 = r0.length;
        r2 = r9;
    L_0x00a8:
        if (r2 >= r1) goto L_0x00b7;
    L_0x00aa:
        r3 = r0[r2];
        r4 = r3 instanceof com.alibaba.fastjson.a.b;
        if (r4 == 0) goto L_0x00b4;
    L_0x00b0:
        r0 = r3;
        r0 = (com.alibaba.fastjson.a.b) r0;
        goto L_0x00b9;
    L_0x00b4:
        r2 = r2 + 1;
        goto L_0x00a8;
    L_0x00b7:
        r0 = r16;
    L_0x00b9:
        if (r0 != 0) goto L_0x00c3;
    L_0x00bb:
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = "illegal json creator";
        r0.<init>(r1);
        throw r0;
    L_0x00c3:
        r3 = r10[r6];
        r1 = r8.getGenericParameterTypes();
        r4 = r1[r6];
        r1 = r0.b();
        r5 = com.alibaba.fastjson.c.j.a(r11, r1, r14);
        r17 = r0.a();
        r1 = r0.f();
        r18 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1);
        r2 = new com.alibaba.fastjson.c.d;
        r1 = r0.b();
        r0 = r2;
        r9 = r2;
        r2 = r11;
        r20 = r6;
        r6 = r17;
        r21 = r10;
        r10 = r7;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        a(r10, r9);
        r6 = r20 + 1;
        r7 = r10;
        r10 = r21;
        r9 = 0;
        goto L_0x00a1;
    L_0x00fe:
        r10 = r7;
        r9 = new com.alibaba.fastjson.c.g;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r0 = r9;
        r1 = r11;
        r2 = r13;
        r4 = r8;
        r7 = r12;
        r8 = r10;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        return r9;
    L_0x010e:
        r10 = r7;
        r8 = a(r11, r15);
        if (r8 == 0) goto L_0x018b;
    L_0x0115:
        com.alibaba.fastjson.c.j.a(r8);
        r9 = r8.getParameterTypes();
        r0 = r9.length;
        if (r0 <= 0) goto L_0x017c;
    L_0x011f:
        r15 = r8.getParameterAnnotations();
        r7 = 0;
    L_0x0124:
        r0 = r9.length;
        if (r7 >= r0) goto L_0x017c;
    L_0x0127:
        r0 = r15[r7];
        r1 = r0.length;
        r2 = 0;
    L_0x012b:
        if (r2 >= r1) goto L_0x013a;
    L_0x012d:
        r3 = r0[r2];
        r4 = r3 instanceof com.alibaba.fastjson.a.b;
        if (r4 == 0) goto L_0x0137;
    L_0x0133:
        r0 = r3;
        r0 = (com.alibaba.fastjson.a.b) r0;
        goto L_0x013c;
    L_0x0137:
        r2 = r2 + 1;
        goto L_0x012b;
    L_0x013a:
        r0 = r16;
    L_0x013c:
        if (r0 != 0) goto L_0x0146;
    L_0x013e:
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = "illegal json creator";
        r0.<init>(r1);
        throw r0;
    L_0x0146:
        r3 = r9[r7];
        r1 = r8.getGenericParameterTypes();
        r4 = r1[r7];
        r1 = r0.b();
        r5 = com.alibaba.fastjson.c.j.a(r11, r1, r14);
        r6 = r0.a();
        r1 = r0.f();
        r17 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1);
        r2 = new com.alibaba.fastjson.c.d;
        r1 = r0.b();
        r0 = r2;
        r22 = r9;
        r9 = r2;
        r2 = r11;
        r18 = r7;
        r7 = r17;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        a(r10, r9);
        r7 = r18 + 1;
        r9 = r22;
        goto L_0x0124;
    L_0x017c:
        r9 = new com.alibaba.fastjson.c.g;
        r3 = 0;
        r4 = 0;
        r6 = 0;
        r0 = r9;
        r1 = r11;
        r2 = r13;
        r5 = r8;
        r7 = r12;
        r8 = r10;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        return r9;
    L_0x018b:
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = new java.lang.StringBuilder;
        r2 = "default constructor not found. ";
        r1.<init>(r2);
        r1.append(r11);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x019f:
        r17 = r10;
        r10 = r7;
        if (r8 == 0) goto L_0x01a7;
    L_0x01a4:
        com.alibaba.fastjson.c.j.a(r8);
    L_0x01a7:
        if (r13 == 0) goto L_0x0359;
    L_0x01a9:
        r0 = com.alibaba.fastjson.a.c.class;
        r0 = r13.getAnnotation(r0);
        r0 = (com.alibaba.fastjson.a.c) r0;
        if (r0 == 0) goto L_0x01b8;
    L_0x01b3:
        r0 = r0.b();
        goto L_0x01ba;
    L_0x01b8:
        r0 = r16;
    L_0x01ba:
        if (r0 == 0) goto L_0x01c5;
    L_0x01bc:
        r1 = r0.length();
        if (r1 != 0) goto L_0x01c3;
    L_0x01c2:
        goto L_0x01c5;
    L_0x01c3:
        r9 = r0;
        goto L_0x01c8;
    L_0x01c5:
        r0 = "with";
        goto L_0x01c3;
    L_0x01c8:
        r7 = r13.getMethods();
        r6 = r7.length;
        r5 = 0;
    L_0x01ce:
        if (r5 >= r6) goto L_0x030b;
    L_0x01d0:
        r2 = r7[r5];
        r0 = r2.getModifiers();
        r0 = java.lang.reflect.Modifier.isStatic(r0);
        if (r0 != 0) goto L_0x02e9;
    L_0x01dc:
        r0 = r2.getReturnType();
        r0 = r0.equals(r13);
        if (r0 == 0) goto L_0x02e9;
    L_0x01e6:
        r0 = com.alibaba.fastjson.a.b.class;
        r0 = r2.getAnnotation(r0);
        r0 = (com.alibaba.fastjson.a.b) r0;
        if (r0 != 0) goto L_0x01f4;
    L_0x01f0:
        r0 = com.alibaba.fastjson.c.j.a(r11, r2);
    L_0x01f4:
        r4 = r0;
        if (r4 == 0) goto L_0x0279;
    L_0x01f7:
        r0 = r4.e();
        if (r0 == 0) goto L_0x0268;
    L_0x01fd:
        r18 = r4.a();
        r0 = r4.f();
        r20 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0);
        r0 = r4.b();
        r0 = r0.length();
        if (r0 == 0) goto L_0x0250;
    L_0x0213:
        r1 = r4.b();
        r3 = new com.alibaba.fastjson.c.d;
        r21 = 0;
        r22 = 0;
        r23 = 0;
        r0 = r3;
        r24 = r3;
        r3 = r21;
        r21 = r4;
        r4 = r11;
        r25 = r5;
        r5 = r37;
        r26 = r6;
        r6 = r18;
        r27 = r7;
        r7 = r20;
        r28 = r8;
        r8 = r21;
        r29 = r9;
        r9 = r22;
        r30 = r12;
        r31 = r14;
        r14 = r17;
        r12 = r10;
        r10 = r23;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r0 = r24;
        a(r12, r0);
        r17 = r29;
        goto L_0x02f8;
    L_0x0250:
        r21 = r4;
        r25 = r5;
        r26 = r6;
        r27 = r7;
        r28 = r8;
        r29 = r9;
        r30 = r12;
        r31 = r14;
        r14 = r17;
        r12 = r10;
        r6 = r18;
        r7 = r20;
        goto L_0x028e;
    L_0x0268:
        r25 = r5;
        r26 = r6;
        r27 = r7;
        r28 = r8;
        r30 = r12;
        r31 = r14;
        r12 = r10;
        r17 = r9;
        goto L_0x02f8;
    L_0x0279:
        r21 = r4;
        r25 = r5;
        r26 = r6;
        r27 = r7;
        r28 = r8;
        r29 = r9;
        r30 = r12;
        r31 = r14;
        r14 = r17;
        r12 = r10;
        r6 = 0;
        r7 = 0;
    L_0x028e:
        r0 = r2.getName();
        r10 = r29;
        r1 = r0.startsWith(r10);
        if (r1 == 0) goto L_0x02e6;
    L_0x029a:
        r1 = r0.length();
        r3 = r10.length();
        if (r1 <= r3) goto L_0x02e6;
    L_0x02a4:
        r1 = r10.length();
        r1 = r0.charAt(r1);
        r3 = java.lang.Character.isUpperCase(r1);
        if (r3 == 0) goto L_0x02e6;
    L_0x02b2:
        r3 = new java.lang.StringBuilder;
        r4 = r10.length();
        r0 = r0.substring(r4);
        r3.<init>(r0);
        r0 = java.lang.Character.toLowerCase(r1);
        r9 = 0;
        r3.setCharAt(r9, r0);
        r1 = r3.toString();
        r8 = new com.alibaba.fastjson.c.d;
        r3 = 0;
        r17 = 0;
        r18 = 0;
        r0 = r8;
        r4 = r11;
        r5 = r37;
        r14 = r8;
        r8 = r21;
        r9 = r17;
        r17 = r10;
        r10 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        a(r12, r14);
        goto L_0x02f8;
    L_0x02e6:
        r17 = r10;
        goto L_0x02f8;
    L_0x02e9:
        r25 = r5;
        r26 = r6;
        r27 = r7;
        r28 = r8;
        r17 = r9;
        r30 = r12;
        r31 = r14;
        r12 = r10;
    L_0x02f8:
        r5 = r25 + 1;
        r10 = r12;
        r9 = r17;
        r6 = r26;
        r7 = r27;
        r8 = r28;
        r12 = r30;
        r14 = r31;
        r17 = 1;
        goto L_0x01ce;
    L_0x030b:
        r28 = r8;
        r30 = r12;
        r31 = r14;
        r12 = r10;
        if (r13 == 0) goto L_0x0357;
    L_0x0314:
        r0 = com.alibaba.fastjson.a.c.class;
        r0 = r13.getAnnotation(r0);
        r0 = (com.alibaba.fastjson.a.c) r0;
        if (r0 == 0) goto L_0x0323;
    L_0x031e:
        r0 = r0.a();
        goto L_0x0325;
    L_0x0323:
        r0 = r16;
    L_0x0325:
        if (r0 == 0) goto L_0x0330;
    L_0x0327:
        r1 = r0.length();
        if (r1 != 0) goto L_0x032e;
    L_0x032d:
        goto L_0x0330;
    L_0x032e:
        r14 = 0;
        goto L_0x0333;
    L_0x0330:
        r0 = "build";
        goto L_0x032e;
    L_0x0333:
        r1 = new java.lang.Class[r14];	 Catch:{ NoSuchMethodException -> 0x033a, NoSuchMethodException -> 0x033a }
        r0 = r13.getMethod(r0, r1);	 Catch:{ NoSuchMethodException -> 0x033a, NoSuchMethodException -> 0x033a }
        goto L_0x033c;
    L_0x033a:
        r0 = r16;
    L_0x033c:
        if (r0 != 0) goto L_0x0347;
    L_0x033e:
        r1 = "create";	 Catch:{ NoSuchMethodException -> 0x0347, NoSuchMethodException -> 0x0347 }
        r2 = new java.lang.Class[r14];	 Catch:{ NoSuchMethodException -> 0x0347, NoSuchMethodException -> 0x0347 }
        r1 = r13.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0347, NoSuchMethodException -> 0x0347 }
        r0 = r1;
    L_0x0347:
        if (r0 != 0) goto L_0x0351;
    L_0x0349:
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = "buildMethod not found.";
        r0.<init>(r1);
        throw r0;
    L_0x0351:
        com.alibaba.fastjson.c.j.a(r0);
        r17 = r0;
        goto L_0x0363;
    L_0x0357:
        r14 = 0;
        goto L_0x0361;
    L_0x0359:
        r28 = r8;
        r30 = r12;
        r31 = r14;
        r14 = 0;
        r12 = r10;
    L_0x0361:
        r17 = r16;
    L_0x0363:
        r10 = r15.length;
        r9 = r14;
    L_0x0365:
        r8 = 4;
        r7 = 3;
        if (r9 >= r10) goto L_0x054d;
    L_0x0369:
        r2 = r15[r9];
        r0 = r2.getName();
        r1 = r0.length();
        if (r1 < r8) goto L_0x0539;
    L_0x0375:
        r1 = r2.getModifiers();
        r1 = java.lang.reflect.Modifier.isStatic(r1);
        if (r1 != 0) goto L_0x0539;
    L_0x037f:
        r1 = r2.getReturnType();
        r3 = java.lang.Void.TYPE;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0395;
    L_0x038b:
        r1 = r2.getReturnType();
        r1 = r1.equals(r11);
        if (r1 == 0) goto L_0x0539;
    L_0x0395:
        r1 = r2.getParameterTypes();
        r3 = r1.length;
        r4 = 1;
        if (r3 != r4) goto L_0x052e;
    L_0x039d:
        r3 = com.alibaba.fastjson.a.b.class;
        r3 = r2.getAnnotation(r3);
        r3 = (com.alibaba.fastjson.a.b) r3;
        if (r3 != 0) goto L_0x03ab;
    L_0x03a7:
        r3 = com.alibaba.fastjson.c.j.a(r11, r2);
    L_0x03ab:
        r6 = r3;
        if (r6 == 0) goto L_0x03f9;
    L_0x03ae:
        r3 = r6.e();
        if (r3 == 0) goto L_0x0539;
    L_0x03b4:
        r18 = r6.a();
        r3 = r6.f();
        r19 = com.alibaba.fastjson.serializer.SerializerFeature.of(r3);
        r3 = r6.b();
        r3 = r3.length();
        if (r3 == 0) goto L_0x03f2;
    L_0x03ca:
        r1 = r6.b();
        r8 = new com.alibaba.fastjson.c.d;
        r3 = 0;
        r20 = 0;
        r21 = 0;
        r0 = r8;
        r4 = r11;
        r5 = r37;
        r22 = r6;
        r6 = r18;
        r7 = r19;
        r14 = r8;
        r8 = r22;
        r23 = r9;
        r9 = r20;
        r20 = r10;
        r10 = r21;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        a(r12, r14);
        goto L_0x0527;
    L_0x03f2:
        r22 = r6;
        r23 = r9;
        r20 = r10;
        goto L_0x0403;
    L_0x03f9:
        r22 = r6;
        r23 = r9;
        r20 = r10;
        r18 = 0;
        r19 = 0;
    L_0x0403:
        r3 = "set";
        r3 = r0.startsWith(r3);
        if (r3 == 0) goto L_0x0527;
    L_0x040b:
        r3 = r0.charAt(r7);
        r4 = java.lang.Character.isUpperCase(r3);
        if (r4 != 0) goto L_0x0446;
    L_0x0415:
        r4 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r3 <= r4) goto L_0x041a;
    L_0x0419:
        goto L_0x0446;
    L_0x041a:
        r4 = 95;
        if (r3 != r4) goto L_0x0423;
    L_0x041e:
        r0 = r0.substring(r8);
        goto L_0x0452;
    L_0x0423:
        r4 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 != r4) goto L_0x042c;
    L_0x0427:
        r0 = r0.substring(r7);
        goto L_0x0452;
    L_0x042c:
        r3 = r0.length();
        r4 = 5;
        if (r3 < r4) goto L_0x0527;
    L_0x0433:
        r3 = r0.charAt(r8);
        r3 = java.lang.Character.isUpperCase(r3);
        if (r3 == 0) goto L_0x0527;
    L_0x043d:
        r0 = r0.substring(r7);
        r0 = com.alibaba.fastjson.c.j.a(r0);
        goto L_0x0452;
    L_0x0446:
        r3 = com.alibaba.fastjson.c.j.a;
        if (r3 == 0) goto L_0x0456;
    L_0x044a:
        r0 = r0.substring(r7);
        r0 = com.alibaba.fastjson.c.j.a(r0);
    L_0x0452:
        r3 = r0;
        r14 = r31;
        goto L_0x0472;
    L_0x0456:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r0.charAt(r7);
        r4 = java.lang.Character.toLowerCase(r4);
        r3.append(r4);
        r0 = r0.substring(r8);
        r3.append(r0);
        r0 = r3.toString();
        goto L_0x0452;
    L_0x0472:
        r0 = com.alibaba.fastjson.c.j.a(r11, r3, r14);
        if (r0 != 0) goto L_0x04a4;
    L_0x0478:
        r10 = 0;
        r1 = r1[r10];
        r4 = java.lang.Boolean.TYPE;
        if (r1 != r4) goto L_0x04a2;
    L_0x047f:
        r0 = new java.lang.StringBuilder;
        r1 = "is";
        r0.<init>(r1);
        r1 = r3.charAt(r10);
        r1 = java.lang.Character.toUpperCase(r1);
        r0.append(r1);
        r9 = 1;
        r1 = r3.substring(r9);
        r0.append(r1);
        r0 = r0.toString();
        r0 = com.alibaba.fastjson.c.j.a(r11, r0, r14);
        goto L_0x04a6;
    L_0x04a2:
        r9 = 1;
        goto L_0x04a6;
    L_0x04a4:
        r9 = 1;
        r10 = 0;
    L_0x04a6:
        r4 = r0;
        if (r4 == 0) goto L_0x0505;
    L_0x04a9:
        r0 = com.alibaba.fastjson.a.b.class;
        r0 = r4.getAnnotation(r0);
        r8 = r0;
        r8 = (com.alibaba.fastjson.a.b) r8;
        if (r8 == 0) goto L_0x04f8;
    L_0x04b4:
        r6 = r8.a();
        r0 = r8.f();
        r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0);
        r0 = r8.b();
        r0 = r0.length();
        if (r0 == 0) goto L_0x04f1;
    L_0x04ca:
        r1 = r8.b();
        r5 = new com.alibaba.fastjson.c.d;
        r18 = 0;
        r0 = r5;
        r3 = r4;
        r4 = r11;
        r32 = r5;
        r5 = r37;
        r21 = r8;
        r8 = r22;
        r24 = r9;
        r9 = r21;
        r25 = r10;
        r10 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r0 = r32;
        a(r12, r0);
        r33 = r14;
        goto L_0x0543;
    L_0x04f1:
        r21 = r8;
        r24 = r9;
        r25 = r10;
        goto L_0x0502;
    L_0x04f8:
        r21 = r8;
        r24 = r9;
        r25 = r10;
        r6 = r18;
        r7 = r19;
    L_0x0502:
        r9 = r21;
        goto L_0x050f;
    L_0x0505:
        r24 = r9;
        r25 = r10;
        r9 = r16;
        r6 = r18;
        r7 = r19;
    L_0x050f:
        r10 = new com.alibaba.fastjson.c.d;
        r18 = 0;
        r0 = r10;
        r1 = r3;
        r3 = r4;
        r4 = r11;
        r5 = r37;
        r8 = r22;
        r33 = r14;
        r14 = r10;
        r10 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        a(r12, r14);
        goto L_0x0543;
    L_0x0527:
        r33 = r31;
        r24 = 1;
        r25 = 0;
        goto L_0x0543;
    L_0x052e:
        r24 = r4;
        r23 = r9;
        r20 = r10;
        r25 = r14;
        r33 = r31;
        goto L_0x0543;
    L_0x0539:
        r23 = r9;
        r20 = r10;
        r25 = r14;
        r33 = r31;
        r24 = 1;
    L_0x0543:
        r9 = r23 + 1;
        r10 = r20;
        r14 = r25;
        r31 = r33;
        goto L_0x0365;
    L_0x054d:
        r25 = r14;
        r24 = 1;
        r14 = r36.getFields();
        r15 = r14.length;
        r10 = r25;
    L_0x0558:
        if (r10 >= r15) goto L_0x05e2;
    L_0x055a:
        r3 = r14[r10];
        r0 = r3.getModifiers();
        r0 = java.lang.reflect.Modifier.isStatic(r0);
        if (r0 != 0) goto L_0x05da;
    L_0x0566:
        r0 = r12.iterator();
    L_0x056a:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0585;
    L_0x0570:
        r1 = r0.next();
        r1 = (com.alibaba.fastjson.c.d) r1;
        r1 = r1.a;
        r2 = r3.getName();
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x056a;
    L_0x0582:
        r0 = r24;
        goto L_0x0587;
    L_0x0585:
        r0 = r25;
    L_0x0587:
        if (r0 != 0) goto L_0x05da;
    L_0x0589:
        r0 = r3.getName();
        r1 = com.alibaba.fastjson.a.b.class;
        r1 = r3.getAnnotation(r1);
        r9 = r1;
        r9 = (com.alibaba.fastjson.a.b) r9;
        if (r9 == 0) goto L_0x05b7;
    L_0x0598:
        r1 = r9.a();
        r2 = r9.f();
        r2 = com.alibaba.fastjson.serializer.SerializerFeature.of(r2);
        r4 = r9.b();
        r4 = r4.length();
        if (r4 == 0) goto L_0x05b2;
    L_0x05ae:
        r0 = r9.b();
    L_0x05b2:
        r6 = r1;
        r16 = r2;
        r1 = r0;
        goto L_0x05bc;
    L_0x05b7:
        r1 = r0;
        r6 = r25;
        r16 = r6;
    L_0x05bc:
        r5 = new com.alibaba.fastjson.c.d;
        r2 = 0;
        r18 = 0;
        r19 = 0;
        r0 = r5;
        r4 = r11;
        r34 = r5;
        r5 = r37;
        r7 = r16;
        r8 = r18;
        r16 = r10;
        r10 = r19;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r0 = r34;
        a(r12, r0);
        goto L_0x05dc;
    L_0x05da:
        r16 = r10;
    L_0x05dc:
        r10 = r16 + 1;
        r7 = 3;
        r8 = 4;
        goto L_0x0558;
    L_0x05e2:
        r14 = r36.getMethods();
        r15 = r14.length;
        r10 = r25;
    L_0x05e9:
        if (r10 >= r15) goto L_0x06c5;
    L_0x05eb:
        r2 = r14[r10];
        r0 = r2.getName();
        r1 = r0.length();
        r9 = 4;
        if (r1 < r9) goto L_0x06bb;
    L_0x05f8:
        r1 = r2.getModifiers();
        r1 = java.lang.reflect.Modifier.isStatic(r1);
        if (r1 != 0) goto L_0x06bb;
    L_0x0602:
        r1 = "get";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x06bb;
    L_0x060a:
        r8 = 3;
        r1 = r0.charAt(r8);
        r1 = java.lang.Character.isUpperCase(r1);
        if (r1 == 0) goto L_0x06b4;
    L_0x0615:
        r1 = r2.getParameterTypes();
        r1 = r1.length;
        if (r1 != 0) goto L_0x06b4;
    L_0x061c:
        r1 = java.util.Collection.class;
        r3 = r2.getReturnType();
        r1 = r1.isAssignableFrom(r3);
        if (r1 != 0) goto L_0x064c;
    L_0x0628:
        r1 = java.util.Map.class;
        r3 = r2.getReturnType();
        r1 = r1.isAssignableFrom(r3);
        if (r1 != 0) goto L_0x064c;
    L_0x0634:
        r1 = java.util.concurrent.atomic.AtomicBoolean.class;
        r3 = r2.getReturnType();
        if (r1 == r3) goto L_0x064c;
    L_0x063c:
        r1 = java.util.concurrent.atomic.AtomicInteger.class;
        r3 = r2.getReturnType();
        if (r1 == r3) goto L_0x064c;
    L_0x0644:
        r1 = java.util.concurrent.atomic.AtomicLong.class;
        r3 = r2.getReturnType();
        if (r1 != r3) goto L_0x06b4;
    L_0x064c:
        r1 = com.alibaba.fastjson.a.b.class;
        r1 = r2.getAnnotation(r1);
        r7 = r1;
        r7 = (com.alibaba.fastjson.a.b) r7;
        if (r7 == 0) goto L_0x0666;
    L_0x0657:
        r1 = r7.b();
        r1 = r1.length();
        if (r1 <= 0) goto L_0x0666;
    L_0x0661:
        r0 = r7.b();
        goto L_0x0681;
    L_0x0666:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = r0.charAt(r8);
        r3 = java.lang.Character.toLowerCase(r3);
        r1.append(r3);
        r0 = r0.substring(r9);
        r1.append(r0);
        r0 = r1.toString();
    L_0x0681:
        r1 = r0;
        r0 = a(r12, r1);
        if (r0 != 0) goto L_0x06b4;
    L_0x0688:
        r6 = new com.alibaba.fastjson.c.d;
        r3 = 0;
        r16 = 0;
        r18 = 0;
        r19 = 0;
        r20 = 0;
        r0 = r6;
        r4 = r11;
        r5 = r37;
        r35 = r6;
        r6 = r16;
        r16 = r7;
        r7 = r18;
        r18 = r8;
        r8 = r16;
        r16 = r9;
        r9 = r19;
        r25 = r10;
        r10 = r20;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r0 = r35;
        a(r12, r0);
        goto L_0x06c1;
    L_0x06b4:
        r18 = r8;
        r16 = r9;
        r25 = r10;
        goto L_0x06c1;
    L_0x06bb:
        r16 = r9;
        r25 = r10;
        r18 = 3;
    L_0x06c1:
        r10 = r25 + 1;
        goto L_0x05e9;
    L_0x06c5:
        r9 = new com.alibaba.fastjson.c.g;
        r4 = 0;
        r5 = 0;
        r0 = r9;
        r1 = r11;
        r2 = r13;
        r3 = r28;
        r6 = r17;
        r7 = r30;
        r8 = r12;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.g.a(java.lang.Class, java.lang.reflect.Type):com.alibaba.fastjson.c.g");
    }

    private static Constructor<?> a(Class<?> cls) {
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : cls.getDeclaredConstructors()) {
            if (((a) constructor2.getAnnotation(a.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        return constructor;
    }

    private static Method a(Class<?> cls, Method[] methodArr) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((a) method2.getAnnotation(a.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        return method;
    }

    public static Class<?> a(d dVar) {
        if (dVar == null) {
            return null;
        }
        dVar = dVar.i();
        if (dVar == Void.class) {
            return null;
        }
        return dVar;
    }
}
