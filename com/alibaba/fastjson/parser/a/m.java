package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.c.d;
import com.alibaba.fastjson.c.g;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: JavaBeanDeserializer */
public class m implements r {
    protected final k[] a = new k[this.c.i.length];
    protected final Class<?> b;
    public final g c;
    private final k[] d;

    public int e_() {
        return 12;
    }

    public m(Class<?> cls, Type type) {
        this.b = cls;
        this.c = g.a((Class) cls, type);
        type = null;
        cls = this.c.i.length;
        for (int i = 0; i < cls; i++) {
            this.a[i] = com.alibaba.fastjson.parser.g.a(this.c, this.c.i[i]);
        }
        this.d = new k[this.c.h.length];
        Type length = this.c.h.length;
        while (type < length) {
            this.d[type] = a(this.c.h[type].a);
            type++;
        }
    }

    public final k a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.a.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.a[i2].a.a.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.a[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public final Object a(a aVar, Type type) {
        StringBuilder stringBuilder;
        if ((type instanceof Class) && this.b.isInterface()) {
            Class cls = (Class) type;
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new JSONObject());
        } else if (this.c.c == null) {
            return null;
        } else {
            try {
                type = this.c.c;
                if (this.c.g == 0) {
                    type = type.newInstance(new Object[0]);
                } else {
                    type = type.newInstance(new Object[]{aVar.c().a});
                }
                if (!(aVar == null || aVar.e.a(Feature.InitStringFieldAsEmpty) == null)) {
                    for (d dVar : this.c.h) {
                        if (dVar.d == String.class) {
                            try {
                                String str = "";
                                if (dVar.b != null) {
                                    dVar.b.invoke(type, new Object[]{str});
                                } else {
                                    dVar.c.set(type, str);
                                }
                            } catch (a aVar2) {
                                stringBuilder = new StringBuilder("create instance error, class ");
                                stringBuilder.append(this.b.getName());
                                throw new JSONException(stringBuilder.toString(), aVar2);
                            }
                        }
                    }
                }
                return type;
            } catch (a aVar22) {
                stringBuilder = new StringBuilder("create instance error, class ");
                stringBuilder.append(this.b.getName());
                throw new JSONException(stringBuilder.toString(), aVar22);
            }
        }
    }

    public <T> T a(a aVar, Type type, Object obj) {
        return a(aVar, type, obj, null);
    }

    private <T> T a(com.alibaba.fastjson.parser.a r22, java.lang.reflect.Type r23, java.lang.Object r24, java.lang.Object r25) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.alibaba.fastjson.parser.a.m.a(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object):T. bs: [B:316:0x0479, B:357:0x0509]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r21 = this;
        r1 = r21;
        r2 = r22;
        r3 = r23;
        r4 = r24;
        r5 = com.alibaba.fastjson.a.class;
        r6 = 0;
        if (r3 == r5) goto L_0x0571;
    L_0x000d:
        r5 = com.alibaba.fastjson.JSONObject.class;
        if (r3 != r5) goto L_0x0013;
    L_0x0011:
        goto L_0x0571;
    L_0x0013:
        r5 = r2.e;
        r5 = (com.alibaba.fastjson.parser.c) r5;
        r7 = r5.a();
        r8 = 8;
        r9 = 16;
        if (r7 != r8) goto L_0x0025;
    L_0x0021:
        r5.a(r9);
        return r6;
    L_0x0025:
        r8 = r22.c();
        r10 = 13;
        if (r7 != r10) goto L_0x003e;
    L_0x002d:
        r5.a(r9);	 Catch:{ all -> 0x0038 }
        r3 = r21.a(r22, r23);	 Catch:{ all -> 0x0038 }
        r2.a(r8);
        return r3;
    L_0x0038:
        r0 = move-exception;
        r9 = r25;
    L_0x003b:
        r3 = r0;
        goto L_0x0569;
    L_0x003e:
        r11 = 14;
        r12 = 0;
        if (r7 != r11) goto L_0x010b;
    L_0x0043:
        r14 = r1.c;	 Catch:{ all -> 0x0038 }
        r14 = r14.j;	 Catch:{ all -> 0x0038 }
        r15 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean;	 Catch:{ all -> 0x0038 }
        r15 = r15.mask;	 Catch:{ all -> 0x0038 }
        r14 = r14 & r15;	 Catch:{ all -> 0x0038 }
        if (r14 != 0) goto L_0x0059;	 Catch:{ all -> 0x0038 }
    L_0x004e:
        r14 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean;	 Catch:{ all -> 0x0038 }
        r14 = r5.a(r14);	 Catch:{ all -> 0x0038 }
        if (r14 == 0) goto L_0x0057;	 Catch:{ all -> 0x0038 }
    L_0x0056:
        goto L_0x0059;	 Catch:{ all -> 0x0038 }
    L_0x0057:
        r14 = r12;	 Catch:{ all -> 0x0038 }
        goto L_0x005a;	 Catch:{ all -> 0x0038 }
    L_0x0059:
        r14 = 1;	 Catch:{ all -> 0x0038 }
    L_0x005a:
        if (r14 == 0) goto L_0x010b;	 Catch:{ all -> 0x0038 }
    L_0x005c:
        r4 = r2.e;	 Catch:{ all -> 0x0038 }
        r5 = r4.a();	 Catch:{ all -> 0x0038 }
        if (r5 == r11) goto L_0x006c;	 Catch:{ all -> 0x0038 }
    L_0x0064:
        r3 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0038 }
        r4 = "error";	 Catch:{ all -> 0x0038 }
        r3.<init>(r4);	 Catch:{ all -> 0x0038 }
        throw r3;	 Catch:{ all -> 0x0038 }
    L_0x006c:
        r3 = r21.a(r22, r23);	 Catch:{ all -> 0x0038 }
        r5 = r1.a;	 Catch:{ all -> 0x0038 }
        r5 = r5.length;	 Catch:{ all -> 0x0038 }
    L_0x0073:
        if (r12 >= r5) goto L_0x0103;	 Catch:{ all -> 0x0038 }
    L_0x0075:
        r7 = r5 + -1;	 Catch:{ all -> 0x0038 }
        r13 = 93;	 Catch:{ all -> 0x0038 }
        if (r12 != r7) goto L_0x007d;	 Catch:{ all -> 0x0038 }
    L_0x007b:
        r7 = r13;	 Catch:{ all -> 0x0038 }
        goto L_0x007f;	 Catch:{ all -> 0x0038 }
    L_0x007d:
        r7 = 44;	 Catch:{ all -> 0x0038 }
    L_0x007f:
        r14 = r1.a;	 Catch:{ all -> 0x0038 }
        r14 = r14[r12];	 Catch:{ all -> 0x0038 }
        r15 = r14.a;	 Catch:{ all -> 0x0038 }
        r15 = r15.d;	 Catch:{ all -> 0x0038 }
        r10 = java.lang.Integer.TYPE;	 Catch:{ all -> 0x0038 }
        if (r15 != r10) goto L_0x0097;	 Catch:{ all -> 0x0038 }
    L_0x008b:
        r7 = r4.b(r7);	 Catch:{ all -> 0x0038 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0038 }
        r14.a(r3, r7);	 Catch:{ all -> 0x0038 }
        goto L_0x00fd;	 Catch:{ all -> 0x0038 }
    L_0x0097:
        r10 = java.lang.String.class;	 Catch:{ all -> 0x0038 }
        if (r15 != r10) goto L_0x00a3;	 Catch:{ all -> 0x0038 }
    L_0x009b:
        r7 = r4.c(r7);	 Catch:{ all -> 0x0038 }
        r14.a(r3, r7);	 Catch:{ all -> 0x0038 }
        goto L_0x00fd;	 Catch:{ all -> 0x0038 }
    L_0x00a3:
        r10 = java.lang.Long.TYPE;	 Catch:{ all -> 0x0038 }
        if (r15 != r10) goto L_0x00b3;	 Catch:{ all -> 0x0038 }
    L_0x00a7:
        r9 = r4.a(r7);	 Catch:{ all -> 0x0038 }
        r7 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x0038 }
        r14.a(r3, r7);	 Catch:{ all -> 0x0038 }
        goto L_0x00fd;	 Catch:{ all -> 0x0038 }
    L_0x00b3:
        r9 = r15.isEnum();	 Catch:{ all -> 0x0038 }
        if (r9 == 0) goto L_0x00c3;	 Catch:{ all -> 0x0038 }
    L_0x00b9:
        r9 = r2.b;	 Catch:{ all -> 0x0038 }
        r7 = r4.a(r15, r9, r7);	 Catch:{ all -> 0x0038 }
        r14.a(r3, r7);	 Catch:{ all -> 0x0038 }
        goto L_0x00fd;	 Catch:{ all -> 0x0038 }
    L_0x00c3:
        r4.a(r11);	 Catch:{ all -> 0x0038 }
        r9 = r14.a;	 Catch:{ all -> 0x0038 }
        r9 = r9.e;	 Catch:{ all -> 0x0038 }
        r9 = r2.a(r9, r6);	 Catch:{ all -> 0x0038 }
        r14.a(r3, r9);	 Catch:{ all -> 0x0038 }
        if (r7 != r13) goto L_0x00e9;	 Catch:{ all -> 0x0038 }
    L_0x00d3:
        r7 = r4.a();	 Catch:{ all -> 0x0038 }
        r9 = 15;	 Catch:{ all -> 0x0038 }
        if (r7 == r9) goto L_0x00e3;	 Catch:{ all -> 0x0038 }
    L_0x00db:
        r3 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0038 }
        r4 = "syntax error";	 Catch:{ all -> 0x0038 }
        r3.<init>(r4);	 Catch:{ all -> 0x0038 }
        throw r3;	 Catch:{ all -> 0x0038 }
    L_0x00e3:
        r9 = 16;	 Catch:{ all -> 0x0038 }
        r4.a(r9);	 Catch:{ all -> 0x0038 }
        goto L_0x00fd;	 Catch:{ all -> 0x0038 }
    L_0x00e9:
        r9 = 16;	 Catch:{ all -> 0x0038 }
        r10 = 44;	 Catch:{ all -> 0x0038 }
        if (r7 != r10) goto L_0x00fd;	 Catch:{ all -> 0x0038 }
    L_0x00ef:
        r7 = r4.a();	 Catch:{ all -> 0x0038 }
        if (r7 == r9) goto L_0x00fd;	 Catch:{ all -> 0x0038 }
    L_0x00f5:
        r3 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0038 }
        r4 = "syntax error";	 Catch:{ all -> 0x0038 }
        r3.<init>(r4);	 Catch:{ all -> 0x0038 }
        throw r3;	 Catch:{ all -> 0x0038 }
    L_0x00fd:
        r12 = r12 + 1;	 Catch:{ all -> 0x0038 }
        r9 = 16;	 Catch:{ all -> 0x0038 }
        goto L_0x0073;	 Catch:{ all -> 0x0038 }
    L_0x0103:
        r5 = r9;	 Catch:{ all -> 0x0038 }
        r4.a(r5);	 Catch:{ all -> 0x0038 }
        r2.a(r8);
        return r3;
    L_0x010b:
        r9 = 12;
        r11 = 4;
        if (r7 == r9) goto L_0x0161;
    L_0x0110:
        r9 = 16;
        if (r7 == r9) goto L_0x0161;
    L_0x0114:
        r3 = r5.q();	 Catch:{ all -> 0x0038 }
        if (r3 == 0) goto L_0x011e;
    L_0x011a:
        r2.a(r8);
        return r6;
    L_0x011e:
        if (r7 != r11) goto L_0x0131;
    L_0x0120:
        r3 = r5.l();	 Catch:{ all -> 0x0038 }
        r3 = r3.length();	 Catch:{ all -> 0x0038 }
        if (r3 != 0) goto L_0x0131;	 Catch:{ all -> 0x0038 }
    L_0x012a:
        r5.d();	 Catch:{ all -> 0x0038 }
        r2.a(r8);
        return r6;
    L_0x0131:
        r3 = new java.lang.StringBuffer;	 Catch:{ all -> 0x0038 }
        r7 = "syntax error, expect {, actual ";	 Catch:{ all -> 0x0038 }
        r3.<init>(r7);	 Catch:{ all -> 0x0038 }
        r7 = r5.b();	 Catch:{ all -> 0x0038 }
        r3.append(r7);	 Catch:{ all -> 0x0038 }
        r7 = ", pos ";	 Catch:{ all -> 0x0038 }
        r3.append(r7);	 Catch:{ all -> 0x0038 }
        r5 = r5.i();	 Catch:{ all -> 0x0038 }
        r3.append(r5);	 Catch:{ all -> 0x0038 }
        r5 = r4 instanceof java.lang.String;	 Catch:{ all -> 0x0038 }
        if (r5 == 0) goto L_0x0157;	 Catch:{ all -> 0x0038 }
    L_0x014f:
        r5 = ", fieldName ";	 Catch:{ all -> 0x0038 }
        r3.append(r5);	 Catch:{ all -> 0x0038 }
        r3.append(r4);	 Catch:{ all -> 0x0038 }
    L_0x0157:
        r4 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0038 }
        r3 = r3.toString();	 Catch:{ all -> 0x0038 }
        r4.<init>(r3);	 Catch:{ all -> 0x0038 }
        throw r4;	 Catch:{ all -> 0x0038 }
    L_0x0161:
        r7 = r2.g;	 Catch:{ all -> 0x0564 }
        r9 = 2;
        if (r7 != r9) goto L_0x0168;
    L_0x0166:
        r2.g = r12;	 Catch:{ all -> 0x0038 }
    L_0x0168:
        r9 = r25;
        r14 = r6;
        r15 = r14;
        r7 = r12;
    L_0x016d:
        r12 = r1.a;	 Catch:{ all -> 0x0560 }
        r12 = r12.length;	 Catch:{ all -> 0x0560 }
        if (r7 >= r12) goto L_0x017b;	 Catch:{ all -> 0x0560 }
    L_0x0172:
        r12 = r1.a;	 Catch:{ all -> 0x0560 }
        r12 = r12[r7];	 Catch:{ all -> 0x0560 }
        r6 = r12.a;	 Catch:{ all -> 0x0560 }
        r13 = r6.d;	 Catch:{ all -> 0x0560 }
        goto L_0x017e;	 Catch:{ all -> 0x0560 }
    L_0x017b:
        r6 = 0;	 Catch:{ all -> 0x0560 }
        r12 = 0;	 Catch:{ all -> 0x0560 }
        r13 = 0;	 Catch:{ all -> 0x0560 }
    L_0x017e:
        if (r12 == 0) goto L_0x025e;	 Catch:{ all -> 0x0560 }
    L_0x0180:
        r11 = r6.l;	 Catch:{ all -> 0x0560 }
        r10 = java.lang.Integer.TYPE;	 Catch:{ all -> 0x0560 }
        r16 = r7;	 Catch:{ all -> 0x0560 }
        r7 = -2;	 Catch:{ all -> 0x0560 }
        if (r13 == r10) goto L_0x0247;	 Catch:{ all -> 0x0560 }
    L_0x0189:
        r10 = java.lang.Integer.class;	 Catch:{ all -> 0x0560 }
        if (r13 != r10) goto L_0x018f;	 Catch:{ all -> 0x0560 }
    L_0x018d:
        goto L_0x0247;	 Catch:{ all -> 0x0560 }
    L_0x018f:
        r10 = java.lang.Long.TYPE;	 Catch:{ all -> 0x0560 }
        if (r13 == r10) goto L_0x0234;	 Catch:{ all -> 0x0560 }
    L_0x0193:
        r10 = java.lang.Long.class;	 Catch:{ all -> 0x0560 }
        if (r13 != r10) goto L_0x0199;	 Catch:{ all -> 0x0560 }
    L_0x0197:
        goto L_0x0234;	 Catch:{ all -> 0x0560 }
    L_0x0199:
        r10 = java.lang.String.class;	 Catch:{ all -> 0x0560 }
        if (r13 != r10) goto L_0x01ad;	 Catch:{ all -> 0x0560 }
    L_0x019d:
        r10 = r5.b(r11);	 Catch:{ all -> 0x0560 }
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 <= 0) goto L_0x01a7;	 Catch:{ all -> 0x0560 }
    L_0x01a5:
        goto L_0x0253;	 Catch:{ all -> 0x0560 }
    L_0x01a7:
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 != r7) goto L_0x025c;	 Catch:{ all -> 0x0560 }
    L_0x01ab:
        goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x01ad:
        r10 = java.lang.Boolean.TYPE;	 Catch:{ all -> 0x0560 }
        if (r13 == r10) goto L_0x0221;	 Catch:{ all -> 0x0560 }
    L_0x01b1:
        r10 = java.lang.Boolean.class;	 Catch:{ all -> 0x0560 }
        if (r13 != r10) goto L_0x01b7;	 Catch:{ all -> 0x0560 }
    L_0x01b5:
        goto L_0x0221;	 Catch:{ all -> 0x0560 }
    L_0x01b7:
        r10 = java.lang.Float.TYPE;	 Catch:{ all -> 0x0560 }
        if (r13 == r10) goto L_0x020e;	 Catch:{ all -> 0x0560 }
    L_0x01bb:
        r10 = java.lang.Float.class;	 Catch:{ all -> 0x0560 }
        if (r13 != r10) goto L_0x01c0;	 Catch:{ all -> 0x0560 }
    L_0x01bf:
        goto L_0x020e;	 Catch:{ all -> 0x0560 }
    L_0x01c0:
        r10 = java.lang.Double.TYPE;	 Catch:{ all -> 0x0560 }
        if (r13 == r10) goto L_0x01fb;	 Catch:{ all -> 0x0560 }
    L_0x01c4:
        r10 = java.lang.Double.class;	 Catch:{ all -> 0x0560 }
        if (r13 != r10) goto L_0x01c9;	 Catch:{ all -> 0x0560 }
    L_0x01c8:
        goto L_0x01fb;	 Catch:{ all -> 0x0560 }
    L_0x01c9:
        r10 = r13.isEnum();	 Catch:{ all -> 0x0560 }
        if (r10 == 0) goto L_0x01f2;	 Catch:{ all -> 0x0560 }
    L_0x01cf:
        r10 = r22.b();	 Catch:{ all -> 0x0560 }
        r10 = r10.a(r13);	 Catch:{ all -> 0x0560 }
        r10 = r10 instanceof com.alibaba.fastjson.parser.a.g;	 Catch:{ all -> 0x0560 }
        if (r10 == 0) goto L_0x01f2;	 Catch:{ all -> 0x0560 }
    L_0x01db:
        r10 = r2.b;	 Catch:{ all -> 0x0560 }
        r10 = r5.a(r11, r10);	 Catch:{ all -> 0x0560 }
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 <= 0) goto L_0x01ec;	 Catch:{ all -> 0x0560 }
    L_0x01e5:
        r7 = java.lang.Enum.valueOf(r13, r10);	 Catch:{ all -> 0x0560 }
        r10 = r7;	 Catch:{ all -> 0x0560 }
        goto L_0x0253;	 Catch:{ all -> 0x0560 }
    L_0x01ec:
        r10 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r10 == r7) goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x01f0:
        goto L_0x0260;	 Catch:{ all -> 0x0560 }
    L_0x01f2:
        r7 = r5.a(r11);	 Catch:{ all -> 0x0560 }
        if (r7 == 0) goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x01f8:
        r7 = 1;	 Catch:{ all -> 0x0560 }
        goto L_0x0261;	 Catch:{ all -> 0x0560 }
    L_0x01fb:
        r10 = r5.g(r11);	 Catch:{ all -> 0x0560 }
        r10 = java.lang.Double.valueOf(r10);	 Catch:{ all -> 0x0560 }
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 <= 0) goto L_0x0208;	 Catch:{ all -> 0x0560 }
    L_0x0207:
        goto L_0x0253;	 Catch:{ all -> 0x0560 }
    L_0x0208:
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 != r7) goto L_0x025c;	 Catch:{ all -> 0x0560 }
    L_0x020c:
        goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x020e:
        r10 = r5.f(r11);	 Catch:{ all -> 0x0560 }
        r10 = java.lang.Float.valueOf(r10);	 Catch:{ all -> 0x0560 }
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 <= 0) goto L_0x021b;	 Catch:{ all -> 0x0560 }
    L_0x021a:
        goto L_0x0253;	 Catch:{ all -> 0x0560 }
    L_0x021b:
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 != r7) goto L_0x025c;	 Catch:{ all -> 0x0560 }
    L_0x021f:
        goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x0221:
        r10 = r5.d(r11);	 Catch:{ all -> 0x0560 }
        r10 = java.lang.Boolean.valueOf(r10);	 Catch:{ all -> 0x0560 }
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 <= 0) goto L_0x022e;	 Catch:{ all -> 0x0560 }
    L_0x022d:
        goto L_0x0253;	 Catch:{ all -> 0x0560 }
    L_0x022e:
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 != r7) goto L_0x025c;	 Catch:{ all -> 0x0560 }
    L_0x0232:
        goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x0234:
        r10 = r5.e(r11);	 Catch:{ all -> 0x0560 }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0560 }
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 <= 0) goto L_0x0241;	 Catch:{ all -> 0x0560 }
    L_0x0240:
        goto L_0x0253;	 Catch:{ all -> 0x0560 }
    L_0x0241:
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 != r7) goto L_0x025c;	 Catch:{ all -> 0x0560 }
    L_0x0245:
        goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x0247:
        r10 = r5.c(r11);	 Catch:{ all -> 0x0560 }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0560 }
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 <= 0) goto L_0x0256;	 Catch:{ all -> 0x0560 }
    L_0x0253:
        r7 = 1;	 Catch:{ all -> 0x0560 }
        r11 = 1;	 Catch:{ all -> 0x0560 }
        goto L_0x0263;	 Catch:{ all -> 0x0560 }
    L_0x0256:
        r11 = r5.n;	 Catch:{ all -> 0x0560 }
        if (r11 != r7) goto L_0x025c;	 Catch:{ all -> 0x0560 }
    L_0x025a:
        goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x025c:
        r7 = 0;	 Catch:{ all -> 0x0560 }
        goto L_0x0262;	 Catch:{ all -> 0x0560 }
    L_0x025e:
        r16 = r7;	 Catch:{ all -> 0x0560 }
    L_0x0260:
        r7 = 0;	 Catch:{ all -> 0x0560 }
    L_0x0261:
        r10 = 0;	 Catch:{ all -> 0x0560 }
    L_0x0262:
        r11 = 0;	 Catch:{ all -> 0x0560 }
    L_0x0263:
        if (r7 != 0) goto L_0x03a5;	 Catch:{ all -> 0x0560 }
    L_0x0265:
        r17 = r13;	 Catch:{ all -> 0x0560 }
        r13 = r2.b;	 Catch:{ all -> 0x0560 }
        r13 = r5.a(r13);	 Catch:{ all -> 0x0560 }
        if (r13 != 0) goto L_0x028f;	 Catch:{ all -> 0x0560 }
    L_0x026f:
        r18 = r10;	 Catch:{ all -> 0x0560 }
        r10 = r5.a();	 Catch:{ all -> 0x0560 }
        r19 = r6;	 Catch:{ all -> 0x0560 }
        r6 = 13;	 Catch:{ all -> 0x0560 }
        if (r10 != r6) goto L_0x0282;	 Catch:{ all -> 0x0560 }
    L_0x027b:
        r6 = 16;	 Catch:{ all -> 0x0560 }
        r5.a(r6);	 Catch:{ all -> 0x0560 }
        goto L_0x0370;	 Catch:{ all -> 0x0560 }
    L_0x0282:
        r6 = 16;	 Catch:{ all -> 0x0560 }
        if (r10 != r6) goto L_0x0293;	 Catch:{ all -> 0x0560 }
    L_0x0286:
        r6 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas;	 Catch:{ all -> 0x0560 }
        r6 = r5.a(r6);	 Catch:{ all -> 0x0560 }
        if (r6 != 0) goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x028e:
        goto L_0x0293;	 Catch:{ all -> 0x0560 }
    L_0x028f:
        r19 = r6;	 Catch:{ all -> 0x0560 }
        r18 = r10;	 Catch:{ all -> 0x0560 }
    L_0x0293:
        r6 = "$ref";	 Catch:{ all -> 0x0560 }
        if (r6 != r13) goto L_0x033d;	 Catch:{ all -> 0x0560 }
    L_0x0297:
        r5.p();	 Catch:{ all -> 0x0560 }
        r3 = r5.a();	 Catch:{ all -> 0x0560 }
        r6 = 4;	 Catch:{ all -> 0x0560 }
        if (r3 != r6) goto L_0x0325;	 Catch:{ all -> 0x0560 }
    L_0x02a1:
        r3 = r5.l();	 Catch:{ all -> 0x0560 }
        r6 = "@";	 Catch:{ all -> 0x0560 }
        r6 = r6.equals(r3);	 Catch:{ all -> 0x0560 }
        if (r6 == 0) goto L_0x02b2;	 Catch:{ all -> 0x0560 }
    L_0x02ad:
        r3 = r8.a;	 Catch:{ all -> 0x0560 }
    L_0x02af:
        r6 = 13;	 Catch:{ all -> 0x0560 }
        goto L_0x02ff;	 Catch:{ all -> 0x0560 }
    L_0x02b2:
        r6 = "..";	 Catch:{ all -> 0x0560 }
        r6 = r6.equals(r3);	 Catch:{ all -> 0x0560 }
        if (r6 == 0) goto L_0x02cf;	 Catch:{ all -> 0x0560 }
    L_0x02ba:
        r6 = r8.b;	 Catch:{ all -> 0x0560 }
        r7 = r6.a;	 Catch:{ all -> 0x0560 }
        if (r7 == 0) goto L_0x02c3;	 Catch:{ all -> 0x0560 }
    L_0x02c0:
        r3 = r6.a;	 Catch:{ all -> 0x0560 }
        goto L_0x02af;	 Catch:{ all -> 0x0560 }
    L_0x02c3:
        r7 = new com.alibaba.fastjson.parser.a$a;	 Catch:{ all -> 0x0560 }
        r7.<init>(r6, r3);	 Catch:{ all -> 0x0560 }
        r2.a(r7);	 Catch:{ all -> 0x0560 }
        r3 = 1;	 Catch:{ all -> 0x0560 }
        r2.g = r3;	 Catch:{ all -> 0x0560 }
        goto L_0x02fd;	 Catch:{ all -> 0x0560 }
    L_0x02cf:
        r6 = "$";	 Catch:{ all -> 0x0560 }
        r6 = r6.equals(r3);	 Catch:{ all -> 0x0560 }
        if (r6 == 0) goto L_0x02f2;	 Catch:{ all -> 0x0560 }
    L_0x02d7:
        r6 = r8;	 Catch:{ all -> 0x0560 }
    L_0x02d8:
        r7 = r6.b;	 Catch:{ all -> 0x0560 }
        if (r7 == 0) goto L_0x02df;	 Catch:{ all -> 0x0560 }
    L_0x02dc:
        r6 = r6.b;	 Catch:{ all -> 0x0560 }
        goto L_0x02d8;	 Catch:{ all -> 0x0560 }
    L_0x02df:
        r7 = r6.a;	 Catch:{ all -> 0x0560 }
        if (r7 == 0) goto L_0x02e6;	 Catch:{ all -> 0x0560 }
    L_0x02e3:
        r3 = r6.a;	 Catch:{ all -> 0x0560 }
        goto L_0x02af;	 Catch:{ all -> 0x0560 }
    L_0x02e6:
        r7 = new com.alibaba.fastjson.parser.a$a;	 Catch:{ all -> 0x0560 }
        r7.<init>(r6, r3);	 Catch:{ all -> 0x0560 }
        r2.a(r7);	 Catch:{ all -> 0x0560 }
        r3 = 1;	 Catch:{ all -> 0x0560 }
        r2.g = r3;	 Catch:{ all -> 0x0560 }
        goto L_0x02fd;	 Catch:{ all -> 0x0560 }
    L_0x02f2:
        r6 = new com.alibaba.fastjson.parser.a$a;	 Catch:{ all -> 0x0560 }
        r6.<init>(r8, r3);	 Catch:{ all -> 0x0560 }
        r2.a(r6);	 Catch:{ all -> 0x0560 }
        r3 = 1;	 Catch:{ all -> 0x0560 }
        r2.g = r3;	 Catch:{ all -> 0x0560 }
    L_0x02fd:
        r3 = r9;
        goto L_0x02af;
    L_0x02ff:
        r5.a(r6);	 Catch:{ all -> 0x0320 }
        r7 = r5.a();	 Catch:{ all -> 0x0320 }
        if (r7 == r6) goto L_0x0310;	 Catch:{ all -> 0x0320 }
    L_0x0308:
        r4 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0320 }
        r5 = "illegal ref";	 Catch:{ all -> 0x0320 }
        r4.<init>(r5);	 Catch:{ all -> 0x0320 }
        throw r4;	 Catch:{ all -> 0x0320 }
    L_0x0310:
        r6 = 16;	 Catch:{ all -> 0x0320 }
        r5.a(r6);	 Catch:{ all -> 0x0320 }
        r2.a(r8, r3, r4);	 Catch:{ all -> 0x0320 }
        if (r14 == 0) goto L_0x031c;
    L_0x031a:
        r14.a = r3;
    L_0x031c:
        r2.a(r8);
        return r3;
    L_0x0320:
        r0 = move-exception;
        r9 = r3;
        r6 = r14;
        goto L_0x003b;
    L_0x0325:
        r4 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0560 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0560 }
        r6 = "illegal ref, ";	 Catch:{ all -> 0x0560 }
        r5.<init>(r6);	 Catch:{ all -> 0x0560 }
        r3 = com.alibaba.fastjson.parser.e.a(r3);	 Catch:{ all -> 0x0560 }
        r5.append(r3);	 Catch:{ all -> 0x0560 }
        r3 = r5.toString();	 Catch:{ all -> 0x0560 }
        r4.<init>(r3);	 Catch:{ all -> 0x0560 }
        throw r4;	 Catch:{ all -> 0x0560 }
    L_0x033d:
        r6 = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;	 Catch:{ all -> 0x0560 }
        if (r6 != r13) goto L_0x03ac;	 Catch:{ all -> 0x0560 }
    L_0x0341:
        r5.p();	 Catch:{ all -> 0x0560 }
        r6 = r5.a();	 Catch:{ all -> 0x0560 }
        r7 = 4;	 Catch:{ all -> 0x0560 }
        if (r6 != r7) goto L_0x039d;	 Catch:{ all -> 0x0560 }
    L_0x034b:
        r6 = r5.l();	 Catch:{ all -> 0x0560 }
        r7 = 16;	 Catch:{ all -> 0x0560 }
        r5.a(r7);	 Catch:{ all -> 0x0560 }
        r7 = r3 instanceof java.lang.Class;	 Catch:{ all -> 0x0560 }
        if (r7 == 0) goto L_0x037d;	 Catch:{ all -> 0x0560 }
    L_0x0358:
        r7 = r3;	 Catch:{ all -> 0x0560 }
        r7 = (java.lang.Class) r7;	 Catch:{ all -> 0x0560 }
        r7 = r7.getName();	 Catch:{ all -> 0x0560 }
        r7 = r6.equals(r7);	 Catch:{ all -> 0x0560 }
        if (r7 == 0) goto L_0x037d;	 Catch:{ all -> 0x0560 }
    L_0x0365:
        r6 = r5.a();	 Catch:{ all -> 0x0560 }
        r7 = 13;	 Catch:{ all -> 0x0560 }
        if (r6 != r7) goto L_0x0373;	 Catch:{ all -> 0x0560 }
    L_0x036d:
        r5.d();	 Catch:{ all -> 0x0560 }
    L_0x0370:
        r6 = r14;	 Catch:{ all -> 0x0560 }
        goto L_0x046f;	 Catch:{ all -> 0x0560 }
    L_0x0373:
        r6 = r14;	 Catch:{ all -> 0x0560 }
        r7 = 0;	 Catch:{ all -> 0x0560 }
        r10 = 4;	 Catch:{ all -> 0x0560 }
        r11 = 16;	 Catch:{ all -> 0x0560 }
    L_0x0378:
        r12 = 13;	 Catch:{ all -> 0x0560 }
    L_0x037a:
        r14 = 1;	 Catch:{ all -> 0x0560 }
        goto L_0x0554;	 Catch:{ all -> 0x0560 }
    L_0x037d:
        r3 = r22.b();	 Catch:{ all -> 0x0560 }
        r3 = r3.b();	 Catch:{ all -> 0x0560 }
        r3 = com.alibaba.fastjson.c.j.a(r6, r3);	 Catch:{ all -> 0x0560 }
        r5 = r22.b();	 Catch:{ all -> 0x0560 }
        r5 = r5.a(r3);	 Catch:{ all -> 0x0560 }
        r3 = r5.a(r2, r3, r4);	 Catch:{ all -> 0x0560 }
        if (r14 == 0) goto L_0x0399;
    L_0x0397:
        r14.a = r9;
    L_0x0399:
        r2.a(r8);
        return r3;
    L_0x039d:
        r3 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0560 }
        r4 = "syntax error";	 Catch:{ all -> 0x0560 }
        r3.<init>(r4);	 Catch:{ all -> 0x0560 }
        throw r3;	 Catch:{ all -> 0x0560 }
    L_0x03a5:
        r19 = r6;	 Catch:{ all -> 0x0560 }
        r18 = r10;	 Catch:{ all -> 0x0560 }
        r17 = r13;	 Catch:{ all -> 0x0560 }
        r13 = 0;	 Catch:{ all -> 0x0560 }
    L_0x03ac:
        if (r9 != 0) goto L_0x03cf;	 Catch:{ all -> 0x0560 }
    L_0x03ae:
        if (r15 != 0) goto L_0x03cf;	 Catch:{ all -> 0x0560 }
    L_0x03b0:
        r6 = r21.a(r22, r23);	 Catch:{ all -> 0x0560 }
        if (r6 != 0) goto L_0x03c5;
    L_0x03b6:
        r9 = new java.util.HashMap;	 Catch:{ all -> 0x03c0 }
        r10 = r1.d;	 Catch:{ all -> 0x03c0 }
        r10 = r10.length;	 Catch:{ all -> 0x03c0 }
        r9.<init>(r10);	 Catch:{ all -> 0x03c0 }
        r15 = r9;	 Catch:{ all -> 0x03c0 }
        goto L_0x03c5;	 Catch:{ all -> 0x03c0 }
    L_0x03c0:
        r0 = move-exception;	 Catch:{ all -> 0x03c0 }
        r3 = r0;	 Catch:{ all -> 0x03c0 }
        r9 = r6;	 Catch:{ all -> 0x03c0 }
        goto L_0x0562;	 Catch:{ all -> 0x03c0 }
    L_0x03c5:
        r9 = r2.a(r8, r6, r4);	 Catch:{ all -> 0x03c0 }
        r20 = r9;
        r9 = r6;
        r6 = r20;
        goto L_0x03d0;
    L_0x03cf:
        r6 = r14;
    L_0x03d0:
        if (r7 == 0) goto L_0x0409;
    L_0x03d2:
        if (r11 != 0) goto L_0x03da;
    L_0x03d4:
        r12.a(r2, r9, r3, r15);	 Catch:{ all -> 0x055d }
        r10 = 4;	 Catch:{ all -> 0x055d }
        goto L_0x045c;	 Catch:{ all -> 0x055d }
    L_0x03da:
        if (r9 != 0) goto L_0x03e6;	 Catch:{ all -> 0x055d }
    L_0x03dc:
        r7 = r19;	 Catch:{ all -> 0x055d }
        r7 = r7.a;	 Catch:{ all -> 0x055d }
        r10 = r18;	 Catch:{ all -> 0x055d }
        r15.put(r7, r10);	 Catch:{ all -> 0x055d }
        goto L_0x0403;	 Catch:{ all -> 0x055d }
    L_0x03e6:
        r10 = r18;	 Catch:{ all -> 0x055d }
        if (r10 != 0) goto L_0x0400;	 Catch:{ all -> 0x055d }
    L_0x03ea:
        r7 = java.lang.Integer.TYPE;	 Catch:{ all -> 0x055d }
        r13 = r17;	 Catch:{ all -> 0x055d }
        if (r13 == r7) goto L_0x0403;	 Catch:{ all -> 0x055d }
    L_0x03f0:
        r7 = java.lang.Long.TYPE;	 Catch:{ all -> 0x055d }
        if (r13 == r7) goto L_0x0403;	 Catch:{ all -> 0x055d }
    L_0x03f4:
        r7 = java.lang.Float.TYPE;	 Catch:{ all -> 0x055d }
        if (r13 == r7) goto L_0x0403;	 Catch:{ all -> 0x055d }
    L_0x03f8:
        r7 = java.lang.Double.TYPE;	 Catch:{ all -> 0x055d }
        if (r13 == r7) goto L_0x0403;	 Catch:{ all -> 0x055d }
    L_0x03fc:
        r7 = java.lang.Boolean.TYPE;	 Catch:{ all -> 0x055d }
        if (r13 == r7) goto L_0x0403;	 Catch:{ all -> 0x055d }
    L_0x0400:
        r12.a(r9, r10);	 Catch:{ all -> 0x055d }
    L_0x0403:
        r7 = r5.n;	 Catch:{ all -> 0x055d }
        r10 = 4;	 Catch:{ all -> 0x055d }
        if (r7 != r10) goto L_0x045c;	 Catch:{ all -> 0x055d }
    L_0x0408:
        goto L_0x046f;	 Catch:{ all -> 0x055d }
    L_0x0409:
        r10 = 4;	 Catch:{ all -> 0x055d }
        r7 = r2.e;	 Catch:{ all -> 0x055d }
        r11 = r1.b(r13);	 Catch:{ all -> 0x055d }
        if (r11 != 0) goto L_0x0441;	 Catch:{ all -> 0x055d }
    L_0x0412:
        r11 = com.alibaba.fastjson.parser.Feature.IgnoreNotMatch;	 Catch:{ all -> 0x055d }
        r7 = r7.a(r11);	 Catch:{ all -> 0x055d }
        if (r7 != 0) goto L_0x043c;	 Catch:{ all -> 0x055d }
    L_0x041a:
        r3 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x055d }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x055d }
        r5 = "setter not found, class ";	 Catch:{ all -> 0x055d }
        r4.<init>(r5);	 Catch:{ all -> 0x055d }
        r5 = r1.b;	 Catch:{ all -> 0x055d }
        r5 = r5.getName();	 Catch:{ all -> 0x055d }
        r4.append(r5);	 Catch:{ all -> 0x055d }
        r5 = ", property ";	 Catch:{ all -> 0x055d }
        r4.append(r5);	 Catch:{ all -> 0x055d }
        r4.append(r13);	 Catch:{ all -> 0x055d }
        r4 = r4.toString();	 Catch:{ all -> 0x055d }
        r3.<init>(r4);	 Catch:{ all -> 0x055d }
        throw r3;	 Catch:{ all -> 0x055d }
    L_0x043c:
        r2.b(r9);	 Catch:{ all -> 0x055d }
        r7 = 0;	 Catch:{ all -> 0x055d }
        goto L_0x0448;	 Catch:{ all -> 0x055d }
    L_0x0441:
        r7.p();	 Catch:{ all -> 0x055d }
        r11.a(r2, r9, r3, r15);	 Catch:{ all -> 0x055d }
        r7 = 1;	 Catch:{ all -> 0x055d }
    L_0x0448:
        if (r7 != 0) goto L_0x045c;	 Catch:{ all -> 0x055d }
    L_0x044a:
        r7 = r5.a();	 Catch:{ all -> 0x055d }
        r11 = 13;	 Catch:{ all -> 0x055d }
        if (r7 != r11) goto L_0x0456;	 Catch:{ all -> 0x055d }
    L_0x0452:
        r5.d();	 Catch:{ all -> 0x055d }
        goto L_0x046f;	 Catch:{ all -> 0x055d }
    L_0x0456:
        r12 = r11;	 Catch:{ all -> 0x055d }
        r7 = 0;	 Catch:{ all -> 0x055d }
        r11 = 16;	 Catch:{ all -> 0x055d }
        goto L_0x037a;	 Catch:{ all -> 0x055d }
    L_0x045c:
        r7 = r5.a();	 Catch:{ all -> 0x055d }
        r11 = 16;	 Catch:{ all -> 0x055d }
        if (r7 == r11) goto L_0x0551;	 Catch:{ all -> 0x055d }
    L_0x0464:
        r7 = r5.a();	 Catch:{ all -> 0x055d }
        r12 = 13;	 Catch:{ all -> 0x055d }
        if (r7 != r12) goto L_0x0525;	 Catch:{ all -> 0x055d }
    L_0x046c:
        r5.a(r11);	 Catch:{ all -> 0x055d }
    L_0x046f:
        if (r9 != 0) goto L_0x04f9;	 Catch:{ all -> 0x055d }
    L_0x0471:
        if (r15 != 0) goto L_0x0487;	 Catch:{ all -> 0x055d }
    L_0x0473:
        r3 = r21.a(r22, r23);	 Catch:{ all -> 0x055d }
        if (r6 != 0) goto L_0x047e;
    L_0x0479:
        r4 = r2.a(r8, r3, r4);	 Catch:{ all -> 0x0521 }
        goto L_0x047f;
    L_0x047e:
        r4 = r6;
    L_0x047f:
        if (r4 == 0) goto L_0x0483;
    L_0x0481:
        r4.a = r3;
    L_0x0483:
        r2.a(r8);
        return r3;
    L_0x0487:
        r3 = r1.c;	 Catch:{ all -> 0x055d }
        r3 = r3.h;	 Catch:{ all -> 0x055d }
        r4 = r3.length;	 Catch:{ all -> 0x055d }
        r5 = new java.lang.Object[r4];	 Catch:{ all -> 0x055d }
        r7 = 0;	 Catch:{ all -> 0x055d }
    L_0x048f:
        if (r7 >= r4) goto L_0x049e;	 Catch:{ all -> 0x055d }
    L_0x0491:
        r10 = r3[r7];	 Catch:{ all -> 0x055d }
        r10 = r10.a;	 Catch:{ all -> 0x055d }
        r10 = r15.get(r10);	 Catch:{ all -> 0x055d }
        r5[r7] = r10;	 Catch:{ all -> 0x055d }
        r7 = r7 + 1;	 Catch:{ all -> 0x055d }
        goto L_0x048f;	 Catch:{ all -> 0x055d }
    L_0x049e:
        r3 = r1.c;	 Catch:{ all -> 0x055d }
        r3 = r3.d;	 Catch:{ all -> 0x055d }
        if (r3 == 0) goto L_0x04cb;
    L_0x04a4:
        r3 = r1.c;	 Catch:{ Exception -> 0x04ad }
        r3 = r3.d;	 Catch:{ Exception -> 0x04ad }
        r3 = r3.newInstance(r5);	 Catch:{ Exception -> 0x04ad }
        goto L_0x04fa;
    L_0x04ad:
        r0 = move-exception;
        r3 = r0;
        r4 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x055d }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x055d }
        r7 = "create instance error, ";	 Catch:{ all -> 0x055d }
        r5.<init>(r7);	 Catch:{ all -> 0x055d }
        r7 = r1.c;	 Catch:{ all -> 0x055d }
        r7 = r7.d;	 Catch:{ all -> 0x055d }
        r7 = r7.toGenericString();	 Catch:{ all -> 0x055d }
        r5.append(r7);	 Catch:{ all -> 0x055d }
        r5 = r5.toString();	 Catch:{ all -> 0x055d }
        r4.<init>(r5, r3);	 Catch:{ all -> 0x055d }
        throw r4;	 Catch:{ all -> 0x055d }
    L_0x04cb:
        r3 = r1.c;	 Catch:{ all -> 0x055d }
        r3 = r3.e;	 Catch:{ all -> 0x055d }
        if (r3 == 0) goto L_0x04f9;
    L_0x04d1:
        r3 = r1.c;	 Catch:{ Exception -> 0x04db }
        r3 = r3.e;	 Catch:{ Exception -> 0x04db }
        r4 = 0;	 Catch:{ Exception -> 0x04db }
        r3 = r3.invoke(r4, r5);	 Catch:{ Exception -> 0x04db }
        goto L_0x04fa;
    L_0x04db:
        r0 = move-exception;
        r3 = r0;
        r4 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x055d }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x055d }
        r7 = "create factory method error, ";	 Catch:{ all -> 0x055d }
        r5.<init>(r7);	 Catch:{ all -> 0x055d }
        r7 = r1.c;	 Catch:{ all -> 0x055d }
        r7 = r7.e;	 Catch:{ all -> 0x055d }
        r7 = r7.toString();	 Catch:{ all -> 0x055d }
        r5.append(r7);	 Catch:{ all -> 0x055d }
        r5 = r5.toString();	 Catch:{ all -> 0x055d }
        r4.<init>(r5, r3);	 Catch:{ all -> 0x055d }
        throw r4;	 Catch:{ all -> 0x055d }
    L_0x04f9:
        r3 = r9;
    L_0x04fa:
        r4 = r1.c;	 Catch:{ all -> 0x0521 }
        r4 = r4.f;	 Catch:{ all -> 0x0521 }
        if (r4 != 0) goto L_0x0508;
    L_0x0500:
        if (r6 == 0) goto L_0x0504;
    L_0x0502:
        r6.a = r3;
    L_0x0504:
        r2.a(r8);
        return r3;
    L_0x0508:
        r7 = 0;
        r5 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0517 }
        r4 = r4.invoke(r3, r5);	 Catch:{ Exception -> 0x0517 }
        if (r6 == 0) goto L_0x0513;
    L_0x0511:
        r6.a = r3;
    L_0x0513:
        r2.a(r8);
        return r4;
    L_0x0517:
        r0 = move-exception;
        r4 = r0;
        r5 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x0521 }
        r7 = "build object error";	 Catch:{ all -> 0x0521 }
        r5.<init>(r7, r4);	 Catch:{ all -> 0x0521 }
        throw r5;	 Catch:{ all -> 0x0521 }
    L_0x0521:
        r0 = move-exception;
        r9 = r3;
        goto L_0x003b;
    L_0x0525:
        r7 = 0;
        r13 = r5.a();	 Catch:{ all -> 0x055d }
        r14 = 18;	 Catch:{ all -> 0x055d }
        if (r13 == r14) goto L_0x0535;	 Catch:{ all -> 0x055d }
    L_0x052e:
        r13 = r5.a();	 Catch:{ all -> 0x055d }
        r14 = 1;	 Catch:{ all -> 0x055d }
        if (r13 != r14) goto L_0x0554;	 Catch:{ all -> 0x055d }
    L_0x0535:
        r3 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x055d }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x055d }
        r7 = "syntax error, unexpect token ";	 Catch:{ all -> 0x055d }
        r4.<init>(r7);	 Catch:{ all -> 0x055d }
        r5 = r5.a();	 Catch:{ all -> 0x055d }
        r5 = com.alibaba.fastjson.parser.e.a(r5);	 Catch:{ all -> 0x055d }
        r4.append(r5);	 Catch:{ all -> 0x055d }
        r4 = r4.toString();	 Catch:{ all -> 0x055d }
        r3.<init>(r4);	 Catch:{ all -> 0x055d }
        throw r3;	 Catch:{ all -> 0x055d }
    L_0x0551:
        r7 = 0;
        goto L_0x0378;
    L_0x0554:
        r13 = r16 + 1;
        r14 = r6;
        r11 = r10;
        r10 = r12;
        r7 = r13;
        r6 = 0;
        goto L_0x016d;
    L_0x055d:
        r0 = move-exception;
        goto L_0x003b;
    L_0x0560:
        r0 = move-exception;
        r3 = r0;
    L_0x0562:
        r6 = r14;
        goto L_0x0569;
    L_0x0564:
        r0 = move-exception;
        r9 = r25;
        r3 = r0;
        r6 = 0;
    L_0x0569:
        if (r6 == 0) goto L_0x056d;
    L_0x056b:
        r6.a = r9;
    L_0x056d:
        r2.a(r8);
        throw r3;
    L_0x0571:
        r3 = r6;
        r2 = r2.a(r3);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.m.a(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object):T");
    }

    private k b(String str) {
        if (str == null) {
            return null;
        }
        k a = a(str);
        int i = 0;
        if (a == null) {
            boolean startsWith = str.startsWith("is");
            k[] kVarArr = this.a;
            int length = kVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                k kVar = kVarArr[i2];
                d dVar = kVar.a;
                Class cls = dVar.d;
                String str2 = dVar.a;
                if (!str2.equalsIgnoreCase(str)) {
                    if (!startsWith || ((cls != Boolean.TYPE && cls != Boolean.class) || !str2.equalsIgnoreCase(str.substring(2)))) {
                        i2++;
                    }
                }
                a = kVar;
                break;
            }
        }
        if (a == null && str.indexOf(95) != -1) {
            str = str.replaceAll("_", "");
            a = a(str);
            if (a == null) {
                k[] kVarArr2 = this.a;
                int length2 = kVarArr2.length;
                while (i < length2) {
                    k kVar2 = kVarArr2[i];
                    if (kVar2.a.a.equalsIgnoreCase(str)) {
                        a = kVar2;
                        break;
                    }
                    i++;
                }
            }
        }
        return a;
    }

    public final Object a(Map<String, Object> map, com.alibaba.fastjson.parser.g gVar) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        StringBuilder stringBuilder;
        int i = 0;
        Object obj = null;
        if (this.c.d == null && this.c.f == null) {
            Object a = a(null, this.b);
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String str = (String) entry.getKey();
                obj = entry.getValue();
                k a2 = a(str);
                if (a2 != null) {
                    Method method = a2.a.b;
                    if (method != null) {
                        obj = j.a(obj, method.getGenericParameterTypes()[0], gVar);
                        method.invoke(a, new Object[]{obj});
                    } else {
                        a2.a.c.set(a, j.a(obj, a2.a.e, gVar));
                    }
                }
            }
            return a;
        }
        gVar = this.c.h;
        int length = gVar.length;
        Object[] objArr = new Object[length];
        while (i < length) {
            objArr[i] = map.get(gVar[i].a);
            i++;
        }
        if (this.c.d != null) {
            try {
                obj = this.c.d.newInstance(objArr);
            } catch (Map<String, Object> map2) {
                stringBuilder = new StringBuilder("create instance error, ");
                stringBuilder.append(this.c.d.toGenericString());
                throw new JSONException(stringBuilder.toString(), map2);
            }
        } else if (this.c.e != null) {
            try {
                obj = this.c.e.invoke(null, objArr);
            } catch (Map<String, Object> map22) {
                stringBuilder = new StringBuilder("create factory method error, ");
                stringBuilder.append(this.c.e.toString());
                throw new JSONException(stringBuilder.toString(), map22);
            }
        }
        return obj;
    }
}
