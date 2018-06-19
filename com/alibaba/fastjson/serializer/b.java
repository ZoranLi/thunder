package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a.d;
import com.alibaba.fastjson.b.e;
import com.alibaba.fastjson.b.f;
import com.alibaba.fastjson.b.g;
import com.alibaba.fastjson.c.c;
import com.alibaba.fastjson.c.j;
import com.alipay.sdk.util.h;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.umeng.message.proguard.k;
import com.xunlei.download.Downloads.Impl;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ASMSerializerFactory */
public class b {
    static final String b = c.b(af.class);
    static final String c = c.b(ax.class);
    static final String d = c.b(ag.class);
    static final String e;
    static final String f = c.a(at.class);
    protected final com.alibaba.fastjson.c.a a = new com.alibaba.fastjson.c.a();
    private final AtomicLong g = new AtomicLong();

    /* compiled from: ASMSerializerFactory */
    static class a {
        static int a = 6;
        static int b = 7;
        static int c = 8;
        private final String d;
        private final int e;
        private final boolean f;
        private Map<String, Integer> g = new HashMap();
        private int h = 9;

        public a(String str, int i, boolean z) {
            this.d = str;
            this.e = i;
            this.f = z;
            if (this.f != null) {
                c = 8;
            }
        }

        public final int a(String str) {
            if (((Integer) this.g.get(str)) == null) {
                Map map = this.g;
                int i = this.h;
                this.h = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return ((Integer) this.g.get(str)).intValue();
        }

        public final int b(String str) {
            if (((Integer) this.g.get(str)) == null) {
                this.g.put(str, Integer.valueOf(this.h));
                this.h += 2;
            }
            return ((Integer) this.g.get(str)).intValue();
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder("L");
        stringBuilder.append(c.b(ag.class));
        stringBuilder.append(h.b);
        e = stringBuilder.toString();
    }

    public final ao a(Class<?> cls) throws Exception {
        b bVar = this;
        Class cls2 = cls;
        if (cls.isPrimitive()) {
            StringBuilder stringBuilder = new StringBuilder("unsupportd class ");
            stringBuilder.append(cls.getName());
            throw new JSONException(stringBuilder.toString());
        }
        boolean z;
        d dVar = (d) cls2.getAnnotation(d.class);
        List<com.alibaba.fastjson.c.d> a = j.a(cls2, false);
        for (com.alibaba.fastjson.c.d dVar2 : a) {
            if (dVar2.c == null && dVar2.b != null && dVar2.b.getDeclaringClass().isInterface()) {
                return new ag(cls2);
            }
        }
        String[] b = dVar != null ? dVar.b() : null;
        List arrayList;
        if (b == null || b.length == 0) {
            arrayList = new ArrayList(a);
            Collections.sort(arrayList);
        } else {
            arrayList = j.a(cls2, true);
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (!((com.alibaba.fastjson.c.d) a.get(i)).equals(r6.get(i))) {
                z = false;
                break;
            }
        }
        z = true;
        if (r6.size() > 256) {
            return null;
        }
        StringBuilder stringBuilder2;
        String str;
        f gVar;
        List list;
        List list2;
        a aVar;
        StringBuilder stringBuilder3;
        for (com.alibaba.fastjson.c.d a2 : r6) {
            if (!c.a(a2.a().getName())) {
                return null;
            }
        }
        StringBuilder stringBuilder4 = new StringBuilder("ASMSerializer_");
        stringBuilder4.append(bVar.g.incrementAndGet());
        stringBuilder4.append("_");
        stringBuilder4.append(cls.getSimpleName());
        String stringBuilder5 = stringBuilder4.toString();
        String name = b.class.getPackage().getName();
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(name.replace('.', '/'));
        stringBuilder6.append("/");
        stringBuilder6.append(stringBuilder5);
        String stringBuilder7 = stringBuilder6.toString();
        StringBuilder stringBuilder8 = new StringBuilder();
        stringBuilder8.append(name);
        stringBuilder8.append(".");
        stringBuilder8.append(stringBuilder5);
        stringBuilder5 = stringBuilder8.toString();
        int a3 = j.a((Class) cls);
        com.alibaba.fastjson.b.b bVar2 = new com.alibaba.fastjson.b.b();
        bVar2.a(stringBuilder7, c.b(a.class), new String[]{c.b(ao.class)});
        for (com.alibaba.fastjson.c.d dVar3 : r6) {
            if (!(dVar3.d.isPrimitive() || dVar3.d.isEnum())) {
                if (dVar3.d != String.class) {
                    StringBuilder stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(dVar3.a);
                    stringBuilder9.append("_asm_fieldType");
                    com.alibaba.fastjson.b.c cVar = new com.alibaba.fastjson.b.c(bVar2, stringBuilder9.toString(), "Ljava/lang/reflect/Type;");
                }
            }
        }
        f gVar2 = new g(bVar2, "<init>", "()V", null);
        int i2 = 25;
        gVar2.b(25, 0);
        gVar2.a(com.alibaba.fastjson.b.h.a(c.a((Class) cls)));
        gVar2.b(183, c.b(a.class), "<init>", "(Ljava/lang/Class;)V");
        Iterator it = r6.iterator();
        while (it.hasNext()) {
            com.alibaba.fastjson.c.d dVar4 = (com.alibaba.fastjson.c.d) it.next();
            if (!(dVar4.d.isPrimitive() || dVar4.d.isEnum() || dVar4.d == String.class)) {
                Iterator it2;
                gVar2.b(i2, 0);
                gVar2.a(com.alibaba.fastjson.b.h.a(c.a(dVar4.f)));
                if (dVar4.b != null) {
                    gVar2.a(dVar4.b.getName());
                    it2 = it;
                    gVar2.b(184, c.b(c.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    it2 = it;
                    gVar2.a(dVar4.c.getName());
                    gVar2.b(184, c.b(c.class), "getFieldType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(dVar4.a);
                stringBuilder2.append("_asm_fieldType");
                gVar2.a(181, stringBuilder7, stringBuilder2.toString(), "Ljava/lang/reflect/Type;");
                it = it2;
                i2 = 25;
            }
        }
        gVar2.a((int) Opcodes.SUB_INT_2ADDR);
        gVar2.c(4, 4);
        int i3 = 0;
        while (i3 < 2) {
            String str2;
            boolean z2;
            d dVar5;
            int i4;
            if (i3 == 0) {
                str2 = "write";
                z2 = true;
            } else {
                str2 = "write1";
                z2 = false;
            }
            a aVar2 = new a(stringBuilder7, a3, z2);
            stringBuilder9 = new StringBuilder("(L");
            stringBuilder9.append(b);
            stringBuilder9.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            str = stringBuilder5;
            gVar = new g(bVar2, str2, stringBuilder9.toString(), new String[]{"java/io/IOException"});
            gVar.b(25, 1);
            StringBuilder stringBuilder10 = new StringBuilder("()L");
            stringBuilder10.append(c);
            stringBuilder10.append(h.b);
            gVar.b(182, b, "getWriter", stringBuilder10.toString());
            gVar.b(58, aVar2.a("out"));
            if (z || !(dVar == null || dVar.g())) {
                dVar5 = dVar;
                list = list2;
            } else {
                e eVar = new e();
                gVar.b(25, aVar2.a("out"));
                dVar5 = dVar;
                list = list2;
                gVar.b(182, c, "isSortField", "()Z");
                gVar.a(154, eVar);
                gVar.b(25, 0);
                gVar.b(25, 1);
                gVar.b(25, 2);
                gVar.b(25, 3);
                gVar.b(25, 4);
                gVar.b(21, 5);
                StringBuilder stringBuilder11 = new StringBuilder("(L");
                stringBuilder11.append(b);
                stringBuilder11.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                gVar.b(182, stringBuilder7, "writeUnsorted", stringBuilder11.toString());
                gVar.a((int) Opcodes.SUB_INT_2ADDR);
                gVar.a(eVar);
            }
            if (aVar2.f) {
                e eVar2 = new e();
                gVar.b(25, 1);
                gVar.b(182, b, "writeDirect", "()Z");
                gVar.a(154, eVar2);
                gVar.b(25, 0);
                gVar.b(25, 1);
                gVar.b(25, 2);
                gVar.b(25, 3);
                gVar.b(25, 4);
                gVar.b(21, 5);
                stringBuilder4 = new StringBuilder("(L");
                stringBuilder4.append(b);
                stringBuilder4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                gVar.b(182, stringBuilder7, "write1", stringBuilder4.toString());
                i4 = Opcodes.SUB_INT_2ADDR;
                gVar.a((int) Opcodes.SUB_INT_2ADDR);
                gVar.a(eVar2);
            } else {
                i4 = Opcodes.SUB_INT_2ADDR;
            }
            gVar.b(25, 2);
            gVar.a(192, c.b(cls));
            gVar.b(58, aVar2.a(Impl.COLUMN_APP_DATA));
            a(cls2, gVar, (List) r6, aVar2);
            gVar.a(i4);
            gVar.c(7, aVar2.h + 2);
            i3++;
            stringBuilder5 = str;
            dVar = dVar5;
            list2 = list;
        }
        list = list2;
        str = stringBuilder5;
        if (!z) {
            aVar = new a(stringBuilder7, a3, false);
            stringBuilder2 = new StringBuilder("(L");
            stringBuilder2.append(b);
            stringBuilder2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            gVar = new g(bVar2, "writeUnsorted", stringBuilder2.toString(), new String[]{"java/io/IOException"});
            gVar.b(25, 1);
            stringBuilder3 = new StringBuilder("()L");
            stringBuilder3.append(c);
            stringBuilder3.append(h.b);
            gVar.b(182, b, "getWriter", stringBuilder3.toString());
            gVar.b(58, aVar.a("out"));
            gVar.b(25, 2);
            gVar.a(192, c.b(cls));
            gVar.b(58, aVar.a(Impl.COLUMN_APP_DATA));
            a(cls2, gVar, list, aVar);
            gVar.a((int) Opcodes.SUB_INT_2ADDR);
            gVar.c(7, aVar.h + 2);
        }
        aVar = new a(stringBuilder7, a3, false);
        stringBuilder2 = new StringBuilder("(L");
        stringBuilder2.append(b);
        stringBuilder2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;)V");
        gVar = new g(bVar2, "writeAsArray", stringBuilder2.toString(), new String[]{"java/io/IOException"});
        gVar.b(25, 1);
        stringBuilder3 = new StringBuilder("()L");
        stringBuilder3.append(c);
        stringBuilder3.append(h.b);
        gVar.b(182, b, "getWriter", stringBuilder3.toString());
        gVar.b(58, aVar.a("out"));
        gVar.b(25, 2);
        gVar.a(192, c.b(cls));
        gVar.b(58, aVar.a(Impl.COLUMN_APP_DATA));
        a(gVar, (List) r6, aVar);
        gVar.a((int) Opcodes.SUB_INT_2ADDR);
        gVar.c(7, aVar.h + 2);
        byte[] a4 = bVar2.a();
        return (ao) bVar.a.a(str, a4, a4.length).newInstance();
    }

    private static void a(f fVar, List<com.alibaba.fastjson.c.d> list, a aVar) throws Exception {
        fVar.b(25, aVar.a("out"));
        fVar.b(16, 91);
        fVar.b(182, c, "write", "(I)V");
        int size = list.size();
        if (size == 0) {
            fVar.b(25, aVar.a("out"));
            fVar.b(16, 93);
            fVar.b(182, c, "write", "(I)V");
            return;
        }
        int i = 0;
        while (i < size) {
            int i2 = i == size + -1 ? 93 : 44;
            com.alibaba.fastjson.c.d dVar = (com.alibaba.fastjson.c.d) list.get(i);
            Class cls = dVar.d;
            fVar.a(dVar.a);
            fVar.b(58, a.a);
            if (!(cls == Byte.TYPE || cls == Short.TYPE)) {
                if (cls != Integer.TYPE) {
                    if (cls == Long.TYPE) {
                        fVar.b(25, aVar.a("out"));
                        a(fVar, aVar, dVar);
                        fVar.b(16, i2);
                        fVar.b(182, c, "writeLongAndChar", "(JC)V");
                    } else if (cls == Float.TYPE) {
                        fVar.b(25, aVar.a("out"));
                        a(fVar, aVar, dVar);
                        fVar.b(16, i2);
                        fVar.b(182, c, "writeFloatAndChar", "(FC)V");
                    } else if (cls == Double.TYPE) {
                        fVar.b(25, aVar.a("out"));
                        a(fVar, aVar, dVar);
                        fVar.b(16, i2);
                        fVar.b(182, c, "writeDoubleAndChar", "(DC)V");
                    } else if (cls == Boolean.TYPE) {
                        fVar.b(25, aVar.a("out"));
                        a(fVar, aVar, dVar);
                        fVar.b(16, i2);
                        fVar.b(182, c, "writeBooleanAndChar", "(ZC)V");
                    } else if (cls == Character.TYPE) {
                        fVar.b(25, aVar.a("out"));
                        a(fVar, aVar, dVar);
                        fVar.b(16, i2);
                        fVar.b(182, c, "writeCharacterAndChar", "(CC)V");
                    } else if (cls == String.class) {
                        fVar.b(25, aVar.a("out"));
                        a(fVar, aVar, dVar);
                        fVar.b(16, i2);
                        fVar.b(182, c, "writeString", "(Ljava/lang/String;C)V");
                    } else if (cls.isEnum()) {
                        fVar.b(25, aVar.a("out"));
                        a(fVar, aVar, dVar);
                        fVar.b(16, i2);
                        fVar.b(182, c, "writeEnum", "(Ljava/lang/Enum;C)V");
                    } else {
                        Object c = dVar.c();
                        fVar.b(25, 1);
                        a(fVar, aVar, dVar);
                        if (c != null) {
                            fVar.a(c);
                            fVar.b(182, b, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                        } else {
                            fVar.b(25, a.a);
                            if ((dVar.e instanceof Class) && ((Class) dVar.e).isPrimitive()) {
                                fVar.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                fVar.b(25, 0);
                                String c2 = aVar.d;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(dVar.a);
                                stringBuilder.append("_asm_fieldType");
                                fVar.a(180, c2, stringBuilder.toString(), "Ljava/lang/reflect/Type;");
                                fVar.a(Integer.valueOf(dVar.h));
                                fVar.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                        }
                        fVar.b(25, aVar.a("out"));
                        fVar.b(16, i2);
                        fVar.b(182, c, "write", "(I)V");
                    }
                    i++;
                }
            }
            fVar.b(25, aVar.a("out"));
            a(fVar, aVar, dVar);
            fVar.b(16, i2);
            fVar.b(182, c, "writeIntAndChar", "(IC)V");
            i++;
        }
    }

    private void a(Class<?> cls, f fVar, List<com.alibaba.fastjson.c.d> list, a aVar) throws Exception {
        e eVar;
        f fVar2 = fVar;
        a aVar2 = aVar;
        e eVar2 = new e();
        int size = list.size();
        e eVar3 = new e();
        e eVar4 = new e();
        int i = 25;
        fVar2.b(25, aVar2.a("out"));
        int i2 = 182;
        fVar2.b(182, c, "isPrettyFormat", "()Z");
        fVar2.a(153, eVar3);
        fVar2.b(25, 0);
        fVar2.a(180, aVar.d, "nature", e);
        fVar2.a(199, eVar4);
        fVar2.a(eVar4);
        fVar2.b(25, 0);
        fVar2.a(180, aVar.d, "nature", e);
        fVar2.b(25, 1);
        fVar2.b(25, 2);
        fVar2.b(25, 3);
        fVar2.b(25, 4);
        fVar2.b(21, 5);
        StringBuilder stringBuilder = new StringBuilder("(L");
        stringBuilder.append(b);
        stringBuilder.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        fVar2.b(182, d, "write", stringBuilder.toString());
        fVar2.a((int) Opcodes.SUB_INT_2ADDR);
        fVar2.a(eVar3);
        eVar3 = new e();
        e eVar5 = new e();
        fVar2.b(25, 0);
        fVar2.a(180, aVar.d, "nature", e);
        fVar2.a(199, eVar5);
        fVar2.a(eVar5);
        fVar2.b(25, 0);
        fVar2.a(180, aVar.d, "nature", e);
        fVar2.b(25, 1);
        fVar2.b(25, 2);
        fVar2.b(21, 5);
        StringBuilder stringBuilder2 = new StringBuilder("(L");
        stringBuilder2.append(b);
        stringBuilder2.append(";Ljava/lang/Object;I)Z");
        fVar2.b(182, d, "writeReference", stringBuilder2.toString());
        fVar2.a(153, eVar3);
        fVar2.a((int) Opcodes.SUB_INT_2ADDR);
        fVar2.a(eVar3);
        eVar3 = new e();
        fVar2.b(25, 0);
        fVar2.a(180, aVar.d, "nature", e);
        fVar2.b(25, 1);
        StringBuilder stringBuilder3 = new StringBuilder("(L");
        stringBuilder3.append(b);
        stringBuilder3.append(";)Z");
        fVar2.b(182, d, "isWriteAsArray", stringBuilder3.toString());
        fVar2.a(153, eVar3);
        fVar2.b(25, 0);
        fVar2.b(25, 1);
        fVar2.b(25, 2);
        fVar2.b(25, 3);
        fVar2.b(25, 4);
        stringBuilder3 = new StringBuilder("(L");
        stringBuilder3.append(b);
        stringBuilder3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;)V");
        fVar2.b(182, aVar.d, "writeAsArray", stringBuilder3.toString());
        fVar2.a((int) Opcodes.SUB_INT_2ADDR);
        fVar2.a(eVar3);
        fVar2.b(25, 1);
        StringBuilder stringBuilder4 = new StringBuilder("()");
        stringBuilder4.append(f);
        fVar2.b(182, b, "getContext", stringBuilder4.toString());
        int i3 = 58;
        fVar2.b(58, aVar2.a("parent"));
        fVar2.b(25, 1);
        fVar2.b(25, aVar2.a("parent"));
        fVar2.b(25, 2);
        fVar2.b(25, 3);
        fVar2.a(Integer.valueOf(aVar.e));
        stringBuilder3 = new StringBuilder(k.s);
        stringBuilder3.append(f);
        stringBuilder3.append("Ljava/lang/Object;Ljava/lang/Object;I)V");
        fVar2.b(182, b, "setContext", stringBuilder3.toString());
        eVar3 = new e();
        e eVar6 = new e();
        e eVar7 = new e();
        fVar2.b(25, 1);
        fVar2.b(25, 4);
        fVar2.b(25, 2);
        fVar2.b(182, b, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
        fVar2.a(153, eVar6);
        fVar2.b(25, 4);
        fVar2.b(25, 2);
        fVar2.b(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        fVar2.a((int) Opcodes.USHR_LONG, eVar6);
        fVar2.a(eVar7);
        fVar2.b(25, aVar2.a("out"));
        StringBuilder stringBuilder5 = new StringBuilder("{\"");
        stringBuilder5.append(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
        stringBuilder5.append("\":\"");
        stringBuilder5.append(cls.getName());
        stringBuilder5.append("\"");
        fVar2.a(stringBuilder5.toString());
        fVar2.b(182, c, "write", "(Ljava/lang/String;)V");
        fVar2.b(16, 44);
        int i4 = Opcodes.SUB_FLOAT;
        fVar2.a((int) Opcodes.SUB_FLOAT, eVar3);
        fVar2.a(eVar6);
        fVar2.b(16, 123);
        fVar2.a(eVar3);
        int i5 = 54;
        fVar2.b(54, aVar2.a("seperator"));
        if (!aVar.f) {
            fVar2.b(25, 1);
            fVar2.b(25, 2);
            fVar2.b(21, aVar2.a("seperator"));
            fVar2.b(182, b, "writeBefore", "(Ljava/lang/Object;C)C");
            fVar2.b(54, aVar2.a("seperator"));
        }
        fVar2.b(25, aVar2.a("out"));
        fVar2.b(182, c, "isNotWriteDefaultValue", "()Z");
        fVar2.b(54, aVar2.a("notWriteDefaultValue"));
        if (!aVar.f) {
            fVar2.b(25, 1);
            fVar2.b(182, b, "checkValue", "()Z");
            fVar2.b(54, aVar2.a("checkValue"));
            fVar2.b(25, 1);
            fVar2.b(182, b, "hasNameFilters", "()Z");
            fVar2.b(54, aVar2.a("hasNameFilters"));
        }
        int i6 = 0;
        while (i6 < size) {
            int i7;
            int i8;
            com.alibaba.fastjson.c.d dVar = (com.alibaba.fastjson.c.d) list.get(i6);
            Class cls2 = dVar.d;
            fVar2.a(dVar.a);
            fVar2.b(i3, a.a);
            e eVar8;
            if (cls2 == Byte.TYPE) {
                eVar8 = new e();
                b(fVar2, dVar, aVar2, eVar8);
                a(fVar2, aVar2, dVar);
                fVar2.b(i5, aVar2.a("byte"));
                a(fVar2, dVar, aVar2, eVar8);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(21, aVar2.a("byte"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;I)V");
                a(fVar2, aVar2);
                fVar2.a(eVar8);
            } else if (cls2 == Short.TYPE) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(i5, aVar2.a("short"));
                a(fVar2, dVar, aVar2, r6);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(21, aVar2.a("short"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;I)V");
                a(fVar2, aVar2);
                fVar2.a(r6);
            } else if (cls2 == Integer.TYPE) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(i5, aVar2.a("int"));
                a(fVar2, dVar, aVar2, r6);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(21, aVar2.a("int"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;I)V");
                a(fVar2, aVar2);
                fVar2.a(r6);
            } else if (cls2 == Long.TYPE) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(55, aVar2.b("long"));
                a(fVar2, dVar, aVar2, r6);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(22, aVar2.b("long"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;J)V");
                a(fVar2, aVar2);
                fVar2.a(r6);
            } else if (cls2 == Float.TYPE) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(56, aVar2.a("float"));
                a(fVar2, dVar, aVar2, r6);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(23, aVar2.a("float"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;F)V");
                a(fVar2, aVar2);
                fVar2.a(r6);
            } else if (cls2 == Double.TYPE) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(57, aVar2.b("double"));
                a(fVar2, dVar, aVar2, r6);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(24, aVar2.b("double"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;D)V");
                a(fVar2, aVar2);
                fVar2.a(r6);
            } else if (cls2 == Boolean.TYPE) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(i5, aVar2.a("boolean"));
                a(fVar2, dVar, aVar2, r6);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(21, aVar2.a("boolean"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;Z)V");
                a(fVar2, aVar2);
                fVar2.a(r6);
            } else if (cls2 == Character.TYPE) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(i5, aVar2.a("char"));
                a(fVar2, dVar, aVar2, r6);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(21, aVar2.a("char"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;C)V");
                a(fVar2, aVar2);
                fVar2.a(r6);
            } else if (cls2 == String.class) {
                r6 = new e();
                b(fVar2, dVar, aVar2, r6);
                a(fVar2, aVar2, dVar);
                fVar2.b(i3, aVar2.a("string"));
                a(fVar2, dVar, aVar2, r6);
                eVar8 = new e();
                r15 = new e();
                fVar2.b(i, aVar2.a("string"));
                fVar2.a(199, eVar8);
                b(fVar2, dVar, aVar2);
                fVar2.a(i4, r15);
                fVar2.a(eVar8);
                if (aVar.f) {
                    fVar2.b(i, aVar2.a("out"));
                    fVar2.b(21, aVar2.a("seperator"));
                    fVar2.b(i, a.a);
                    fVar2.b(i, aVar2.a("string"));
                    fVar2.b(i2, c, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
                } else {
                    fVar2.b(i, aVar2.a("out"));
                    fVar2.b(21, aVar2.a("seperator"));
                    fVar2.b(i, a.a);
                    fVar2.b(i, aVar2.a("string"));
                    fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
                }
                a(fVar2, aVar2);
                fVar2.a(r15);
                fVar2.a(r6);
            } else if (cls2 == BigDecimal.class) {
                eVar4 = new e();
                b(fVar2, dVar, aVar2, eVar4);
                a(fVar2, aVar2, dVar);
                fVar2.b(i3, aVar2.a("decimal"));
                a(fVar2, dVar, aVar2, eVar4);
                r6 = new e();
                eVar8 = new e();
                r15 = new e();
                fVar2.a(r6);
                fVar2.b(i, aVar2.a("decimal"));
                fVar2.a(199, eVar8);
                b(fVar2, dVar, aVar2);
                fVar2.a(i4, r15);
                fVar2.a(eVar8);
                fVar2.b(i, aVar2.a("out"));
                fVar2.b(21, aVar2.a("seperator"));
                fVar2.b(i, a.a);
                fVar2.b(i, aVar2.a("decimal"));
                fVar2.b(i2, c, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
                a(fVar2, aVar2);
                fVar2.a(i4, r15);
                fVar2.a(r15);
                fVar2.a(eVar4);
            } else {
                if (List.class.isAssignableFrom(cls2)) {
                    Class cls3;
                    int i9;
                    Type type = dVar.e;
                    if (type instanceof Class) {
                        cls3 = Object.class;
                    } else {
                        cls3 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    }
                    Class cls4 = null;
                    if (cls3 instanceof Class) {
                        cls4 = cls3;
                    }
                    r15 = new e();
                    r6 = new e();
                    eVar6 = new e();
                    e eVar9 = new e();
                    fVar2.a(r6);
                    b(fVar2, dVar, aVar2, r15);
                    a(fVar2, aVar2, dVar);
                    fVar2.a(192, "java/util/List");
                    fVar2.b(i3, aVar2.a("list"));
                    a(fVar2, dVar, aVar2, r15);
                    fVar2.b(i, aVar2.a("list"));
                    fVar2.a(199, eVar6);
                    b(fVar2, dVar, aVar2);
                    fVar2.a((int) Opcodes.SUB_FLOAT, eVar9);
                    fVar2.a(eVar6);
                    fVar2.b(i, aVar2.a("out"));
                    fVar2.b(21, aVar2.a("seperator"));
                    fVar2.b(182, c, "write", "(I)V");
                    fVar2.b(i, aVar2.a("out"));
                    fVar2.b(i, a.a);
                    fVar2.a(3);
                    fVar2.b(182, c, "writeFieldName", "(Ljava/lang/String;Z)V");
                    fVar2.b(i, aVar2.a("list"));
                    fVar2.b(Opcodes.SHR_INT_2ADDR, "java/util/List", "size", "()I");
                    fVar2.b(54, aVar2.a("int"));
                    r6 = new e();
                    e eVar10 = new e();
                    eVar5 = new e();
                    fVar2.a(r6);
                    fVar2.b(21, aVar2.a("int"));
                    fVar2.a(3);
                    fVar2.a((int) Opcodes.AND_LONG, eVar10);
                    fVar2.b(i, aVar2.a("out"));
                    fVar2.a((Object) "[]");
                    i7 = size;
                    fVar2.b(182, c, "write", "(Ljava/lang/String;)V");
                    fVar2.a((int) Opcodes.SUB_FLOAT, eVar5);
                    fVar2.a(eVar10);
                    fVar2.b(25, 1);
                    fVar2.b(25, aVar2.a("list"));
                    fVar2.b(25, a.a);
                    fVar2.b(182, b, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                    fVar2.b(25, aVar2.a("out"));
                    fVar2.b(16, 91);
                    fVar2.b(182, c, "write", "(I)V");
                    fVar2.a(1);
                    fVar2.a(192, c.b(ao.class));
                    fVar2.b(58, aVar2.a("list_ser"));
                    eVar = new e();
                    r6 = new e();
                    fVar2.a(3);
                    fVar2.b(54, aVar2.a("i"));
                    fVar2.a(eVar);
                    fVar2.b(21, aVar2.a("i"));
                    fVar2.b(21, aVar2.a("int"));
                    fVar2.a(4);
                    fVar2.a(100);
                    fVar2.a((int) Opcodes.XOR_LONG, r6);
                    if (cls3 == String.class) {
                        fVar2.b(25, aVar2.a("out"));
                        fVar2.b(25, aVar2.a("list"));
                        fVar2.b(21, aVar2.a("i"));
                        fVar2.b(Opcodes.SHR_INT_2ADDR, "java/util/List", "get", "(I)Ljava/lang/Object;");
                        fVar2.a(192, "java/lang/String");
                        fVar2.b(16, 44);
                        if (aVar.f) {
                            fVar2.b(182, c, "writeStringWithDoubleQuoteDirect", "(Ljava/lang/String;C)V");
                        } else {
                            fVar2.b(182, c, "writeString", "(Ljava/lang/String;C)V");
                        }
                    } else {
                        int i10;
                        fVar2.b(25, 1);
                        fVar2.b(25, aVar2.a("list"));
                        fVar2.b(21, aVar2.a("i"));
                        fVar2.b(Opcodes.SHR_INT_2ADDR, "java/util/List", "get", "(I)Ljava/lang/Object;");
                        fVar2.b(21, aVar2.a("i"));
                        fVar2.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        if (cls4 == null || !Modifier.isPublic(cls4.getModifiers())) {
                            i10 = 182;
                            fVar2.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                        } else {
                            fVar2.a(com.alibaba.fastjson.b.h.a(c.a(cls3)));
                            fVar2.a(Integer.valueOf(dVar.h));
                            i10 = 182;
                            fVar2.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        }
                        fVar2.b(25, aVar2.a("out"));
                        fVar2.b(16, 44);
                        fVar2.b(i10, c, "write", "(I)V");
                    }
                    fVar2.b(aVar2.a("i"));
                    i = Opcodes.SUB_FLOAT;
                    fVar2.a((int) Opcodes.SUB_FLOAT, eVar);
                    fVar2.a(r6);
                    if (cls3 == String.class) {
                        int i11;
                        fVar2.b(25, aVar2.a("out"));
                        fVar2.b(25, aVar2.a("list"));
                        fVar2.b(21, aVar2.a("int"));
                        fVar2.a(4);
                        fVar2.a(100);
                        fVar2.b(Opcodes.SHR_INT_2ADDR, "java/util/List", "get", "(I)Ljava/lang/Object;");
                        fVar2.a(192, "java/lang/String");
                        fVar2.b(16, 93);
                        if (aVar.f) {
                            i11 = 182;
                            fVar2.b(182, c, "writeStringWithDoubleQuoteDirect", "(Ljava/lang/String;C)V");
                        } else {
                            i11 = 182;
                            fVar2.b(182, c, "writeString", "(Ljava/lang/String;C)V");
                        }
                        i4 = i11;
                        size = 1;
                        i9 = 25;
                    } else {
                        fVar2.b(25, 1);
                        fVar2.b(25, aVar2.a("list"));
                        fVar2.b(21, aVar2.a("i"));
                        fVar2.b(Opcodes.SHR_INT_2ADDR, "java/util/List", "get", "(I)Ljava/lang/Object;");
                        fVar2.b(21, aVar2.a("i"));
                        fVar2.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        if (cls4 == null || !Modifier.isPublic(cls4.getModifiers())) {
                            i4 = 182;
                            fVar2.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                        } else {
                            fVar2.a(com.alibaba.fastjson.b.h.a(c.a(cls3)));
                            fVar2.a(Integer.valueOf(dVar.h));
                            i4 = 182;
                            fVar2.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        }
                        i9 = 25;
                        fVar2.b(25, aVar2.a("out"));
                        fVar2.b(16, 93);
                        fVar2.b(i4, c, "write", "(I)V");
                        size = 1;
                    }
                    fVar2.b(i9, size);
                    fVar2.b(i4, b, "popContext", "()V");
                    fVar2.a(eVar5);
                    a(fVar2, aVar2);
                    fVar2.a(eVar9);
                    fVar2.a(r15);
                } else {
                    i7 = size;
                    i = i4;
                    if (cls2.isEnum()) {
                        a(fVar2, dVar, aVar2);
                    } else {
                        eVar = new e();
                        b(fVar2, dVar, aVar2, eVar);
                        a(fVar2, aVar2, dVar);
                        i8 = 58;
                        fVar2.b(58, aVar2.a("object"));
                        a(fVar2, dVar, aVar2, eVar);
                        c(fVar2, dVar, aVar2, eVar);
                        fVar2.a(eVar);
                        i6++;
                        i3 = i8;
                        i4 = i;
                        size = i7;
                        i = 25;
                        i2 = 182;
                        i5 = 54;
                    }
                }
                i8 = 58;
                i6++;
                i3 = i8;
                i4 = i;
                size = i7;
                i = 25;
                i2 = 182;
                i5 = 54;
            }
            i7 = size;
            i = i4;
            i8 = i3;
            i6++;
            i3 = i8;
            i4 = i;
            size = i7;
            i = 25;
            i2 = 182;
            i5 = 54;
        }
        if (!aVar.f) {
            fVar2.b(25, 1);
            fVar2.b(25, 2);
            fVar2.b(21, aVar2.a("seperator"));
            fVar2.b(182, b, "writeAfter", "(Ljava/lang/Object;C)C");
            fVar2.b(54, aVar2.a("seperator"));
        }
        eVar = new e();
        eVar3 = new e();
        fVar2.b(21, aVar2.a("seperator"));
        fVar2.a(16, 123);
        fVar2.a((int) Opcodes.AND_LONG, eVar);
        fVar2.b(25, aVar2.a("out"));
        fVar2.b(16, 123);
        fVar2.b(182, c, "write", "(I)V");
        fVar2.a(eVar);
        fVar2.b(25, aVar2.a("out"));
        fVar2.b(16, 125);
        fVar2.b(182, c, "write", "(I)V");
        fVar2.a(eVar3);
        fVar2.a(eVar2);
        fVar2.b(25, 1);
        fVar2.b(25, aVar2.a("parent"));
        StringBuilder stringBuilder6 = new StringBuilder(k.s);
        stringBuilder6.append(f);
        stringBuilder6.append(")V");
        fVar2.b(182, b, "setContext", stringBuilder6.toString());
    }

    private static void a(f fVar, com.alibaba.fastjson.c.d dVar, a aVar) {
        com.alibaba.fastjson.a.b b = dVar.b();
        int i = 0;
        if (b != null) {
            SerializerFeature[] f = b.f();
            int length = f.length;
            int i2 = 0;
            while (i < length) {
                if (f[i] == SerializerFeature.WriteEnumUsingToString) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
        }
        e eVar = new e();
        e eVar2 = new e();
        e eVar3 = new e();
        b(fVar, dVar, aVar, eVar3);
        a(fVar, aVar, dVar);
        fVar.a(192, "java/lang/Enum");
        fVar.b(58, aVar.a("enum"));
        a(fVar, dVar, aVar, eVar3);
        fVar.b(25, aVar.a("enum"));
        fVar.a(199, eVar);
        b(fVar, dVar, aVar);
        fVar.a((int) Opcodes.SUB_FLOAT, eVar2);
        fVar.a(eVar);
        fVar.b(25, aVar.a("out"));
        fVar.b(21, aVar.a("seperator"));
        fVar.b(25, a.a);
        fVar.b(25, aVar.a("enum"));
        if (i != 0) {
            fVar.b(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
            fVar.b(182, c, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else if (aVar.f) {
            fVar.b(182, "java/lang/Enum", com.alipay.sdk.cons.c.e, "()Ljava/lang/String;");
            fVar.b(182, c, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            fVar.b(182, c, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/Enum;)V");
        }
        a(fVar, aVar);
        fVar.a(eVar2);
        fVar.a(eVar3);
    }

    private static void a(f fVar, a aVar, com.alibaba.fastjson.c.d dVar) {
        Method method = dVar.b;
        if (method != null) {
            fVar.b(25, aVar.a(Impl.COLUMN_APP_DATA));
            fVar.b(182, c.b(method.getDeclaringClass()), method.getName(), c.a(method));
            return;
        }
        fVar.b(25, aVar.a(Impl.COLUMN_APP_DATA));
        fVar.a(180, c.b(dVar.f), dVar.c.getName(), c.a(dVar.d));
    }

    private static void a(f fVar, com.alibaba.fastjson.c.d dVar, a aVar, e eVar) {
        f fVar2 = fVar;
        com.alibaba.fastjson.c.d dVar2 = dVar;
        a aVar2 = aVar;
        e eVar2 = eVar;
        if (dVar2.c != null && Modifier.isTransient(dVar2.c.getModifiers())) {
            fVar2.b(25, aVar2.a("out"));
            fVar2.b(182, c, "isSkipTransientField", "()Z");
            fVar2.a(154, eVar2);
        }
        e eVar3 = new e();
        fVar2.b(21, aVar2.a("notWriteDefaultValue"));
        fVar2.a(153, eVar3);
        Class cls = dVar2.d;
        if (cls == Boolean.TYPE) {
            fVar2.b(21, aVar2.a("boolean"));
            fVar2.a(153, eVar2);
        } else if (cls == Byte.TYPE) {
            fVar2.b(21, aVar2.a("byte"));
            fVar2.a(153, eVar2);
        } else if (cls == Short.TYPE) {
            fVar2.b(21, aVar2.a("short"));
            fVar2.a(153, eVar2);
        } else if (cls == Integer.TYPE) {
            fVar2.b(21, aVar2.a("int"));
            fVar2.a(153, eVar2);
        } else if (cls == Long.TYPE) {
            fVar2.b(22, aVar2.a("long"));
            fVar2.a(9);
            fVar2.a((int) Opcodes.REM_INT);
            fVar2.a(153, eVar2);
        } else if (cls == Float.TYPE) {
            fVar2.b(23, aVar2.a("float"));
            fVar2.a(11);
            fVar2.a((int) Opcodes.AND_INT);
            fVar2.a(153, eVar2);
        } else if (cls == Double.TYPE) {
            fVar2.b(24, aVar2.a("double"));
            fVar2.a(14);
            fVar2.a(151);
            fVar2.a(153, eVar2);
        }
        fVar2.a(eVar3);
        if (!aVar.f) {
            Class cls2 = dVar2.d;
            fVar2.b(25, 1);
            fVar2.b(25, 2);
            fVar2.b(25, a.a);
            if (cls2 == Byte.TYPE) {
                fVar2.b(21, aVar2.a("byte"));
                fVar2.b(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            } else if (cls2 == Short.TYPE) {
                fVar2.b(21, aVar2.a("short"));
                fVar2.b(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            } else if (cls2 == Integer.TYPE) {
                fVar2.b(21, aVar2.a("int"));
                fVar2.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else if (cls2 == Character.TYPE) {
                fVar2.b(21, aVar2.a("char"));
                fVar2.b(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            } else if (cls2 == Long.TYPE) {
                fVar2.b(22, aVar2.b("long"));
                fVar2.b(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            } else if (cls2 == Float.TYPE) {
                fVar2.b(23, aVar2.a("float"));
                fVar2.b(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            } else if (cls2 == Double.TYPE) {
                fVar2.b(24, aVar2.b("double"));
                fVar2.b(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            } else if (cls2 == Boolean.TYPE) {
                fVar2.b(21, aVar2.a("boolean"));
                fVar2.b(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            } else if (cls2 == BigDecimal.class) {
                fVar2.b(25, aVar2.a("decimal"));
            } else if (cls2 == String.class) {
                fVar2.b(25, aVar2.a("string"));
            } else if (cls2.isEnum()) {
                fVar2.b(25, aVar2.a("enum"));
            } else if (List.class.isAssignableFrom(cls2)) {
                fVar2.b(25, aVar2.a("list"));
            } else {
                fVar2.b(25, aVar2.a("object"));
            }
            fVar2.b(182, b, "apply", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
            fVar2.a(153, eVar2);
            eVar3 = new e();
            fVar2.b(21, aVar2.a("hasNameFilters"));
            fVar2.a(154, eVar3);
            Class cls3 = dVar2.d;
            fVar2.b(25, 1);
            fVar2.b(25, 2);
            fVar2.b(25, a.a);
            if (cls3 == Byte.TYPE) {
                fVar2.b(21, aVar2.a("byte"));
                fVar2.b(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            } else if (cls3 == Short.TYPE) {
                fVar2.b(21, aVar2.a("short"));
                fVar2.b(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            } else if (cls3 == Integer.TYPE) {
                fVar2.b(21, aVar2.a("int"));
                fVar2.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else if (cls3 == Character.TYPE) {
                fVar2.b(21, aVar2.a("char"));
                fVar2.b(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            } else if (cls3 == Long.TYPE) {
                fVar2.b(22, aVar2.b("long"));
                fVar2.b(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            } else if (cls3 == Float.TYPE) {
                fVar2.b(23, aVar2.a("float"));
                fVar2.b(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            } else if (cls3 == Double.TYPE) {
                fVar2.b(24, aVar2.b("double"));
                fVar2.b(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            } else if (cls3 == Boolean.TYPE) {
                fVar2.b(21, aVar2.a("boolean"));
                fVar2.b(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            } else if (cls3 == BigDecimal.class) {
                fVar2.b(25, aVar2.a("decimal"));
            } else if (cls3 == String.class) {
                fVar2.b(25, aVar2.a("string"));
            } else if (cls3.isEnum()) {
                fVar2.b(25, aVar2.a("enum"));
            } else if (List.class.isAssignableFrom(cls3)) {
                fVar2.b(25, aVar2.a("list"));
            } else {
                fVar2.b(25, aVar2.a("object"));
            }
            fVar2.b(182, b, "processKey", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
            fVar2.b(58, a.a);
            fVar2.a(eVar3);
            eVar3 = new e();
            fVar2.b(21, aVar2.a("checkValue"));
            fVar2.a(154, eVar2);
            Class cls4 = dVar2.d;
            fVar2.b(25, 1);
            fVar2.b(25, 0);
            fVar2.a(180, aVar.d, "nature", e);
            fVar2.b(25, 2);
            fVar2.b(25, a.a);
            String str = "Ljava/lang/Object;";
            if (cls4 == Byte.TYPE) {
                fVar2.b(21, aVar2.a("byte"));
                fVar2.b(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == Short.TYPE) {
                fVar2.b(21, aVar2.a("short"));
                fVar2.b(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == Integer.TYPE) {
                fVar2.b(21, aVar2.a("int"));
                fVar2.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == Character.TYPE) {
                fVar2.b(21, aVar2.a("char"));
                fVar2.b(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == Long.TYPE) {
                fVar2.b(22, aVar2.b("long"));
                fVar2.b(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == Float.TYPE) {
                fVar2.b(23, aVar2.a("float"));
                fVar2.b(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == Double.TYPE) {
                fVar2.b(24, aVar2.b("double"));
                fVar2.b(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == Boolean.TYPE) {
                fVar2.b(21, aVar2.a("boolean"));
                fVar2.b(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                fVar2.a(89);
                fVar2.b(58, a.b);
            } else if (cls4 == BigDecimal.class) {
                fVar2.b(25, aVar2.a("decimal"));
                fVar2.b(58, a.b);
                fVar2.b(25, a.b);
            } else if (cls4 == String.class) {
                fVar2.b(25, aVar2.a("string"));
                fVar2.b(58, a.b);
                fVar2.b(25, a.b);
            } else if (cls4.isEnum()) {
                fVar2.b(25, aVar2.a("enum"));
                fVar2.b(58, a.b);
                fVar2.b(25, a.b);
            } else if (List.class.isAssignableFrom(cls4)) {
                fVar2.b(25, aVar2.a("list"));
                fVar2.b(58, a.b);
                fVar2.b(25, a.b);
            } else {
                fVar2.b(25, aVar2.a("object"));
                fVar2.b(58, a.b);
                fVar2.b(25, a.b);
            }
            StringBuilder stringBuilder = new StringBuilder(k.s);
            stringBuilder.append(e);
            stringBuilder.append("Ljava/lang/Object;Ljava/lang/String;");
            stringBuilder.append(str);
            stringBuilder.append(")Ljava/lang/Object;");
            fVar2.b(182, b, "processValue", stringBuilder.toString());
            fVar2.b(58, a.c);
            fVar2.b(25, a.b);
            fVar2.b(25, a.c);
            fVar2.a((int) Opcodes.USHR_LONG, eVar3);
            c(fVar, dVar, aVar, eVar);
            fVar2.a((int) Opcodes.SUB_FLOAT, eVar2);
            fVar2.a(eVar3);
        }
    }

    private static void b(f fVar, com.alibaba.fastjson.c.d dVar, a aVar, e eVar) {
        if (!aVar.f) {
            fVar.b(25, 1);
            fVar.b(25, 2);
            fVar.b(25, a.a);
            fVar.b(182, b, "applyName", "(Ljava/lang/Object;Ljava/lang/String;)Z");
            fVar.a(153, eVar);
            fVar.b(25, 1);
            fVar.a(dVar.i);
            fVar.b(182, b, "applyLabel", "(Ljava/lang/String;)Z");
            fVar.a(153, eVar);
        }
        if (dVar.c == null) {
            fVar.b(25, aVar.a("out"));
            fVar.b(182, c, "isIgnoreNonFieldGetter", "()Z");
            fVar.a(154, eVar);
        }
    }

    private static void c(f fVar, com.alibaba.fastjson.c.d dVar, a aVar, e eVar) {
        Object c = dVar.c();
        e eVar2 = new e();
        if (aVar.f) {
            fVar.b(25, aVar.a("object"));
        } else {
            fVar.b(25, a.c);
        }
        fVar.a(199, eVar2);
        b(fVar, dVar, aVar);
        fVar.a((int) Opcodes.SUB_FLOAT, eVar);
        fVar.a(eVar2);
        fVar.b(25, aVar.a("out"));
        fVar.b(21, aVar.a("seperator"));
        fVar.b(182, c, "write", "(I)V");
        fVar.b(25, aVar.a("out"));
        fVar.b(25, a.a);
        fVar.a(3);
        fVar.b(182, c, "writeFieldName", "(Ljava/lang/String;Z)V");
        fVar.b(25, 1);
        if (aVar.f != null) {
            fVar.b(25, aVar.a("object"));
        } else {
            fVar.b(25, a.c);
        }
        if (c != null) {
            fVar.a(c);
            fVar.b(182, b, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            fVar.b(25, a.a);
            if ((dVar.e instanceof Class) == null || ((Class) dVar.e).isPrimitive() == null) {
                if (dVar.d == String.class) {
                    fVar.a(com.alibaba.fastjson.b.h.a(c.a(String.class)));
                } else {
                    fVar.b(25, null);
                    String c2 = aVar.d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar.a);
                    stringBuilder.append("_asm_fieldType");
                    fVar.a(180, c2, stringBuilder.toString(), "Ljava/lang/reflect/Type;");
                }
                fVar.a(Integer.valueOf(dVar.h));
                fVar.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                fVar.b(182, b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
        }
        a(fVar, aVar);
    }

    private static void b(f fVar, com.alibaba.fastjson.c.d dVar, a aVar) {
        int i;
        int i2;
        int i3;
        int i4;
        f fVar2 = fVar;
        a aVar2 = aVar;
        Class cls = dVar.d;
        e eVar = new e();
        e eVar2 = new e();
        e eVar3 = new e();
        e eVar4 = new e();
        fVar2.a(eVar);
        com.alibaba.fastjson.a.b b = dVar.b();
        int i5 = 0;
        if (b != null) {
            SerializerFeature[] f = b.f();
            int length = f.length;
            int i6 = 0;
            i = i6;
            i2 = i;
            i3 = i2;
            i4 = i3;
            while (i5 < length) {
                SerializerFeature serializerFeature = f[i5];
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    i6 = 1;
                } else if (serializerFeature == SerializerFeature.WriteNullNumberAsZero) {
                    i2 = 1;
                } else if (serializerFeature == SerializerFeature.WriteNullStringAsEmpty) {
                    i = 1;
                } else if (serializerFeature == SerializerFeature.WriteNullBooleanAsFalse) {
                    i3 = 1;
                } else if (serializerFeature == SerializerFeature.WriteNullListAsEmpty) {
                    i4 = 1;
                }
                i5++;
            }
            i5 = i6;
        } else {
            i = 0;
            i2 = i;
            i3 = i2;
            i4 = i3;
        }
        if (i5 == 0) {
            fVar2.b(25, aVar2.a("out"));
            fVar2.b(182, c, "isWriteMapNullValue", "()Z");
            fVar2.a(153, eVar2);
        }
        fVar2.a(eVar3);
        fVar2.b(25, aVar2.a("out"));
        fVar2.b(21, aVar2.a("seperator"));
        fVar2.b(25, a.a);
        if (cls != String.class) {
            if (cls != Character.class) {
                if (Number.class.isAssignableFrom(cls)) {
                    if (i2 != 0) {
                        fVar2.a(3);
                        fVar2.b(182, c, "writeFieldValue", "(CLjava/lang/String;I)V");
                    } else {
                        fVar2.b(182, c, "writeFieldNullNumber", "(CLjava/lang/String;)V");
                    }
                } else if (cls != Boolean.class) {
                    if (!Collection.class.isAssignableFrom(cls)) {
                        if (!cls.isArray()) {
                            fVar2.b(182, c, "writeFieldNull", "(CLjava/lang/String;)V");
                        }
                    }
                    if (i4 != 0) {
                        fVar2.b(182, c, "writeFieldEmptyList", "(CLjava/lang/String;)V");
                    } else {
                        fVar2.b(182, c, "writeFieldNullList", "(CLjava/lang/String;)V");
                    }
                } else if (i3 != 0) {
                    fVar2.a(3);
                    fVar2.b(182, c, "writeFieldValue", "(CLjava/lang/String;Z)V");
                } else {
                    fVar2.b(182, c, "writeFieldNullBoolean", "(CLjava/lang/String;)V");
                }
                a(fVar2, aVar2);
                fVar2.a((int) Opcodes.SUB_FLOAT, eVar4);
                fVar2.a(eVar2);
                fVar2.a(eVar4);
            }
        }
        if (i != 0) {
            fVar2.a((Object) "");
            fVar2.b(182, c, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            fVar2.b(182, c, "writeFieldNullString", "(CLjava/lang/String;)V");
        }
        a(fVar2, aVar2);
        fVar2.a((int) Opcodes.SUB_FLOAT, eVar4);
        fVar2.a(eVar2);
        fVar2.a(eVar4);
    }

    private static void a(f fVar, a aVar) {
        fVar.b(16, 44);
        fVar.b(54, aVar.a("seperator"));
    }
}
