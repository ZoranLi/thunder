package com.alipay.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class a implements i, j {
    public final Object a(Object obj) {
        Object[] objArr = (Object[]) obj;
        List arrayList = new ArrayList();
        for (Object b : objArr) {
            arrayList.add(f.b(b));
        }
        return arrayList;
    }

    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(org.json.alipay.a.class)) {
            return null;
        }
        org.json.alipay.a aVar = (org.json.alipay.a) obj;
        if (type instanceof GenericArrayType) {
            throw new IllegalArgumentException("Does not support generic array!");
        }
        type = ((Class) type).getComponentType();
        int a = aVar.a();
        Object newInstance = Array.newInstance(type, a);
        for (int i = 0; i < a; i++) {
            Array.set(newInstance, i, e.a(aVar.a(i), type));
        }
        return newInstance;
    }

    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
