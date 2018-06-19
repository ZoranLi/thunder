package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/* compiled from: CollectionCodec */
public final class s implements r, ao {
    public static final s a = new s();

    public final int e_() {
        return 14;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        i = afVar.a;
        if (obj != null) {
            Type type2 = null;
            int i2 = 0;
            if (i.b(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Collection collection = (Collection) obj;
            at atVar = afVar.m;
            afVar.a(atVar, obj, obj2);
            if (i.b(SerializerFeature.WriteClassName) != null) {
                if (HashSet.class == collection.getClass()) {
                    i.a((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    i.a((CharSequence) "TreeSet");
                }
            }
            try {
                i.write(91);
                for (Object next : collection) {
                    obj2 = i2 + 1;
                    if (i2 != 0) {
                        i.write(44);
                    }
                    if (next == null) {
                        i.write("null");
                    } else {
                        Class cls = next.getClass();
                        if (cls == Integer.class) {
                            i.a(((Integer) next).intValue());
                        } else if (cls == Long.class) {
                            i.a(((Long) next).longValue());
                            if (i.b(SerializerFeature.WriteClassName) != null) {
                                i.write(76);
                            }
                        } else {
                            afVar.a(cls).a(afVar, next, Integer.valueOf(obj2 - 1), type2, 0);
                        }
                    }
                    i2 = obj2;
                }
                i.write(93);
            } finally {
                afVar.m = atVar;
            }
        } else if (i.b(SerializerFeature.WriteNullListAsEmpty) != null) {
            i.write("[]");
        } else {
            i.write("null");
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        T t = null;
        if (aVar.e.a() == 8) {
            aVar.e.a(16);
            return null;
        } else if (type == JSONArray.class) {
            Collection jSONArray = new JSONArray();
            aVar.b(jSONArray);
            return jSONArray;
        } else {
            Collection g = j.g(type);
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    if (!cls.getName().startsWith("java.")) {
                        type = cls.getGenericSuperclass();
                        if (type instanceof ParameterizedType) {
                            t = ((ParameterizedType) type).getActualTypeArguments()[0];
                        }
                    }
                }
                type = t;
                if (type == null) {
                    type = Object.class;
                }
            }
            aVar.a(type, g, obj);
            return g;
        }
    }
}
