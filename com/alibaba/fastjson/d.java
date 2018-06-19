package com.alibaba.fastjson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeReference */
public class d<T> {
    public static final Type b = new e().a;
    protected final Type a = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected d() {
    }
}
