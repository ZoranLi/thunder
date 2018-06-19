package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: JavaObjectDeserializer */
public final class n implements r {
    public static final n a = new n();

    public final int e_() {
        return 12;
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return aVar.a(obj);
        }
        type = ((GenericArrayType) type).getGenericComponentType();
        if ((type instanceof TypeVariable) != null) {
            type = ((TypeVariable) type).getBounds()[null];
        }
        obj = new ArrayList();
        aVar.a(type, (Collection) obj);
        if (!(type instanceof Class)) {
            return obj.toArray();
        }
        Class cls = (Class) type;
        if (cls == Boolean.TYPE) {
            return j.a(obj, boolean[].class, aVar.b());
        }
        if (cls == Short.TYPE) {
            return j.a(obj, short[].class, aVar.b());
        }
        if (cls == Integer.TYPE) {
            return j.a(obj, int[].class, aVar.b());
        }
        if (cls == Long.TYPE) {
            return j.a(obj, long[].class, aVar.b());
        }
        if (cls == Float.TYPE) {
            return j.a(obj, float[].class, aVar.b());
        }
        if (cls == Double.TYPE) {
            return j.a(obj, double[].class, aVar.b());
        }
        Object[] objArr = (Object[]) Array.newInstance(cls, obj.size());
        obj.toArray(objArr);
        return objArr;
    }
}
