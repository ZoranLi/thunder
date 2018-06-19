package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.c.d;
import com.alibaba.fastjson.c.j;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* compiled from: JavaBeanSerializer */
public class ag implements ao {
    private static final char[] d = new char[]{'t', 'r', 'u', 'e'};
    private static final char[] e = new char[]{'f', 'a', 'l', 's', 'e'};
    protected final z[] a;
    protected int b;
    protected final Class<?> c;
    private final z[] f;

    public ag(Class<?> cls) {
        this((Class) cls, (byte) 0);
    }

    private ag(Class<?> cls, byte b) {
        this((Class) cls, j.a((Class) cls));
    }

    public ag(java.lang.Class<?> r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r5.<init>();
        r0 = 0;
        r5.b = r0;
        r5.b = r7;
        r5.c = r6;
        r7 = com.alibaba.fastjson.a.d.class;
        r7 = r6.getAnnotation(r7);
        r7 = (com.alibaba.fastjson.a.d) r7;
        if (r7 == 0) goto L_0x001b;
    L_0x0014:
        r1 = r7.e();
        com.alibaba.fastjson.serializer.SerializerFeature.of(r1);
    L_0x001b:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = com.alibaba.fastjson.c.j.a(r6, r0);
        r2 = r2.iterator();
    L_0x0028:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x003d;
    L_0x002e:
        r3 = r2.next();
        r3 = (com.alibaba.fastjson.c.d) r3;
        r4 = new com.alibaba.fastjson.serializer.z;
        r4.<init>(r6, r3);
        r1.add(r4);
        goto L_0x0028;
    L_0x003d:
        r2 = r1.size();
        r2 = new com.alibaba.fastjson.serializer.z[r2];
        r1 = r1.toArray(r2);
        r1 = (com.alibaba.fastjson.serializer.z[]) r1;
        r5.f = r1;
        r1 = 0;
        if (r7 == 0) goto L_0x0052;
    L_0x004e:
        r1 = r7.b();
    L_0x0052:
        if (r1 == 0) goto L_0x0089;
    L_0x0054:
        r7 = r1.length;
        if (r7 == 0) goto L_0x0089;
    L_0x0057:
        r7 = 1;
        r7 = com.alibaba.fastjson.c.j.a(r6, r7);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r7 = r7.iterator();
    L_0x0065:
        r1 = r7.hasNext();
        if (r1 == 0) goto L_0x007a;
    L_0x006b:
        r1 = r7.next();
        r1 = (com.alibaba.fastjson.c.d) r1;
        r2 = new com.alibaba.fastjson.serializer.z;
        r2.<init>(r6, r1);
        r0.add(r2);
        goto L_0x0065;
    L_0x007a:
        r6 = r0.size();
        r6 = new com.alibaba.fastjson.serializer.z[r6];
        r6 = r0.toArray(r6);
        r6 = (com.alibaba.fastjson.serializer.z[]) r6;
        r5.a = r6;
        return;
    L_0x0089:
        r6 = r5.f;
        r6 = r6.length;
        r6 = new com.alibaba.fastjson.serializer.z[r6];
        r7 = r5.f;
        r1 = r5.f;
        r1 = r1.length;
        java.lang.System.arraycopy(r7, r0, r6, r0, r1);
        java.util.Arrays.sort(r6);
        r7 = r5.f;
        r7 = java.util.Arrays.equals(r6, r7);
        if (r7 == 0) goto L_0x00a6;
    L_0x00a1:
        r6 = r5.f;
        r5.a = r6;
        return;
    L_0x00a6:
        r5.a = r6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ag.<init>(java.lang.Class, int):void");
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        at atVar;
        af afVar2;
        Throwable th;
        Throwable e;
        at atVar2;
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        ag agVar = this;
        af afVar3 = afVar;
        Object obj3 = obj;
        Object obj4 = obj2;
        Object obj5 = type;
        ax axVar = afVar3.a;
        if (obj3 == null) {
            axVar.write("null");
            return;
        }
        Object obj6;
        at atVar3 = afVar3.m;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if ((atVar3 == null || ((atVar3.d & i2) == 0 && (i & i2) == 0)) && afVar3.l != null && afVar3.l.containsKey(obj3)) {
            afVar.b(obj);
            obj6 = 1;
        } else {
            obj6 = null;
        }
        String str2;
        if (obj6 == null) {
            z[] zVarArr;
            Object obj7;
            int i3;
            int i4;
            char c;
            Object obj8;
            boolean z;
            boolean z2;
            List list;
            List list2;
            List list3;
            Object obj9;
            List list4;
            List list5;
            List list6;
            int i5;
            Object obj10;
            z zVar;
            z[] zVarArr2;
            Field field;
            int i6;
            d dVar;
            String str3;
            Class cls;
            boolean z3;
            List list7;
            List list8;
            List list9;
            List list10;
            List list11;
            boolean z4;
            List list12;
            int i7;
            Object obj11;
            long j;
            Object obj12;
            Integer valueOf;
            Iterator it;
            Iterator it2;
            String str4;
            Object obj13;
            Object obj14;
            Object obj15;
            String str5;
            char c2;
            if (axVar.i) {
                zVarArr = agVar.a;
            } else {
                zVarArr = agVar.f;
            }
            at atVar4 = afVar3.m;
            afVar3.a(atVar4, obj3, obj4, agVar.b);
            if ((agVar.b & SerializerFeature.BeanToArray.mask) == 0) {
                if (!afVar3.a.k) {
                    obj7 = null;
                    i3 = obj7 == null ? 91 : 123;
                    i4 = obj7 == null ? 93 : 125;
                    axVar.write(i3);
                    if (zVarArr.length > 0 && axVar.l) {
                        afVar.d();
                        afVar.f();
                    }
                    if (((agVar.b & SerializerFeature.WriteClassName.mask) == 0 || afVar3.a((Type) obj5)) && obj.getClass() != obj5) {
                        axVar.e(a.DEFAULT_TYPE_KEY);
                        afVar3.c(obj.getClass());
                        obj5 = 1;
                    } else {
                        obj5 = null;
                    }
                    c = obj5 == null ? ',' : '\u0000';
                    obj8 = (axVar.h || axVar.g) ? null : 1;
                    obj5 = afVar3.a(c) != ',' ? 1 : null;
                    z = axVar.n;
                    z2 = axVar.p;
                    list = afVar3.h;
                    list2 = afVar3.d;
                    list3 = afVar3.f;
                    obj9 = obj5;
                    list4 = afVar3.e;
                    list5 = afVar3.i;
                    atVar = atVar4;
                    try {
                        list6 = afVar3.g;
                        i5 = i4;
                        obj10 = obj8;
                        i4 = 0;
                        while (i4 < zVarArr.length) {
                            try {
                                zVar = zVarArr[i4];
                                zVarArr2 = zVarArr;
                                field = zVar.a.c;
                                i6 = i4;
                                dVar = zVar.a;
                                try {
                                    str3 = dVar.a;
                                    cls = dVar.d;
                                    if (z || field == null) {
                                        z3 = z;
                                    } else {
                                        z3 = z;
                                        try {
                                            if (!dVar.k) {
                                            }
                                            list7 = r1;
                                            list8 = r4;
                                            list9 = r5;
                                            list10 = r8;
                                            list11 = r9;
                                            z4 = z2;
                                            list12 = list2;
                                            afVar2 = afVar;
                                            i4 = i6 + 1;
                                            afVar3 = afVar2;
                                            zVarArr = zVarArr2;
                                            z = z3;
                                            list = list11;
                                            list6 = list10;
                                            z2 = z4;
                                            list3 = list7;
                                            list2 = list12;
                                            list5 = list8;
                                            list4 = list9;
                                            obj3 = obj;
                                        } catch (Throwable e2) {
                                            th = e2;
                                            atVar2 = atVar;
                                            afVar2 = afVar;
                                        } catch (Throwable e22) {
                                            th = e22;
                                            atVar2 = atVar;
                                            afVar2 = afVar;
                                        }
                                    }
                                    if (z2) {
                                        if (field != null) {
                                        }
                                        list7 = r1;
                                        list8 = r4;
                                        list9 = r5;
                                        list10 = r8;
                                        list11 = r9;
                                        z4 = z2;
                                        list12 = list2;
                                        afVar2 = afVar;
                                        i4 = i6 + 1;
                                        afVar3 = afVar2;
                                        zVarArr = zVarArr2;
                                        z = z3;
                                        list = list11;
                                        list6 = list10;
                                        z2 = z4;
                                        list3 = list7;
                                        list2 = list12;
                                        list5 = list8;
                                        list4 = list9;
                                        obj3 = obj;
                                    }
                                    if (r8 != null) {
                                        for (ar a : r8) {
                                            if (!a.a()) {
                                                obj6 = null;
                                                break;
                                            }
                                        }
                                    }
                                    obj6 = 1;
                                    if (obj6 != null) {
                                        if (r9 != null) {
                                            for (ah a2 : r9) {
                                                if (!a2.a()) {
                                                    obj6 = null;
                                                    break;
                                                }
                                            }
                                        }
                                        obj6 = 1;
                                        if (obj6 != null) {
                                            if (dVar.j) {
                                                obj6 = zVar.a(obj3);
                                            } else {
                                                if (cls == Integer.TYPE) {
                                                    i7 = dVar.c.getInt(obj3);
                                                    obj11 = null;
                                                    list10 = r8;
                                                    list11 = r9;
                                                    z4 = z2;
                                                    j = 0;
                                                    obj6 = 1;
                                                    z2 = false;
                                                } else if (cls == Long.TYPE) {
                                                    list10 = r8;
                                                    list11 = r9;
                                                    z4 = z2;
                                                    j = dVar.c.getLong(obj3);
                                                    z2 = false;
                                                    i7 = 0;
                                                    obj12 = null;
                                                    obj11 = null;
                                                    obj6 = 1;
                                                    if (list2 != null) {
                                                        if (obj6 != null) {
                                                            if (cls == Integer.TYPE) {
                                                                valueOf = Integer.valueOf(i7);
                                                            } else if (cls == Long.TYPE) {
                                                                valueOf = Long.valueOf(j);
                                                            } else if (cls == Boolean.TYPE) {
                                                                valueOf = Boolean.valueOf(z2);
                                                            }
                                                            obj11 = valueOf;
                                                            obj12 = 1;
                                                        }
                                                        it = list2.iterator();
                                                        while (it.hasNext()) {
                                                            it2 = it;
                                                            if (!((aq) it.next()).a()) {
                                                                obj3 = null;
                                                                break;
                                                            }
                                                            it = it2;
                                                        }
                                                    }
                                                    obj3 = 1;
                                                    if (obj3 == null) {
                                                        if (r1 == null) {
                                                            if (obj6 != null && r26 == null) {
                                                                if (cls == Integer.TYPE) {
                                                                    valueOf = Integer.valueOf(i7);
                                                                } else if (cls != Long.TYPE) {
                                                                    valueOf = Long.valueOf(j);
                                                                } else if (cls == Boolean.TYPE) {
                                                                    valueOf = Boolean.valueOf(z2);
                                                                }
                                                                obj11 = valueOf;
                                                                obj12 = 1;
                                                            }
                                                            str4 = str3;
                                                            for (am a3 : r1) {
                                                                list7 = list3;
                                                                str4 = a3.a();
                                                                list3 = list7;
                                                            }
                                                            list7 = list3;
                                                            list12 = list2;
                                                            obj13 = obj11;
                                                            str2 = str4;
                                                        } else {
                                                            list7 = r1;
                                                            list12 = list2;
                                                            str2 = str3;
                                                            obj13 = obj11;
                                                        }
                                                        if (axVar.q) {
                                                            if (cls == Integer.TYPE) {
                                                                obj13 = Integer.toString(i7);
                                                            } else if (cls == Long.TYPE) {
                                                                obj13 = Long.toString(j);
                                                            } else if (cls != Boolean.TYPE) {
                                                                obj13 = Boolean.toString(z2);
                                                            } else if (cls != String.class && ((obj13 instanceof Number) || (obj13 instanceof Boolean))) {
                                                                obj13 = obj13.toString();
                                                            }
                                                            obj12 = 1;
                                                        }
                                                        if (r5 == null) {
                                                            if (obj6 != null && r26 == null) {
                                                                if (cls == Integer.TYPE) {
                                                                    obj13 = Integer.valueOf(i7);
                                                                } else if (cls != Long.TYPE) {
                                                                    obj13 = Long.valueOf(j);
                                                                } else if (cls == Boolean.TYPE) {
                                                                    obj13 = Boolean.valueOf(z2);
                                                                }
                                                                obj12 = 1;
                                                            }
                                                            obj11 = obj13;
                                                            for (az a4 : r5) {
                                                                obj14 = obj13;
                                                                obj11 = a4.a();
                                                                obj13 = obj14;
                                                            }
                                                            obj14 = obj13;
                                                            obj13 = obj11;
                                                        } else {
                                                            obj14 = obj13;
                                                        }
                                                        if (r4 != null) {
                                                            if (obj6 != null && r26 == null) {
                                                                if (cls == Integer.TYPE) {
                                                                    obj13 = Integer.valueOf(i7);
                                                                } else if (cls != Long.TYPE) {
                                                                    obj13 = Long.valueOf(j);
                                                                } else if (cls == Boolean.TYPE) {
                                                                    obj13 = Boolean.valueOf(z2);
                                                                }
                                                                obj14 = obj13;
                                                                obj12 = 1;
                                                            }
                                                            for (t a5 : r4) {
                                                                obj13 = a5.a();
                                                            }
                                                        }
                                                        obj15 = obj14;
                                                        if (obj12 == null && obj13 == null && obj7 == null) {
                                                            list8 = r4;
                                                            if (!zVar.b) {
                                                                if (!axVar.u) {
                                                                    list9 = r5;
                                                                    afVar2 = afVar;
                                                                    i4 = i6 + 1;
                                                                    afVar3 = afVar2;
                                                                    zVarArr = zVarArr2;
                                                                    z = z3;
                                                                    list = list11;
                                                                    list6 = list10;
                                                                    z2 = z4;
                                                                    list3 = list7;
                                                                    list2 = list12;
                                                                    list5 = list8;
                                                                    list4 = list9;
                                                                    obj3 = obj;
                                                                }
                                                            }
                                                        } else {
                                                            list8 = r4;
                                                        }
                                                        if (obj13 == null && axVar.r) {
                                                            Class cls2 = dVar.d;
                                                            list9 = r5;
                                                            if (!((cls2 == Byte.TYPE && (obj13 instanceof Byte) && ((Byte) obj13).byteValue() == (byte) 0) || ((cls2 == Short.TYPE && (obj13 instanceof Short) && ((Short) obj13).shortValue() == (short) 0) || ((cls2 == Integer.TYPE && (obj13 instanceof Integer) && ((Integer) obj13).intValue() == 0) || ((cls2 == Long.TYPE && (obj13 instanceof Long) && ((Long) obj13).longValue() == 0) || ((cls2 == Float.TYPE && (obj13 instanceof Float) && ((Float) obj13).floatValue() == 0.0f) || (cls2 == Double.TYPE && (obj13 instanceof Double) && ((Double) obj13).doubleValue() == 0.0d))))))) {
                                                                if (cls2 == Boolean.TYPE && (obj13 instanceof Boolean)) {
                                                                    if (((Boolean) obj13).booleanValue()) {
                                                                    }
                                                                }
                                                            }
                                                            afVar2 = afVar;
                                                            i4 = i6 + 1;
                                                            afVar3 = afVar2;
                                                            zVarArr = zVarArr2;
                                                            z = z3;
                                                            list = list11;
                                                            list6 = list10;
                                                            z2 = z4;
                                                            list3 = list7;
                                                            list2 = list12;
                                                            list5 = list8;
                                                            list4 = list9;
                                                            obj3 = obj;
                                                        } else {
                                                            list9 = r5;
                                                        }
                                                        if (obj9 != null) {
                                                            axVar.write(44);
                                                            if (axVar.l) {
                                                                str = str3;
                                                                afVar2 = afVar;
                                                                try {
                                                                    afVar.f();
                                                                    if (str2 == str) {
                                                                        if (obj7 == null) {
                                                                            axVar.e(str2);
                                                                        }
                                                                        afVar2.c(obj13);
                                                                    } else if (obj15 == obj13) {
                                                                        if (obj7 == null) {
                                                                            zVar.a(afVar2);
                                                                        }
                                                                        afVar2.c(obj13);
                                                                    } else {
                                                                        if (obj7 == null) {
                                                                            if (obj10 == null) {
                                                                                axVar.write(dVar.l, 0, dVar.l.length);
                                                                            } else {
                                                                                zVar.a(afVar2);
                                                                            }
                                                                        }
                                                                        if (obj6 != null || obj12 != null) {
                                                                            if (obj7 != null) {
                                                                                zVar.a(afVar2, obj13);
                                                                            } else if (cls != String.class) {
                                                                                zVar.a(afVar2, obj13);
                                                                            } else if (obj13 != null) {
                                                                                if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                                    if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                                        axVar.write("null");
                                                                                    }
                                                                                }
                                                                                axVar.b("");
                                                                            } else {
                                                                                str5 = (String) obj13;
                                                                                if (axVar.g) {
                                                                                    axVar.a(str5, '\u0000');
                                                                                } else {
                                                                                    axVar.c(str5);
                                                                                }
                                                                            }
                                                                            obj9 = 1;
                                                                            i4 = i6 + 1;
                                                                            afVar3 = afVar2;
                                                                            zVarArr = zVarArr2;
                                                                            z = z3;
                                                                            list = list11;
                                                                            list6 = list10;
                                                                            z2 = z4;
                                                                            list3 = list7;
                                                                            list2 = list12;
                                                                            list5 = list8;
                                                                            list4 = list9;
                                                                            obj3 = obj;
                                                                        } else if (cls == Integer.TYPE) {
                                                                            afVar2.a.a(i7);
                                                                        } else if (cls == Long.TYPE) {
                                                                            afVar2.a.a(j);
                                                                        } else if (cls == Boolean.TYPE) {
                                                                            if (z2) {
                                                                                afVar2.a.write(d, 0, d.length);
                                                                            } else {
                                                                                afVar2.a.write(e, 0, e.length);
                                                                            }
                                                                        }
                                                                    }
                                                                    obj9 = 1;
                                                                    i4 = i6 + 1;
                                                                    afVar3 = afVar2;
                                                                    zVarArr = zVarArr2;
                                                                    z = z3;
                                                                    list = list11;
                                                                    list6 = list10;
                                                                    z2 = z4;
                                                                    list3 = list7;
                                                                    list2 = list12;
                                                                    list5 = list8;
                                                                    list4 = list9;
                                                                    obj3 = obj;
                                                                } catch (Exception e3) {
                                                                    e22 = e3;
                                                                } catch (Throwable th2) {
                                                                    e22 = th2;
                                                                }
                                                            }
                                                        }
                                                        str = str3;
                                                        afVar2 = afVar;
                                                        if (str2 == str) {
                                                            if (obj7 == null) {
                                                                axVar.e(str2);
                                                            }
                                                            afVar2.c(obj13);
                                                        } else if (obj15 == obj13) {
                                                            if (obj7 == null) {
                                                                if (obj10 == null) {
                                                                    zVar.a(afVar2);
                                                                } else {
                                                                    axVar.write(dVar.l, 0, dVar.l.length);
                                                                }
                                                            }
                                                            if (obj6 != null) {
                                                            }
                                                            if (obj7 != null) {
                                                                zVar.a(afVar2, obj13);
                                                            } else if (cls != String.class) {
                                                                zVar.a(afVar2, obj13);
                                                            } else if (obj13 != null) {
                                                                str5 = (String) obj13;
                                                                if (axVar.g) {
                                                                    axVar.a(str5, '\u0000');
                                                                } else {
                                                                    axVar.c(str5);
                                                                }
                                                            } else {
                                                                if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                        axVar.write("null");
                                                                    }
                                                                }
                                                                axVar.b("");
                                                            }
                                                            obj9 = 1;
                                                            i4 = i6 + 1;
                                                            afVar3 = afVar2;
                                                            zVarArr = zVarArr2;
                                                            z = z3;
                                                            list = list11;
                                                            list6 = list10;
                                                            z2 = z4;
                                                            list3 = list7;
                                                            list2 = list12;
                                                            list5 = list8;
                                                            list4 = list9;
                                                            obj3 = obj;
                                                        } else {
                                                            if (obj7 == null) {
                                                                zVar.a(afVar2);
                                                            }
                                                            afVar2.c(obj13);
                                                        }
                                                        obj9 = 1;
                                                        i4 = i6 + 1;
                                                        afVar3 = afVar2;
                                                        zVarArr = zVarArr2;
                                                        z = z3;
                                                        list = list11;
                                                        list6 = list10;
                                                        z2 = z4;
                                                        list3 = list7;
                                                        list2 = list12;
                                                        list5 = list8;
                                                        list4 = list9;
                                                        obj3 = obj;
                                                    } else {
                                                        list7 = r1;
                                                        list8 = r4;
                                                        list9 = r5;
                                                        list12 = list2;
                                                        afVar2 = afVar;
                                                        i4 = i6 + 1;
                                                        afVar3 = afVar2;
                                                        zVarArr = zVarArr2;
                                                        z = z3;
                                                        list = list11;
                                                        list6 = list10;
                                                        z2 = z4;
                                                        list3 = list7;
                                                        list2 = list12;
                                                        list5 = list8;
                                                        list4 = list9;
                                                        obj3 = obj;
                                                    }
                                                } else if (cls != Boolean.TYPE) {
                                                    obj11 = null;
                                                    list10 = r8;
                                                    list11 = r9;
                                                    z4 = z2;
                                                    z2 = dVar.c.getBoolean(obj3);
                                                    j = 0;
                                                    obj6 = 1;
                                                    i7 = 0;
                                                } else {
                                                    obj6 = dVar.c.get(obj3);
                                                }
                                                obj12 = null;
                                                if (list2 != null) {
                                                    if (obj6 != null) {
                                                        if (cls == Integer.TYPE) {
                                                            valueOf = Integer.valueOf(i7);
                                                        } else if (cls == Long.TYPE) {
                                                            valueOf = Long.valueOf(j);
                                                        } else if (cls == Boolean.TYPE) {
                                                            valueOf = Boolean.valueOf(z2);
                                                        }
                                                        obj11 = valueOf;
                                                        obj12 = 1;
                                                    }
                                                    it = list2.iterator();
                                                    while (it.hasNext()) {
                                                        it2 = it;
                                                        if (!((aq) it.next()).a()) {
                                                            obj3 = null;
                                                            break;
                                                        }
                                                        it = it2;
                                                    }
                                                }
                                                obj3 = 1;
                                                if (obj3 == null) {
                                                    list7 = r1;
                                                    list8 = r4;
                                                    list9 = r5;
                                                    list12 = list2;
                                                    afVar2 = afVar;
                                                    i4 = i6 + 1;
                                                    afVar3 = afVar2;
                                                    zVarArr = zVarArr2;
                                                    z = z3;
                                                    list = list11;
                                                    list6 = list10;
                                                    z2 = z4;
                                                    list3 = list7;
                                                    list2 = list12;
                                                    list5 = list8;
                                                    list4 = list9;
                                                    obj3 = obj;
                                                } else {
                                                    if (r1 == null) {
                                                        list7 = r1;
                                                        list12 = list2;
                                                        str2 = str3;
                                                        obj13 = obj11;
                                                    } else {
                                                        if (cls == Integer.TYPE) {
                                                            valueOf = Integer.valueOf(i7);
                                                        } else if (cls != Long.TYPE) {
                                                            if (cls == Boolean.TYPE) {
                                                                valueOf = Boolean.valueOf(z2);
                                                            }
                                                            str4 = str3;
                                                            while (it.hasNext()) {
                                                                list7 = list3;
                                                                str4 = a3.a();
                                                                list3 = list7;
                                                            }
                                                            list7 = list3;
                                                            list12 = list2;
                                                            obj13 = obj11;
                                                            str2 = str4;
                                                        } else {
                                                            valueOf = Long.valueOf(j);
                                                        }
                                                        obj11 = valueOf;
                                                        obj12 = 1;
                                                        str4 = str3;
                                                        while (it.hasNext()) {
                                                            list7 = list3;
                                                            str4 = a3.a();
                                                            list3 = list7;
                                                        }
                                                        list7 = list3;
                                                        list12 = list2;
                                                        obj13 = obj11;
                                                        str2 = str4;
                                                    }
                                                    if (axVar.q) {
                                                        if (cls == Integer.TYPE) {
                                                            obj13 = Integer.toString(i7);
                                                        } else if (cls == Long.TYPE) {
                                                            obj13 = Long.toString(j);
                                                        } else if (cls != Boolean.TYPE) {
                                                            obj13 = obj13.toString();
                                                        } else {
                                                            obj13 = Boolean.toString(z2);
                                                        }
                                                        obj12 = 1;
                                                    }
                                                    if (r5 == null) {
                                                        obj14 = obj13;
                                                    } else {
                                                        if (cls == Integer.TYPE) {
                                                            obj13 = Integer.valueOf(i7);
                                                        } else if (cls != Long.TYPE) {
                                                            if (cls == Boolean.TYPE) {
                                                                obj13 = Boolean.valueOf(z2);
                                                            }
                                                            obj11 = obj13;
                                                            while (r12.hasNext()) {
                                                                obj14 = obj13;
                                                                obj11 = a4.a();
                                                                obj13 = obj14;
                                                            }
                                                            obj14 = obj13;
                                                            obj13 = obj11;
                                                        } else {
                                                            obj13 = Long.valueOf(j);
                                                        }
                                                        obj12 = 1;
                                                        obj11 = obj13;
                                                        while (r12.hasNext()) {
                                                            obj14 = obj13;
                                                            obj11 = a4.a();
                                                            obj13 = obj14;
                                                        }
                                                        obj14 = obj13;
                                                        obj13 = obj11;
                                                    }
                                                    if (r4 != null) {
                                                        if (cls == Integer.TYPE) {
                                                            obj13 = Integer.valueOf(i7);
                                                        } else if (cls != Long.TYPE) {
                                                            if (cls == Boolean.TYPE) {
                                                                obj13 = Boolean.valueOf(z2);
                                                            }
                                                            while (r12.hasNext()) {
                                                                obj13 = a5.a();
                                                            }
                                                        } else {
                                                            obj13 = Long.valueOf(j);
                                                        }
                                                        obj14 = obj13;
                                                        obj12 = 1;
                                                        while (r12.hasNext()) {
                                                            obj13 = a5.a();
                                                        }
                                                    }
                                                    obj15 = obj14;
                                                    if (obj12 == null) {
                                                    }
                                                    list8 = r4;
                                                    if (obj13 == null) {
                                                    }
                                                    list9 = r5;
                                                    if (obj9 != null) {
                                                        axVar.write(44);
                                                        if (axVar.l) {
                                                            str = str3;
                                                            afVar2 = afVar;
                                                            afVar.f();
                                                            if (str2 == str) {
                                                                if (obj7 == null) {
                                                                    axVar.e(str2);
                                                                }
                                                                afVar2.c(obj13);
                                                            } else if (obj15 == obj13) {
                                                                if (obj7 == null) {
                                                                    zVar.a(afVar2);
                                                                }
                                                                afVar2.c(obj13);
                                                            } else {
                                                                if (obj7 == null) {
                                                                    if (obj10 == null) {
                                                                        axVar.write(dVar.l, 0, dVar.l.length);
                                                                    } else {
                                                                        zVar.a(afVar2);
                                                                    }
                                                                }
                                                                if (obj6 != null) {
                                                                }
                                                                if (obj7 != null) {
                                                                    zVar.a(afVar2, obj13);
                                                                } else if (cls != String.class) {
                                                                    zVar.a(afVar2, obj13);
                                                                } else if (obj13 != null) {
                                                                    if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                        if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                            axVar.write("null");
                                                                        }
                                                                    }
                                                                    axVar.b("");
                                                                } else {
                                                                    str5 = (String) obj13;
                                                                    if (axVar.g) {
                                                                        axVar.c(str5);
                                                                    } else {
                                                                        axVar.a(str5, '\u0000');
                                                                    }
                                                                }
                                                                obj9 = 1;
                                                                i4 = i6 + 1;
                                                                afVar3 = afVar2;
                                                                zVarArr = zVarArr2;
                                                                z = z3;
                                                                list = list11;
                                                                list6 = list10;
                                                                z2 = z4;
                                                                list3 = list7;
                                                                list2 = list12;
                                                                list5 = list8;
                                                                list4 = list9;
                                                                obj3 = obj;
                                                            }
                                                            obj9 = 1;
                                                            i4 = i6 + 1;
                                                            afVar3 = afVar2;
                                                            zVarArr = zVarArr2;
                                                            z = z3;
                                                            list = list11;
                                                            list6 = list10;
                                                            z2 = z4;
                                                            list3 = list7;
                                                            list2 = list12;
                                                            list5 = list8;
                                                            list4 = list9;
                                                            obj3 = obj;
                                                        }
                                                    }
                                                    str = str3;
                                                    afVar2 = afVar;
                                                    if (str2 == str) {
                                                        if (obj7 == null) {
                                                            axVar.e(str2);
                                                        }
                                                        afVar2.c(obj13);
                                                    } else if (obj15 == obj13) {
                                                        if (obj7 == null) {
                                                            if (obj10 == null) {
                                                                zVar.a(afVar2);
                                                            } else {
                                                                axVar.write(dVar.l, 0, dVar.l.length);
                                                            }
                                                        }
                                                        if (obj6 != null) {
                                                        }
                                                        if (obj7 != null) {
                                                            zVar.a(afVar2, obj13);
                                                        } else if (cls != String.class) {
                                                            zVar.a(afVar2, obj13);
                                                        } else if (obj13 != null) {
                                                            str5 = (String) obj13;
                                                            if (axVar.g) {
                                                                axVar.a(str5, '\u0000');
                                                            } else {
                                                                axVar.c(str5);
                                                            }
                                                        } else {
                                                            if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    axVar.write("null");
                                                                }
                                                            }
                                                            axVar.b("");
                                                        }
                                                        obj9 = 1;
                                                        i4 = i6 + 1;
                                                        afVar3 = afVar2;
                                                        zVarArr = zVarArr2;
                                                        z = z3;
                                                        list = list11;
                                                        list6 = list10;
                                                        z2 = z4;
                                                        list3 = list7;
                                                        list2 = list12;
                                                        list5 = list8;
                                                        list4 = list9;
                                                        obj3 = obj;
                                                    } else {
                                                        if (obj7 == null) {
                                                            zVar.a(afVar2);
                                                        }
                                                        afVar2.c(obj13);
                                                    }
                                                    obj9 = 1;
                                                    i4 = i6 + 1;
                                                    afVar3 = afVar2;
                                                    zVarArr = zVarArr2;
                                                    z = z3;
                                                    list = list11;
                                                    list6 = list10;
                                                    z2 = z4;
                                                    list3 = list7;
                                                    list2 = list12;
                                                    list5 = list8;
                                                    list4 = list9;
                                                    obj3 = obj;
                                                }
                                            }
                                            obj11 = obj6;
                                            list10 = r8;
                                            list11 = r9;
                                            z4 = z2;
                                            j = 0;
                                            obj6 = null;
                                            z2 = false;
                                            i7 = 0;
                                            obj12 = 1;
                                            if (list2 != null) {
                                                if (obj6 != null) {
                                                    if (cls == Integer.TYPE) {
                                                        valueOf = Integer.valueOf(i7);
                                                    } else if (cls == Long.TYPE) {
                                                        valueOf = Long.valueOf(j);
                                                    } else if (cls == Boolean.TYPE) {
                                                        valueOf = Boolean.valueOf(z2);
                                                    }
                                                    obj11 = valueOf;
                                                    obj12 = 1;
                                                }
                                                it = list2.iterator();
                                                while (it.hasNext()) {
                                                    it2 = it;
                                                    if (!((aq) it.next()).a()) {
                                                        obj3 = null;
                                                        break;
                                                    }
                                                    it = it2;
                                                }
                                            }
                                            obj3 = 1;
                                            if (obj3 == null) {
                                                if (r1 == null) {
                                                    if (cls == Integer.TYPE) {
                                                        valueOf = Integer.valueOf(i7);
                                                    } else if (cls != Long.TYPE) {
                                                        valueOf = Long.valueOf(j);
                                                    } else {
                                                        if (cls == Boolean.TYPE) {
                                                            valueOf = Boolean.valueOf(z2);
                                                        }
                                                        str4 = str3;
                                                        while (it.hasNext()) {
                                                            list7 = list3;
                                                            str4 = a3.a();
                                                            list3 = list7;
                                                        }
                                                        list7 = list3;
                                                        list12 = list2;
                                                        obj13 = obj11;
                                                        str2 = str4;
                                                    }
                                                    obj11 = valueOf;
                                                    obj12 = 1;
                                                    str4 = str3;
                                                    while (it.hasNext()) {
                                                        list7 = list3;
                                                        str4 = a3.a();
                                                        list3 = list7;
                                                    }
                                                    list7 = list3;
                                                    list12 = list2;
                                                    obj13 = obj11;
                                                    str2 = str4;
                                                } else {
                                                    list7 = r1;
                                                    list12 = list2;
                                                    str2 = str3;
                                                    obj13 = obj11;
                                                }
                                                if (axVar.q) {
                                                    if (cls == Integer.TYPE) {
                                                        obj13 = Integer.toString(i7);
                                                    } else if (cls == Long.TYPE) {
                                                        obj13 = Long.toString(j);
                                                    } else if (cls != Boolean.TYPE) {
                                                        obj13 = Boolean.toString(z2);
                                                    } else {
                                                        obj13 = obj13.toString();
                                                    }
                                                    obj12 = 1;
                                                }
                                                if (r5 == null) {
                                                    if (cls == Integer.TYPE) {
                                                        obj13 = Integer.valueOf(i7);
                                                    } else if (cls != Long.TYPE) {
                                                        obj13 = Long.valueOf(j);
                                                    } else {
                                                        if (cls == Boolean.TYPE) {
                                                            obj13 = Boolean.valueOf(z2);
                                                        }
                                                        obj11 = obj13;
                                                        while (r12.hasNext()) {
                                                            obj14 = obj13;
                                                            obj11 = a4.a();
                                                            obj13 = obj14;
                                                        }
                                                        obj14 = obj13;
                                                        obj13 = obj11;
                                                    }
                                                    obj12 = 1;
                                                    obj11 = obj13;
                                                    while (r12.hasNext()) {
                                                        obj14 = obj13;
                                                        obj11 = a4.a();
                                                        obj13 = obj14;
                                                    }
                                                    obj14 = obj13;
                                                    obj13 = obj11;
                                                } else {
                                                    obj14 = obj13;
                                                }
                                                if (r4 != null) {
                                                    if (cls == Integer.TYPE) {
                                                        obj13 = Integer.valueOf(i7);
                                                    } else if (cls != Long.TYPE) {
                                                        obj13 = Long.valueOf(j);
                                                    } else {
                                                        if (cls == Boolean.TYPE) {
                                                            obj13 = Boolean.valueOf(z2);
                                                        }
                                                        while (r12.hasNext()) {
                                                            obj13 = a5.a();
                                                        }
                                                    }
                                                    obj14 = obj13;
                                                    obj12 = 1;
                                                    while (r12.hasNext()) {
                                                        obj13 = a5.a();
                                                    }
                                                }
                                                obj15 = obj14;
                                                if (obj12 == null) {
                                                }
                                                list8 = r4;
                                                if (obj13 == null) {
                                                }
                                                list9 = r5;
                                                if (obj9 != null) {
                                                    axVar.write(44);
                                                    if (axVar.l) {
                                                        str = str3;
                                                        afVar2 = afVar;
                                                        afVar.f();
                                                        if (str2 == str) {
                                                            if (obj7 == null) {
                                                                axVar.e(str2);
                                                            }
                                                            afVar2.c(obj13);
                                                        } else if (obj15 == obj13) {
                                                            if (obj7 == null) {
                                                                zVar.a(afVar2);
                                                            }
                                                            afVar2.c(obj13);
                                                        } else {
                                                            if (obj7 == null) {
                                                                if (obj10 == null) {
                                                                    axVar.write(dVar.l, 0, dVar.l.length);
                                                                } else {
                                                                    zVar.a(afVar2);
                                                                }
                                                            }
                                                            if (obj6 != null) {
                                                            }
                                                            if (obj7 != null) {
                                                                zVar.a(afVar2, obj13);
                                                            } else if (cls != String.class) {
                                                                zVar.a(afVar2, obj13);
                                                            } else if (obj13 != null) {
                                                                if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                        axVar.write("null");
                                                                    }
                                                                }
                                                                axVar.b("");
                                                            } else {
                                                                str5 = (String) obj13;
                                                                if (axVar.g) {
                                                                    axVar.c(str5);
                                                                } else {
                                                                    axVar.a(str5, '\u0000');
                                                                }
                                                            }
                                                            obj9 = 1;
                                                            i4 = i6 + 1;
                                                            afVar3 = afVar2;
                                                            zVarArr = zVarArr2;
                                                            z = z3;
                                                            list = list11;
                                                            list6 = list10;
                                                            z2 = z4;
                                                            list3 = list7;
                                                            list2 = list12;
                                                            list5 = list8;
                                                            list4 = list9;
                                                            obj3 = obj;
                                                        }
                                                        obj9 = 1;
                                                        i4 = i6 + 1;
                                                        afVar3 = afVar2;
                                                        zVarArr = zVarArr2;
                                                        z = z3;
                                                        list = list11;
                                                        list6 = list10;
                                                        z2 = z4;
                                                        list3 = list7;
                                                        list2 = list12;
                                                        list5 = list8;
                                                        list4 = list9;
                                                        obj3 = obj;
                                                    }
                                                }
                                                str = str3;
                                                afVar2 = afVar;
                                                if (str2 == str) {
                                                    if (obj7 == null) {
                                                        axVar.e(str2);
                                                    }
                                                    afVar2.c(obj13);
                                                } else if (obj15 == obj13) {
                                                    if (obj7 == null) {
                                                        if (obj10 == null) {
                                                            zVar.a(afVar2);
                                                        } else {
                                                            axVar.write(dVar.l, 0, dVar.l.length);
                                                        }
                                                    }
                                                    if (obj6 != null) {
                                                    }
                                                    if (obj7 != null) {
                                                        zVar.a(afVar2, obj13);
                                                    } else if (cls != String.class) {
                                                        zVar.a(afVar2, obj13);
                                                    } else if (obj13 != null) {
                                                        str5 = (String) obj13;
                                                        if (axVar.g) {
                                                            axVar.a(str5, '\u0000');
                                                        } else {
                                                            axVar.c(str5);
                                                        }
                                                    } else {
                                                        if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                            if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                axVar.write("null");
                                                            }
                                                        }
                                                        axVar.b("");
                                                    }
                                                    obj9 = 1;
                                                    i4 = i6 + 1;
                                                    afVar3 = afVar2;
                                                    zVarArr = zVarArr2;
                                                    z = z3;
                                                    list = list11;
                                                    list6 = list10;
                                                    z2 = z4;
                                                    list3 = list7;
                                                    list2 = list12;
                                                    list5 = list8;
                                                    list4 = list9;
                                                    obj3 = obj;
                                                } else {
                                                    if (obj7 == null) {
                                                        zVar.a(afVar2);
                                                    }
                                                    afVar2.c(obj13);
                                                }
                                                obj9 = 1;
                                                i4 = i6 + 1;
                                                afVar3 = afVar2;
                                                zVarArr = zVarArr2;
                                                z = z3;
                                                list = list11;
                                                list6 = list10;
                                                z2 = z4;
                                                list3 = list7;
                                                list2 = list12;
                                                list5 = list8;
                                                list4 = list9;
                                                obj3 = obj;
                                            } else {
                                                list7 = r1;
                                                list8 = r4;
                                                list9 = r5;
                                                list12 = list2;
                                                afVar2 = afVar;
                                                i4 = i6 + 1;
                                                afVar3 = afVar2;
                                                zVarArr = zVarArr2;
                                                z = z3;
                                                list = list11;
                                                list6 = list10;
                                                z2 = z4;
                                                list3 = list7;
                                                list2 = list12;
                                                list5 = list8;
                                                list4 = list9;
                                                obj3 = obj;
                                            }
                                        }
                                    }
                                    list7 = r1;
                                    list8 = r4;
                                    list9 = r5;
                                    list10 = r8;
                                    list11 = r9;
                                    z4 = z2;
                                    list12 = list2;
                                    afVar2 = afVar;
                                    i4 = i6 + 1;
                                    afVar3 = afVar2;
                                    zVarArr = zVarArr2;
                                    z = z3;
                                    list = list11;
                                    list6 = list10;
                                    z2 = z4;
                                    list3 = list7;
                                    list2 = list12;
                                    list5 = list8;
                                    list4 = list9;
                                    obj3 = obj;
                                } catch (Exception e4) {
                                    e22 = e4;
                                    afVar2 = afVar;
                                } catch (Throwable th3) {
                                    e22 = th3;
                                    afVar2 = afVar;
                                }
                            } catch (Exception e5) {
                                e22 = e5;
                                afVar2 = afVar3;
                            } catch (Throwable th4) {
                                e22 = th4;
                                afVar2 = afVar3;
                            }
                        }
                        afVar2 = afVar3;
                        zVarArr2 = zVarArr;
                        c2 = '\u0000';
                        if (obj9 != null) {
                            c2 = ',';
                        }
                    } catch (Exception e6) {
                        e22 = e6;
                        afVar2 = afVar3;
                        atVar2 = atVar;
                        th = e22;
                        try {
                            str2 = "write javaBean error";
                            if (obj != null) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(str2);
                                stringBuilder.append(", class ");
                                stringBuilder.append(obj.getClass().getName());
                                str2 = stringBuilder.toString();
                            }
                            str = str2;
                            obj3 = obj2;
                            if (obj3 != null) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(str);
                                stringBuilder.append(", fieldName : ");
                                stringBuilder.append(obj3);
                                str = stringBuilder.toString();
                            }
                            if (th.getMessage() != null) {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(str);
                                stringBuilder2.append(", ");
                                stringBuilder2.append(th.getMessage());
                                str = stringBuilder2.toString();
                            }
                            throw new JSONException(str, th);
                        } catch (Throwable th5) {
                            e22 = th5;
                            th = e22;
                            afVar2.m = atVar2;
                            throw th;
                        }
                    } catch (Throwable th6) {
                        e22 = th6;
                        afVar2 = afVar3;
                        atVar2 = atVar;
                        th = e22;
                        afVar2.m = atVar2;
                        throw th;
                    }
                    try {
                        afVar2.b(c2);
                        if (zVarArr2.length > 0) {
                            if (axVar.l) {
                                afVar.e();
                                afVar.f();
                            }
                        }
                        axVar.write(i5);
                        afVar2.m = atVar;
                        return;
                    } catch (Exception e7) {
                        e22 = e7;
                        atVar2 = atVar;
                        th = e22;
                        str2 = "write javaBean error";
                        if (obj != null) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append(", class ");
                            stringBuilder.append(obj.getClass().getName());
                            str2 = stringBuilder.toString();
                        }
                        str = str2;
                        obj3 = obj2;
                        if (obj3 != null) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append(", fieldName : ");
                            stringBuilder.append(obj3);
                            str = stringBuilder.toString();
                        }
                        if (th.getMessage() != null) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(str);
                            stringBuilder2.append(", ");
                            stringBuilder2.append(th.getMessage());
                            str = stringBuilder2.toString();
                        }
                        throw new JSONException(str, th);
                    } catch (Throwable th7) {
                        e22 = th7;
                        atVar2 = atVar;
                        th = e22;
                        afVar2.m = atVar2;
                        throw th;
                    }
                }
            }
            obj7 = 1;
            if (obj7 == null) {
            }
            if (obj7 == null) {
            }
            try {
                axVar.write(i3);
                afVar.d();
                afVar.f();
                if ((agVar.b & SerializerFeature.WriteClassName.mask) == 0) {
                }
                axVar.e(a.DEFAULT_TYPE_KEY);
                afVar3.c(obj.getClass());
                obj5 = 1;
                if (obj5 == null) {
                }
                if (axVar.h) {
                }
                if (afVar3.a(c) != ',') {
                }
                z = axVar.n;
                z2 = axVar.p;
                list = afVar3.h;
                list2 = afVar3.d;
                list3 = afVar3.f;
                obj9 = obj5;
                list4 = afVar3.e;
                list5 = afVar3.i;
                atVar = atVar4;
                list6 = afVar3.g;
                i5 = i4;
                obj10 = obj8;
                i4 = 0;
                while (i4 < zVarArr.length) {
                    zVar = zVarArr[i4];
                    zVarArr2 = zVarArr;
                    field = zVar.a.c;
                    i6 = i4;
                    dVar = zVar.a;
                    str3 = dVar.a;
                    cls = dVar.d;
                    if (z) {
                    }
                    z3 = z;
                    if (z2) {
                        if (field != null) {
                        }
                        list7 = r1;
                        list8 = r4;
                        list9 = r5;
                        list10 = r8;
                        list11 = r9;
                        z4 = z2;
                        list12 = list2;
                        afVar2 = afVar;
                        i4 = i6 + 1;
                        afVar3 = afVar2;
                        zVarArr = zVarArr2;
                        z = z3;
                        list = list11;
                        list6 = list10;
                        z2 = z4;
                        list3 = list7;
                        list2 = list12;
                        list5 = list8;
                        list4 = list9;
                        obj3 = obj;
                    }
                    if (r8 != null) {
                        while (r7.hasNext()) {
                            if (a.a()) {
                                obj6 = null;
                                break;
                            }
                        }
                    }
                    obj6 = 1;
                    if (obj6 != null) {
                        if (r9 != null) {
                            while (r7.hasNext()) {
                                if (a2.a()) {
                                    obj6 = null;
                                    break;
                                }
                            }
                        }
                        obj6 = 1;
                        if (obj6 != null) {
                            if (dVar.j) {
                                obj6 = zVar.a(obj3);
                            } else {
                                if (cls == Integer.TYPE) {
                                    i7 = dVar.c.getInt(obj3);
                                    obj11 = null;
                                    list10 = r8;
                                    list11 = r9;
                                    z4 = z2;
                                    j = 0;
                                    obj6 = 1;
                                    z2 = false;
                                } else if (cls == Long.TYPE) {
                                    list10 = r8;
                                    list11 = r9;
                                    z4 = z2;
                                    j = dVar.c.getLong(obj3);
                                    z2 = false;
                                    i7 = 0;
                                    obj12 = null;
                                    obj11 = null;
                                    obj6 = 1;
                                    if (list2 != null) {
                                        if (obj6 != null) {
                                            if (cls == Integer.TYPE) {
                                                valueOf = Integer.valueOf(i7);
                                            } else if (cls == Long.TYPE) {
                                                valueOf = Long.valueOf(j);
                                            } else if (cls == Boolean.TYPE) {
                                                valueOf = Boolean.valueOf(z2);
                                            }
                                            obj11 = valueOf;
                                            obj12 = 1;
                                        }
                                        it = list2.iterator();
                                        while (it.hasNext()) {
                                            it2 = it;
                                            if (!((aq) it.next()).a()) {
                                                obj3 = null;
                                                break;
                                            }
                                            it = it2;
                                        }
                                    }
                                    obj3 = 1;
                                    if (obj3 == null) {
                                        list7 = r1;
                                        list8 = r4;
                                        list9 = r5;
                                        list12 = list2;
                                        afVar2 = afVar;
                                        i4 = i6 + 1;
                                        afVar3 = afVar2;
                                        zVarArr = zVarArr2;
                                        z = z3;
                                        list = list11;
                                        list6 = list10;
                                        z2 = z4;
                                        list3 = list7;
                                        list2 = list12;
                                        list5 = list8;
                                        list4 = list9;
                                        obj3 = obj;
                                    } else {
                                        if (r1 == null) {
                                            list7 = r1;
                                            list12 = list2;
                                            str2 = str3;
                                            obj13 = obj11;
                                        } else {
                                            if (cls == Integer.TYPE) {
                                                valueOf = Integer.valueOf(i7);
                                            } else if (cls != Long.TYPE) {
                                                if (cls == Boolean.TYPE) {
                                                    valueOf = Boolean.valueOf(z2);
                                                }
                                                str4 = str3;
                                                while (it.hasNext()) {
                                                    list7 = list3;
                                                    str4 = a3.a();
                                                    list3 = list7;
                                                }
                                                list7 = list3;
                                                list12 = list2;
                                                obj13 = obj11;
                                                str2 = str4;
                                            } else {
                                                valueOf = Long.valueOf(j);
                                            }
                                            obj11 = valueOf;
                                            obj12 = 1;
                                            str4 = str3;
                                            while (it.hasNext()) {
                                                list7 = list3;
                                                str4 = a3.a();
                                                list3 = list7;
                                            }
                                            list7 = list3;
                                            list12 = list2;
                                            obj13 = obj11;
                                            str2 = str4;
                                        }
                                        if (axVar.q) {
                                            if (cls == Integer.TYPE) {
                                                obj13 = Integer.toString(i7);
                                            } else if (cls == Long.TYPE) {
                                                obj13 = Long.toString(j);
                                            } else if (cls != Boolean.TYPE) {
                                                obj13 = obj13.toString();
                                            } else {
                                                obj13 = Boolean.toString(z2);
                                            }
                                            obj12 = 1;
                                        }
                                        if (r5 == null) {
                                            obj14 = obj13;
                                        } else {
                                            if (cls == Integer.TYPE) {
                                                obj13 = Integer.valueOf(i7);
                                            } else if (cls != Long.TYPE) {
                                                if (cls == Boolean.TYPE) {
                                                    obj13 = Boolean.valueOf(z2);
                                                }
                                                obj11 = obj13;
                                                while (r12.hasNext()) {
                                                    obj14 = obj13;
                                                    obj11 = a4.a();
                                                    obj13 = obj14;
                                                }
                                                obj14 = obj13;
                                                obj13 = obj11;
                                            } else {
                                                obj13 = Long.valueOf(j);
                                            }
                                            obj12 = 1;
                                            obj11 = obj13;
                                            while (r12.hasNext()) {
                                                obj14 = obj13;
                                                obj11 = a4.a();
                                                obj13 = obj14;
                                            }
                                            obj14 = obj13;
                                            obj13 = obj11;
                                        }
                                        if (r4 != null) {
                                            if (cls == Integer.TYPE) {
                                                obj13 = Integer.valueOf(i7);
                                            } else if (cls != Long.TYPE) {
                                                if (cls == Boolean.TYPE) {
                                                    obj13 = Boolean.valueOf(z2);
                                                }
                                                while (r12.hasNext()) {
                                                    obj13 = a5.a();
                                                }
                                            } else {
                                                obj13 = Long.valueOf(j);
                                            }
                                            obj14 = obj13;
                                            obj12 = 1;
                                            while (r12.hasNext()) {
                                                obj13 = a5.a();
                                            }
                                        }
                                        obj15 = obj14;
                                        if (obj12 == null) {
                                        }
                                        list8 = r4;
                                        if (obj13 == null) {
                                        }
                                        list9 = r5;
                                        if (obj9 != null) {
                                            axVar.write(44);
                                            if (axVar.l) {
                                                str = str3;
                                                afVar2 = afVar;
                                                afVar.f();
                                                if (str2 == str) {
                                                    if (obj7 == null) {
                                                        axVar.e(str2);
                                                    }
                                                    afVar2.c(obj13);
                                                } else if (obj15 == obj13) {
                                                    if (obj7 == null) {
                                                        zVar.a(afVar2);
                                                    }
                                                    afVar2.c(obj13);
                                                } else {
                                                    if (obj7 == null) {
                                                        if (obj10 == null) {
                                                            axVar.write(dVar.l, 0, dVar.l.length);
                                                        } else {
                                                            zVar.a(afVar2);
                                                        }
                                                    }
                                                    if (obj6 != null) {
                                                    }
                                                    if (obj7 != null) {
                                                        zVar.a(afVar2, obj13);
                                                    } else if (cls != String.class) {
                                                        zVar.a(afVar2, obj13);
                                                    } else if (obj13 != null) {
                                                        if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                            if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                axVar.write("null");
                                                            }
                                                        }
                                                        axVar.b("");
                                                    } else {
                                                        str5 = (String) obj13;
                                                        if (axVar.g) {
                                                            axVar.c(str5);
                                                        } else {
                                                            axVar.a(str5, '\u0000');
                                                        }
                                                    }
                                                    obj9 = 1;
                                                    i4 = i6 + 1;
                                                    afVar3 = afVar2;
                                                    zVarArr = zVarArr2;
                                                    z = z3;
                                                    list = list11;
                                                    list6 = list10;
                                                    z2 = z4;
                                                    list3 = list7;
                                                    list2 = list12;
                                                    list5 = list8;
                                                    list4 = list9;
                                                    obj3 = obj;
                                                }
                                                obj9 = 1;
                                                i4 = i6 + 1;
                                                afVar3 = afVar2;
                                                zVarArr = zVarArr2;
                                                z = z3;
                                                list = list11;
                                                list6 = list10;
                                                z2 = z4;
                                                list3 = list7;
                                                list2 = list12;
                                                list5 = list8;
                                                list4 = list9;
                                                obj3 = obj;
                                            }
                                        }
                                        str = str3;
                                        afVar2 = afVar;
                                        if (str2 == str) {
                                            if (obj7 == null) {
                                                axVar.e(str2);
                                            }
                                            afVar2.c(obj13);
                                        } else if (obj15 == obj13) {
                                            if (obj7 == null) {
                                                if (obj10 == null) {
                                                    zVar.a(afVar2);
                                                } else {
                                                    axVar.write(dVar.l, 0, dVar.l.length);
                                                }
                                            }
                                            if (obj6 != null) {
                                            }
                                            if (obj7 != null) {
                                                zVar.a(afVar2, obj13);
                                            } else if (cls != String.class) {
                                                zVar.a(afVar2, obj13);
                                            } else if (obj13 != null) {
                                                str5 = (String) obj13;
                                                if (axVar.g) {
                                                    axVar.a(str5, '\u0000');
                                                } else {
                                                    axVar.c(str5);
                                                }
                                            } else {
                                                if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                    if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                        axVar.write("null");
                                                    }
                                                }
                                                axVar.b("");
                                            }
                                            obj9 = 1;
                                            i4 = i6 + 1;
                                            afVar3 = afVar2;
                                            zVarArr = zVarArr2;
                                            z = z3;
                                            list = list11;
                                            list6 = list10;
                                            z2 = z4;
                                            list3 = list7;
                                            list2 = list12;
                                            list5 = list8;
                                            list4 = list9;
                                            obj3 = obj;
                                        } else {
                                            if (obj7 == null) {
                                                zVar.a(afVar2);
                                            }
                                            afVar2.c(obj13);
                                        }
                                        obj9 = 1;
                                        i4 = i6 + 1;
                                        afVar3 = afVar2;
                                        zVarArr = zVarArr2;
                                        z = z3;
                                        list = list11;
                                        list6 = list10;
                                        z2 = z4;
                                        list3 = list7;
                                        list2 = list12;
                                        list5 = list8;
                                        list4 = list9;
                                        obj3 = obj;
                                    }
                                } else if (cls != Boolean.TYPE) {
                                    obj6 = dVar.c.get(obj3);
                                } else {
                                    obj11 = null;
                                    list10 = r8;
                                    list11 = r9;
                                    z4 = z2;
                                    z2 = dVar.c.getBoolean(obj3);
                                    j = 0;
                                    obj6 = 1;
                                    i7 = 0;
                                }
                                obj12 = null;
                                if (list2 != null) {
                                    if (obj6 != null) {
                                        if (cls == Integer.TYPE) {
                                            valueOf = Integer.valueOf(i7);
                                        } else if (cls == Long.TYPE) {
                                            valueOf = Long.valueOf(j);
                                        } else if (cls == Boolean.TYPE) {
                                            valueOf = Boolean.valueOf(z2);
                                        }
                                        obj11 = valueOf;
                                        obj12 = 1;
                                    }
                                    it = list2.iterator();
                                    while (it.hasNext()) {
                                        it2 = it;
                                        if (!((aq) it.next()).a()) {
                                            obj3 = null;
                                            break;
                                        }
                                        it = it2;
                                    }
                                }
                                obj3 = 1;
                                if (obj3 == null) {
                                    if (r1 == null) {
                                        if (cls == Integer.TYPE) {
                                            valueOf = Integer.valueOf(i7);
                                        } else if (cls != Long.TYPE) {
                                            valueOf = Long.valueOf(j);
                                        } else {
                                            if (cls == Boolean.TYPE) {
                                                valueOf = Boolean.valueOf(z2);
                                            }
                                            str4 = str3;
                                            while (it.hasNext()) {
                                                list7 = list3;
                                                str4 = a3.a();
                                                list3 = list7;
                                            }
                                            list7 = list3;
                                            list12 = list2;
                                            obj13 = obj11;
                                            str2 = str4;
                                        }
                                        obj11 = valueOf;
                                        obj12 = 1;
                                        str4 = str3;
                                        while (it.hasNext()) {
                                            list7 = list3;
                                            str4 = a3.a();
                                            list3 = list7;
                                        }
                                        list7 = list3;
                                        list12 = list2;
                                        obj13 = obj11;
                                        str2 = str4;
                                    } else {
                                        list7 = r1;
                                        list12 = list2;
                                        str2 = str3;
                                        obj13 = obj11;
                                    }
                                    if (axVar.q) {
                                        if (cls == Integer.TYPE) {
                                            obj13 = Integer.toString(i7);
                                        } else if (cls == Long.TYPE) {
                                            obj13 = Long.toString(j);
                                        } else if (cls != Boolean.TYPE) {
                                            obj13 = Boolean.toString(z2);
                                        } else {
                                            obj13 = obj13.toString();
                                        }
                                        obj12 = 1;
                                    }
                                    if (r5 == null) {
                                        if (cls == Integer.TYPE) {
                                            obj13 = Integer.valueOf(i7);
                                        } else if (cls != Long.TYPE) {
                                            obj13 = Long.valueOf(j);
                                        } else {
                                            if (cls == Boolean.TYPE) {
                                                obj13 = Boolean.valueOf(z2);
                                            }
                                            obj11 = obj13;
                                            while (r12.hasNext()) {
                                                obj14 = obj13;
                                                obj11 = a4.a();
                                                obj13 = obj14;
                                            }
                                            obj14 = obj13;
                                            obj13 = obj11;
                                        }
                                        obj12 = 1;
                                        obj11 = obj13;
                                        while (r12.hasNext()) {
                                            obj14 = obj13;
                                            obj11 = a4.a();
                                            obj13 = obj14;
                                        }
                                        obj14 = obj13;
                                        obj13 = obj11;
                                    } else {
                                        obj14 = obj13;
                                    }
                                    if (r4 != null) {
                                        if (cls == Integer.TYPE) {
                                            obj13 = Integer.valueOf(i7);
                                        } else if (cls != Long.TYPE) {
                                            obj13 = Long.valueOf(j);
                                        } else {
                                            if (cls == Boolean.TYPE) {
                                                obj13 = Boolean.valueOf(z2);
                                            }
                                            while (r12.hasNext()) {
                                                obj13 = a5.a();
                                            }
                                        }
                                        obj14 = obj13;
                                        obj12 = 1;
                                        while (r12.hasNext()) {
                                            obj13 = a5.a();
                                        }
                                    }
                                    obj15 = obj14;
                                    if (obj12 == null) {
                                    }
                                    list8 = r4;
                                    if (obj13 == null) {
                                    }
                                    list9 = r5;
                                    if (obj9 != null) {
                                        axVar.write(44);
                                        if (axVar.l) {
                                            str = str3;
                                            afVar2 = afVar;
                                            afVar.f();
                                            if (str2 == str) {
                                                if (obj7 == null) {
                                                    axVar.e(str2);
                                                }
                                                afVar2.c(obj13);
                                            } else if (obj15 == obj13) {
                                                if (obj7 == null) {
                                                    zVar.a(afVar2);
                                                }
                                                afVar2.c(obj13);
                                            } else {
                                                if (obj7 == null) {
                                                    if (obj10 == null) {
                                                        axVar.write(dVar.l, 0, dVar.l.length);
                                                    } else {
                                                        zVar.a(afVar2);
                                                    }
                                                }
                                                if (obj6 != null) {
                                                }
                                                if (obj7 != null) {
                                                    zVar.a(afVar2, obj13);
                                                } else if (cls != String.class) {
                                                    zVar.a(afVar2, obj13);
                                                } else if (obj13 != null) {
                                                    if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                        if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                            axVar.write("null");
                                                        }
                                                    }
                                                    axVar.b("");
                                                } else {
                                                    str5 = (String) obj13;
                                                    if (axVar.g) {
                                                        axVar.c(str5);
                                                    } else {
                                                        axVar.a(str5, '\u0000');
                                                    }
                                                }
                                                obj9 = 1;
                                                i4 = i6 + 1;
                                                afVar3 = afVar2;
                                                zVarArr = zVarArr2;
                                                z = z3;
                                                list = list11;
                                                list6 = list10;
                                                z2 = z4;
                                                list3 = list7;
                                                list2 = list12;
                                                list5 = list8;
                                                list4 = list9;
                                                obj3 = obj;
                                            }
                                            obj9 = 1;
                                            i4 = i6 + 1;
                                            afVar3 = afVar2;
                                            zVarArr = zVarArr2;
                                            z = z3;
                                            list = list11;
                                            list6 = list10;
                                            z2 = z4;
                                            list3 = list7;
                                            list2 = list12;
                                            list5 = list8;
                                            list4 = list9;
                                            obj3 = obj;
                                        }
                                    }
                                    str = str3;
                                    afVar2 = afVar;
                                    if (str2 == str) {
                                        if (obj7 == null) {
                                            axVar.e(str2);
                                        }
                                        afVar2.c(obj13);
                                    } else if (obj15 == obj13) {
                                        if (obj7 == null) {
                                            if (obj10 == null) {
                                                zVar.a(afVar2);
                                            } else {
                                                axVar.write(dVar.l, 0, dVar.l.length);
                                            }
                                        }
                                        if (obj6 != null) {
                                        }
                                        if (obj7 != null) {
                                            zVar.a(afVar2, obj13);
                                        } else if (cls != String.class) {
                                            zVar.a(afVar2, obj13);
                                        } else if (obj13 != null) {
                                            str5 = (String) obj13;
                                            if (axVar.g) {
                                                axVar.a(str5, '\u0000');
                                            } else {
                                                axVar.c(str5);
                                            }
                                        } else {
                                            if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                    axVar.write("null");
                                                }
                                            }
                                            axVar.b("");
                                        }
                                        obj9 = 1;
                                        i4 = i6 + 1;
                                        afVar3 = afVar2;
                                        zVarArr = zVarArr2;
                                        z = z3;
                                        list = list11;
                                        list6 = list10;
                                        z2 = z4;
                                        list3 = list7;
                                        list2 = list12;
                                        list5 = list8;
                                        list4 = list9;
                                        obj3 = obj;
                                    } else {
                                        if (obj7 == null) {
                                            zVar.a(afVar2);
                                        }
                                        afVar2.c(obj13);
                                    }
                                    obj9 = 1;
                                    i4 = i6 + 1;
                                    afVar3 = afVar2;
                                    zVarArr = zVarArr2;
                                    z = z3;
                                    list = list11;
                                    list6 = list10;
                                    z2 = z4;
                                    list3 = list7;
                                    list2 = list12;
                                    list5 = list8;
                                    list4 = list9;
                                    obj3 = obj;
                                } else {
                                    list7 = r1;
                                    list8 = r4;
                                    list9 = r5;
                                    list12 = list2;
                                    afVar2 = afVar;
                                    i4 = i6 + 1;
                                    afVar3 = afVar2;
                                    zVarArr = zVarArr2;
                                    z = z3;
                                    list = list11;
                                    list6 = list10;
                                    z2 = z4;
                                    list3 = list7;
                                    list2 = list12;
                                    list5 = list8;
                                    list4 = list9;
                                    obj3 = obj;
                                }
                            }
                            obj11 = obj6;
                            list10 = r8;
                            list11 = r9;
                            z4 = z2;
                            j = 0;
                            obj6 = null;
                            z2 = false;
                            i7 = 0;
                            obj12 = 1;
                            if (list2 != null) {
                                if (obj6 != null) {
                                    if (cls == Integer.TYPE) {
                                        valueOf = Integer.valueOf(i7);
                                    } else if (cls == Long.TYPE) {
                                        valueOf = Long.valueOf(j);
                                    } else if (cls == Boolean.TYPE) {
                                        valueOf = Boolean.valueOf(z2);
                                    }
                                    obj11 = valueOf;
                                    obj12 = 1;
                                }
                                it = list2.iterator();
                                while (it.hasNext()) {
                                    it2 = it;
                                    if (!((aq) it.next()).a()) {
                                        obj3 = null;
                                        break;
                                    }
                                    it = it2;
                                }
                            }
                            obj3 = 1;
                            if (obj3 == null) {
                                list7 = r1;
                                list8 = r4;
                                list9 = r5;
                                list12 = list2;
                                afVar2 = afVar;
                                i4 = i6 + 1;
                                afVar3 = afVar2;
                                zVarArr = zVarArr2;
                                z = z3;
                                list = list11;
                                list6 = list10;
                                z2 = z4;
                                list3 = list7;
                                list2 = list12;
                                list5 = list8;
                                list4 = list9;
                                obj3 = obj;
                            } else {
                                if (r1 == null) {
                                    list7 = r1;
                                    list12 = list2;
                                    str2 = str3;
                                    obj13 = obj11;
                                } else {
                                    if (cls == Integer.TYPE) {
                                        valueOf = Integer.valueOf(i7);
                                    } else if (cls != Long.TYPE) {
                                        if (cls == Boolean.TYPE) {
                                            valueOf = Boolean.valueOf(z2);
                                        }
                                        str4 = str3;
                                        while (it.hasNext()) {
                                            list7 = list3;
                                            str4 = a3.a();
                                            list3 = list7;
                                        }
                                        list7 = list3;
                                        list12 = list2;
                                        obj13 = obj11;
                                        str2 = str4;
                                    } else {
                                        valueOf = Long.valueOf(j);
                                    }
                                    obj11 = valueOf;
                                    obj12 = 1;
                                    str4 = str3;
                                    while (it.hasNext()) {
                                        list7 = list3;
                                        str4 = a3.a();
                                        list3 = list7;
                                    }
                                    list7 = list3;
                                    list12 = list2;
                                    obj13 = obj11;
                                    str2 = str4;
                                }
                                if (axVar.q) {
                                    if (cls == Integer.TYPE) {
                                        obj13 = Integer.toString(i7);
                                    } else if (cls == Long.TYPE) {
                                        obj13 = Long.toString(j);
                                    } else if (cls != Boolean.TYPE) {
                                        obj13 = obj13.toString();
                                    } else {
                                        obj13 = Boolean.toString(z2);
                                    }
                                    obj12 = 1;
                                }
                                if (r5 == null) {
                                    obj14 = obj13;
                                } else {
                                    if (cls == Integer.TYPE) {
                                        obj13 = Integer.valueOf(i7);
                                    } else if (cls != Long.TYPE) {
                                        if (cls == Boolean.TYPE) {
                                            obj13 = Boolean.valueOf(z2);
                                        }
                                        obj11 = obj13;
                                        while (r12.hasNext()) {
                                            obj14 = obj13;
                                            obj11 = a4.a();
                                            obj13 = obj14;
                                        }
                                        obj14 = obj13;
                                        obj13 = obj11;
                                    } else {
                                        obj13 = Long.valueOf(j);
                                    }
                                    obj12 = 1;
                                    obj11 = obj13;
                                    while (r12.hasNext()) {
                                        obj14 = obj13;
                                        obj11 = a4.a();
                                        obj13 = obj14;
                                    }
                                    obj14 = obj13;
                                    obj13 = obj11;
                                }
                                if (r4 != null) {
                                    if (cls == Integer.TYPE) {
                                        obj13 = Integer.valueOf(i7);
                                    } else if (cls != Long.TYPE) {
                                        if (cls == Boolean.TYPE) {
                                            obj13 = Boolean.valueOf(z2);
                                        }
                                        while (r12.hasNext()) {
                                            obj13 = a5.a();
                                        }
                                    } else {
                                        obj13 = Long.valueOf(j);
                                    }
                                    obj14 = obj13;
                                    obj12 = 1;
                                    while (r12.hasNext()) {
                                        obj13 = a5.a();
                                    }
                                }
                                obj15 = obj14;
                                if (obj12 == null) {
                                }
                                list8 = r4;
                                if (obj13 == null) {
                                }
                                list9 = r5;
                                if (obj9 != null) {
                                    axVar.write(44);
                                    if (axVar.l) {
                                        str = str3;
                                        afVar2 = afVar;
                                        afVar.f();
                                        if (str2 == str) {
                                            if (obj7 == null) {
                                                axVar.e(str2);
                                            }
                                            afVar2.c(obj13);
                                        } else if (obj15 == obj13) {
                                            if (obj7 == null) {
                                                zVar.a(afVar2);
                                            }
                                            afVar2.c(obj13);
                                        } else {
                                            if (obj7 == null) {
                                                if (obj10 == null) {
                                                    axVar.write(dVar.l, 0, dVar.l.length);
                                                } else {
                                                    zVar.a(afVar2);
                                                }
                                            }
                                            if (obj6 != null) {
                                            }
                                            if (obj7 != null) {
                                                zVar.a(afVar2, obj13);
                                            } else if (cls != String.class) {
                                                zVar.a(afVar2, obj13);
                                            } else if (obj13 != null) {
                                                if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                    if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                        axVar.write("null");
                                                    }
                                                }
                                                axVar.b("");
                                            } else {
                                                str5 = (String) obj13;
                                                if (axVar.g) {
                                                    axVar.c(str5);
                                                } else {
                                                    axVar.a(str5, '\u0000');
                                                }
                                            }
                                            obj9 = 1;
                                            i4 = i6 + 1;
                                            afVar3 = afVar2;
                                            zVarArr = zVarArr2;
                                            z = z3;
                                            list = list11;
                                            list6 = list10;
                                            z2 = z4;
                                            list3 = list7;
                                            list2 = list12;
                                            list5 = list8;
                                            list4 = list9;
                                            obj3 = obj;
                                        }
                                        obj9 = 1;
                                        i4 = i6 + 1;
                                        afVar3 = afVar2;
                                        zVarArr = zVarArr2;
                                        z = z3;
                                        list = list11;
                                        list6 = list10;
                                        z2 = z4;
                                        list3 = list7;
                                        list2 = list12;
                                        list5 = list8;
                                        list4 = list9;
                                        obj3 = obj;
                                    }
                                }
                                str = str3;
                                afVar2 = afVar;
                                if (str2 == str) {
                                    if (obj7 == null) {
                                        axVar.e(str2);
                                    }
                                    afVar2.c(obj13);
                                } else if (obj15 == obj13) {
                                    if (obj7 == null) {
                                        if (obj10 == null) {
                                            zVar.a(afVar2);
                                        } else {
                                            axVar.write(dVar.l, 0, dVar.l.length);
                                        }
                                    }
                                    if (obj6 != null) {
                                    }
                                    if (obj7 != null) {
                                        zVar.a(afVar2, obj13);
                                    } else if (cls != String.class) {
                                        zVar.a(afVar2, obj13);
                                    } else if (obj13 != null) {
                                        str5 = (String) obj13;
                                        if (axVar.g) {
                                            axVar.a(str5, '\u0000');
                                        } else {
                                            axVar.c(str5);
                                        }
                                    } else {
                                        if ((axVar.d & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                            if ((zVar.c & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                axVar.write("null");
                                            }
                                        }
                                        axVar.b("");
                                    }
                                    obj9 = 1;
                                    i4 = i6 + 1;
                                    afVar3 = afVar2;
                                    zVarArr = zVarArr2;
                                    z = z3;
                                    list = list11;
                                    list6 = list10;
                                    z2 = z4;
                                    list3 = list7;
                                    list2 = list12;
                                    list5 = list8;
                                    list4 = list9;
                                    obj3 = obj;
                                } else {
                                    if (obj7 == null) {
                                        zVar.a(afVar2);
                                    }
                                    afVar2.c(obj13);
                                }
                                obj9 = 1;
                                i4 = i6 + 1;
                                afVar3 = afVar2;
                                zVarArr = zVarArr2;
                                z = z3;
                                list = list11;
                                list6 = list10;
                                z2 = z4;
                                list3 = list7;
                                list2 = list12;
                                list5 = list8;
                                list4 = list9;
                                obj3 = obj;
                            }
                        }
                    }
                    list7 = r1;
                    list8 = r4;
                    list9 = r5;
                    list10 = r8;
                    list11 = r9;
                    z4 = z2;
                    list12 = list2;
                    afVar2 = afVar;
                    i4 = i6 + 1;
                    afVar3 = afVar2;
                    zVarArr = zVarArr2;
                    z = z3;
                    list = list11;
                    list6 = list10;
                    z2 = z4;
                    list3 = list7;
                    list2 = list12;
                    list5 = list8;
                    list4 = list9;
                    obj3 = obj;
                }
                afVar2 = afVar3;
                zVarArr2 = zVarArr;
                c2 = '\u0000';
                if (obj9 != null) {
                    c2 = ',';
                }
                afVar2.b(c2);
                if (zVarArr2.length > 0) {
                    if (axVar.l) {
                        afVar.e();
                        afVar.f();
                    }
                }
                axVar.write(i5);
                afVar2.m = atVar;
                return;
            } catch (Exception e8) {
                e22 = e8;
                afVar2 = afVar3;
                atVar2 = atVar4;
                th = e22;
                str2 = "write javaBean error";
                if (obj != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(", class ");
                    stringBuilder.append(obj.getClass().getName());
                    str2 = stringBuilder.toString();
                }
                str = str2;
                obj3 = obj2;
                if (obj3 != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(", fieldName : ");
                    stringBuilder.append(obj3);
                    str = stringBuilder.toString();
                }
                if (th.getMessage() != null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(", ");
                    stringBuilder2.append(th.getMessage());
                    str = stringBuilder2.toString();
                }
                throw new JSONException(str, th);
            } catch (Throwable th8) {
                e22 = th8;
                afVar2 = afVar3;
                atVar2 = atVar4;
                th = e22;
                afVar2.m = atVar2;
                throw th;
            }
        }
        return;
        th = e22;
        atVar2 = atVar;
        afVar2.m = atVar2;
        throw th;
        th = e22;
        atVar2 = atVar;
        str2 = "write javaBean error";
        if (obj != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(", class ");
            stringBuilder.append(obj.getClass().getName());
            str2 = stringBuilder.toString();
        }
        str = str2;
        obj3 = obj2;
        if (obj3 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(", fieldName : ");
            stringBuilder.append(obj3);
            str = stringBuilder.toString();
        }
        if (th.getMessage() != null) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(", ");
            stringBuilder2.append(th.getMessage());
            str = stringBuilder2.toString();
        }
        throw new JSONException(str, th);
    }

    public static z a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = null.a.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = null.a[i2].a.a.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return null.a[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }
}
