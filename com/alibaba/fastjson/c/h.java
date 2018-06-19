package com.alibaba.fastjson.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: ParameterizedTypeImpl */
public final class h implements ParameterizedType {
    private final Type[] a;
    private final Type b;
    private final Type c;

    public h(Type[] typeArr, Type type, Type type2) {
        this.a = typeArr;
        this.b = type;
        this.c = type2;
    }

    public final Type[] getActualTypeArguments() {
        return this.a;
    }

    public final Type getOwnerType() {
        return this.b;
    }

    public final Type getRawType() {
        return this.c;
    }
}
