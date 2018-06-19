package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.b.b;
import com.alibaba.fastjson.b.f;
import com.alibaba.fastjson.b.h;
import com.alibaba.fastjson.c.c;
import com.alibaba.fastjson.c.d;
import com.alibaba.fastjson.c.g;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.e;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.umeng.message.proguard.k;
import com.xunlei.tdlive.protocol.XLLivePushTagRequest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ASMDeserializerFactory */
public class a {
    static final String c = c.b(com.alibaba.fastjson.parser.a.class);
    static final String d = c.b(com.alibaba.fastjson.parser.c.class);
    static final String e = c.b(e.class);
    public final com.alibaba.fastjson.c.a a;
    protected final AtomicLong b = new AtomicLong();

    /* compiled from: ASMDeserializerFactory */
    static class a {
        int a = 5;
        final Class<?> b;
        final g c;
        final String d;
        d[] e;
        private final Map<String, Integer> f = new HashMap();

        public a(String str, g gVar, int i) {
            this.d = str;
            this.b = gVar.a;
            this.a = i;
            this.c = gVar;
            this.e = gVar.h;
        }

        public final Class<?> a() {
            Class<?> cls = this.c.b;
            return cls == null ? this.b : cls;
        }

        public final int a(String str) {
            if (((Integer) this.f.get(str)) == null) {
                this.f.put(str, Integer.valueOf(this.a));
                this.a += 2;
            }
            return ((Integer) this.f.get(str)).intValue();
        }

        public final int b(String str) {
            if (((Integer) this.f.get(str)) == null) {
                Map map = this.f;
                int i = this.a;
                this.a = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return ((Integer) this.f.get(str)).intValue();
        }
    }

    public a(ClassLoader classLoader) {
        this.a = (com.alibaba.fastjson.c.a) classLoader;
    }

    public final r a(com.alibaba.fastjson.parser.g gVar, Class<?> cls, Type type) throws Exception {
        if (cls.isPrimitive()) {
            type = new StringBuilder("not support type :");
            type.append(cls.getName());
            throw new IllegalArgumentException(type.toString());
        }
        StringBuilder stringBuilder = new StringBuilder("FastjsonASMDeserializer_");
        stringBuilder.append(this.b.incrementAndGet());
        stringBuilder.append("_");
        stringBuilder.append(cls.getSimpleName());
        String stringBuilder2 = stringBuilder.toString();
        String name = a.class.getPackage().getName();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(name.replace('.', '/'));
        stringBuilder3.append("/");
        stringBuilder3.append(stringBuilder2);
        String stringBuilder4 = stringBuilder3.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(name);
        stringBuilder5.append(".");
        stringBuilder5.append(stringBuilder2);
        stringBuilder2 = stringBuilder5.toString();
        b bVar = new b();
        bVar.a(stringBuilder4, c.b(b.class), null);
        type = g.a((Class) cls, type);
        c(bVar, new a(stringBuilder4, type, 3));
        a aVar = new a(stringBuilder4, type, 3);
        StringBuilder stringBuilder6 = new StringBuilder("(L");
        stringBuilder6.append(c);
        stringBuilder6.append(";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        f gVar2 = new com.alibaba.fastjson.b.g(bVar, "createInstance", stringBuilder6.toString(), null);
        gVar2.a((int) Opcodes.ADD_LONG_2ADDR, c.b(aVar.a()));
        gVar2.a(89);
        gVar2.b(183, c.b(aVar.a()), "<init>", "()V");
        gVar2.a((int) Opcodes.ADD_INT_2ADDR);
        gVar2.c(3, 3);
        b(bVar, new a(stringBuilder4, type, 4));
        a(bVar, new a(stringBuilder4, type, 4));
        type = bVar.a();
        return (r) this.a.a(stringBuilder2, type, type.length).getConstructor(new Class[]{com.alibaba.fastjson.parser.g.class, Class.class}).newInstance(new Object[]{gVar, cls});
    }

    private static void a(f fVar, a aVar, int i) {
        StringBuilder stringBuilder = new StringBuilder("_asm_flag_");
        stringBuilder.append(i / 32);
        String stringBuilder2 = stringBuilder.toString();
        fVar.b(21, aVar.b(stringBuilder2));
        fVar.a(Integer.valueOf(1 << i));
        fVar.a(128);
        fVar.b(54, aVar.b(stringBuilder2));
    }

    private static void a(b bVar, a aVar) {
        a aVar2 = aVar;
        StringBuilder stringBuilder = new StringBuilder("(L");
        stringBuilder.append(c);
        stringBuilder.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        f gVar = new com.alibaba.fastjson.b.g(bVar, "deserialzeArrayMapping", stringBuilder.toString(), null);
        a(aVar2, gVar);
        b(aVar2, gVar);
        d[] dVarArr = aVar2.c.i;
        int length = dVarArr.length;
        int i = 0;
        while (i < length) {
            StringBuilder stringBuilder2;
            Object obj = i == length + -1 ? 1 : null;
            int i2 = obj != null ? 93 : 44;
            d dVar = dVarArr[i];
            Class cls = dVar.d;
            Type type = dVar.e;
            if (!(cls == Byte.TYPE || cls == Short.TYPE)) {
                if (cls != Integer.TYPE) {
                    if (cls == Long.TYPE) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(16, i2);
                        gVar.b(182, d, "scanLong", "(C)J");
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(dVar.a);
                        stringBuilder2.append("_asm");
                        gVar.b(55, aVar2.a(stringBuilder2.toString()));
                    } else if (cls == Boolean.TYPE) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(16, i2);
                        gVar.b(182, d, "scanBoolean", "(C)Z");
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(dVar.a);
                        stringBuilder2.append("_asm");
                        gVar.b(54, aVar2.b(stringBuilder2.toString()));
                    } else if (cls == Float.TYPE) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(16, i2);
                        gVar.b(182, d, "scanFloat", "(C)F");
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(dVar.a);
                        stringBuilder2.append("_asm");
                        gVar.b(56, aVar2.b(stringBuilder2.toString()));
                    } else if (cls == Double.TYPE) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(16, i2);
                        gVar.b(182, d, "scanDouble", "(C)D");
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(dVar.a);
                        stringBuilder2.append("_asm");
                        gVar.b(57, aVar2.a(stringBuilder2.toString()));
                    } else if (cls == Character.TYPE) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(16, i2);
                        gVar.b(182, d, "scanString", "(C)Ljava/lang/String;");
                        gVar.a(3);
                        gVar.b(182, "java/lang/String", "charAt", "(I)C");
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(dVar.a);
                        stringBuilder2.append("_asm");
                        gVar.b(54, aVar2.b(stringBuilder2.toString()));
                    } else if (cls == String.class) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(16, i2);
                        gVar.b(182, d, "scanString", "(C)Ljava/lang/String;");
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(dVar.a);
                        stringBuilder.append("_asm");
                        gVar.b(58, aVar2.b(stringBuilder.toString()));
                    } else if (cls.isEnum()) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.a(h.a(c.a(cls)));
                        gVar.b(25, 1);
                        StringBuilder stringBuilder3 = new StringBuilder("()");
                        stringBuilder3.append(c.a(com.alibaba.fastjson.parser.h.class));
                        gVar.b(182, c, "getSymbolTable", stringBuilder3.toString());
                        gVar.b(16, i2);
                        r8 = new StringBuilder("(Ljava/lang/Class;");
                        r8.append(c.a(com.alibaba.fastjson.parser.h.class));
                        r8.append("C)Ljava/lang/Enum;");
                        gVar.b(182, d, "scanEnum", r8.toString());
                        gVar.a(192, c.b(cls));
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(dVar.a);
                        stringBuilder.append("_asm");
                        gVar.b(58, aVar2.b(stringBuilder.toString()));
                    } else if (Collection.class.isAssignableFrom(cls)) {
                        Class f = j.f(type);
                        if (f == String.class) {
                            gVar.b(25, aVar2.b("lexer"));
                            gVar.a(h.a(c.a(cls)));
                            gVar.b(16, i2);
                            gVar.b(182, d, "scanStringArray", "(Ljava/lang/Class;C)Ljava/util/Collection;");
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(dVar.a);
                            stringBuilder.append("_asm");
                            gVar.b(58, aVar2.b(stringBuilder.toString()));
                        } else {
                            gVar.b(25, 1);
                            if (i == 0) {
                                i2 = Opcodes.MUL_INT_2ADDR;
                                gVar.a(Opcodes.MUL_INT_2ADDR, e, "LBRACKET", "I");
                            } else {
                                i2 = Opcodes.MUL_INT_2ADDR;
                                gVar.a(Opcodes.MUL_INT_2ADDR, e, "COMMA", "I");
                            }
                            gVar.a(i2, e, "LBRACKET", "I");
                            gVar.b(182, c, "accept", "(II)V");
                            a(gVar, cls, i, false);
                            gVar.a(89);
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(dVar.a);
                            stringBuilder2.append("_asm");
                            gVar.b(58, aVar2.b(stringBuilder2.toString()));
                            a(aVar2, gVar, dVar, f);
                            gVar.b(25, 1);
                            gVar.a(h.a(c.a(f)));
                            gVar.b(25, 3);
                            r8 = new StringBuilder("(Ljava/util/Collection;");
                            r8.append(c.a(r.class));
                            r8.append("L");
                            r8.append(c);
                            r8.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            gVar.b(184, c.b(c.class), "parseArray", r8.toString());
                        }
                    } else if (cls.isArray()) {
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "LBRACKET", "I");
                        gVar.b(182, d, "nextToken", "(I)V");
                        gVar.b(25, 1);
                        gVar.b(25, 0);
                        gVar.a(Integer.valueOf(i));
                        gVar.b(182, c.b(b.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                        gVar.b(182, c, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                        gVar.a(192, c.b(cls));
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(dVar.a);
                        stringBuilder.append("_asm");
                        gVar.b(58, aVar2.b(stringBuilder.toString()));
                    } else {
                        gVar.b(25, 1);
                        if (i == 0) {
                            i2 = Opcodes.MUL_INT_2ADDR;
                            gVar.a(Opcodes.MUL_INT_2ADDR, e, "LBRACKET", "I");
                        } else {
                            i2 = Opcodes.MUL_INT_2ADDR;
                            gVar.a(Opcodes.MUL_INT_2ADDR, e, "COMMA", "I");
                        }
                        gVar.a(i2, e, "LBRACKET", "I");
                        gVar.b(182, c, "accept", "(II)V");
                        a(aVar2, gVar, dVar, cls, i);
                        gVar.b(25, 1);
                        if (obj == null) {
                            gVar.a(i2, e, "COMMA", "I");
                            gVar.a(i2, e, "LBRACKET", "I");
                        } else {
                            gVar.a(i2, e, "RBRACKET", "I");
                            gVar.a(i2, e, "EOF", "I");
                        }
                        gVar.b(182, c, "accept", "(II)V");
                    }
                    i++;
                }
            }
            gVar.b(25, aVar2.b("lexer"));
            gVar.b(16, i2);
            gVar.b(182, d, "scanInt", "(C)I");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(dVar.a);
            stringBuilder2.append("_asm");
            gVar.b(54, aVar2.b(stringBuilder2.toString()));
            i++;
        }
        a(aVar2, gVar, false);
        gVar.b(25, aVar2.b("lexer"));
        gVar.a(Opcodes.MUL_INT_2ADDR, e, "COMMA", "I");
        gVar.b(182, d, "nextToken", "(I)V");
        gVar.b(25, aVar2.b("instance"));
        gVar.a((int) Opcodes.ADD_INT_2ADDR);
        gVar.c(5, aVar2.a);
    }

    private static void a(a aVar, f fVar, Feature feature) {
        fVar.b(25, aVar.b("lexer"));
        fVar.a(Opcodes.MUL_INT_2ADDR, c.b(Feature.class), feature.name(), c.a(Feature.class));
        StringBuilder stringBuilder = new StringBuilder(k.s);
        stringBuilder.append(c.a(Feature.class));
        stringBuilder.append(")Z");
        fVar.b(182, d, "isEnabled", stringBuilder.toString());
    }

    private static void a(a aVar, f fVar) {
        fVar.b(25, 1);
        fVar.a(180, c, "lexer", c.a(com.alibaba.fastjson.parser.b.class));
        fVar.a(192, d);
        fVar.b(58, aVar.b("lexer"));
    }

    private static void c(a aVar, f fVar) {
        a(aVar, fVar, true);
    }

    private static void a(f fVar, d dVar) {
        if (dVar.b != null) {
            fVar.b(182, c.b(dVar.f), dVar.b.getName(), c.a(dVar.b));
            if (dVar.b.getReturnType().equals(Void.TYPE) == null) {
                fVar.a(87);
                return;
            }
        }
        fVar.a(181, c.b(dVar.f), dVar.c.getName(), c.a(dVar.d));
    }

    private static void a(a aVar, f fVar, com.alibaba.fastjson.b.e eVar) {
        fVar.a(21, aVar.b("matchedCount"));
        fVar.a(158, eVar);
        fVar.b(25, aVar.b("lexer"));
        fVar.b(182, d, "token", "()I");
        fVar.a(Opcodes.MUL_INT_2ADDR, e, "RBRACE", "I");
        fVar.a((int) Opcodes.AND_LONG, eVar);
        fVar.b(25, aVar.b("lexer"));
        fVar.a(Opcodes.MUL_INT_2ADDR, e, "COMMA", "I");
        fVar.b(182, d, "nextToken", "(I)V");
    }

    private static void a(a aVar, f fVar, d dVar, Class<?> cls) {
        com.alibaba.fastjson.b.e eVar = new com.alibaba.fastjson.b.e();
        fVar.b(25, 0);
        String str = aVar.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dVar.a);
        stringBuilder.append("_asm_list_item_deser__");
        fVar.a(180, str, stringBuilder.toString(), c.a(r.class));
        fVar.a(199, eVar);
        fVar.b(25, 0);
        fVar.b(25, 1);
        StringBuilder stringBuilder2 = new StringBuilder("()");
        stringBuilder2.append(c.a(com.alibaba.fastjson.parser.g.class));
        fVar.b(182, c, "getConfig", stringBuilder2.toString());
        fVar.a(h.a(c.a((Class) cls)));
        stringBuilder = new StringBuilder("(Ljava/lang/reflect/Type;)");
        stringBuilder.append(c.a(r.class));
        fVar.b(182, c.b(com.alibaba.fastjson.parser.g.class), "getDeserializer", stringBuilder.toString());
        cls = aVar.d;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(dVar.a);
        stringBuilder3.append("_asm_list_item_deser__");
        fVar.a(181, cls, stringBuilder3.toString(), c.a(r.class));
        fVar.a(eVar);
        fVar.b(25, 0);
        aVar = aVar.d;
        cls = new StringBuilder();
        cls.append(dVar.a);
        cls.append("_asm_list_item_deser__");
        fVar.a(180, aVar, cls.toString(), c.a(r.class));
    }

    private static void a(f fVar, Class<?> cls, int i, boolean z) {
        if (cls.isAssignableFrom(ArrayList.class) && !z) {
            fVar.a((int) Opcodes.ADD_LONG_2ADDR, "java/util/ArrayList");
            fVar.a(89);
            fVar.b(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z) {
            fVar.a((int) Opcodes.ADD_LONG_2ADDR, c.b(LinkedList.class));
            fVar.a(89);
            fVar.b(183, c.b(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            fVar.a((int) Opcodes.ADD_LONG_2ADDR, c.b(HashSet.class));
            fVar.a(89);
            fVar.b(183, c.b(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            fVar.a((int) Opcodes.ADD_LONG_2ADDR, c.b(TreeSet.class));
            fVar.a(89);
            fVar.b(183, c.b(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            fVar.a((int) Opcodes.ADD_LONG_2ADDR, c.b(LinkedHashSet.class));
            fVar.a(89);
            fVar.b(183, c.b(LinkedHashSet.class), "<init>", "()V");
        } else if (z) {
            fVar.a((int) Opcodes.ADD_LONG_2ADDR, c.b(HashSet.class));
            fVar.a(89);
            fVar.b(183, c.b(HashSet.class), "<init>", "()V");
        } else {
            fVar.b(true, 0);
            fVar.a(Integer.valueOf(i));
            fVar.b(182, c.b(b.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            fVar.b(184, c.b(j.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        fVar.a(192, c.b(cls));
    }

    private static void b(b bVar, a aVar) {
        a aVar2 = aVar;
        if (aVar2.e.length != 0) {
            StringBuilder stringBuilder;
            com.alibaba.fastjson.b.e eVar;
            com.alibaba.fastjson.b.e eVar2;
            com.alibaba.fastjson.b.e eVar3;
            com.alibaba.fastjson.b.e eVar4;
            StringBuilder stringBuilder2;
            d[] dVarArr = aVar2.e;
            int length = dVarArr.length;
            int i = 0;
            while (i < length) {
                d dVar = dVarArr[i];
                Class cls = dVar.d;
                Type type = dVar.e;
                if (cls != Character.TYPE) {
                    if (!Collection.class.isAssignableFrom(cls) || ((type instanceof ParameterizedType) && (((ParameterizedType) type).getActualTypeArguments()[0] instanceof Class))) {
                        i++;
                    } else {
                        return;
                    }
                }
                return;
            }
            aVar2.e = aVar2.c.i;
            StringBuilder stringBuilder3 = new StringBuilder("(L");
            stringBuilder3.append(c);
            stringBuilder3.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
            f gVar = new com.alibaba.fastjson.b.g(bVar, "deserialze", stringBuilder3.toString(), null);
            com.alibaba.fastjson.b.e eVar5 = new com.alibaba.fastjson.b.e();
            com.alibaba.fastjson.b.e eVar6 = new com.alibaba.fastjson.b.e();
            com.alibaba.fastjson.b.e eVar7 = new com.alibaba.fastjson.b.e();
            com.alibaba.fastjson.b.e eVar8 = new com.alibaba.fastjson.b.e();
            a(aVar2, gVar);
            a(aVar2, gVar, Feature.SortFeidFastMatch);
            gVar.a(153, eVar6);
            com.alibaba.fastjson.b.e eVar9 = new com.alibaba.fastjson.b.e();
            int i2 = 25;
            gVar.b(25, 0);
            gVar.b(25, aVar2.b("lexer"));
            StringBuilder stringBuilder4 = new StringBuilder(k.s);
            stringBuilder4.append(c.a(com.alibaba.fastjson.parser.b.class));
            stringBuilder4.append(")Z");
            gVar.b(183, c.b(b.class), "isSupportArrayToBean", stringBuilder4.toString());
            gVar.a(153, eVar9);
            gVar.b(25, aVar2.b("lexer"));
            int i3 = 182;
            gVar.b(182, d, "token", "()I");
            gVar.a(Opcodes.MUL_INT_2ADDR, e, "LBRACKET", "I");
            gVar.a((int) Opcodes.AND_LONG, eVar9);
            gVar.b(25, 0);
            int i4 = 1;
            gVar.b(25, 1);
            gVar.b(25, 2);
            gVar.b(25, 3);
            StringBuilder stringBuilder5 = new StringBuilder("(L");
            stringBuilder5.append(c);
            stringBuilder5.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
            gVar.b(183, aVar2.d, "deserialzeArrayMapping", stringBuilder5.toString());
            gVar.a((int) Opcodes.ADD_INT_2ADDR);
            gVar.a(eVar9);
            gVar.b(25, aVar2.b("lexer"));
            gVar.a(aVar2.b.getName());
            gVar.b(182, d, "scanType", "(Ljava/lang/String;)I");
            gVar.a(Opcodes.MUL_INT_2ADDR, d, "NOT_MATCH", "I");
            gVar.a((int) Opcodes.REM_LONG, eVar6);
            gVar.b(25, 1);
            StringBuilder stringBuilder6 = new StringBuilder("()");
            stringBuilder6.append(c.a(com.alibaba.fastjson.parser.f.class));
            gVar.b(182, c, "getContext", stringBuilder6.toString());
            gVar.b(58, aVar2.b("mark_context"));
            gVar.a(3);
            gVar.b(54, aVar2.b("matchedCount"));
            b(aVar2, gVar);
            gVar.b(25, 1);
            StringBuilder stringBuilder7 = new StringBuilder("()");
            stringBuilder7.append(c.a(com.alibaba.fastjson.parser.f.class));
            gVar.b(182, c, "getContext", stringBuilder7.toString());
            gVar.b(58, aVar2.b("context"));
            gVar.b(25, 1);
            gVar.b(25, aVar2.b("context"));
            gVar.b(25, aVar2.b("instance"));
            gVar.b(25, 3);
            stringBuilder6 = new StringBuilder(k.s);
            stringBuilder6.append(c.a(com.alibaba.fastjson.parser.f.class));
            stringBuilder6.append("Ljava/lang/Object;Ljava/lang/Object;)");
            stringBuilder6.append(c.a(com.alibaba.fastjson.parser.f.class));
            gVar.b(182, c, "setContext", stringBuilder6.toString());
            gVar.b(58, aVar2.b("childContext"));
            gVar.b(25, aVar2.b("lexer"));
            gVar.a(180, d, "matchStat", "I");
            gVar.a(Opcodes.MUL_INT_2ADDR, d, "END", "I");
            gVar.a((int) Opcodes.REM_LONG, eVar7);
            int i5 = 3;
            gVar.a(3);
            gVar.a(54, aVar2.b("matchStat"));
            int length2 = aVar2.e.length;
            int i6 = 0;
            while (i6 < length2) {
                gVar.a(i5);
                stringBuilder7 = new StringBuilder("_asm_flag_");
                stringBuilder7.append(i6 / 32);
                gVar.b(54, aVar2.b(stringBuilder7.toString()));
                i6 += 32;
                i5 = 3;
            }
            a(aVar2, gVar, Feature.InitStringFieldAsEmpty);
            gVar.a(54, aVar2.b("initStringFieldAsEmpty"));
            i5 = 0;
            while (i5 < length2) {
                d dVar2 = aVar2.e[i5];
                Class cls2 = dVar2.d;
                if (!(cls2 == Boolean.TYPE || cls2 == Byte.TYPE || cls2 == Short.TYPE)) {
                    if (cls2 != Integer.TYPE) {
                        if (cls2 == Long.TYPE) {
                            gVar.a(9);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(dVar2.a);
                            stringBuilder.append("_asm");
                            gVar.b(55, aVar2.a(stringBuilder.toString()));
                        } else if (cls2 == Float.TYPE) {
                            gVar.a(11);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(dVar2.a);
                            stringBuilder.append("_asm");
                            gVar.b(56, aVar2.b(stringBuilder.toString()));
                        } else if (cls2 == Double.TYPE) {
                            gVar.a(14);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(dVar2.a);
                            stringBuilder.append("_asm");
                            gVar.b(57, aVar2.a(stringBuilder.toString()));
                        } else {
                            if (cls2 == String.class) {
                                eVar = new com.alibaba.fastjson.b.e();
                                eVar2 = new com.alibaba.fastjson.b.e();
                                gVar.b(21, aVar2.b("initStringFieldAsEmpty"));
                                gVar.a(153, eVar2);
                                a(gVar, aVar2, i5);
                                gVar.b(i2, aVar2.b("lexer"));
                                gVar.b(182, d, "stringDefaultValue", "()Ljava/lang/String;");
                                gVar.a((int) Opcodes.SUB_FLOAT, eVar);
                                gVar.a(eVar2);
                                gVar.a(1);
                                gVar.a(eVar);
                            } else {
                                gVar.a(i4);
                            }
                            gVar.a(192, c.b(cls2));
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append(dVar2.a);
                            stringBuilder5.append("_asm");
                            gVar.b(58, aVar2.b(stringBuilder5.toString()));
                        }
                        i5++;
                        i2 = 25;
                        i4 = 1;
                    }
                }
                gVar.a(3);
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append(dVar2.a);
                stringBuilder5.append("_asm");
                gVar.b(54, aVar2.b(stringBuilder5.toString()));
                i5++;
                i2 = 25;
                i4 = 1;
            }
            i5 = 0;
            while (i5 < length2) {
                d dVar3 = aVar2.e[i5];
                Class cls3 = dVar3.d;
                Type type2 = dVar3.e;
                eVar2 = new com.alibaba.fastjson.b.e();
                String str;
                StringBuilder stringBuilder8;
                if (cls3 == Boolean.TYPE) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldBoolean", "([C)Z");
                    stringBuilder8 = new StringBuilder();
                    stringBuilder8.append(dVar3.a);
                    stringBuilder8.append("_asm");
                    gVar.b(54, aVar2.b(stringBuilder8.toString()));
                } else if (cls3 == Byte.TYPE) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldInt", "([C)I");
                    stringBuilder8 = new StringBuilder();
                    stringBuilder8.append(dVar3.a);
                    stringBuilder8.append("_asm");
                    gVar.b(54, aVar2.b(stringBuilder8.toString()));
                } else if (cls3 == Short.TYPE) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldInt", "([C)I");
                    stringBuilder8 = new StringBuilder();
                    stringBuilder8.append(dVar3.a);
                    stringBuilder8.append("_asm");
                    gVar.b(54, aVar2.b(stringBuilder8.toString()));
                } else if (cls3 == Integer.TYPE) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldInt", "([C)I");
                    stringBuilder8 = new StringBuilder();
                    stringBuilder8.append(dVar3.a);
                    stringBuilder8.append("_asm");
                    gVar.b(54, aVar2.b(stringBuilder8.toString()));
                } else if (cls3 == Long.TYPE) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldLong", "([C)J");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm");
                    gVar.b(55, aVar2.a(stringBuilder.toString()));
                } else if (cls3 == Float.TYPE) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldFloat", "([C)F");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm");
                    gVar.b(56, aVar2.b(stringBuilder.toString()));
                } else if (cls3 == Double.TYPE) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldDouble", "([C)D");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm");
                    gVar.b(57, aVar2.a(stringBuilder.toString()));
                } else if (cls3 == String.class) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    str = aVar2.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm_prefix__");
                    gVar.a(180, str, stringBuilder.toString(), "[C");
                    gVar.b(i3, d, "scanFieldString", "([C)Ljava/lang/String;");
                    stringBuilder8 = new StringBuilder();
                    stringBuilder8.append(dVar3.a);
                    stringBuilder8.append("_asm");
                    gVar.b(58, aVar2.b(stringBuilder8.toString()));
                } else if (cls3.isEnum()) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    r10 = aVar2.d;
                    r14 = new StringBuilder();
                    r14.append(dVar3.a);
                    r14.append("_asm_prefix__");
                    gVar.a(180, r10, r14.toString(), "[C");
                    eVar = new com.alibaba.fastjson.b.e();
                    gVar.a(1);
                    gVar.a(192, c.b(cls3));
                    stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(dVar3.a);
                    stringBuilder6.append("_asm");
                    gVar.b(58, aVar2.b(stringBuilder6.toString()));
                    gVar.b(25, 1);
                    StringBuilder stringBuilder9 = new StringBuilder("()");
                    stringBuilder9.append(c.a(com.alibaba.fastjson.parser.h.class));
                    gVar.b(182, c, "getSymbolTable", stringBuilder9.toString());
                    r14 = new StringBuilder("([C");
                    r14.append(c.a(com.alibaba.fastjson.parser.h.class));
                    r14.append(")Ljava/lang/String;");
                    gVar.b(182, d, "scanFieldSymbol", r14.toString());
                    gVar.a(89);
                    stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(dVar3.a);
                    stringBuilder6.append("_asm_enumName");
                    gVar.b(58, aVar2.b(stringBuilder6.toString()));
                    gVar.a(198, eVar);
                    stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(dVar3.a);
                    stringBuilder6.append("_asm_enumName");
                    gVar.b(25, aVar2.b(stringBuilder6.toString()));
                    stringBuilder9 = new StringBuilder("(Ljava/lang/String;)");
                    stringBuilder9.append(c.a(cls3));
                    gVar.b(184, c.b(cls3), "valueOf", stringBuilder9.toString());
                    stringBuilder8 = new StringBuilder();
                    stringBuilder8.append(dVar3.a);
                    stringBuilder8.append("_asm");
                    gVar.b(58, aVar2.b(stringBuilder8.toString()));
                    gVar.a(eVar);
                } else if (Collection.class.isAssignableFrom(cls3)) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    String str2 = aVar2.d;
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(dVar3.a);
                    stringBuilder4.append("_asm_prefix__");
                    gVar.a(180, str2, stringBuilder4.toString(), "[C");
                    Class f = j.f(type2);
                    if (f == String.class) {
                        gVar.a(h.a(c.a(cls3)));
                        stringBuilder6 = new StringBuilder("([CLjava/lang/Class;)");
                        stringBuilder6.append(c.a(Collection.class));
                        gVar.b(182, d, "scanFieldStringArray", stringBuilder6.toString());
                        stringBuilder8 = new StringBuilder();
                        stringBuilder8.append(dVar3.a);
                        stringBuilder8.append("_asm");
                        gVar.b(58, aVar2.b(stringBuilder8.toString()));
                    } else {
                        eVar2 = new com.alibaba.fastjson.b.e();
                        gVar.b(182, d, "matchField", "([C)Z");
                        gVar.a(153, eVar2);
                        a(gVar, aVar2, i5);
                        com.alibaba.fastjson.b.e eVar10 = new com.alibaba.fastjson.b.e();
                        gVar.b(25, aVar2.b("lexer"));
                        eVar3 = eVar6;
                        gVar.b(182, d, "token", "()I");
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "NULL", "I");
                        gVar.a((int) Opcodes.AND_LONG, eVar10);
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "COMMA", "I");
                        gVar.b(182, d, "nextToken", "(I)V");
                        gVar.a((int) Opcodes.SUB_FLOAT, eVar2);
                        gVar.a(eVar10);
                        eVar6 = new com.alibaba.fastjson.b.e();
                        com.alibaba.fastjson.b.e eVar11 = new com.alibaba.fastjson.b.e();
                        gVar.b(25, aVar2.b("lexer"));
                        eVar4 = eVar7;
                        gVar.b(182, d, "token", "()I");
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "SET", "I");
                        gVar.a((int) Opcodes.AND_LONG, eVar11);
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "LBRACKET", "I");
                        gVar.b(182, d, "nextToken", "(I)V");
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(182, d, "token", "()I");
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "LBRACKET", "I");
                        gVar.a((int) Opcodes.AND_LONG, eVar5);
                        a(gVar, cls3, i5, true);
                        gVar.a((int) Opcodes.SUB_FLOAT, eVar6);
                        gVar.a(eVar11);
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(182, d, "token", "()I");
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "LBRACKET", "I");
                        gVar.a((int) Opcodes.AND_LONG, eVar5);
                        a(gVar, cls3, i5, false);
                        gVar.a(eVar6);
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(dVar3.a);
                        stringBuilder3.append("_asm");
                        gVar.b(58, aVar2.b(stringBuilder3.toString()));
                        a(aVar2, gVar, dVar3, f);
                        gVar.b(Opcodes.SHR_INT_2ADDR, c.b(r.class), "getFastMatchToken", "()I");
                        gVar.b(54, aVar2.b("fastMatchToken"));
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(21, aVar2.b("fastMatchToken"));
                        gVar.b(182, d, "nextToken", "(I)V");
                        gVar.b(25, 1);
                        stringBuilder6 = new StringBuilder("()");
                        stringBuilder6.append(c.a(com.alibaba.fastjson.parser.f.class));
                        gVar.b(182, c, "getContext", stringBuilder6.toString());
                        gVar.b(58, aVar2.b("listContext"));
                        gVar.b(25, 1);
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(dVar3.a);
                        stringBuilder2.append("_asm");
                        gVar.b(25, aVar2.b(stringBuilder2.toString()));
                        gVar.a(dVar3.a);
                        stringBuilder6 = new StringBuilder("(Ljava/lang/Object;Ljava/lang/Object;)");
                        stringBuilder6.append(c.a(com.alibaba.fastjson.parser.f.class));
                        gVar.b(182, c, "setContext", stringBuilder6.toString());
                        gVar.a(87);
                        eVar6 = new com.alibaba.fastjson.b.e();
                        eVar7 = new com.alibaba.fastjson.b.e();
                        gVar.a(3);
                        gVar.b(54, aVar2.b("i"));
                        gVar.a(eVar6);
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(182, d, "token", "()I");
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "RBRACKET", "I");
                        gVar.a((int) Opcodes.REM_LONG, eVar7);
                        gVar.b(25, 0);
                        String str3 = aVar2.d;
                        r14 = new StringBuilder();
                        r14.append(dVar3.a);
                        r14.append("_asm_list_item_deser__");
                        gVar.a(180, str3, r14.toString(), c.a(r.class));
                        gVar.b(25, 1);
                        gVar.a(h.a(c.a(f)));
                        gVar.b(21, aVar2.b("i"));
                        gVar.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        r14 = new StringBuilder("(L");
                        r14.append(c);
                        r14.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
                        gVar.b(Opcodes.SHR_INT_2ADDR, c.b(r.class), "deserialze", r14.toString());
                        gVar.b(58, aVar2.b("list_item_value"));
                        gVar.b(aVar2.b("i"));
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(dVar3.a);
                        stringBuilder.append("_asm");
                        gVar.b(25, aVar2.b(stringBuilder.toString()));
                        gVar.b(25, aVar2.b("list_item_value"));
                        if (cls3.isInterface()) {
                            gVar.b(Opcodes.SHR_INT_2ADDR, c.b(cls3), XLLivePushTagRequest.T_ADD, "(Ljava/lang/Object;)Z");
                        } else {
                            gVar.b(182, c.b(cls3), XLLivePushTagRequest.T_ADD, "(Ljava/lang/Object;)Z");
                        }
                        gVar.a(87);
                        gVar.b(25, 1);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(dVar3.a);
                        stringBuilder.append("_asm");
                        gVar.b(25, aVar2.b(stringBuilder.toString()));
                        gVar.b(182, c, "checkListResolve", "(Ljava/util/Collection;)V");
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(182, d, "token", "()I");
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "COMMA", "I");
                        gVar.a((int) Opcodes.AND_LONG, eVar6);
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(21, aVar2.b("fastMatchToken"));
                        gVar.b(182, d, "nextToken", "(I)V");
                        gVar.a((int) Opcodes.SUB_FLOAT, eVar6);
                        gVar.a(eVar7);
                        gVar.b(25, 1);
                        gVar.b(25, aVar2.b("listContext"));
                        stringBuilder5 = new StringBuilder(k.s);
                        stringBuilder5.append(c.a(com.alibaba.fastjson.parser.f.class));
                        stringBuilder5.append(")V");
                        gVar.b(182, c, "setContext", stringBuilder5.toString());
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.b(182, d, "token", "()I");
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "RBRACKET", "I");
                        gVar.a((int) Opcodes.AND_LONG, eVar5);
                        gVar.b(25, aVar2.b("lexer"));
                        gVar.a(Opcodes.MUL_INT_2ADDR, e, "COMMA", "I");
                        gVar.b(182, d, "nextToken", "(I)V");
                        gVar.a(eVar2);
                        if (i5 == length2 - 1) {
                            a(aVar2, gVar, eVar5);
                        }
                        i5++;
                        eVar6 = eVar3;
                        eVar7 = eVar4;
                        i3 = 182;
                    }
                } else {
                    eVar3 = eVar6;
                    eVar4 = eVar7;
                    eVar6 = new com.alibaba.fastjson.b.e();
                    eVar7 = new com.alibaba.fastjson.b.e();
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.b(25, 0);
                    r10 = aVar2.d;
                    StringBuilder stringBuilder10 = new StringBuilder();
                    stringBuilder10.append(dVar3.a);
                    stringBuilder10.append("_asm_prefix__");
                    gVar.a(180, r10, stringBuilder10.toString(), "[C");
                    gVar.b(182, d, "matchField", "([C)Z");
                    gVar.a(154, eVar6);
                    gVar.a(1);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar3.a);
                    stringBuilder.append("_asm");
                    gVar.b(58, aVar2.b(stringBuilder.toString()));
                    gVar.a((int) Opcodes.SUB_FLOAT, eVar7);
                    gVar.a(eVar6);
                    a(gVar, aVar2, i5);
                    gVar.b(21, aVar2.b("matchedCount"));
                    gVar.a(4);
                    gVar.a(96);
                    gVar.b(54, aVar2.b("matchedCount"));
                    a(aVar2, gVar, dVar3, cls3, i5);
                    gVar.b(25, 1);
                    gVar.b(182, c, "getResolveStatus", "()I");
                    gVar.a(Opcodes.MUL_INT_2ADDR, c, "NeedToResolve", "I");
                    gVar.a((int) Opcodes.AND_LONG, eVar7);
                    gVar.b(25, 1);
                    stringBuilder10 = new StringBuilder("()");
                    stringBuilder10.append(c.a(com.alibaba.fastjson.parser.a.a.class));
                    gVar.b(182, c, "getLastResolveTask", stringBuilder10.toString());
                    gVar.b(58, aVar2.b("resolveTask"));
                    gVar.b(25, aVar2.b("resolveTask"));
                    gVar.b(25, 1);
                    r14 = new StringBuilder("()");
                    r14.append(c.a(com.alibaba.fastjson.parser.f.class));
                    gVar.b(182, c, "getContext", r14.toString());
                    gVar.a(181, c.b(com.alibaba.fastjson.parser.a.a.class), "ownerContext", c.a(com.alibaba.fastjson.parser.f.class));
                    gVar.b(25, aVar2.b("resolveTask"));
                    gVar.b(25, 0);
                    gVar.a(dVar3.a);
                    stringBuilder10 = new StringBuilder("(Ljava/lang/String;)");
                    stringBuilder10.append(c.a(k.class));
                    gVar.b(182, c.b(b.class), "getFieldDeserializer", stringBuilder10.toString());
                    gVar.a(181, c.b(com.alibaba.fastjson.parser.a.a.class), "fieldDeserializer", c.a(k.class));
                    gVar.b(25, 1);
                    gVar.a(Opcodes.MUL_INT_2ADDR, c, "NONE", "I");
                    gVar.b(182, c, "setResolveStatus", "(I)V");
                    gVar.a(eVar7);
                    if (i5 == length2 - 1) {
                        a(aVar2, gVar, eVar5);
                    }
                    i5++;
                    eVar6 = eVar3;
                    eVar7 = eVar4;
                    i3 = 182;
                }
                gVar.b(25, aVar2.b("lexer"));
                gVar.a(180, d, "matchStat", "I");
                com.alibaba.fastjson.b.e eVar12 = new com.alibaba.fastjson.b.e();
                gVar.a(158, eVar12);
                a(gVar, aVar2, i5);
                gVar.a(eVar12);
                gVar.b(25, aVar2.b("lexer"));
                gVar.a(180, d, "matchStat", "I");
                gVar.a(89);
                gVar.b(54, aVar2.b("matchStat"));
                gVar.a(Opcodes.MUL_INT_2ADDR, d, "NOT_MATCH", "I");
                gVar.a((int) Opcodes.REM_LONG, eVar5);
                gVar.b(25, aVar2.b("lexer"));
                gVar.a(180, d, "matchStat", "I");
                gVar.a(158, eVar2);
                gVar.b(21, aVar2.b("matchedCount"));
                gVar.a(4);
                gVar.a(96);
                gVar.b(54, aVar2.b("matchedCount"));
                gVar.b(25, aVar2.b("lexer"));
                gVar.a(180, d, "matchStat", "I");
                gVar.a(Opcodes.MUL_INT_2ADDR, d, "END", "I");
                gVar.a((int) Opcodes.REM_LONG, eVar8);
                gVar.a(eVar2);
                if (i5 == length2 - 1) {
                    gVar.b(25, aVar2.b("lexer"));
                    gVar.a(180, d, "matchStat", "I");
                    gVar.a(Opcodes.MUL_INT_2ADDR, d, "END", "I");
                    gVar.a((int) Opcodes.AND_LONG, eVar5);
                    eVar3 = eVar6;
                    eVar4 = eVar7;
                    int i7 = Opcodes.AND_LONG;
                    i5++;
                    eVar6 = eVar3;
                    eVar7 = eVar4;
                    i3 = 182;
                } else {
                    eVar3 = eVar6;
                    eVar4 = eVar7;
                    i5++;
                    eVar6 = eVar3;
                    eVar7 = eVar4;
                    i3 = 182;
                }
            }
            eVar3 = eVar6;
            eVar4 = eVar7;
            gVar.a(eVar8);
            if (!(aVar2.b.isInterface() || Modifier.isAbstract(aVar2.b.getModifiers()))) {
                c(aVar2, gVar);
            }
            gVar.a(eVar4);
            gVar.b(25, 1);
            gVar.b(25, aVar2.b("context"));
            stringBuilder2 = new StringBuilder(k.s);
            stringBuilder2.append(c.a(com.alibaba.fastjson.parser.f.class));
            stringBuilder2.append(")V");
            gVar.b(182, c, "setContext", stringBuilder2.toString());
            com.alibaba.fastjson.b.e eVar13 = new com.alibaba.fastjson.b.e();
            gVar.b(25, aVar2.b("childContext"));
            gVar.a(198, eVar13);
            gVar.b(25, aVar2.b("childContext"));
            gVar.b(25, aVar2.b("instance"));
            gVar.a(181, c.b(com.alibaba.fastjson.parser.f.class), "object", "Ljava/lang/Object;");
            gVar.a(eVar13);
            gVar.b(25, aVar2.b("instance"));
            Method method = aVar2.c.f;
            if (method != null) {
                String b = c.b(aVar.a());
                String name = method.getName();
                StringBuilder stringBuilder11 = new StringBuilder("()");
                stringBuilder11.append(c.a(method.getReturnType()));
                gVar.b(182, b, name, stringBuilder11.toString());
            }
            gVar.a((int) Opcodes.ADD_INT_2ADDR);
            gVar.a(eVar5);
            c(aVar2, gVar);
            gVar.b(25, 0);
            gVar.b(25, 1);
            gVar.b(25, 2);
            gVar.b(25, 3);
            gVar.b(25, aVar2.b("instance"));
            stringBuilder3 = new StringBuilder("(L");
            stringBuilder3.append(c);
            stringBuilder3.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
            gVar.b(182, c.b(b.class), "parseRest", stringBuilder3.toString());
            gVar.a(192, c.b(aVar2.b));
            gVar.a((int) Opcodes.ADD_INT_2ADDR);
            gVar.a(eVar3);
            gVar.b(25, 0);
            gVar.b(25, 1);
            gVar.b(25, 2);
            gVar.b(25, 3);
            stringBuilder2 = new StringBuilder("(L");
            stringBuilder2.append(c);
            stringBuilder2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
            gVar.b(183, c.b(b.class), "deserialze", stringBuilder2.toString());
            gVar.a((int) Opcodes.ADD_INT_2ADDR);
            gVar.c(5, aVar2.a);
        }
    }

    private static void b(a aVar, f fVar) {
        Constructor constructor = aVar.c.c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            fVar.a((int) Opcodes.ADD_LONG_2ADDR, c.b(aVar.a()));
            fVar.a(89);
            fVar.b(183, c.b(constructor.getDeclaringClass()), "<init>", "()V");
            fVar.b(58, aVar.b("instance"));
            return;
        }
        fVar.b(25, 0);
        fVar.b(25, 1);
        StringBuilder stringBuilder = new StringBuilder("(L");
        stringBuilder.append(c);
        stringBuilder.append(";)Ljava/lang/Object;");
        fVar.b(183, c.b(b.class), "createInstance", stringBuilder.toString());
        fVar.a(192, c.b(aVar.a()));
        fVar.b(58, aVar.b("instance"));
    }

    private static void a(a aVar, f fVar, boolean z) {
        int length = aVar.e.length;
        for (int i = 0; i < length; i++) {
            com.alibaba.fastjson.b.e eVar = new com.alibaba.fastjson.b.e();
            if (z) {
                StringBuilder stringBuilder = new StringBuilder("_asm_flag_");
                stringBuilder.append(i / 32);
                fVar.b(21, aVar.b(stringBuilder.toString()));
                fVar.a(Integer.valueOf(1 << i));
                fVar.a((int) Opcodes.NOT_LONG);
                fVar.a(153, eVar);
            }
            d dVar = aVar.e[i];
            Class cls = dVar.d;
            Type type = dVar.e;
            StringBuilder stringBuilder2;
            if (cls == Boolean.TYPE) {
                fVar.b(25, aVar.b("instance"));
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(dVar.a);
                stringBuilder2.append("_asm");
                fVar.b(21, aVar.b(stringBuilder2.toString()));
                a(fVar, dVar);
            } else {
                if (!(cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE)) {
                    if (cls != Character.TYPE) {
                        if (cls == Long.TYPE) {
                            fVar.b(25, aVar.b("instance"));
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(dVar.a);
                            stringBuilder2.append("_asm");
                            fVar.b(22, aVar.a(stringBuilder2.toString()));
                            if (dVar.b != null) {
                                fVar.b(182, c.b(aVar.a()), dVar.b.getName(), c.a(dVar.b));
                                if (!dVar.b.getReturnType().equals(Void.TYPE)) {
                                    fVar.a(87);
                                }
                            } else {
                                fVar.a(181, c.b(dVar.f), dVar.c.getName(), c.a(dVar.d));
                            }
                        } else if (cls == Float.TYPE) {
                            fVar.b(25, aVar.b("instance"));
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(dVar.a);
                            stringBuilder2.append("_asm");
                            fVar.b(23, aVar.b(stringBuilder2.toString()));
                            a(fVar, dVar);
                        } else if (cls == Double.TYPE) {
                            fVar.b(25, aVar.b("instance"));
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(dVar.a);
                            stringBuilder2.append("_asm");
                            fVar.b(24, aVar.a(stringBuilder2.toString()));
                            a(fVar, dVar);
                        } else if (cls == String.class) {
                            fVar.b(25, aVar.b("instance"));
                            r3 = new StringBuilder();
                            r3.append(dVar.a);
                            r3.append("_asm");
                            fVar.b(25, aVar.b(r3.toString()));
                            a(fVar, dVar);
                        } else if (cls.isEnum()) {
                            fVar.b(25, aVar.b("instance"));
                            r3 = new StringBuilder();
                            r3.append(dVar.a);
                            r3.append("_asm");
                            fVar.b(25, aVar.b(r3.toString()));
                            a(fVar, dVar);
                        } else if (Collection.class.isAssignableFrom(cls)) {
                            fVar.b(25, aVar.b("instance"));
                            if (j.f(type) == String.class) {
                                r3 = new StringBuilder();
                                r3.append(dVar.a);
                                r3.append("_asm");
                                fVar.b(25, aVar.b(r3.toString()));
                                fVar.a(192, c.b(cls));
                            } else {
                                r3 = new StringBuilder();
                                r3.append(dVar.a);
                                r3.append("_asm");
                                fVar.b(25, aVar.b(r3.toString()));
                            }
                            a(fVar, dVar);
                        } else {
                            fVar.b(25, aVar.b("instance"));
                            r3 = new StringBuilder();
                            r3.append(dVar.a);
                            r3.append("_asm");
                            fVar.b(25, aVar.b(r3.toString()));
                            a(fVar, dVar);
                        }
                    }
                }
                fVar.b(25, aVar.b("instance"));
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(dVar.a);
                stringBuilder2.append("_asm");
                fVar.b(21, aVar.b(stringBuilder2.toString()));
                a(fVar, dVar);
            }
            if (z) {
                fVar.a(eVar);
            }
        }
    }

    private static void a(a aVar, f fVar, d dVar, Class<?> cls, int i) {
        com.alibaba.fastjson.b.e eVar = new com.alibaba.fastjson.b.e();
        fVar.b(25, 0);
        String str = aVar.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dVar.a);
        stringBuilder.append("_asm_deser__");
        fVar.a(180, str, stringBuilder.toString(), c.a(r.class));
        fVar.a(199, eVar);
        fVar.b(25, 0);
        fVar.b(25, 1);
        StringBuilder stringBuilder2 = new StringBuilder("()");
        stringBuilder2.append(c.a(com.alibaba.fastjson.parser.g.class));
        fVar.b(182, c, "getConfig", stringBuilder2.toString());
        fVar.a(h.a(c.a(dVar.d)));
        stringBuilder2 = new StringBuilder("(Ljava/lang/reflect/Type;)");
        stringBuilder2.append(c.a(r.class));
        fVar.b(182, c.b(com.alibaba.fastjson.parser.g.class), "getDeserializer", stringBuilder2.toString());
        String str2 = aVar.d;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(dVar.a);
        stringBuilder3.append("_asm_deser__");
        fVar.a(181, str2, stringBuilder3.toString(), c.a(r.class));
        fVar.a(eVar);
        fVar.b(25, 0);
        String str3 = aVar.d;
        stringBuilder = new StringBuilder();
        stringBuilder.append(dVar.a);
        stringBuilder.append("_asm_deser__");
        fVar.a(180, str3, stringBuilder.toString(), c.a(r.class));
        fVar.b(25, 1);
        if (dVar.e instanceof Class) {
            fVar.a(h.a(c.a(dVar.d)));
        } else {
            fVar.b(25, 0);
            fVar.a(Integer.valueOf(i));
            fVar.b(182, c.b(b.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        fVar.a(dVar.a);
        StringBuilder stringBuilder4 = new StringBuilder("(L");
        stringBuilder4.append(c);
        stringBuilder4.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        fVar.b(Opcodes.SHR_INT_2ADDR, c.b(r.class), "deserialze", stringBuilder4.toString());
        fVar.a(192, c.b(cls));
        i = new StringBuilder();
        i.append(dVar.a);
        i.append("_asm");
        fVar.b(58, aVar.b(i.toString()));
    }

    private static void c(b bVar, a aVar) {
        StringBuilder stringBuilder;
        for (d dVar : aVar.e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(dVar.a);
            stringBuilder.append("_asm_prefix__");
            com.alibaba.fastjson.b.c cVar = new com.alibaba.fastjson.b.c(bVar, stringBuilder.toString(), "[C");
        }
        for (d dVar2 : aVar.e) {
            Class cls = dVar2.d;
            if (!(cls.isPrimitive() || cls.isEnum())) {
                if (Collection.class.isAssignableFrom(cls)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar2.a);
                    stringBuilder.append("_asm_list_item_deser__");
                    cVar = new com.alibaba.fastjson.b.c(bVar, stringBuilder.toString(), c.a(r.class));
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar2.a);
                    stringBuilder.append("_asm_deser__");
                    cVar = new com.alibaba.fastjson.b.c(bVar, stringBuilder.toString(), c.a(r.class));
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder(k.s);
        stringBuilder2.append(c.a(com.alibaba.fastjson.parser.g.class));
        stringBuilder2.append("Ljava/lang/Class;)V");
        f gVar = new com.alibaba.fastjson.b.g(bVar, "<init>", stringBuilder2.toString(), null);
        gVar.b(25, 0);
        gVar.b(25, 1);
        gVar.b(25, 2);
        stringBuilder = new StringBuilder(k.s);
        stringBuilder.append(c.a(com.alibaba.fastjson.parser.g.class));
        stringBuilder.append("Ljava/lang/Class;)V");
        gVar.b(183, c.b(b.class), "<init>", stringBuilder.toString());
        for (d dVar3 : aVar.e) {
            gVar.b(25, 0);
            stringBuilder = new StringBuilder("\"");
            stringBuilder.append(dVar3.a);
            stringBuilder.append("\":");
            gVar.a(stringBuilder.toString());
            gVar.b(182, "java/lang/String", "toCharArray", "()[C");
            String str = aVar.d;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(dVar3.a);
            stringBuilder3.append("_asm_prefix__");
            gVar.a(181, str, stringBuilder3.toString(), "[C");
        }
        gVar.a((int) Opcodes.SUB_INT_2ADDR);
        gVar.c(4, 4);
    }
}
